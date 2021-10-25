
/**
 * This class is used to create Villain objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Villain extends Actor
{
    /**
     * Constructor for objects of class Villain
     */
    public Villain()
    {
        //sets the image of the Villain actor to be an image of a villain stored in the 
        //Object folder of the img folder
        setImage("img/Object/villain.png");
    } 
    
    public void act()
    {
        //checks to see if touching the Ninja object and if the spacebar is being
        //pressed - if so, the score of the ninja increases by 1 point, and the villain
        //is removed from the world
        if(isTouching(Ninja.class) && Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            w.removeObject(this);
            ninja.increaseScore(1);
        }
        else if(isTouching(Ninja.class))
        {
            //however, if the ninja object is touching the villain class without the spacebar
            //being pressed, the ninja loses a life, and is set to the location (400, 100)
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            ninja.setLocation(400,100);
            ninja.decreaseLives(1);
        }
    }
}
