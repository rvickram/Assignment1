package assignment1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Miles
 */
public class Model {
    int[] intArray;
    int arraySize;
    
    public Model(){
        intArray = new int[1];
    }
    
    public void reset(int size)
    {
        arraySize = size;
        getUnsortedList();
    }
    
    public int[] getUnsortedList()
    {
        return intArray;
    }
    
    public int getArraySize()
    {
        return arraySize;
    }
    
    /**
     * 
     * @param maxHeight takes height of pane
     * @param size takes size of array
     */
    public void setArraySize(int maxHeight, int size)
    {
        arraySize = size;
        intArray = new int[arraySize];
        
        int i;
        for (i=0; i<arraySize; i++)
        {
            intArray[i]= ThreadLocalRandom.current().nextInt(1, maxHeight);
        }
    }
}
