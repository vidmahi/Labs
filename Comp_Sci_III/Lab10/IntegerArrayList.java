public class IntegerArrayList extends MyArrayList implements IntegerList
{
    /**
     *    If obj is *not* an instanceof a Integer then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public boolean add(Object obj)
    {
        //Do whatever MyArrayList does for this method
        
        if(obj instanceof Integer)
        {
            return super.add(obj);
        }
        else
        {
            //obj is not a Integer!
            return false;
        }
        
    }
    
    /**
     *    If obj is *not* an instanceof a Integer then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public void add(int index, Object obj)
    {
        //Do whatever MyArrayList does for this method
        
        if(obj instanceof Integer)
        {
            super.add(index, obj);
        }
        
    }
    
    /**
     *    If obj is *not* an instanceof a Integer then this method should
     *    NOT set the value at index to obj and it should reutnr null.
     *    Otherwise, it should do whatever MyArrayList does for this method
     */
    public Object set(int index, Object obj)
    {
        //Do  whatever MyArrayList does for this method
        
        if(obj instanceof Integer)
        {
            return super.set(index, obj);
        }
        else
        {
            //obj is not a Integer!
            return null;
        }
    }
    
    public Integer getInt(int index)
    {
        //return super.get(index);
        if((Integer) super.get(index) instanceof Integer)
        {
            return (Integer) super.get(index);
        }
        else
        {
            //obj is not a Integer!
            return null;
        }
    }
    
    public Integer removeInt(int index)
    {
        if((Integer) super.remove(index) instanceof Integer)
        {
            return (Integer) super.remove(index);
        }
        else
        {
            //obj is not a Integer!
            return null;
        }
    }
    
    public Integer setInt(int index, Integer i)
    {
        if((Integer) super.set(index, i) instanceof Integer)
        {
            return (Integer) super.set(index, i);
        }
        else
        {
            //obj is not a Integer!
            return null;
        }
    }
}