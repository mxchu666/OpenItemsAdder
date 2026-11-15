package ia.sh.libby.logging.adapters;

import ia.sh.libby.logging.LogLevel;

static class JDKLogAdapter.1 {
    static final /* synthetic */ int[] $SwitchMap$com$alessiodp$libby$logging$LogLevel;

    static {
        $SwitchMap$com$alessiodp$libby$logging$LogLevel = new int[LogLevel.values().length];
        try {
            JDKLogAdapter.1.$SwitchMap$com$alessiodp$libby$logging$LogLevel[LogLevel.DEBUG.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            JDKLogAdapter.1.$SwitchMap$com$alessiodp$libby$logging$LogLevel[LogLevel.INFO.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            JDKLogAdapter.1.$SwitchMap$com$alessiodp$libby$logging$LogLevel[LogLevel.WARN.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
        try {
            JDKLogAdapter.1.$SwitchMap$com$alessiodp$libby$logging$LogLevel[LogLevel.ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            // empty catch block
        }
    }
}
