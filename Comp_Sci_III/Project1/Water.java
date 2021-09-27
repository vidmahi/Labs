
/**
 * This class is used to create Water objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Water extends Actor
{
    /**
     * Constructor for objects of class Water
     */
    public Water()
    {
        //sets the image of the Water actor to be an image of a water stored in the 
        //Tiles folder of the img folder
        setImage("img/Tiles/17.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object - if it is touching it, the
        //life of the ninja decreases by 1 point, and the ninja gets reset to
        //the location (400, 100)
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            ninja.setLocation(400,100);
            ninja.decreaseLives(1);
        }
    }
}
