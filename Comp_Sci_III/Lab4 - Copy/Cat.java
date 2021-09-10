import mayflower.*;

//public class Cat extends Actor
public class Cat extends MoveableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation walkLeft;
    private Animation fallingLeft;
    private Animation fallingRight;
    private Animation idleLeft;
    //private Timer animationTimer;
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
        idle.scale(100, 87);
        idle.setBounds(18, 5, 54, 80);
        
        String[] idleLeftStr = new String[10];
        for(int d = 0; d <= 9; d++)
        {
            idleLeftStr[d] = "img/cat/Idle (" + (d+1) + ").png";
            
        }
        
        Animation idleLeft = new Animation(50, idleLeftStr);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(18, 5, 54, 80);
        
        walk = new Animation(50, str);
        walk.scale(100, 87);
        walk.setTransparency(50);
        walk.setBounds(18, 5, 54, 80);
        //walk.mirrorHorizontally();
        //setAnimation(walk);
        
        //animationTimer = new Timer(100000000);
        String[] leftStr = new String[10];
        for(int z = 0; z <= 9; z++)
        {
            leftStr[z] = "img/cat/Walk (" + (z+1) + ").png";
            
        }
        walkLeft = new Animation(50, leftStr);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(28, 5, 54, 80);
        
        
        setWalkRightAnimation(walk);
        setIdleAnimation(idle);
        setWalkLeftAnimation(walkLeft);
        setIdleLeftAnimation(idleLeft);
        
        String[] fallLeftStr = new String[8];
        String[] fallRightStr = new String[8];
        
        
        for(int r = 0; r <= 7; r++)
        {
            fallRightStr[r] = "img/cat/Fall (" + (r+1) + ").png";
            
        }
        fallingRight = new Animation(50, fallRightStr);
        fallingRight.scale(100, 87);
        fallingRight.setBounds(18, 5, 54, 80);
        
        for(int l = 0; l <= 7; l++)
        {
            fallLeftStr[l] = "img/cat/Fall (" + (l+1) + ").png";
            
        }
        
        fallingLeft = new Animation(50, fallLeftStr);
        fallingLeft.scale(100, 87);
        fallingLeft.mirrorHorizontally();
        fallingLeft.setBounds(28, 5, 54, 80);
        
        setFallingLeftAnimation(fallingLeft);
        setFallingRightAnimation(fallingRight);
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
