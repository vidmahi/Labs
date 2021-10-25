
/**
 * This class sets the parameters and requirements for the Animation of the Actors.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class AnimatedActor extends GravityActor
{
    // icreates an instance of an Animation object and a Timer object as instance
    //variables
    private Animation animation;
    private Timer animationTimer;

    /**
     * Constructor for objects of class AnimatedActor
     */
    public AnimatedActor()
    {
        //sets the animationTimer object to have 1000000 (units), and creates a 
        //String array holding 10 Strings in the array
        animationTimer = new Timer(1000000);
       // animationTimer = new Timer(1000000000);
        String[] str = new String[10];
        
    }
    
    public void act()
    {
        //checks to see if the timer is done, and then resets it
        //next, the if statement creates a new MayflowerImage, and gets the next
        //frame, and sets it as the next image for the actor
        //it lastly calls the act method of its parent class
        if(animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage img = new MayflowerImage(animation.getNextFrame());
            setImage(img);
        }
        super.act();
    }
    
    public void setAnimation(Animation a)
    {
        //sets the animation object to the Animation a argument in this method
        animation = a;
    }
}
