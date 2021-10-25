
/**
 * This class emulates the gravity by allowing the object to perform actions while in the air or land/block.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class GravityActor extends Actor
{
    //constructor for GravityActor
    
    public GravityActor()
    {
       
    }

    public void act()
    {
        //sends the actor down until it lands, where it stops falling
        setLocation(getX(), getY()+1);
        
        //checks to see if the actor has landed on a block
        boolean landed = false;
        
        //checks to see if the actor is blocked on any sides, confirming if it has
        //landed on a block
        if(isBlocked())
        {
            landed = true;
        }
        
        
        //checking to see if the actor has landed - if it has, it sets landed to 
        //false, and sets the location up 2 pixels so it can move - otherwise, it
        //sets the location down until it touches the block and lands
        if(landed == true)
        {
            setLocation(getX(), getY()-2);
            landed = false;
            
        }
        else
        {
            setLocation(getX(), getY()+1);
        }
   
    }
    
    //this method checks if the actor is touching the block object, and returning
    //tru if it is, and false if it isn't, to check if it is blocked
    public boolean isBlocked()
    {
        if(isTouching(Block.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //this method makes the actor move downwards when in the air and the up arrow
    //is not being pressed. It checks if it touches a block, and if it is, moves the
    //actor one pixel back up
    public boolean isFalling()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 1); 
        ret = isTouching(Block.class);
        // move actor back up
        setLocation(getX(), getY() - 1);
        return !ret;

    }
    
    //this method makes the actor move upwards when in the air and the up arrow
    //is being pressed. It checks if it touches a block, and if it is, moves the
    //actor one pixel back up
    public boolean isJumping()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() - 1);
        ret = isTouching(Block.class);
        // move actor back up
        setLocation(getX(), getY() + 1);
        return !ret;
    }
    
    //this method makes the actor move upwards when touching an instance of a ladder
    //object.
    public boolean isClimbing()
    {
        boolean ret;
        // move the actor down and see if it touches a block
        ret = isTouching(Ladder.class);
        // move actor back up
        return ret;

    }
}
