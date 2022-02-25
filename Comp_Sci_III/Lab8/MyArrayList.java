public class MyArrayList implements MyList
{
    
    private Object[] data;
    
    public MyArrayList()
    {
        data = new Object[0];
    }
    
    /**
     *    Add obj to the end of the list.
     *    This method always returns true
     */
    public boolean add(Object obj){
        
        Object[] newArr = new Object[data.length + 1];
        
    
        for(int i = 0; i < data.length; i++)
        {
            newArr[i] = data[i];
        }
        
        newArr[newArr.length - 1] = obj;
        data = newArr;
        return true;
    }
    
    /**
     *    Add obj to the specified index of the list.
     *    If index is too big, then add obj to the end of the list
     *    If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj){
        
        Object[] newArr = new Object[data.length + 1];
        Object old = null;
        
        if(index <= 0)
        {
            newArr[0] = obj;
            
            for(int i = 1; i < newArr.length; i++)
            {
                newArr[i] = data[i - 1];
            }
            
            data = newArr;
        }
        else if(index > data.length)
        {
            for(int i = 0; i < data.length; i++)
            {
                newArr[i] = data[i];
            }
            
            newArr[newArr.length - 1] = obj;
            data = newArr;
        }
        else
        {
            for(int i = 0; i < index; i++)
            {
                newArr[i] = data[i];
            }
            
            
            for(int j = index + 1; j < newArr.length; j++)
            {
                newArr[j] = data[j - 1];
            }
            
            newArr[index] = obj;
            data = newArr;
        }
    }
    
    /**
     *    Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj){
        
        for(int i = 0; i < data.length; i++)
        {
            if (data[i].equals(obj))
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
    public Object get(int index){
        if(index < 0 || index >= data.length)
        {
            return null;
        }
        
        Object o = data[index];
        
        return o;
    }
    
    /**
     *    Return true if there are no elements in the list
     */
    public boolean isEmpty(){
        
        if (data.length == 0)
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
    public Object remove(int index){
        
        Object[] newArr = new Object[data.length - 1];
        Object old = null;
        
       /* if(data.length == 0)
        {
            return null;
        }
        
        else if(index < 0 || index >= data.length)
        {
            return null;
        }
        else
        {
        
            for(int i = 0; i < data.length; i++)
            {
                if(i < index)
                {
                    newArr[i] = data[i];
                }
                else if(i == index)
                {
                    old = data[i];
                }
                else
                {
                    newArr[i - 1] = data[i];
                }
            }
            data = newArr;
            return old;
        }*/
        
        if(data.length == 0)
        {
            return null;
        }
        
        else if(index < 0 || index >= data.length)
        {
            return null;
        }
        else
        {
            old = data[index];
            for(int i = 0; i < index; i++)
            {
                newArr[i] = data[i];
            }
            for(int j = index; j < newArr.length; j++)
            {
                newArr[j] = data[j + 1];
            }
            
            data = newArr;
            return old;
        }
    }
    
    
    /**
     *    Remove the first Object that is .equals() to obj
     *    Return true if an object was removed
     */
    public boolean remove(Object obj){
        
        Object[] newArr = new Object[data.length - 1];
        int indexObj = 0;
        boolean found = false;
        
        for(int i = 0; i < data.length; i++)
        {
            if (data[i].equals(obj))
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
                newArr[i] = data[i];
            }
            
            
            for(int j = indexObj; j < newArr.length ; j++)
            {
                newArr[j] = data[j + 1];
            }
            
            data = newArr;
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
    public Object set(int index, Object obj){
        
        Object[] newArr = new Object[data.length];
        Object old = null;
        
        if(index < 0 || index >= data.length)
        {
            return null;
        }
        else 
        {
            for(int i = 0; i < index; i++)
            {
                newArr[i] = data[i];
            }
            
            old = data[index];
            newArr[index] = obj;
            
            for(int j = index + 1; j < newArr.length; j++)
            {
                newArr[j] = data[j];
            }
            
            data = newArr;
        }
        
        
        return old;
        
    }
    
    /**
     *    Return the number of elements that are in the list
     */
    public int size(){
        
        return data.length;
    }
}