/**
 * Given "a" an integer or float value, and b as an integer value,
 * Find a power b.
 *
 * @author Siva Sankar
 */

 public class Power {
    Power() {
       int a = 0;
       int b = 0;
    }
    /**
     * This method finds a^b where both a and b are integers.
     * @param  a , the base
     * @param  b , the exponential
     * @return a^b which is a long value.
     */
     public static long pow(final int a, final int b) {
      long c = (long) Math.pow(a, b);
      return c;
     }
     Power() {
      double a = 0;
      int b = 0;
   }
     /**
     * This method finds a^b where both variable a is a double
     * and b is an integer.
     * @param  a , the base
     * @param  b , the exponential
     * @return a^b which is a long value.
     */
     public static double pow(final float a, final int b) {
      double d = (double) Math.pow(a, b);
      return d;

     }
 }
