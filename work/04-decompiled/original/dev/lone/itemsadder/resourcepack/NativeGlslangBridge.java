package dev.lone.itemsadder.resourcepack;

import itemsadder.m.bcg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.util.shaderc.GLSLang;
import org.lwjgl.util.shaderc.GLSLangInput;
import org.lwjgl.util.shaderc.GLSLangResource;

@bcg
public final class NativeGlslangBridge {
    private static final AtomicInteger ACTIVE_HANDLES = new AtomicInteger();

    private NativeGlslangBridge() {
    }

    public static String[] validate(String[] stringArray, String[] stringArray2) {
        if (stringArray.length != stringArray2.length || stringArray.length == 0 || stringArray.length > 2) {
            throw new IllegalArgumentException("expected one shader stage or one vertex/fragment pair");
        }
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        long l = 0L;
        long[] lArray = new long[stringArray2.length];
        try {
            String[] stringArray3;
            block24: {
                MemoryStack memoryStack = MemoryStack.stackPush();
                try {
                    int n;
                    bl = GLSLang.glslang_initialize_process();
                    if (!bl) {
                        throw new IllegalStateException("glslang initialization failed");
                    }
                    GLSLangResource gLSLangResource = NativeGlslangBridge.resourceLimits(memoryStack);
                    boolean bl2 = true;
                    for (n = 0; n < stringArray2.length; ++n) {
                        int n2 = NativeGlslangBridge.nativeStage(stringArray[n]);
                        ByteBuffer byteBuffer = memoryStack.UTF8((CharSequence)stringArray2[n]);
                        GLSLangInput gLSLangInput = GLSLangInput.calloc((MemoryStack)memoryStack).language(1).stage(n2).client(0).client_version(0).target_language(0).target_language_version(0).code(byteBuffer).default_version(150).default_profile(4).force_default_version_and_profile(false).forward_compatible(false).messages(131073).resource(gLSLangResource);
                        long l2 = GLSLang.glslang_shader_create((GLSLangInput)gLSLangInput);
                        if (l2 == 0L) {
                            throw new IllegalStateException("glslang shader allocation failed");
                        }
                        lArray[n] = l2;
                        ACTIVE_HANDLES.incrementAndGet();
                        GLSLang.glslang_shader_set_options((long)l2, (int)0);
                        boolean bl3 = GLSLang.glslang_shader_preprocess((long)l2, (GLSLangInput)gLSLangInput);
                        String string = NativeGlslangBridge.log(GLSLang.glslang_shader_get_info_log((long)l2));
                        if (!bl3) {
                            NativeGlslangBridge.message(arrayList, "preprocess", n, bl3, string);
                        }
                        if (!bl3) {
                            bl2 = false;
                            continue;
                        }
                        String string2 = GLSLang.glslang_shader_get_preprocessed_code((long)l2);
                        if (string2 != null) {
                            GLSLang.glslang_shader_set_preprocessed_code((long)l2, (CharSequence)string2);
                        }
                        boolean bl4 = GLSLang.glslang_shader_parse((long)l2, (GLSLangInput)gLSLangInput);
                        String string3 = NativeGlslangBridge.log(GLSLang.glslang_shader_get_info_log((long)l2));
                        if (!bl4) {
                            NativeGlslangBridge.message(arrayList, "parse", n, bl4, string3);
                        }
                        bl2 &= bl4;
                    }
                    if (stringArray2.length == 2 && bl2) {
                        l = GLSLang.glslang_program_create();
                        if (l == 0L) {
                            throw new IllegalStateException("glslang program allocation failed");
                        }
                        ACTIVE_HANDLES.incrementAndGet();
                        for (long l3 : lArray) {
                            GLSLang.glslang_program_add_shader((long)l, (long)l3);
                        }
                        n = GLSLang.glslang_program_link((long)l, (int)655361) ? 1 : 0;
                        String string = NativeGlslangBridge.log(GLSLang.glslang_program_get_info_log((long)l));
                        if (n == 0) {
                            NativeGlslangBridge.message(arrayList, "link", -1, n != 0, string);
                        }
                    }
                    stringArray3 = (String[])arrayList.toArray(String[]::new);
                    if (memoryStack == null) break block24;
                }
                catch (Throwable throwable) {
                    if (memoryStack != null) {
                        try {
                            memoryStack.close();
                        }
                        catch (Throwable throwable2) {
                            throwable.addSuppressed(throwable2);
                        }
                    }
                    throw throwable;
                }
                memoryStack.close();
            }
            return stringArray3;
        }
        finally {
            if (l != 0L) {
                GLSLang.glslang_program_delete((long)l);
                ACTIVE_HANDLES.decrementAndGet();
            }
            for (long l2 : lArray) {
                if (l2 == 0L) continue;
                GLSLang.glslang_shader_delete((long)l2);
                ACTIVE_HANDLES.decrementAndGet();
            }
            if (bl) {
                GLSLang.glslang_finalize_process();
            }
        }
    }

    public static int activeHandles() {
        return ACTIVE_HANDLES.get();
    }

    private static GLSLangResource resourceLimits(MemoryStack memoryStack) {
        GLSLangResource gLSLangResource = GLSLangResource.calloc((MemoryStack)memoryStack);
        for (int i = 0; i < GLSLangResource.LIMITS; i += 4) {
            MemoryUtil.memPutInt((long)(gLSLangResource.address() + (long)i), (int)4096);
        }
        gLSLangResource.limits().set(true, true, true, true, true, true, true, true, true);
        gLSLangResource.min_program_texel_offset(-8);
        return gLSLangResource;
    }

    private static int nativeStage(String string) {
        return switch (string) {
            case "vertex" -> 0;
            case "fragment" -> 4;
            default -> throw new IllegalArgumentException("unsupported GLSL stage: " + string);
        };
    }

    private static void message(List list, String string, int n, boolean bl, String string2) {
        list.add(string);
        list.add(Integer.toString(n));
        list.add(Boolean.toString(bl));
        list.add(string2);
    }

    private static String log(String string) {
        return string == null ? "" : string.trim();
    }
}
