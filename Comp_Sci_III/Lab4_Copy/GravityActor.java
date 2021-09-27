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
            setLocation(getX(), getY()-1);
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
        ret = isTouching(Block.class);
        // move actor back up
        setLocation(getX(), getY() - 1);
        return !ret;

    }
}
