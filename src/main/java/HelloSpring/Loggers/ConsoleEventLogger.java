package HelloSpring.Loggers;

import HelloSpring.Beans.Event;

public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event);
    }

}
