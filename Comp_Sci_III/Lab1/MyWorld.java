
/**
 * Write a description of class MyWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;

public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld
     */
    public MyWorld()
    {
        setBackground("img/bluebonnets.jpg");
        Cat a = new Cat();
        addObject(a, 400, 300);
        Dog b = new Dog();
        addObject(b, 200, 150);
        Yarn c = new Yarn();
        addObject(c, 600, 150);
        Yarn d = new Yarn();
        addObject(d, 200, 450);
        Yarn e = new Yarn();
        addObject(e, 600, 450);
    }
    
    public void act()
    {
        
    }
}
