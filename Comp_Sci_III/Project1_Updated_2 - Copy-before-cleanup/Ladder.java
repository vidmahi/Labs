
/**
 * Write a description of class Yarn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;


public class Ladder extends Actor
{
    /**
     * Constructor for objects of class Yarn
     */
    public Ladder()
    {
        setImage("img/Object/ladder.png");
    } 
    
    public void act()
    {
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            World w = getWorld();
            //w.removeObject(this);
            ninja.setLocation(getX(),getY() - 100);
            //ninja.decreaseLives(1);
        }
    }
}
