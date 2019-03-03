package HelloSpring.Loggers;

import HelloSpring.Beans.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {
    int cacheSize;
    List<Event> cache = new ArrayList<Event>();
    public CacheFileLogger(String fileName,int cacheSize) {
        super(fileName);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        cache.add(event);
        if (cache.size()== cacheSize) {
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() throws IOException{
        for (int i =0; i<cache.size();i++)
            super.logEvent(cache.get(i));
    }

    public void destroy() throws IOException {
        if (!cache.isEmpty()) writeEventsFromCache();
    }
}
