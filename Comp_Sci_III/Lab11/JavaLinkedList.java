public class JavaLinkedList
{
    private MyLinkedList<Integer> list;
    //private LinkedList<Integer> list;

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
        /*while (list.head.getNext() != null)
        {
            
        }*/
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
        Node head;
        
        
         while (head != null)
         { 
  
        // If max is less then head->data then 
        // assign value of head->data to max 
        // otherwise node point to next node. 
            if (largest < head.data) 
                largest = head.data; 
            head = head.next; 
        } 
        
        return largest;
    }

    /**
     *  Return the smallest item in the list
     */
    public int getSmallest()
    {
        int smallest = smallest=Integer.MAX_VALUE;
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
        String output="";
        return output;
    }
}