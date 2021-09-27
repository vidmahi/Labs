
/**
 * Write a description of class Yarn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;


public class Villain extends Actor
{
    /**
     * Constructor for objects of class Yarn
     */
    public Villain()
    {
        setImage("img/Object/villain.png");
    } 
    
    public void act()
    {
        if(isTouching(Ninja.class) && Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            w.removeObject(this);
            //ninja.setLocation(400,100);
            ninja.increaseScore(1);
        }
        else if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            //w.removeObject(this);
            ninja.setLocation(400,100);
            ninja.decreaseLives(1);
        }
    }
}
