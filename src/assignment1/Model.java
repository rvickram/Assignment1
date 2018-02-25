package assignment1;

/**
 *
 * @author Miles
 */
public class Model {
    int[] intArray;
    int arraySize;
    
    public void reset(int size)
    {
        arraySize = size;
        getUnsortedList();
    }
    
    public void getUnsortedList()
    {
        int i;
        for (i=0; i<arraySize; i++)
        {
            int rand = (int )(Math.random() * 300 + 1);
            intArray[i]= rand;
        }
    }
    
    public int getArraySize(int size)
    {
        arraySize=size;
        return arraySize;
    }
    
    public int[] setArraySize(int[] oldArray, int size)
    {
        oldArray = null;
        arraySize = size;
        getUnsortedList();
        return intArray;
    }
}
