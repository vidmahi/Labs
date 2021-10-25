
/**
 * This class is used to create the Winning Screen
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class YouWin extends World
{
    
    /**
     * Constructor for objects of class YouWin
     */
    public YouWin()
    {
        
    }
    
    public void act()
    {
        //calls the setBG method to set the background of the world
        setBG();
    }
    public void setBG()
    {
        //sets the background of the YouLose object / class to be that of the
        //YouWin png in the BG folder of the img folder
        setBackground("img/BG/YouWin.png");
    }
}
