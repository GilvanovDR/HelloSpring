package HelloSpring.Loggers;

import HelloSpring.Beans.Event;

import java.io.IOException;

public interface EventLogger {
    abstract void logEvent(Event event) throws IOException;

}
