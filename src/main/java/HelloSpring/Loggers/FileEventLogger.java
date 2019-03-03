package HelloSpring.Loggers;

import HelloSpring.Beans.Event;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;



public class FileEventLogger  implements EventLogger {
    private  String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException{
        this.file = new File(fileName);
    }

    public void logEvent(Event event) throws IOException  {
        FileUtils.writeStringToFile(new File(fileName),event.toString() +"\n","UTF-8",true);
    }
}
