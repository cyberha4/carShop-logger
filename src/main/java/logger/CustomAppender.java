package logger;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.spi.LoggingEvent;

import java.io.File;

/**
 * Created by root on 14.02.17.
 */
public class CustomAppender extends AppenderSkeleton {


    @Override
    protected void append(LoggingEvent loggingEvent) {
            String string = new String();
            try {
                string = CustomLayout.class.newInstance().format(loggingEvent);
            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {

            }
            SendMailTls.send(string);
        }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
