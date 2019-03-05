package HelloSpring.Loggers;

import HelloSpring.Beans.Event;

import java.io.IOException;
import java.util.Collection;

public class CombinedEventLogger implements EventLogger {
    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    public void logEvent(Event event) throws IOException {
        for (EventLogger eventLogger : loggers)
            eventLogger.logEvent(event);

    }
}
