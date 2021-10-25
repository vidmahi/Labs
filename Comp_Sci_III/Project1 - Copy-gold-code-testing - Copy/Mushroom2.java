
/**
 * This class is used to create Mushroom2 objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Mushroom2 extends Actor
{
    /**
     * Constructor for objects of class Mushroom2
     */
    
    //sets the image of the Mushroom actor to be an image of a mushroom stored in the 
    //Object folder of the img folder
    public Mushroom2()
    {
        setImage("img/Object/Mushroom_2.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object - if it is touching it, the
        //score of the ninja increases by 1 point, and the mushroom object gets
        //removed from the world
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            ninja.increaseScore(1);
            World w = getWorld();
            w.removeObject(this);
        }
    }
}
