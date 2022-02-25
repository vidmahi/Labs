public class BracketMatcher
{
    public static void main(String[] args)
    {
        String test = "( () [] { [] () } )";
        System.out.println(matchBrackets(test));
    }
    
    public static String matchBrackets(String str)
    {
        
        Stack<String> s = new MyStack<String>();
        String legalLeft = "{[(";
        String legalRight = "}])";
        boolean match = false;
        String temp;
        
        
        for(int i = 0; i < str.length(); i++)
        {
            String letter = str.substring(i, i+1);
            
            if( legalLeft.indexOf( letter ) > -1 )
            {
                s.push(letter);
            }
            else if( legalRight.indexOf( letter ) > -1 )
            {
                if (s.isEmpty())
                {
                    return "Too many closing brackets";
                }
                else
                {
                    temp = s.pop();
                    if (temp.equals("(") && letter.equals(")") || temp.equals("[") && letter.equals("]") || temp.equals("{") && letter.equals("}"))
                    {
                        match = true;
                    }
                    else
                    {
                        match = false;
                    }
                    if (match == false)
                    {
                        return "Bracket mismatch";
                    }
                }
            }
        }
        if (s.isEmpty())
        {
            return "Balanced";
        }
        else
        {
            return "Not enough closing brackets";
        }
        
    }
}