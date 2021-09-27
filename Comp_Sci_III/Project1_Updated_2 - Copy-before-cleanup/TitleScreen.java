import mayflower.*;
public class TitleScreen extends World
{
    
    /**
     * Constructor for objects of class TitleScreen
     */
    public TitleScreen()
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
        setBackground("img/BG/TitleScreen.png");
        
        //here it should have an if keyboard space is presed, create a level one object
        //like Mayflower.setWorld(new LevelOne())
        
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            Mayflower.setWorld(new Level1());
        }
    }
}
