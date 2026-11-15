package itemsadder.m;

final class Json {
    private Json() {
    }

    static String g(String string, String string2) {
        String string3;
        if (string2 == null) {
            return null;
        }
        if ((string2 = string2.replace(".png", "")).contains(":")) {
            String[] stringArray = string2.split(":");
            string3 = stringArray[0];
            string2 = stringArray[1];
        } else {
            string3 = string;
        }
        if (string3 == null) {
            return "assets/minecraft/textures/" + string2 + ".png";
        }
        return "assets/" + string3 + "/textures/" + string2 + ".png";
    }

    static String h(String string, String string2) {
        String string3;
        if (string2 == null) {
            return null;
        }
        if ((string2 = string2.replace(".json", "")).contains(":")) {
            String[] stringArray = string2.split(":");
            string3 = stringArray[0];
            string2 = stringArray[1];
        } else {
            string3 = string;
        }
        if (string3 == null) {
            return "assets/minecraft/models/" + string2 + ".json";
        }
        return "assets/" + string3 + "/models/" + string2 + ".json";
    }

    static String a(int n, String string, String string2) {
        String string3;
        if (string2 == null) {
            return null;
        }
        if ((string2 = string2.replace(".png", "")).contains(":")) {
            String[] stringArray = string2.split(":");
            string3 = stringArray[0];
            string2 = stringArray[1];
        } else {
            string3 = string;
        }
        if (string3 == null) {
            string3 = "minecraft";
        }
        return "assets/" + string3 + "/textures/entity/equipment/humanoid" + (n == 1 ? "_leggings" : "") + "/" + string2 + ".png";
    }
}
