package logger;

import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import car.shop.*;

import java.io.*;


/**
 * Created by root on 14.02.17.
 */
public class CustomLayout extends PatternLayout {

    @Override
    public String format(LoggingEvent loggingEvent) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("applog.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\\n");
            }
        } catch (IOException e) {
            System.out.println("exeption");
        }
        return sb.toString();
    }


}
