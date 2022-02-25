public class MyTester
{
    public static void main(String[] args)
    {
        Stack<Integer> i = new MyStack<Integer>();
        Queue<String> s = new MyQueue<String>();
        
        i.push(1);
        i.push(2);
        i.push(3);
        System.out.println(i.peek());
        System.out.println(i.pop());
        System.out.println(i.peek());
        
        s.add("one");
        s.add("two");
        s.add("three");
        System.out.println(s.peek());
        System.out.println(s.remove());
        System.out.println(s.peek());
    }
}