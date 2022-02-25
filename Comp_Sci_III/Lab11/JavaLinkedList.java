public class JavaLinkedList
{
    private MyLinkedList<Integer> list;
    
    /**
     *  Default Constructor
     *  Create a new MyLinkedList of Integers
     */
    public JavaLinkedList()
    {
        list = new MyLinkedList<Integer>();
        
    }

    /**
     *  Create a new MyLinkedList of Integers from the array
     */
    public JavaLinkedList(int[] nums)
    {
        list = new MyLinkedList<Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            list.add((Integer) nums[i]);
        }
        
    }

    /**
     *  Return the sum of all the items in the list
     */
    public double getSum(  )
    {
        double total=0;
        
        for (int i = 0; i < list.size(); i++)
        {
            total += list.get(i);
        }
    
        return total;
    }

    /**
     *  Return the mean of all the items in the list
     */
    public double getMean(  )
    {
        return getSum()/list.size();
    }
    
    /**
     *  Return the largest item in the list
     */
    public int getLargest()
    {
        int largest=Integer.MIN_VALUE;
        
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) > largest)
            {
                largest = list.get(i);
            }
        }
        
        return largest;
    }

    /**
     *  Return the smallest item in the list
     */
    public int getSmallest()
    {
        int smallest = smallest=Integer.MAX_VALUE;
        
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) < smallest)
            {
                smallest = list.get(i);
            }
        }
        return smallest;
    }

    /**
     *  Return a string with this format:
     *  
     *  SUM:: 10.0
     *  MEAN:: 4.65
     *  SMALLEST:: -1.23
     *  LARGEST:: 5.0
     */
    public String toString()
    {
        String output="SUM:: " + getSum() + "\n" + "MEAN:: " + getMean() + "\n" + "SMALLEST:: " + getSmallest() + "\n" + "LARGEST:: " + getLargest() + "\n" + "\n";
        return output;
    }
}