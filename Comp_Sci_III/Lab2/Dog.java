
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;

public class Dog extends Actor
{
    /**
     * Constructor for objects of class Dog
     */
    public Dog()
    {
        setImage("img/dog.png");
    }
    
    public void act()
    {
        if(isTouching(Cat.class))
        {
            Object b = getOneIntersectingObject(Cat.class);
            Cat cat = (Cat) b;
            
            World w = getWorld();
            cat.setLocation(400, 300);
            
            cat.decreaseLives(1);
        }
    }
}
