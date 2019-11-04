/**
 * 
 */

public class OrderedList<E  extends Comparable<E>> extends AbstractList<E> {
    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     * 
     * The method returns void (nothing)
     */
    public void add(E item) {
        //Inserts the specified element at the end of the list.
        // TODO
        // Your code goes here....
    }

    public int rank(E item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item.compareTo(list[lo]) < 0) hi = mid - 1; 
            else if (item.compareTo(list[lo]) > 0) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    public static void main(String[] args) {
        AbstractList lst = new OrderedList();
        lst.add(1, 1);
    }
    
}