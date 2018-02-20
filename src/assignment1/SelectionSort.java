package assignment1;

/**
 *
 * @author ryanv
 */
public class SelectionSort {
    /**Sorts an array using SelectionSort method
     * 
     * @param a the input array
     * @param size the size of the array
     * @param <T> template, accepts any type array
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] a, int size){
        for(int index = 0; index < size - 1; index++){
            int indexOfNextSmallest = 0;
            swap(a, index, indexOfNextSmallest);
        }
    }
    
    private static <T extends Comparable <? super T>> int getIndexOfSmallest
        (T [] a, int first, int last) {
        T min = a [first];
        int indexOfMin = first;
        for (int index = first + 1 ; index <= last ; index++) {
            if (a [index].compareTo (min) < 0) {
                min = a [index];
                indexOfMin = index;
            } // end if
        } // end for
        return indexOfMin;
    } // end getIndexOfSmallest
    
    private static void swap (Object [] a, int i, int j) {
        Object temp = a [i];
        a [i] = a [j];
        a [j] = temp;
    }
}