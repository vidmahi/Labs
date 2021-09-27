import mayflower.*;
public class YouLose extends World
{
    
    /**
     * Constructor for objects of class TitleScreen
     */
    public YouLose()
    {
        setBackground("img/BG/YouLose.png");
    }
    
    public void act()
    {
        setBG();
    }
    public void setBG()
    {
        //System.out.println("in BG method");
        setBackground("img/BG/YouLose.png");
    }
}
