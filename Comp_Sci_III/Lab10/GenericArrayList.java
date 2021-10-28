import java.util.*;

public class GenericArrayList<E> implements GenericList<E>
{
    private List<E> list;
    private E[] test;
    public GenericArrayList()
    {
        list = new ArrayList<E>();
        //test = new E[0];
        test = (E[]) new Object[0]; 
    }
    
    /**
     *    Remove the Object at the specified index from the list
     *    Return the Object that was removed
     *    If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public boolean add(E obj){
        
            Object[] newArr = new Object[test.length + 1];
        
    
            for(int i = 0; i < test.length; i++)
            {
                newArr[i] = test[i];
            }
        
            newArr[newArr.length - 1] = (E) obj;
            test = (E[]) newArr;
            return true;
        
    }
    
    /**
     *    Add obj to the specified index of the list.
     *    If index is too big, then add obj to the end of the list
     *    If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj)
    {
        Object[] newArr = new Object[test.length + 1];
        Object old = null;
        
        if(index <= 0)
        {
            newArr[0] = obj;
            
            for(int i = 1; i < newArr.length; i++)
            {
                newArr[i] = test[i - 1];
            }
            
            test = (E[]) newArr;
        }
        else if(index > test.length)
        {
            for(int i = 0; i < test.length; i++)
            {
                newArr[i] = test[i];
            }
            
            newArr[newArr.length - 1] = obj;
            test = (E[]) newArr;
        }
        else
        {
            for(int i = 0; i < index; i++)
            {
                newArr[i] = test[i];
            }
            
            
            for(int j = index + 1; j < newArr.length; j++)
            {
                newArr[j] = test[j - 1];
            }
            
            newArr[index] = obj;
            test = (E[]) newArr;
        }
    }
    
    /**
     *    Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj)
    {
        for(int i = 0; i < test.length; i++)
        {
            if (test[i].equals(obj))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     *    Return the Object located at the specified index
     *    If index is too big or too small, return null
     */
    public E get(int index)
    {
        if(index < 0 || index >= test.length)
        {
            return null;
        }
        
        Object o = test[index];
        
        return (E) o;
    }
    
    /**
     *    Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
        if (test.length == 0)
        {
            return true;
        }
        
        return false;
    }
    
    /**
     *    Remove the Object at the specified index from the list
     *    Return the Object that was removed
     *    If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index)
    {
        Object[] newArr = new Object[test.length - 1];
        Object old = null;
        
        if(test.length == 0)
        {
            return null;
        }
        
        else if(index < 0 || index >= test.length)
        {
            return null;
        }
        else
        {
            old = (E) test[index];
            for(int i = 0; i < index; i++)
            {
                newArr[i] = test[i];
            }
            for(int j = index; j < newArr.length; j++)
            {
                newArr[j] = test[j + 1];
            }
            
            test = (E[]) newArr;
            return (E) old;
        }
    }
    
    /**
     *    Remove the first Object that is .equals() to obj
     *    Return true if an object was removed
     */
    public boolean remove(E obj)
    {
        Object[] newArr = new Object[test.length - 1];
        int indexObj = 0;
        boolean found = false;
        
        for(int i = 0; i < test.length; i++)
        {
            if (test[i].equals(obj))
            {
                indexObj = i;
                found = true;
                break;
            }            
        }
        
        if (found == true)
        {
            for(int i = 0; i < indexObj; i++)
            {
                newArr[i] = test[i];
            }
            
            
            for(int j = indexObj; j < newArr.length ; j++)
            {
                newArr[j] = test[j + 1];
            }
            
            test = (E[]) newArr;
            return true;
        }
        else
        {
            return false;
        }
    }
    

    
    /**
     *    Change the value stored at index to obj
     *    Return the value that was replaced
     *    If index is too big or too smalll, do not change and values and return null
     */
    public E set(int index, E obj)
    {
        Object[] newArr = new Object[test.length];
        Object old = null;
        
        if(index < 0 || index >= test.length)
        {
            return null;
        }
        else 
        {
            for(int i = 0; i < index; i++)
            {
                newArr[i] = test[i];
            }
            
            old = test[index];
            newArr[index] = obj;
            
            for(int j = index + 1; j < newArr.length; j++)
            {
                newArr[j] = test[j];
            }
            
            test = (E[]) newArr;
        }
        
        
        return (E) old;
    }
    
    /**
     *    Return the number of elements that are in the list
     */
    public int size()
    {
     return test.length;   
    }
    
}