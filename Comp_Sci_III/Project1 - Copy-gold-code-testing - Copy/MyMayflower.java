
/**
 * This class sets the world initially to title screen.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor for MyMayflower
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project1", 800, 600);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        //Creates an instance of a TitleScreen object, and sets the world to that
        TitleScreen t = new TitleScreen();
        Mayflower.setWorld(t);
    }
}
