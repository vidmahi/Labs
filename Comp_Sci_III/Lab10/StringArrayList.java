public class StringArrayList extends MyArrayList implements StringList
{
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public boolean add(Object obj)
    {
        //Do whatever MyArrayList does for this method
        
        if(obj instanceof String)
        {
            return super.add(obj);
        }
        else
        {
            //obj is not a String!
            return false;
        }
        
    }
    
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT add obj to the list and it should return false.
     *    Otherwise, it should do whatever MyArrayList does for this method.
     */
    public void add(int index, Object obj)
    {
        //Do whatever MyArrayList does for this method
        
        if(obj instanceof String)
        {
            super.add(index, obj);
        }
        
    }
    
    /**
     *    If obj is *not* an instanceof a String then this method should
     *    NOT set the value at index to obj and it should reutnr null.
     *    Otherwise, it should do whatever MyArrayList does for this method
     */
    public Object set(int index, Object obj)
    {
        //Do  whatever MyArrayList does for this method
        
        if(obj instanceof String)
        {
            return super.set(index, obj);
        }
        else
        {
            //obj is not a String!
            return null;
        }
    }
    
    public String getStr(int index)
    {
        //return super.get(index);
        if((String) super.get(index) instanceof String)
        {
            return (String) super.get(index);
        }
        else
        {
            //obj is not a String!
            return null;
        }
    }
    
    public String removeStr(int index)
    {
        if((String) super.remove(index) instanceof String)
        {
            return (String) super.remove(index);
        }
        else
        {
            //obj is not a String!
            return null;
        }
    }
    
    public String setStr(int index, String str)
    {
        if((String) super.set(index, str) instanceof String)
        {
            return (String) super.set(index, str);
        }
        else
        {
            //obj is not a String!
            return null;
        }
    }
}