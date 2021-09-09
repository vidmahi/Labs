import mayflower.*;
/**
 * Write a description of class MoveableAnimatedActor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MoveableAnimatedActor extends AnimatedActor
{
    // instance variables - replace the example below with your own
    private Animation walkRight;
    private Animation idle;
    private String currentAction;
    private Animation walkLeft;
    String lastCurrentAction;
    private Animation fallLeft;
    private Animation fallRight;
    private String lastDirection;
    private Animation idleLeft;

    /**
     * Constructor for objects of class MoveableAnimatedActor
     */
    public MoveableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        walkLeft = null;
        lastCurrentAction = "";
        fallLeft = null;
        fallRight = null;
        lastDirection = "";
        idleLeft = null;
    }

    public void act()
    {
        
        lastCurrentAction = currentAction;
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        World world = getWorld();
        
        int rightScreen = world.getWidth() - w;
        int bottomScreen = world.getHeight() - h;
        
        //int rightScreen = 800 - w;
        //int bottomScreen = 600 - h;
        
        String newAction = null;
        
        if(currentAction == null)
        {
            newAction = "idle";
        }
        
        if(currentAction == "walkLeft" && lastCurrentAction != "walkLeft")
        {
            setLocation(x - 10, y);
        }
        
        if(currentAction != "walkLeft" && lastCurrentAction == "walkLeft")
        {
            setLocation(x + 10, y);
        }
    
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < rightScreen)
        {
            if (isBlocked())
            {
                setLocation(getX() - 1, getY());
                newAction = "walkRight";
            }
            else
            {
                setLocation(x + 1, y);
                newAction = "walkRight";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            
            if (isBlocked())
            {
                setLocation(getX() + 1, getY());
                newAction = "walkLeft";
            }
            else
            {
                setLocation(x - 1, y);
                newAction = "walkLeft";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0)
        {
            setLocation(x, y - 1);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < bottomScreen)
        {
            setLocation(x, y + 1);
        }
        else
        {
            newAction = "idle";
        }
        
        
        
        if((newAction != null) && !newAction.equals(currentAction))
        {
            if(newAction.equals("idle"))
            {
                setAnimation(idle);
            }
            if(newAction.equals("walkRight"))
            {
                setAnimation(walkRight);
            }
            if(newAction.equals("walkLeft"))
            {
                setAnimation(walkLeft);
            }
            currentAction = newAction;
        }
        
        if (isFalling())
        {
            
                setFallingLeftAnimation(fallLeft);
        }
        
        super.act();
    }
    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani)
    {
        walkRight = ani;
    }
    
    public void setIdleAnimation(Animation ani)
    {
        idle = ani;
    }
    
    public void setIdleLeftAnimation(Animation ani)
    {
        idleLeft = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani)
    {
        walkLeft = ani;
    }
    
    public String getCurrentAction()
    {
        return currentAction;
    }
    
    public boolean isCurrentAction(String action)
    {
        if (action.equals(currentAction))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean wasCurrentAction(String action)
    {
        if (action.equals(lastCurrentAction))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void setFallingLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
    
    public void setFallingRightAnimation(Animation ani)
    {
        fallRight = ani;
    }
}
