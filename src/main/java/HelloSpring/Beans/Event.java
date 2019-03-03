package HelloSpring.Beans;
import java.text.DateFormat;
import java.util.Date;


public class Event {
    private int id = (int)  (Math.random()* 100);
    private String msg;
    private Date date;
    private DateFormat df;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public Event(Date date, DateFormat df) {
        this.date =date;
        this.df = df;
    }

    @Override
    public String toString() {
        return df.format(date) +
                " id=" + id +
                " " + msg;
    }
}
