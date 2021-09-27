
/**
 * This class is used to create the Losing Screen
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class YouLose extends World
{
    
    /**
     * Constructor for objects of class YouLose
     */
    public YouLose()
    {
        //sets the background of the YouLose object / class to be that of the
        //YouLose png in the BG folder of the img folder
        setBackground("img/BG/YouLose.png");
    }
    
    public void act()
    {
        //calls the setBG method to set the background of the world
        setBG();
    }
    public void setBG()
    {
        //sets the background of the YouLose object / class to be that of the
        //YouLose png in the BG folder of the img folder
        setBackground("img/BG/YouLose.png");
    }
}
