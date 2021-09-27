
/**
 * This class is used to create the Title Screen
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class TitleScreen extends World
{
    
    /**
     * Constructor for objects of class TitleScreen
     */
    public TitleScreen()
    {
        
    }
    
    public void act()
    {
        //sets the background of the world
        setBG();
    }
    public void setBG()
    {
        //System.out.println("in BG method");
        //sets the background of the world to be the TitleScreen png image
        setBackground("img/BG/TitleScreen.png");
        
        //here it should have an if keyboard space is presed, create a level one object
        //like Mayflower.setWorld(new LevelOne())
        
        //if the enter key is pressed, a new instance of a Level1 object is made, and
        //the background of the world changes to be of the level 1 object's
        if(Mayflower.isKeyDown(Keyboard.KEY_ENTER))
        {
            Mayflower.setWorld(new Level1());
        }
    }
}
