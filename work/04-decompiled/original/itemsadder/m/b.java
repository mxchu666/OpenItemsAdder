package itemsadder.m;

import dev.lone.itemsadder.Main;
import itemsadder.m.ae;
import itemsadder.m.bcy;
import itemsadder.m.zz;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.Nullable;

final class b {
    private b() {
    }

    static List a(String string, String string2, String string3) {
        Object object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        List list = b.a(string, string2);
        if (ae.et != null && !ae.et.isEmpty()) {
            object = new File(Main.rT().getDataFolder().getParentFile().getAbsolutePath());
            for (Object object2 : ae.et) {
                File file = new File((File)object, (String)(object2 = bcy.aE((String)object2, "plugins/")));
                if (!file.exists()) continue;
                list.add(file);
            }
        }
        for (Object object3 : list) {
            Object object2;
            if (bcy.J((File)object3) <= 0) continue;
            object2 = new File((File)object3, "resourcepack/assets/");
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "resourcepack/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "resource_pack/assets/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "resource_pack/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "data/resource_pack/assets/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "data/resource_pack/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, "assets/");
            }
            if (!((File)object2).exists()) {
                object2 = new File((File)object3, ((File)object3).getName());
            }
            for (String string4 : zz.UT) {
                if (!new File((File)object3, string4).exists()) continue;
                object2 = object3;
                break;
            }
            if (!((File)object2).exists() || bcy.J((File)object2) <= 0) continue;
            arrayList.add(object2);
        }
        object = new File(string3);
        if (((File)object).exists()) {
            arrayList.add(object);
        }
        return arrayList;
    }

    static List b(String string, String string2, String string3) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        List list = b.a(string, string2);
        for (File file2 : list) {
            Object object = new File(file2, "resourcepack/");
            if (((File)object).exists() && bcy.J((File)object) > 0) {
                arrayList.add(object);
                continue;
            }
            object = new File(file2, "resource_pack/");
            if (((File)object).exists() && bcy.J((File)object) > 0) {
                arrayList.add(object);
                continue;
            }
            object = new File(file2, "data/resource_pack/");
            if (!((File)object).exists() || bcy.J((File)object) <= 0) continue;
            arrayList.add(object);
        }
        File file = new File(string3);
        if (file.exists()) {
            arrayList.add(0, file);
        }
        if (ae.et != null && !ae.et.isEmpty()) {
            File file2;
            file2 = new File(Main.rT().getDataFolder().getParentFile().getAbsolutePath());
            for (String string4 : ae.et) {
                File file3 = new File(file2, string4 = bcy.aE(string4, "plugins/"));
                if (!file3.exists()) continue;
                arrayList.add(file3);
            }
        }
        return arrayList;
    }

    static List a(String string, String string2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        File file = new File(string);
        ArrayList arrayList2 = bcy.a(file, File::isDirectory);
        for (int i = 0; i < arrayList2.size(); ++i) {
            File file2 = (File)arrayList2.get(i);
            if (ae.es.contains(file2.getName()) || bcy.J(file2) == 0) continue;
            arrayList.add(file2);
        }
        File file3 = new File(string2);
        if (file3.exists()) {
            arrayList.add(0, file3);
        }
        for (String string3 : ae.es) {
            for (File file4 : arrayList2) {
                if (!file4.getName().equals(string3)) continue;
                arrayList.add(0, file4);
            }
        }
        return arrayList;
    }

    @Nullable
    static File a(List list, String string) {
        for (File file : list) {
            File file2 = new File(file, string);
            if (!file2.exists()) continue;
            return file2;
        }
        return null;
    }

    @Nullable
    static File a(List list, List list2, String string) {
        String[] stringArray2;
        string = bcy.iR(string);
        String string2 = bcy.aE(string, "assets/");
        for (String[] stringArray2 : list) {
            Object object = new File((File)stringArray2, string);
            if (((File)object).exists()) {
                return object;
            }
            object = new File((File)stringArray2, string2);
            if (!((File)object).exists()) continue;
            return object;
        }
        Object object = null;
        stringArray2 = string2.split("/");
        if (stringArray2.length > 0) {
            object = stringArray2[0];
        }
        for (File file : list2) {
            File file2;
            if (!file.getName().equals(object) || !(file2 = new File(file, bcy.aE(string2, (String)object + "/"))).exists()) continue;
            return file2;
        }
        return null;
    }

    static List b(List list, List list2, String string) {
        String[] stringArray2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        string = bcy.iR(string);
        String string2 = bcy.aE(string, "assets/");
        for (String[] stringArray2 : list) {
            Object object = new File((File)stringArray2, string);
            if (((File)object).exists()) {
                arrayList.add(object);
            }
            if (!((File)(object = new File((File)stringArray2, string2))).exists()) continue;
            arrayList.add(object);
        }
        Object object = null;
        stringArray2 = string2.split("/");
        if (stringArray2.length > 1) {
            object = stringArray2[0];
        }
        for (File file : list2) {
            File file2;
            if (!file.getName().equals(object) || !(file2 = new File(file, bcy.aE(string2, (String)object + "/"))).exists()) continue;
            arrayList.add(file2);
        }
        return arrayList;
    }

    static List a(File file2) {
        ArrayList<File> arrayList = new ArrayList<File>();
        File[] fileArray = file2.listFiles(File::isDirectory);
        if (fileArray == null) {
            return arrayList;
        }
        if (file2.getName().equals("assets")) {
            arrayList.addAll(List.of(fileArray));
            return arrayList;
        }
        boolean bl = List.of(fileArray).stream().anyMatch(file -> zz.UT.contains(file.getName()));
        if (bl) {
            File file3 = new File(file2, "assets");
            if (file3.isDirectory()) {
                arrayList.add(file3);
            }
            arrayList.add(file2);
            return arrayList;
        }
        arrayList.addAll(List.of(fileArray));
        return arrayList;
    }

    static List a(List list) {
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            arrayList.addAll(b.a(file));
        }
        return arrayList;
    }

    static List b(List list) {
        ArrayList<File> arrayList = new ArrayList<File>();
        List list2 = b.a(list);
        for (File file : list2) {
            Collection collection = FileUtils.listFiles((File)file, (String[])new String[]{"json"}, (boolean)true);
            for (File file2 : collection) {
                if (!bcy.L(file2).contains("/models/")) continue;
                arrayList.add(file2);
            }
        }
        return arrayList;
    }

    static boolean b(String string, String string2) {
        return new File(string).exists() || new File(string2).exists();
    }
}
