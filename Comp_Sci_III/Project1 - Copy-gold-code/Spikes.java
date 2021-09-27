
/**
 * This class is used to create Spikes objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Spikes extends Actor
{
    /**
     * Constructor for objects of class Spikes
     */
    public Spikes()
    {
        //sets the image of the Spikes actor to be an image of a spike stored in the 
        //Object folder of the img folder
        setImage("img/Object/spikes.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object and if the spacebar is being
        //pressed - if so, the score of the ninja increases by 1 point, and the spike
        //is removed from the world
        if(isTouching(Ninja.class) && Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            w.removeObject(this);
            ninja.increaseScore(1);
        }
        //however, if the ninja object is touching the spike class without the spacebar
        //being pressed, the ninja loses a life, and is set to the location (0, 350)
        else if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            ninja.setLocation(0,350);
            ninja.decreaseLives(1);
        }
    }
}
