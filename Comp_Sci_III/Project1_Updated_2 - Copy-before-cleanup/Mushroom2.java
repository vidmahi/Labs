
/**
 * Write a description of class Yarn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;


public class Mushroom2 extends Actor
{
    /**
     * Constructor for objects of class Yarn
     */
    public Mushroom2()
    {
        setImage("img/Object/Mushroom_2.png");
    } 
    
    public void act()
    {
        if(isTouching(Ninja.class))
        {
            Object b = getOneIntersectingObject(Ninja.class);
            Ninja ninja = (Ninja) b;
            
            ninja.increaseScore(1);
            World w = getWorld();
            w.removeObject(this);
            //ninja.increaseScore(1);
        }
    }
}
