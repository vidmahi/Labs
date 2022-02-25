import java.io.*;
import java.util.Scanner;
import java.io.File;

public class RoyalFamily
{
    public static void main(String[] args)
    {
        //Define a variable to store the root node
        TNode<String> root = null;
        
        //TODO: SETUP TREE DATA
        //1. Use Scanner to read the data.txt file
        //2. The first line in data.txt is the root node
        //3. For each line in data.txt in the format A > B
        //        - *find* the A node
        //        - add B as a child of A
        
        try
        {
            //Open a Stream to a file you can read from
            Scanner s = new Scanner( new File("data.txt") );
            
            root = new TNode<String>(s.nextLine());
            //Loop through each line of the file
            while(s.hasNextLine())
            {
                    
                String[] split = null;
                String line = s.nextLine();
                if(!line.contains(">"))
                {
                    root = new TNode<String>(line);
                }else{
                     split = line.split(" > ");
                     System.out.println(split[0] + ", " + split[1]);
                     TNode<String> parent = find(root, split[0]);
                     parent.addChild(new TNode<String>(split[1]));
                }
                
                
            }
            //Close the stream
            s.close();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        
        
        
        //TODO: test printPath method
        TNode<String> child = find(root, "Princess Beatrice of York");
        String path = getPath( child );
        System.out.println(path);
    }
    
    /**
     *    @return node if its data matches name, or return a child node with data that matches name
     */
    public static TNode<String> find(TNode<String> node, String name)
    {
        //use recursion to check this node and all of its children to see if their data matches the specified name
        
        //System.out.println("node = " + node.getData());
        
        
       /* if(node.getData().equals(name))
        {
            return node;
        }
        
        System.out.println(node.getChildren().size());
        for (int j = 0; j < node.getChildren().size(); j++)
        {
            System.out.println(node.getChildren().get(j).getData());
            
        }
        
        
        for (int i = 0; i < node.getChildren().size(); i++)
        {
        //for(TNode<String> child : node.getChildren())
        //{
            //System.out.println("child = " + child.getData());
            //return find(child, name);
       // }
           System.out.println("i = " + i);
           
            return find(node.getChildren().get(i),name);
               
        }*/
            
        //return null;
        //System.out.println("parentnode = " + node.getParent().getData());
        
        if(node.getData().equals(name))
        {
            return node;
        }
        else
        {
            for(TNode<String> child : node.getChildren())
            {
                TNode<String> x = find(child, name);
                if(x != null)
                {
                    return x;
                }
            }
        }
        
        return null;
        
        
    }
    
    /**
     *    @return a String containing the path from the root node to the specified node, separeated by ->
     */
    public static String getPath(TNode<String> node)
    {
        //use recursion to concatenate the getPath of this node's parent with this node's data
        
        /*String s = (String) node.getData();
        for(TNode<String> child : node.getChildren())
        {
            s += getPath(child);
        }
        
        
        return s;*/
        
        String[] arr = new String[10];
        int i = 0;
        
        if(!node.getParent().equals(null))
            //return getPath(node.getParent()) + " -> " + node.getData(); 
        {
            
            arr[i] = node.getParent().getData();
            System.out.println(node.getParent().getData());
            i++;
            return getPath(node.getParent());
        
        }  
        return getPath(node.getParent());
        
         
    }
}
