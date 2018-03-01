package assignment1;

import java.lang.reflect.Array;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ryanv
 */
public class MergeSort implements SortingStrategy {
    
    
    @Override
    public void Sort(int[]a){
        new Thread(()->{
            for (int i = 0; i < a.length; i++)
            {
                try{
                    Thread.sleep(100);
                }
                catch (InterruptedException ex){
                }
                mergeSort(a);
            }
        }).start();
        
    }
    
    public static void mergeSort(int [ ] a){
        int[] tmp = new int[a.length];
        mergeSort(a, tmp,  0,  a.length - 1);
    }
    
    private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right){
        new Thread (()->{
        if( left < right )
        {
                int center = (left + right) / 2;
                mergeSort(a, tmp, left, center);
                mergeSort(a, tmp, center + 1, right);
                merge(a, tmp, left, center + 1, right);
        }
        }).start();
    }

    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd )
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
        
        //ANIMATION HERE:
    }
}