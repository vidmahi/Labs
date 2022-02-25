public class Palindrome
{
    public static void main(String[] args)
    {
        String test = "T! a-,CO!?~.    c-A<>  t.@#$%!^&*()";
        System.out.println(isPalindrome(test));
    }
    
    public static boolean isPalindrome(String str)
    {
        Stack<String> s = new MyStack<String>();
        Queue<String> q = new MyQueue<String>();
        
        for(int i = 0; i < str.length(); i++)
        {
            String letter = str.substring(i, i+1);
            String legal = "abcdefghijklmnopqrstuvwxyz";
            String lowerCaseLetter = letter.toLowerCase();
            if( legal.indexOf( lowerCaseLetter ) > -1 )
            {
                s.push(lowerCaseLetter);
                q.add(lowerCaseLetter);
            }
        }
        for(int j = 0; j < s.size(); j++)
        {
            if(!(s.pop().equals(q.remove())))
            {
                return false;
            }
        }
        
        return true;
    }
}