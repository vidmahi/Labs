import java.util.List;

public class BST<E extends Comparable>
{
    private BNode<E> root;
    
    public BST() 
    {
        root = null;
    }
    
    //add data to this BST
    public void add(E data)
    {
        BNode<E> node = new BNode<E>(data);
        if(root == null)
        {
            root = node;
        }
        else
        {
            addHelper(root, node);
        }
    }
    
    //Recursive helper method for add
    private void addHelper(BNode<E> node, BNode<E> addMe)
    {
      if(addMe.getData().compareTo(node.getData()) < 0)
      {
         if (node.getLeft() != null)
         {
             node = node.getLeft();
             addHelper(node, addMe);
         }
         else
         {
             node.setLeft(addMe);
         }
      }
      else if(addMe.getData().compareTo(node.getData()) >= 0)
      {
         if (node.getRight() != null)
         {
             node = node.getRight();
             addHelper(node, addMe);
         }
         else
         {
             node.setRight(addMe);
         }
      }
    }
    
    public void addAll(List<E> data)
    {
        for(int i = 0; i < data.size(); i++)
        {
            add(data.get(i));
        }
    }
    
    //reutrn the size of this tree (how many nodes are in it?)
    public int size()
    {
        return sizeHelper(root);
    }
    
    //recursive helper method for size
    public int sizeHelper(BNode<E> node)
    {
        if(node.getNumChildren() == 0)
        {
            return 1;
        }
        else
        {
            return (1 + sizeHelper(node.getLeft()) + sizeHelper(node.getRight()));
        }
    }
    
    //Return a string with the data of this BST in pre order
    public String preorder()
    {
        String s = preorderHelper(root, "");
        int len = s.length();
        String truncS = s.substring(0, len - 2);
        s = "[" + truncS  + "]";
        return s;
    }
    
    //Recursive helper method for preorder
    private String preorderHelper(BNode<E> node, String ret)
    {
        if(node == null)
        {
            return ret; 
        }
    
        ret = ret + node.getData() + ", ";
        ret = preorderHelper(node.getLeft(), ret);
        ret = preorderHelper(node.getRight(), ret);
        return ret;
    }
    
    //Return a string with the data of this BST in order
    public String inorder()
    {
        String s = inorderHelper(root, "");
        int len = s.length();
        String truncS = s.substring(0, len - 2);
        s = "[" + truncS  + "]";
        return s; 
    }
    
    //Recursive helper method for inorder
    private String inorderHelper(BNode<E> node, String ret)
    {
        if(node == null)
        {
            return ret; 
        }
        
        ret = inorderHelper(node.getLeft(), ret);
        ret = ret + node.getData() + ", ";
        ret = inorderHelper(node.getRight(), ret);
        return ret;
    }
    
    //Return a string with the data of this BST in post order
    public String postorder()
    {
        String s = postorderHelper(root, "");
        int len = s.length();
        String truncS = s.substring(0, len - 2);
        s = "[" + truncS  + "]";
        return s; 
    }
    
    //Recursive helper method for postorder
    private String postorderHelper(BNode<E> node, String ret)
    {
        if(node == null)
        {
            return ret; 
        }
        
        ret = postorderHelper(node.getLeft(), ret);
        ret = postorderHelper(node.getRight(), ret);
        ret = ret + node.getData() + ", ";
        return ret;
    }
    
    //Check if this BST contains the specified data
    public boolean contains(E data)
    {
        return containsHelper(root, data);
    }
    
    //Recursive helper method for contains
    private boolean containsHelper(BNode<E> node, E data)
    {
        if (node == null)
        {
            return false;
        }
        else if (node.getData().equals(data))
        {
            return true;
        }
        else if(data.compareTo(node.getData()) < 0)
        {
            return containsHelper(node.getLeft(), data);
        }
        else 
        {
            return containsHelper(node.getRight(), data);
        }
    }
    
    //Remove the first occurance of data from this BST tree.
    //If data is successfully removed return true, otherwise return false.
    public boolean remove(E data)
    {
        BNode<E> X = root;
        BNode<E> parent = null;
        
        while (X != null && !(X.getData().equals(data)))
        {
            parent = X;
            if (data.compareTo(X.getData()) < 0)
            {
                X = X.getLeft();
            }
            if (data.compareTo(X.getData()) > 0)
            {
                X = X.getRight();
            }
            
        }
        
        if (X == null)
            return false;
            
        if (X.getNumChildren() == 0)
        {
            if (parent.getLeft().getData().equals(X.getData()))
            {
                parent.setLeft(null);
            }
            else if (parent.getRight().getData().equals(X.getData()))
            {
                parent.setRight(null);
            }
            
        }
        else if (X.getNumChildren() == 1)
        {
            if (X.hasLeftChild())
            {
                BNode<E> lChild = X.getLeft();
                parent.setLeft(lChild);
            }
            else if (X.hasRightChild())
            {
                BNode<E> rChild = X.getRight();
                parent.setRight(rChild);
            }
        }
        else if (X.getNumChildren() == 2)
        {
            BNode<E> cNode = null;
            
            cNode = combine(X.getLeft(), X.getRight());
            
            if (parent != null)
            {
                if (cNode.getData().compareTo(parent.getData()) < 0)
                {
                    parent.setLeft(cNode);
                }
                else if (cNode.getData().compareTo(parent.getData()) >= 0)
                {
                    parent.setRight(cNode);
                }
            }
            else
            {
                root = cNode;
            }
            
        }
    
        return true;
    }
    
    //Recursive helper method for remove. Removes the smallest descendant from the specified node.
    public BNode<E> removeSmallestChild(BNode<E> node)
    {
        BNode<E> temp;
        if (node.getNumChildren() == 0 || (node.getNumChildren() == 1 && (node.hasRightChild())))
        {
            return node;
        }
        if (node.hasLeftChild())
        {
            temp = removeSmallestChild(node.getLeft());
            if (temp.equals(node.getLeft()))
            {
                node.setLeft(temp.getRight());
            }
            return temp;
        }
        return null;
    }
    
    //Helper method for remove. Reforms the left and right subtrees into a single
    //BST and returns its root node.
    public BNode<E> combine(BNode<E> left, BNode<E> right)
    {
        //BNode<E> X;
        BNode<E> X = removeSmallestChild(right);
        if(X.equals(right))
        {
            right = right.getRight();
        }
        X.setLeft(left);
        X.setRight(right);
        return X;
    }
    
    ///////////////////
    //    Helper Class //
    ///////////////////
    class BNode<E extends Comparable>
    {
        private E data;
        private BNode<E> left, right;
        
        public BNode(E data)
        {this.data = data;}
        
        public E getData()
        {return data;}
        
        public BNode<E> getLeft()
        {return left;}
        
        public BNode<E> getRight()
        {return right;}
        
        public void setLeft(BNode<E> left)
        {this.left = left;}
        
        public void setRight(BNode<E> right)
        {this.right = right;}
        
        public boolean hasLeftChild()
        {return null != left;}
        
        public boolean hasRightChild()
        {return null != right;}
  
          public boolean hasChildren()
          {return getNumChildren() > 0;}
          
          public int getNumChildren()
          {
              int ret = 0;
              if(hasLeftChild())  ret++;
              if(hasRightChild()) ret++;
              return ret;
          }
    }
}