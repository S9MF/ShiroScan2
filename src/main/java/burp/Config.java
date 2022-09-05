package burp;

public class Config {
    private static Integer mode = 0;
    private static String key = "";

    public static Integer getMode() {
        String val = BurpExtender.callbacks.loadExtensionSetting("mode");
        try {
            return Integer.valueOf(val);
        }catch (Exception e) {
            return Config.mode;
        }
    }

    public static void setMode(Integer mode) {
        BurpExtender.callbacks.saveExtensionSetting("fuzz_number", String.valueOf(mode));
        Config.mode = mode;
    }

    public static String getKey() {
        String val = BurpExtender.callbacks.loadExtensionSetting("key");
        try {
            return String.valueOf(val);
        }catch (Exception e) {
            return Config.key;
        }
    }

    public static void setKey(String key) {
        BurpExtender.callbacks.saveExtensionSetting("key", String.valueOf(key));
        Config.key = key;
    }
}
