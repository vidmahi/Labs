
/**
 * This class is used to create Ladder objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class Ladder extends Actor
{
    private Timer animationTimer;
    /**
     * Constructor for objects of class Ladder
     */
    public Ladder()
    {
        //sets the image of the Ladder actor to be an image of a ladder stored in the 
        //Object folder of the img folder
        setImage("img/Object/ladder.png");
        animationTimer = new Timer(100000);
    } 
    
    public void act()
    {
        animationTimer = new Timer(100000);
        if(isTouching(Ninja.class))
        {
            if(animationTimer.isDone())
            {
                animationTimer.reset();
                Object b = getOneIntersectingObject(Ninja.class);
                Ninja ninja = (Ninja) b;
                World w = getWorld();
                ninja.setLocation(getX(),getY() - 1);
            }
        }
    }
}
