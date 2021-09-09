import mayflower.*;

//public class Cat extends Actor
public class Cat extends MoveableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation walkLeft;
    //private Timer animationTimer;
    //private Animation fallingLeft;
    //private Animation fallingRight;
    public Cat() 
    {
        String[] str = new String[10];
        
        for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/cat/Walk (" + (x+1) + ").png";
            
        }
        
        String[] idleStr = new String[10];
        for(int y = 0; y <= 9; y++)
        {
            idleStr[y] = "img/cat/Idle (" + (y+1) + ").png";
            
        }
        Animation idle = new Animation(50, idleStr);
        //idle = new Animation(50, idleStr);
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        
        String[] leftStr = new String[10];
        for(int z = 0; z <= 9; z++)
        {
            leftStr[z] = "img/cat/Walk (" + (z+1) + ").png";
            
        }
        walkLeft = new Animation(50, leftStr);
        walkLeft.mirrorHorizontally();
        
        /*
        String[] fallLeftStr = new String[8];
        String[] fallRightStr = new String[8];
        for(int l = 0; l <= 7; l++)
        {
            fallLeftStr[l] = "img/cat/Fall (" + (l+1) + ").png";
            
        }
        
        fallingLeft = new Animation(50, fallLeftStr);
        
        for(int r = 0; r <= 7; r++)
        {
            fallRightStr[r] = "img/cat/Fall (" + (r+1) + ").png";
            
        }
        fallingRight = new Animation(50, fallRightStr);
        
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
        
        walkLeft.setBounds(28, 5, 54, 80);
        //walkLeft = new Animation(50, leftStr);
        walkLeft.mirrorHorizontally();
        setWalkLeftAnimation(walkLeft);
        
        walk = new Animation(50, str);
        walk.scale(100, 87);
        walk.setTransparency(50);
       // setAnimation(walk);
       
       walk.setBounds(18, 5, 54, 80);
       
        setWalkRightAnimation(walk);
        setWalkLeftAnimation(walk);
        setIdleAnimation(idle);
        
        //animationTimer = new Timer(100000000);
        
        
    }
    public void act()
    {
        super.act();
        //scale(100, 87);
       /* if(animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage img = new MayflowerImage(walk.getNextFrame());
            setImage(img);
        }*/
        
    }
}
