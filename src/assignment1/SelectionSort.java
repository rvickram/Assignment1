package assignment1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryanv
 */
public class SelectionSort implements SortingStrategy{
    
    public void Sort(int[]a){
         new Thread(()->{
            for (int i = 0; i < a.length; i++)
            {
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException ex){
                }
                 selectionSort(a, a.length - 1);
            }
        }).start();
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
        new Thread(()->{
            int temp = a [i];
        a [i] = a [j];
        a [j] = temp;
           
        }).start();
        
    }
}