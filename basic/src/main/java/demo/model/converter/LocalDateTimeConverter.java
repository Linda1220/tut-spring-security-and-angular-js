package demo.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Linda on 26/02/16.
 */
@Converter
public class LocalDateTimeConverter implements AttributeConverter<Date, String> {


    private SimpleDateFormat sdf;

    private void initSdf() {
        sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }



    @Override
    public String convertToDatabaseColumn(Date attribute) {

        if (sdf == null) {
           initSdf();
        }

        return sdf.format(attribute);
    }

    @Override
    public Date convertToEntityAttribute(String dbData){
        if (sdf == null) {
            initSdf();
        }
        try {
            return sdf.parse(dbData);
        } catch (ParseException e) {
           throw new RuntimeException(e);
        }
    }
}
