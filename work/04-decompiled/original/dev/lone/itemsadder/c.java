package dev.lone.itemsadder;

import dev.lone.itemsadder.Main;
import ia.sh.libby.logging.LogLevel;
import ia.sh.libby.logging.adapters.LogAdapter;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jetbrains.annotations.NotNull;

class c
implements LogAdapter {
    final /* synthetic */ Main Pg;

    c(Main main) {
        this.Pg = main;
    }

    @Override
    public void log(@NotNull LogLevel logLevel, String string) {
        Logger logger = this.Pg.getLogger();
        switch (logLevel) {
            case DEBUG: {
                logger.log(Level.INFO, string);
                break;
            }
            case INFO: {
                logger.log(Level.INFO, string);
                break;
            }
            case WARN: {
                logger.log(Level.WARNING, string);
                break;
            }
            case ERROR: {
                logger.log(Level.SEVERE, string);
            }
        }
    }

    @Override
    public void log(@NotNull LogLevel logLevel, String string, Throwable throwable) {
        Logger logger = this.Pg.getLogger();
        switch (logLevel) {
            case DEBUG: {
                logger.log(Level.INFO, string, throwable);
                break;
            }
            case INFO: {
                logger.log(Level.INFO, string, throwable);
                break;
            }
            case WARN: {
                logger.log(Level.WARNING, string, throwable);
                break;
            }
            case ERROR: {
                logger.log(Level.SEVERE, string, throwable);
            }
        }
    }
}
