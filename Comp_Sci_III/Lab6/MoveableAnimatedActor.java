import mayflower.*;

public class MoveableAnimatedActor extends AnimatedActor
{
    private Animation walkRight;
    private Animation idle;
    private String currentAction;
    private Animation walkLeft;
    String lastCurrentAction;
    private Animation fallingLeft;
    private Animation fallingRight;
    
    public MoveableAnimatedActor()
    {
        walkRight = null;
        idle = null;
        currentAction = null;
        walkLeft = null;
        lastCurrentAction = null;
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
        
        String[] fallLeftStr = new String[8];
        String[] fallRightStr = new String[8];
        
        for(int r = 0; r <= 7; r++)
        {
            fallRightStr[r] = "img/cat/Fall (" + (r+1) + ").png";
            //fallLeftStr[r] = fallRightStr[r].mirrorHorizontally();
            fallLeftStr[r] = fallRightStr[r];
            
        }
        
        fallingRight = new Animation(50, fallRightStr);
        
        fallingLeft = new Animation(50, fallLeftStr);
        
        /*
        if (isFalling())
        {
            if (getCurrentAction() == "walkLeft")
            {
                setAnimation(fallingLeft);
            }
            if (getCurrentAction() == "walkRight")
            {
                setAnimation(fallingRight);
            }
        }*/
        
        
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
            int tempX = getX() - 1;
            int tempY = getY() ;
            if (isBlocked())
            {
              //System.out.println("right key" + getX() + "," + getY() + "," + x + "," + y); 
              setLocation(x - 1, y);
              //newAction = "walkLeft";
            }
            else
            {
                setLocation(x + 1, y);
                newAction = "walkRight";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            int tempA = getX() + 1;
            int tempB = getY();
            if (isBlocked())
            {
              //System.out.println("leftt key" + getX() + "," + getY() + "," + x + "," + y); 
                setLocation(x + 1, y);  
              //setLocation(tempA + 1, tempB);
              //newAction = "walkRight";
            }
            else
            {
                setLocation(x - 1, y);
                newAction = "walkLeft";
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0)
        {
            if(isBlocked())
            {
              int tempC = getX();
              int tempD = getY();
              setLocation(x, y + 1);
              //setLocation(tempC, tempD - 1);
            }
            else
            {
                setLocation(x, y - 1);
            }
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < bottomScreen)
        {
            if(isBlocked())
            {
                int tempU = getX();
                int tempV = getY();
                setLocation(x, y - 1);  
                //setLocation(tempU, tempV + 1);
            }
            else
            {
                setLocation(x, y + 1);
            }
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
        
        
        
        super.act();
    }
    
    public void setAnimation(Animation a)
    {
        super.setAnimation(a);
    }
    
    public void setWalkRightAnimation(Animation ani)
    {
        //ani.setBounds(18, 5, 54, 80);
        walkRight = ani;
    }
    
    public void setWalkLeftAnimation(Animation ani)
    {
        //ani.setBounds(28, 5, 54, 80);
        walkLeft = ani;
    }
    
    public void setIdleAnimation(Animation ani)
    {
        //ani.setBounds(18, 5, 54, 80);
        idle = ani;
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
}