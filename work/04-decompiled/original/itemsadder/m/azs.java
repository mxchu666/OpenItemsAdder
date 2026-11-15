package itemsadder.m;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class azs {
    private static final String aym = "f_";
    private final Map ayn = new HashMap();
    private String Oa;

    public azs(String string) {
        this.Oa = string;
    }

    public String Bx() {
        this.Oa = this.BA();
        this.Oa = this.Bz();
        this.Oa = this.By();
        this.Oa = this.Oa.replaceAll("\\.0( |\\D|)", ".$1");
        this.Oa = this.Oa.replaceAll("0\\.(\\d+)", ".$1");
        this.Oa = this.Oa.replaceAll("} }", "}}");
        this.Oa = this.Oa.replaceAll("if \\(", "if(");
        this.Oa = this.Oa.replaceAll("for \\(", "for(");
        this.Oa = this.Oa.replaceAll("while \\(", "while(");
        this.Oa = this.Oa.replaceAll("} else \\{", "}else{");
        this.Oa = this.Oa.replace(" = ", "=");
        this.Oa = this.Oa.replace(" == ", "==");
        this.Oa = this.Oa.replace(" + ", "+");
        this.Oa = this.Oa.replace(" += ", "+=");
        this.Oa = this.Oa.replace(" - ", "-");
        this.Oa = this.Oa.replace(" -= ", "-=");
        this.Oa = this.Oa.replace(" * ", "*");
        this.Oa = this.Oa.replace(" *= ", "*=");
        return this.Oa;
    }

    private String By() {
        Matcher matcher = Pattern.compile("#define\\s+(\\w+)\\s+(.+)").matcher(this.Oa);
        while (matcher.find()) {
            String string = matcher.group(1).trim();
            String string2 = matcher.group(2).trim();
            this.Oa = this.Oa.replace(matcher.group(), "");
            this.Oa = this.Oa.replaceAll("\\b" + string + "\\b", string2);
        }
        return this.Oa;
    }

    public String Bz() {
        String string = "/\\*.*?\\*/";
        String string2 = "//.*";
        this.Oa = this.Oa.replaceAll(string, "");
        this.Oa = this.Oa.replaceAll(string2, "");
        return this.Oa;
    }

    public String BA() {
        Matcher matcher = Pattern.compile("\\bvoid\\s+(\\w+)\\s*\\(").matcher(this.Oa);
        while (matcher.find()) {
            String string = matcher.group(1).trim();
            if (string.equals("main") || this.ayn.containsKey(string)) continue;
            this.ayn.put(string, aym + azs.BB());
        }
        for (Map.Entry entry : this.ayn.entrySet()) {
            String string = (String)entry.getKey();
            String string2 = (String)entry.getValue();
            this.Oa = this.Oa.replaceAll("\\bvoid\\s+" + string + "\\s*\\(", "void " + string2 + "(");
            this.Oa = this.Oa.replaceAll("\\b" + string + "\\s*\\(", string2 + "(");
        }
        return this.Oa;
    }

    private static String BB() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
}
