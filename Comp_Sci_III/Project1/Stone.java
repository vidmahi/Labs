
/**
 * This class is used to create Stone objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Stone extends Actor
{
    /**
     * Constructor for objects of class Stone
     */
    public Stone()
    {
        //sets the image of the Stone actor to be an image of a stone stored in the 
        //Object folder of the img folder
        setImage("img/Object/Stone.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object - if it is touching it, the
        //life of the ninja decreases by 1 point, and the stone object gets
        //removed from the world
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            w.removeObject(this);
            ninja.decreaseLives(1);
        }
    }
}
