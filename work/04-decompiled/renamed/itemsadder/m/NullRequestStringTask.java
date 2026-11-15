package itemsadder.m;

import itemsadder.m.ColorBridge;
import itemsadder.m.CommandSenderBridge_5;
import itemsadder.m.MaterialBarColorHolder;
import itemsadder.m.Opaque010;
import itemsadder.m.RuntimeError_2;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;

class NullRequestStringTask
extends Thread {
    private static final String[] ayU = new String[]{"..", "./", "/.", "~", ";", "|", "%"};
    static Opaque010 ayV;
    private final Socket ayW;
    private final File ayX;

    public static void w(int n, int n2) {
        ayV = new Opaque010(n, n2);
        if (MaterialBarColorHolder.cu) {
            CommandSenderBridge_5.log("[SelfHost] Rate limiter: max " + n + " requests / " + n2 + "s.");
            if (MaterialBarColorHolder.cx) {
                CommandSenderBridge_5.log("[SelfHost] Clients exceeding " + MaterialBarColorHolder.cz + " times will be blocked for " + MaterialBarColorHolder.cy + "m.");
            }
        }
    }

    public NullRequestStringTask(Socket socket, File file) {
        this.ayW = socket;
        this.ayX = file;
        this.start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void run() {
        try (PrintStream printStream = new PrintStream(new BufferedOutputStream(this.ayW.getOutputStream()));
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.ayW.getInputStream()));){
            File file;
            Object object;
            Object object2;
            block50: {
                block49: {
                    HashMap<Object, Object> hashMap;
                    block45: {
                        block48: {
                            block47: {
                                block46: {
                                    object2 = null;
                                    String string = bufferedReader.readLine();
                                    if (string == null) {
                                        throw new RuntimeError_2("Null request string. Failed to initialize.");
                                    }
                                    StringTokenizer stringTokenizer = new StringTokenizer(string);
                                    if (!stringTokenizer.hasMoreElements()) throw new RuntimeError_2("Invalid request string. Failed to parse tokens.");
                                    if (!stringTokenizer.nextToken().equalsIgnoreCase("GET")) throw new RuntimeError_2("Invalid request string. Failed to parse tokens.");
                                    if (!stringTokenizer.hasMoreElements()) throw new RuntimeError_2("Invalid request string. Failed to parse tokens.");
                                    object2 = stringTokenizer.nextToken();
                                    hashMap = null;
                                    if (MaterialBarColorHolder.ct || MaterialBarColorHolder.cu) {
                                        hashMap = new HashMap<Object, Object>();
                                        while ((string = bufferedReader.readLine()) != null && !string.trim().isEmpty()) {
                                            object = string.split(": ");
                                            if (((Object)object).length != 2) continue;
                                            hashMap.put(object[0], object[1]);
                                        }
                                    }
                                    if (!MaterialBarColorHolder.ct) break block45;
                                    if (hashMap.containsKey("User-Agent")) break block46;
                                    printStream.println("HTTP/1.0 401 Unauthorized");
                                    printStream.close();
                                    bufferedReader.close();
                                    return;
                                }
                                object = (String)hashMap.get("User-Agent");
                                if (!((String)object).contains("bot") && !((String)object).contains("Bot") && !((String)object).contains("BOT")) break block47;
                                printStream.println("HTTP/1.0 401 Unauthorized");
                                printStream.close();
                                bufferedReader.close();
                                return;
                            }
                            if (((String)object).startsWith("Mozilla") || ((String)object).startsWith("Minecraft")) break block48;
                            printStream.println("HTTP/1.0 401 Unauthorized");
                            printStream.close();
                            bufferedReader.close();
                            return;
                        }
                        if (hashMap.containsKey("X-Minecraft-Username") && hashMap.containsKey("X-Minecraft-UUID") && hashMap.containsKey("X-Minecraft-Version") && hashMap.containsKey("X-Minecraft-Version-ID") && hashMap.containsKey("User-Agent") && ((String)hashMap.get("User-Agent")).startsWith("Minecraft Java")) break block45;
                        printStream.println("HTTP/1.0 401 Unauthorized");
                        printStream.close();
                        bufferedReader.close();
                        return;
                    }
                    if (!MaterialBarColorHolder.cu) break block49;
                    Object object3 = object = this.ayW.getInetAddress().getHostAddress();
                    object3 = hashMap.containsKey("X-Minecraft-UUID") ? (String)object3 + "_" + (String)hashMap.get("X-Minecraft-UUID") : (String)object3 + "_" + (String)hashMap.get("User-Agent");
                    if (ayV.a((String)object, UUID.nameUUIDFromBytes(((String)object3).getBytes()))) break block49;
                    bufferedReader.close();
                    return;
                }
                for (String string : ayU) {
                    if (!((String)object2).contains(string)) continue;
                    throw new SecurityException();
                }
                if (((String)object2).endsWith("/")) {
                    object2 = (String)object2 + "index.html";
                }
                if (((String)object2).contains("?")) {
                    object2 = ((String)object2).split("\\?")[0];
                }
                while (((String)object2).indexOf("/") == 0) {
                    object2 = ((String)object2).substring(1);
                }
                file = new File(this.ayX, (String)(object2 = StringUtils.replace((String)object2, (String)"/", (String)File.separator)));
                if (!file.isDirectory()) break block50;
                object2 = StringUtils.replace((String)object2, (String)"\\", (String)"/");
                printStream.print("HTTP/1.0 301 Moved Permanently\r\nLocation: /" + (String)object2 + "/\r\n\r\n");
                printStream.close();
                bufferedReader.close();
                return;
            }
            try {
                object = new FileInputStream(file);
                try {
                    int n;
                    String string = URLConnection.guessContentTypeFromName((String)object2);
                    long l = file.length();
                    if (string == null) {
                        string = ((String)object2).endsWith(".html") || ((String)object2).endsWith(".htm") ? "text/html" : (((String)object2).endsWith(".jpg") || ((String)object2).endsWith(".jpeg") ? "image/jpeg" : (((String)object2).endsWith(".gif") ? "image/gif" : (((String)object2).endsWith(".class") ? "application/octet-stream" : (((String)object2).endsWith(".zip") ? "application/zip" : "text/plain"))));
                    }
                    printStream.print("HTTP/1.0 200 OK\r\nContent-Type: " + string + "\r\nContent-Length: " + l + "\r\n\r\n");
                    byte[] byArray = new byte[4096];
                    while ((n = ((InputStream)object).read(byArray)) > 0) {
                        printStream.write(byArray, 0, n);
                    }
                    printStream.close();
                    return;
                }
                finally {
                    ((InputStream)object).close();
                }
            }
            catch (FileNotFoundException fileNotFoundException) {
                printStream.println("HTTP/1.0 404 Not Found\r\nContent-Type: text/html\r\n\r\n<html><head></head><body>" + ColorBridge.iO(object2) + " not found\n</body></html>");
                printStream.close();
                return;
            }
            catch (SecurityException securityException) {
                printStream.println("HTTP/1.0 401 Unauthorized\r\nContent-Type: text/html\r\n\r\n<html><head></head><body>No permission for path: " + ColorBridge.iO(object2) + "\n</body></html>");
                printStream.close();
                return;
            }
            catch (RuntimeError_2 runtimeError_2) {
                printStream.println("HTTP/1.0 405 Method Not Allowed\r\nContent-Type: text/html\r\n\r\n<html><head></head><body>Invalid request: " + ColorBridge.iO(object2) + "\n</body></html>");
                printStream.close();
                return;
            }
        }
        catch (SocketException socketException) {
            if (socketException.getMessage().equals("Connection reset")) return;
            CommandSenderBridge_5.error("Unexpected error while handling webserver request: ", socketException);
            return;
        }
        catch (IOException iOException) {
            CommandSenderBridge_5.error("Unexpected I/O error while handling webserver request: ", iOException);
            return;
        }
        catch (Throwable throwable) {
            CommandSenderBridge_5.error("Unexpected error while handling webserver request: ", throwable);
        }
    }
}
