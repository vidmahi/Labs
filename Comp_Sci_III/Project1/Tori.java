
/**
 * This class is used to create Tori objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Tori extends Actor
{
    /**
     * Constructor for objects of class Tori
     */
    public Tori()
    {
        //sets the image of the Torii actor to be an image of a torii stored in the 
        //Object folder of the img folder
        setImage("img/Object/tori.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object - if it is touching it, the
        //score of the ninja increases by 5 points, allowing it to move to the
        //next level
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            w.removeObject(this);
            ninja.increaseScore(5);
        }
    }
}
