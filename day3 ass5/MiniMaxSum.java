/**
 * Given an array of elements, return the String that has two values separated
 * by commans. The first value is the sum of all the elements except minimum
 * and the second value is the sum of all the elements except the maximum.
 * 
 * Input : {1,2,3,4,5};
 * Output : 14,10
 * 
 * Input : {1,2}
 * Output : 2,1
 * 
 * @author Siva Sankar
 */

public class MiniMaxSum {

    /**
     * This method returns the minimum element in the array.
     * @param arr, contains the elements in arr.
     * @return the minimum element in the arr. If there are no elements, then
     * it should return -1.
     */
    public static int min(int[] arr) {
        //  Your code goes here...
        int min = arr[0];
        //int i;
      for (int i=0; i<arr.length; i++ ) {
         if (arr[i]<min) {
            min = arr[i];
         }
      }
      return min;
    }

    /**
     * This method returns the maximum element in the array.
     * @param arr, contains the elements in arr.
     * @return the maximum element in the arr. If there are no elements, then
     * it should return -1.
     */
    public static int max(int[] arr) {
        //  Your code goes here...
        int max = 0;
        //int i;
      for(int i=0; i<arr.length; i++ ) {
         if(arr[i]>max) {
            max = arr[i];
         }
      }
      return max;
    }

    /**
     * This method returns the sum of all the elements in the array.
     * @param arr, contains the elements in arr.
     * @return the sum of all the elements in the arr. returns -1 if there are
     * no elements.
     */
    public static int sum(int[] arr) {
        //  Your code goes here...
        int sum=0;
        int i;
        for(i=0;i<arr.length;i++){
            sum=sum+arr[i];
        }
        return sum;
    }
    
    /**
     * Make use of the functions defined for finding the 
     * minimum element, maximum element and the sum of all the elements of teh 
     * array arr.
     * 
     * @param arr, the input array.
     * @return the string version of maxSum and minSum separated by commas.
     */
    public static String miniMaxSum(int[] arr) {
        //  Your code goes here...
        //min=min(arr);
        //max=max(arr);
        int t1=sum(arr)-min(arr);
        int t2=sum(arr)-max(arr);
        String first=Integer.toString(t1);
        String last=Integer.toString(t2);
        return first+","+last;
    }
}