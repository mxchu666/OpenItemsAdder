package itemsadder.m;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.filter.AbstractFilter;
import org.apache.logging.log4j.message.Message;

public final class TestPassed
extends AbstractFilter {
    private static final String DS = "Test passed";
    private static final String DT = "Test failed";

    public Filter.Result filter(Logger logger, Level level, Marker marker, Message message, Throwable throwable) {
        return message.getFormat().equals(DS) ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(LogEvent logEvent) {
        String string = logEvent.getMessage().getFormat();
        return DS.equals(string) ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, Object object, Throwable throwable) {
        return Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object ... objectArray) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }

    public Filter.Result filter(Logger logger, Level level, Marker marker, String string, Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        return string.startsWith("Tried to load unrecognized recipe: ") ? Filter.Result.DENY : Filter.Result.NEUTRAL;
    }
}
