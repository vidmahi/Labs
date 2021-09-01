
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;

public class Cat extends Actor
{
    /**
     * Constructor for objects of class Cat
     */
    public Cat()
    {
        setImage("img/cat.png");
    } 
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        World world = getWorld();
        
        int rightScreen = world.getWidth() - w;
        int bottomScreen = world.getHeight() - h;
        
        //int rightScreen = 800 - w;
        //int bottomScreen = 600 - h;
        
        
    
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < rightScreen)
        {
            setLocation(x + 1, y);
        
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            setLocation(x - 1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0)
        {
            setLocation(x, y - 1);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < bottomScreen)
        {
            setLocation(x, y + 1);
        }
    }
}
