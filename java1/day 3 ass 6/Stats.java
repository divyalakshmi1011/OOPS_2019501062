/**
 * Given an array of integers Find the mean, median, mode, standard deviation
 * and variance.
 * 
 * Mean
 * Input : [1,2,3,4,5]
 * Output : 3.0
 * 
 * Median
 * Input : [1,2,3,4,5]
 * Output : 3.0
 * 
 * Mode
 * Input : [1,1,2,2,3]
 * Output : [1,2]
 * 
 * Variance
 * Input : [1,2,3,4,5]
 * Output : 2.0
 * 
 * Standard Deviation
 * Input : [1,2,3,4,5]
 * Output : 1.41421356
 * 
 * @author Siva Sankar
 */

import java.util.*;

public class Stats {

    /**
     * This method should return the mean of the elements of the array.
     * If the arr is empty (length is 0), return the mean as 0.
     * @param arr, the input array contians elements.
     * @return the mean of the array.
     */
    public static double mean(int[] arr) {
        //  Your code goes here....
        int total = 0;
        int size = arr.length;
        if(size>0){
            for(int i = 0;i<size;i++) {
                total=total+arr[i];
            }
            double mean=(double)total/size;
            return mean;
        }else{
            return 0.0;
    }
}

    /**
     * This method returns the median of the elements of the array.
     * Prerequisite : The array should be sorted to find the median.
     * 
     * Hint : Arrays.sort(arr) sorts the elements of the array.
     * 
     * @param arr, the input array contains random elements (not in sorted order)
     * @return the median of the elements of the array.
     */
    public static double median(int[] arr) {
        //  Your code goes here...
        int size=arr.length;
        Arrays.sort(arr);
        if(size%2==0){
            return (arr[size/2]+arr[(size-1)/2])/2.0;
        }else if(!(size%2==0)){
            return arr[size/2];            
        }else{
            return 0.0;
        }                
 }

    /**
     * This method returns the mode of the array. If there is no mode, then it returns
     * 0 as the mode.
     * 
     * @param arr, the input array.
     * @return the mode of the array, 0 otherwise if there is no mode.
     */
    public static int mode(int[] arr) {
        //  Your code goes here....
        int size=arr.length;
        int arrMode=arr[0];
        int maxCount=1;

        for(int i=0;i<size;++i){
            int count=0;
            for(int j=0;j<size;++j){
                if(arr[j]==arr[i]){
                    ++count;                                                
                }                                         
                
                if(count>maxCount){
                    maxCount=count;
                    arrMode=arr[i];
                }
            }
        }
        if (maxCount==1){
            return 0;
        }else{
            return arrMode;
        }            
    }

    /**
     * This method returns the variance of the input array.
     * Make use of the mean functon which has already written.
     * 
     * @param arr, the input array
     * @return the variance of the array.
     */
    public static double variance(int[] arr) {
        //  Your code goes here....
        int size=arr.length;
        double vari=0.0;
        if(size>0){
            for(int i=0;i<size;i++){
                vari=vari+Math.pow(arr[i]-mean(arr),2);            
            }
            return vari/size;
        }else{
            return 0.0;
        }       
    }

    /**
     * This method returns the standard deviation of the array.
     * Hint : You can find the square root using Math.sqrt() method.
     * @param arr, the input array
     * @return the standard deviation of the input array.
     */
    public static double standardDeviation(int[] arr) {
        //  Your code goes here....
        //public static double standardDeviation(int[] arr) {
            return Math.sqrt(variance(arr));
        }
    }