/*
 Another class can instantiate a ClockControl to add a clock, which keeps track of time.
 Speed of the clock can be adjusted from 0 to 3. 0 is stopped, and 1 to 3 increment the clock by 1, 2, or 3 hours at a time.
 */
package sandbox;

/**
 *
 * @author aahughes, maxwellkos
 */
public class ClockControl {
    
    Clock clock;
    
    public void speedup(){
        clock.speed += 1;
    }
    
    public void slowdown(){
        clock.speed -= 1;
    }
    
}
