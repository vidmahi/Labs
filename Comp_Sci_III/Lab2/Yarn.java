
/**
 * Write a description of class Yarn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;


public class Yarn extends Actor
{
    /**
     * Constructor for objects of class Yarn
     */
    public Yarn()
    {
        setImage("img/yarn.png");
    } 
    
    public void act()
    {
        if(isTouching(Cat.class))
        {
            Object a = getOneIntersectingObject(Cat.class);
            Cat c = (Cat) a;
            
            World w = getWorld();
            w.removeObject(this);
            
            c.increaseScore(1);
        }
    }
}
