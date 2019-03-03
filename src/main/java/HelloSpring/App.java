package HelloSpring;

import HelloSpring.Beans.Client;
import HelloSpring.Beans.Event;
import HelloSpring.Loggers.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    Client client;
    EventLogger eventLogger;
    static ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");;

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(),client.getStringfullName());
        Event event = (Event) ctx.getBean("event");
        event.setMsg(message);
        try {
            eventLogger.logEvent(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }


    public static void main(String[] args) {
        App app = (App) ctx.getBean("app");
        app.logEvent("Some message for 1");
        app.logEvent("Some message for 2");
        ((ClassPathXmlApplicationContext) ctx).close();
    }
}
