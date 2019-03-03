package HelloSpring.Beans;

public class Client {
    private String id;
    private String stringfullName;
    private String greeting;

    public Client(String id, String stringfullName) {
        this.id = id;
        this.stringfullName = stringfullName;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStringfullName() {
        return stringfullName;
    }

    public void setStringfullName(String stringfullName) {
        this.stringfullName = stringfullName;
    }
}
