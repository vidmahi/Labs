public class Lab10Part1
{
    public static void main(String[] args)
    {
        MyArrayList list = new MyArrayList();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
        
        int r = (int)(Math.random() * list.size());
        
        /* One way of doing it
         
        String s1 = (String) list.get(r);
        String s2 = s1.toUpperCase();
        System.out.println(s2);
          
         */
        
        // The second way of doing it
        
        if(list.get(r) instanceof String)
        {
            String s1 = (String) list.get(r);
            String s2 = s1.toUpperCase();
            System.out.println(s2);
        }
        else
        {
            System.out.println("The object is not a String!");
        }
    }
}