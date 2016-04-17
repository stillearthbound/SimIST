/*
ISTTime stores a LocalDateTime object with a default starting time at 4/1/2016 at 8:00.
It contains methods to set and get the time and date, as well as format and display them.
 */
package sandbox;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author aahughes, maxwellkos
 */
public class ISTTime {
    LocalDateTime now;



    public ISTTime() throws ParseException{
        this.now = LocalDateTime.of(2016,4,1,8,0);
    }

    public LocalTime getTime(){
      return now.toLocalTime();
    }

    public LocalDate getDate(){
        return now.toLocalDate();
    }

    public void setTime(int hours){
        now = now.plusHours(hours);
    }

    public void setDate(LocalDate newDate){
        now = newDate.atTime(getTime());
    }

    public String showDate(){
        return now.format(DateTimeFormatter.ofPattern("d MMM uuuu"));
    }

    public String showTime(){
        return now.format(DateTimeFormatter.ofPattern("HH:mm"));
    }
    public int getMonthValue()
    {
    return now.getMonthValue();
    }

}
