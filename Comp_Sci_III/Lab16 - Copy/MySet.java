import java.util.LinkedList;

public class MySet<E> implements Set<E>
{
    private LinkedList<E> list;
    
    public MySet()
    {
        list = new LinkedList<E>();
    }
    
       /**
     *    Return true if the Set is empty
     */
    public boolean isEmpty()
    {
      /*   if(list.size() == 0) 
        {
            return true;
        }
        return false;*/
        return list.size() == 0;
    }
    
    /**
     *    Return the number of elements in the Set
     */
    public int size()
    {
        int count = 0;
        for(int i = 0; i < list.size(); i++)
        {
            count ++;
        }
        return count;
    }
    
    /**
     *    Return true if this Set contains obj
     */
    public boolean contains(Object obj)
    {
        for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     *    Remove obj from this set.
     *    Return true if obj was removed from the set
     */
    public boolean remove(Object obj)
    {
        if(list.size() == 0)
            {
                return false;
            }
       /* for(int i = 0; i < list.size(); i++)
        {
           if(list.get(i).equals(obj))
           
            {
                list.remove(obj);
                return true;
            }
        }*/
        
        if (contains(obj))
        {
            list.remove(obj);
            return true;
        }
        return false;
    }
    
    /**
     *    If the set does not alreay contain item:
     *        add item to the Set
     *        return true
     *    Otherwise, return false
     */
    public boolean add(E item)
    {
        /*for(int i = 0; i < list.size(); i++)
        {
            if(list.get(i).equals(item))
            {
                return false;
            }
        }*/
        
        if (!contains(item))
        {
            list.add(item);
            return true;
        }
        return false;
        
    }
}
