public class MyLinkedList<E> implements GenericList<E>
{
    
    private Node<E> head;
    
    public MyLinkedList()
    {
        head = new Node<E>(null);
    }
    
    /**
    * This method returns the index where the first occurrence of obj
    * If list does not contain obj, then return -1
    */
    private int indexOf(E obj)
    {
        int spot = 0;
        Node<E> n = head.getNext();
        while (n != null && !n.getValue().equals(obj))
        {
            spot++;
            n = n.getNext();
        }
        if (n == null)
        {
            return -1;
        }
        return spot;
    }

    /**
    * return the Node object that is stored at index
    * If index is out of bounds then return null
    */
    private Node<E> getNode(int index)
    {
        if (index < 0 || index >= size())
        {
            return null;
        }
        
        Node<E> n = head.getNext();
        int i = 0;
        
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        return n;
    }
    
    /**
     *    Add obj to the end of the list.
     *    This method always returns true
     */
    public boolean add(E obj)
    {
        Node<E> n = head;
        while (n.getNext() != null)
        {
            n = n.getNext();
        }
        n.setNext(new Node<E>(obj));
        return true;
    }
    
    /**
     *    Add obj to the specified index of the list.
     *    If index is too big, then add obj to the end of the list
     *    If index is too small, then add obj to the start of the list
     */
    public void add(int index, E obj)
    {
        //this was the original
        /*Node<E> n = new Node<E>(obj);
        Node<E> before = getNode(index-1);
        Node<E> after = before.getNext();
        
        before.setNext(n);
        n.setNext(after);*/
        
        Node<E> first = head;
        Node<E> n = new Node<E>(obj);
        
        if(index <= 0) {
            n.next = head;
            //first.prev = n;
            head = n;
        }
        else if(index >=size()) {
           /* n.next = null;
            //Node<E> temp = head;
            while(first.next != null){
                first = first.next;
            }
            first.next = n; */
            
            add(obj);
        }
        else
        {
            Node<E> before = getNode(index-1);
            Node<E> after = before.getNext();
        
            before.setNext(n);
            n.setNext(after);
        }
    }
    
    /**
     *    Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(E obj)
    {
        // this was the original
       /* int spot = 0;
        Node<E> n = head.getNext();
        while (n != null && !n.getValue().equals(obj))
        {
            spot++;
            n = n.getNext();
        }
        if (spot != 0)
        {
            return true;
        }
        return false;*/
        
        int spot = 0;
        Node<E> n = head.getNext();
        
        /*while (n != null && !n.getValue().equals(obj))
        {
            spot++;
            n = n.getNext();
        }
        if (spot != 0)
        {
            return true;
        }
        return false;*/
        
       

        while (n != null)
        {
          if (n.getValue().equals(obj))
          {
            return true;
          }

          n = n.getNext();
        }

        return false;
    }
    
    /**
     *    Return the Object located at the specified index
     *    If index is too big or too small, return null
     */
    public E get(int index)
    {
        if (index < 0 || index >= size())
        {
            return null;
        }
        
        return getNode(index).getValue();
    }
    
    /**
     *    Return true if there are no elements in the list
     */
    public boolean isEmpty()
    {
       /*  Node<E> n = head.getNext();
        if (n.getNext() == null)
        {
            return true;
        }
        return false;*/
        return size() == 0;
    }
    
    /**
     *    Remove the Object at the specified index from the list
     *    Return the Object that was removed
     *    If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public E remove(int index)
    {
        if (index < 0 || index >= size())
        {
            return null;
        }
        
        if(isEmpty())
        {
            return null;
        }
        
        Node<E> n = head;
        
        E old = null;
        // Original
        // If index=0 , put head node = Node at index 1.
        if (index == 0) {
            if(n.getNext()!=null) {
              old = getNode(index).getValue();
                Node<E> aftern = n.getNext();
            //n.setNext(aftern);
            head = aftern;
            }else {
                n=null;
            }
            
            return old;
        }
        
        
        
        
        if (n.getNext() == null)
        {
            return null;
        }
        
        int i = 0;
        
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        E old1 = getNode(index).getValue();
        
        Node<E> before = getNode(i-1);
        Node<E> after = before.getNext();
        return old1;
        
        ////////////////////////////////////////// version 2
        /*
        E old = null;
        
        if (index < 0 || index >= size())
        {
            return null;
        }
        else if(isEmpty())
        {
            return null;
        }
        else if (index == 0)
        {
            old = n.getValue();
            Node<E> second = n.getNext();
            head = second;
            return old;
        }
        else
        {
            int i = 0;
        
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        E old1 = getNode(index).getValue();
        
        Node<E> before = getNode(i-1);
        Node<E> after = before.getNext();
        return old1;
        }
        */
        
        
        
        
    }
    
    /**
     *    Remove the first Object that is .equals() to obj
     *    Return true if an object was removed
     */
    public boolean remove(E obj)
    {
        //this was the original
      /*  E old = null;
        
        if (indexOf(obj) != -1)
        {
            int i = indexOf(obj);
            //Node<E> old = getNode(i);
           // Node<E> before = getNode(i-1);
            //Node<E> after = before.getNext();
        
            //before.setNext(after);
            old = remove(i);
            return true;
        }
        return false;*/
        
        //this was version 2
        Node<E> n = head;
        //int i = 0;
        int i = indexOf(obj);
        if (i != -1)
        {
            if (i == 0)
            {
                Node<E> after = n.getNext();
                head = after;
            }
            else
            {
        while(n.getNext() != null)
        {
            //i++;
            if (n.getValue().equals(obj))
            {
                Node<E> old = getNode(i);
                Node<E> before = getNode(i-1);
                Node<E> after = before.getNext();
        
                before.setNext(after);
                return true;
                    
            }
            else
            {
                n = n.getNext();
                i++;
            }
        }
    }
        return false;
            
        }
        
        return false;
        //this was add obj
        /*Node<E> n = head;
        while (n.getNext() != null)
        {
            n = n.getNext();
        }
        n.setNext(new Node<E>(obj));
        return true;*/
    }
    
    /**
     *    Change the value stored at index to obj
     *    Return the value that was replaced
     *    If index is too big or too smalll, do not change and values and return null
     */
    public E set(int index, E obj)
    {
        if (index < 0 || index >= size())
        {
            return null;
        }
        
        Node<E> n = head;
        int i = 0;
        
        while(n != null && i < index)
        {
            i++;
            n = n.getNext();
        }
        E old = getNode(index).getValue();
        //n.setValue(obj);
        E newn = getNode(i).setValue(obj);
        return old;
    }
    
    /**
     *    Return the number of elements that are in the list
     */
    public int size()
    {
        Node<E> n = head.getNext();
        int count = 0;
        while(n != null)
        {
            count++;
            n = n.getNext();
        }
        return count;
    }
    
    //Private Helper Class
    class Node<E>
    {
        private E value;
        private Node<E> next;
        
        public Node(E data)
        {
            this.value = data;
            this.next = null;
        }
        
        public E getValue()
        {
            return value;
        }
        
        public E setValue(E data)
        {
            this.value = data;
            return value;
        }
        
        public Node<E> getNext()
        {
            return next;
        }
        
        public Node<E> setNext(Node<E> node)
        {
            this.next = node;
            return next;
        }
        
    }
}