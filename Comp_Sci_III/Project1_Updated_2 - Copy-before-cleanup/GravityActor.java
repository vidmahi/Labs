import mayflower.*;
public class GravityActor extends Actor
{
    
    public GravityActor()
    {
       
    }

    public void act()
    {
        setLocation(getX(), getY()+1);
        boolean landed = false;
        if(isBlocked())
        {
            landed = true;
        }
        
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
    
    public boolean isFalling()
    {
       // if (!isBlocked())
        //{
          //  return true;
        //}
       // return false;

        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() + 1); 
        //setLocation(getX(), getY() - 1);
        ret = isTouching(Block.class);
        // move actor back up
        setLocation(getX(), getY() - 1);
        //setLocation(getX(), getY() + 1);
        return !ret;

    }
    
    public boolean isJumping()
    {
       // if (!isBlocked())
        //{
          //  return true;
        //}
       // return false;

        boolean ret;
        // move the actor down and see if it touches a block
        setLocation(getX(), getY() - 1);
        ret = isTouching(Block.class);
        // move actor back up
        setLocation(getX(), getY() + 1);
        //setLocation(getX(), getY() + 3);
        return !ret;

    }
    
    public boolean isClimbing()
    {
       // if (!isBlocked())
        //{
          //  return true;
        //}
       // return false;

        boolean ret;
        // move the actor down and see if it touches a block
        //setLocation(getX(), getY() - 1);
        ret = isTouching(Ladder.class);
        // move actor back up
        //setLocation(getX(), getY() + 1);
        //setLocation(getX(), getY() + 3);
        return ret;

    }
}
