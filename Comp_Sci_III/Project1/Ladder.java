
/**
 * This class is used to create Ladder objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Ladder extends Actor
{
    /**
     * Constructor for objects of class Ladder
     */
    public Ladder()
    {
        //sets the image of the Ladder actor to be an image of a ladder stored in the 
        //Object folder of the img folder
        setImage("img/Object/ladder.png");
    } 
    
    public void act()
    {
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            ninja.setLocation(getX(),getY() - 100);
        }
    }
}
