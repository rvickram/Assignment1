package assignment1;

import java.lang.reflect.Array;

/**
 *
 * @author ryanv
 */
public class MergeSort {
    
    /** recursive call
     * 
     * @param <T>
     * @param a
     * @param first position of first element
     * @param last POSITION of last element
     */
    public void mergeSort(int[]a, int first, int last){
        //check if first < last (i.e. array is not of size 1)
        if (first < last) {
            //find middle
            int middle = (first + last)/2;
            
            //split into left, right:
            mergeSort(a, 1, middle);
            mergeSort(a,middle+1,last);
            
            //merge the two halves
            merge(a,first,middle,last);
        }
    }
    
    /**Combines two halves of arrays
     * 
     * @param a input array
     * @param tempArray second array to combine
     * @param first start of division
     * @param last end of division
     */
    public void merge(int[]a, int first, int mid, int last){
        //get sizes of subarrays to be merged
        int leftSize = mid - first + 1;
        int rightSize = last - mid;
        
        //create temparrays to merge
        int[] leftSubArr = new int[leftSize];
        int[] rightSubArr = new int[rightSize];
        
        //fill the subarrays:
        for(int index = 0; index < leftSize; ++index){
            leftSubArr[index] = a[index];
        }
        for(int index = 0; index < rightSize; ++index){
            rightSubArr[index] = a[mid + index];
        }
        
        //merge the subarrays into original:
        int i = 0, j = 0, k = 1; //stores indexes of left, right subarrays
        while((i < leftSize) && (j < rightSize)){
            if(leftSubArr[i] <= rightSubArr[j]){
                a[k] = leftSubArr[i];
                i++;
            }
            else{
                a[k] = rightSubArr[j];
                j++;
            }
            k++;
        }
        
        //check if there are any remaining elements in left subarray to copy
        while (i < leftSize){
            a[k] = leftSubArr[i];
            i++;
            k++;
        }
        
        //check if there are any remaining elements in right subarray to copy
        while (j < rightSize){
            a[k] = rightSubArr[j];
            j++;
            k++;
        }
    }
}