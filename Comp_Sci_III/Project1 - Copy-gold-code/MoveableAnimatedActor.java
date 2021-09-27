
/**
 * This class sets the animations for the actor Ninja based on several criteria like key board clicks and diretions and current and last actions.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

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
    private Animation throwLeft;
    private Animation throwRight;
    private Animation jumpRight;
    private Animation jumpLeft;
    private Animation climbLeft;
    private Animation climbRight;

    private boolean jump;
    private boolean fall;
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
        lastDirection = "right";
        idleLeft = null;
        throwLeft = null;
        throwRight = null;
        jumpLeft = null;
        jumpRight = null;
        
        jump = false;
        fall = false;
    }

    
    // This is the act method which basically checks the keyboard presses and the current actions and sets the animation accordingly.
    
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
        
        String newAction = null;
        
        setLocation(getX(), getY()+1);
        
        if(currentAction == null && lastCurrentAction == "walkRight")
        {
            newAction = "idle";
        }
        
        if(currentAction == null && lastCurrentAction == "walkLeft")
        {
            lastDirection = "left";
            newAction = "idleLeft";
        }
        
        if(currentAction == "walkLeft" && lastCurrentAction != "walkLeft")
        {
            setLocation(x - 10, y);
        }
        
        if(currentAction != "walkLeft" && lastCurrentAction == "walkLeft")
        {
            setLocation(x + 10, y);
        }
        
        if(currentAction == "jumpLeft" && lastCurrentAction != "jumpLeft")
        {
            setLocation(x, y - 10);
        }
        
        if(currentAction != "jumpLeft" && lastCurrentAction == "jumpLeft")
        {
            setLocation(x, y + 10);
        }
    
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < rightScreen)
        {
            lastDirection = "right";
            setLocation(x + 1, y);
            if (isBlocked())
            {
                setLocation(getX() - 1, getY());
            }
            else
            {
                setLocation(x + 1, y);
                newAction = "walkRight";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            lastDirection = "left";
            setLocation(x - 1, y);
            if (isBlocked())
            {
                setLocation(getX() + 1, getY());
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
            if (isTouching(Block.class))
            {
                setLocation(getX(), getY() + 1);
            }
            if (isBlocked())
            {
                setLocation(getX(), getY() + 1);
            }
            else
            {
                
                if (lastDirection =="left" && fall == false)
                {
                    
                    setLocation(getX(), getY() - 10);
                    newAction = "jumpLeft";
                    jump = true;
                    
                }
                else
                {
                    setLocation(getX(), getY() - 10);
                    newAction = "jumpRight";
                    jump = true;
                    
                }
                
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < bottomScreen)
        {
            setLocation(x, y + 1);
           
            if (isBlocked())
            {
                setLocation(getX(), getY() - 1);
            }
            else
            {
                setLocation(getX(), getY() + 1);
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_SPACE))
        {
            if (lastDirection =="left")
            {
                newAction = "throwLeft";
            }
            else
            {
                newAction = "throwRight";
            }
        }
        else
        {
            if (lastDirection =="left")
            {
                newAction = "idleLeft";
            }
            else
            {
                newAction = "idle";
            }
        }
        
        if (isClimbing())
        {
            if (lastDirection =="right")
            {
                newAction = "climbRight";
                setAnimation(climbRight);
            }
            else
            {
                newAction = "climbLeft";
                setAnimation(climbLeft);
            }
        }
        
        if (isFalling() && jump == false)
        {
            if (lastDirection =="right")
            {
                newAction = "fallRight";
                setAnimation(fallRight);
                fall = true;
            }
            else
            {
                newAction = "fallLeft";
                setAnimation(fallLeft);
                fall = true;
            }
            
        }
        else
        {
            if((newAction != null) && !newAction.equals(currentAction))
            {
           
                if(newAction.equals("idle"))
                {
                    setAnimation(idle);
                }
                if(newAction.equals("idleLeft"))
                {
                    setAnimation(idleLeft);
                }
                if(newAction.equals("walkRight"))
                {
                    setAnimation(walkRight);
                }
                if(newAction.equals("walkLeft"))
                {
                    setAnimation(walkLeft);
                }
                if(newAction.equals("throwRight"))
                {
                    setAnimation(throwRight);
                }
                if(newAction.equals("throwLeft"))
                {
                    setAnimation(throwLeft);
                }
                if(newAction.equals("jumpRight"))
                {
                    setAnimation(jumpRight);
                }
                if(newAction.equals("jumpLeft"))
                {
                    setAnimation(jumpLeft);
                }
            
                currentAction = newAction;
            }
        }
        
        super.act();
    }
    
     
    // The below method returns the currentAction
    
    public String getCurrentAction()
    {
        return currentAction;
    }
    
    // The below method returns true if the action is equal to the currentAction
    
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
    
    // The below method returns the lastCurrentAction
    
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
    
    // The below methods assign the appropriate animation for the Ninja with the argument 'ani' for various animations like Walk, Fall, Jump, Throw, etc.
    
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
    
    public void setClimbLeftAnimation(Animation ani)
    {
        climbLeft = ani;
    }
    
    public void setClimbRightAnimation(Animation ani)
    {
        climbRight = ani;
    }
    
    public void setFallingLeftAnimation(Animation ani)
    {
        fallLeft = ani;
    }
    
    public void setFallingRightAnimation(Animation ani)
    {
        fallRight = ani;
    }
    
    public void setThrowRightAnimation(Animation ani)
    {
        throwRight = ani;
    }
    
    public void setThrowLeftAnimation(Animation ani)
    {
        throwLeft = ani;
    }
    
    
    public void setjumpRightAnimation(Animation ani)
    {
        jumpRight = ani;
    }
    
    public void setjumpLeftAnimation(Animation ani)
    {
        jumpLeft = ani;
    }
}
