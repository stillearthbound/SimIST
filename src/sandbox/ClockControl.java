/*
 Another class can instantiate a ClockControl to add a clock, which keeps track of time.
 Speed of the clock can be adjusted from 0 to 3. 0 is stopped, and 1 to 3 increment the clock by 1, 2, or 3 hours at a time.
 */
package sandbox;

import java.text.ParseException;

/**
 *
 * @author aahughes, maxwellkos
 */
public class ClockControl {

    Clock clock;

    public ClockControl() throws ParseException{
        this.clock = new Clock();
    }

    public void speedup(){
        if (clock.speed < 3)
            clock.speed += 1;
    }

    public void slowdown(){
        if (clock.speed > 1)
            clock.speed -= 1;
    }

    public void pause(){
        clock.speed = 0;
    }

    public String display(){
        return clock.display;
    }

    public int getSpeed(){
        return clock.speed;
    }
}
