
/**
 * Write a description of class Yarn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;


public class Water extends Actor
{
    /**
     * Constructor for objects of class Yarn
     */
    public Water()
    {
        setImage("img/Tiles/17.png");
    } 
    
    public void act()
    {
        if(isTouching(Ninja.class))
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
