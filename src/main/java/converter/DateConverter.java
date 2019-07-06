package converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/11/1.
 */
public class DateConverter implements Converter<String,Date> {

    public Date convert(String source) {
      //  System.out.println("ok7");
        String pattern = source.length()==10 ? "yyyy-MM-dd" : "yyyy-MM-dd HH:mm:ss";
     //   System.out.println("ok8");
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
         //   System.out.println("ok9");
            return format.parse(source);
        } catch (ParseException e) {
         //   System.out.println("ok10");
            e.printStackTrace();
        }
        return null;
    }
}