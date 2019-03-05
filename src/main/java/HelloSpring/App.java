package HelloSpring;

import HelloSpring.Beans.Client;
import HelloSpring.Beans.Event;
import HelloSpring.Beans.EventType;
import HelloSpring.Loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {
    private Client client;
    private Map<EventType,EventLogger> loggers;
    private EventLogger defaultLogger;

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        Event event = ctx.getBean(Event.class);
        app.logEvent(EventType.ERROR,event,"Some message for 1");
        event = ctx.getBean(Event.class);
        app.logEvent(EventType.INFO,event,"Some message for 2");
        event = ctx.getBean(Event.class);
        app.logEvent(null,event,"Some message for 3");
        ((ClassPathXmlApplicationContext) ctx).close();
    }


    public App(Client client, EventLogger eventLogger, Map<EventType,EventLogger> loggers) {
        super();
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    private void logEvent(EventType type,Event event,String msg) throws IOException {
        EventLogger logger = loggers.get(type);
        String message = msg.replaceAll(client.getId(), client.getStringfullName());
        event.setMsg(message);
        if (logger == null) logger = defaultLogger;
        logger.logEvent(event);
    }

}
