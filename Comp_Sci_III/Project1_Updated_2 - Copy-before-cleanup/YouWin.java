import mayflower.*;
public class YouWin extends World
{
    
    /**
     * Constructor for objects of class TitleScreen
     */
    public YouWin()
    {
        //setBackground("img/BG/TitleScreen.png");
    }
    
    public void act()
    {
        setBG();
    }
    public void setBG()
    {
        //System.out.println("in BG method");
        setBackground("img/BG/YouWin.png");
    }
}
