import java.text.DecimalFormat;

/**
 * Clock data type. Write a data type Clock.java that
 * represents time on a 24-hour clock, such as 00:00, 13:30, or
 * 23:59. Time is measured in hours (00–23) and minutes (00–59).
 * To do so, implement the following public API:
 *
 * @author Siva Sankar
 */

public class Clock {
    // Creates a clock whose initial time is h hrs and m min.
    /**
     * The parameterised constructor will instatiates the object with the values of
     * the parameters h and m to the respective hrs nad min.
     * @param h
     * @param m
     */

    private int h;
    private int m;

    public Clock(final int h, final int m) {
        this.h = h;
        this.m = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.

    public Clock(final String s) {
      String[] str = s.split(":");
      this.h = Integer.parseInt(str[0]);
      this.m = Integer.parseInt(str[1]);
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("00");
        return formatter.format(this.h) + ":" + formatter.format(this.m);
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if ((this.h <= that.h) && (this.m < that.m)) {
            return true;
        }
        return false;
    }

    //private void check() {
        
    //}
   
    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (this.h == 23 && this.m == 59) {
            this.h = 0;
            this.m = 0;
        } else if (this.h >= 0 && this.h < 24 && this.m >= 0 && this.m <= 59) {
            this.m += 1;
            if (this.m > 59) {
                this.h += 1;
                this.m = this.m % 60;
            } else {
                System.out.println("Invalid Time");
            }
        }
    }

    // Adds Δ min to the time on this clock.
    public void toc(int delta) {
        for (int i = 0; i < delta; i++) {
            tic();
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock = new Clock("13:01");
        clock.toc(660);
        System.out.println(clock);
    }
}
