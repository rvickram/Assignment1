package assignment1;

/**
 *
 * @author ryanv
 */
public class SelectionSort implements SortingStrategy{
    
    public void Sort(int[]a){
        selectionSort(a, a.length);
    }
    /**Sorts an array using SelectionSort method
     * 
     * @param a the input array
     * @param size the size of the array
     * @param <T> template, accepts any type array
     */
    public void selectionSort(int[] a, int size){
        for(int index = 0; index < size - 1; index++){
            int indexOfNextSmallest = getIndexOfSmallest (a, index, size - 1);;
            swap(a, index, indexOfNextSmallest);
        }
    }
    
    private int getIndexOfSmallest(int[] a, int first, int last) {
        int min = a [first];
        int indexOfMin = first;
        for (int index = first + 1 ; index <= last ; index++) {
                if (min > a[index]) {
                min = a [index];
                indexOfMin = index;
            } // end if
        } // end for
return indexOfMin;

    } // end getIndexOfSmallest
    
    private static void swap (int [] a, int i, int j) {
        int temp = a [i];
        a [i] = a [j];
        a [j] = temp;
    }
}