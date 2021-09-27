import mayflower.*;

//public class Ninja extends Actor
public class Ninja extends MoveableAnimatedActor
{
    private Animation walk;
    private Animation idle;
    private Animation walkLeft;
    private Animation fallingLeft;
    private Animation fallingRight;
    private Animation idleLeft;
    private int score;
    private int lives;
    private Animation throwingLeft;
    private Animation throwingRight;
    private Animation jumpingRight;
    private Animation jumpingLeft;
    private Animation climbLeft;
    private Animation climbRight;
    //private Timer animationTimer;
    private int level;
    public Ninja(int lvl) 
    {
        score = 0;
        lives = 5;
        level = lvl;
    
        String[] str = new String[10];
        
        for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/ninjagirl/Run__00" + x + ".png";
        }
        
        String[] idleStr = new String[10];
        for(int y = 0; y <= 9; y++)
        {
            idleStr[y] = "img/ninjagirl/Idle__00" + y + ".png";
            
        }
        Animation idle = new Animation(50, idleStr);
        idle.scale(100, 87);
        idle.setBounds(13, 4, 75, 80);
        
        String[] idleLeftStr = new String[10];
        for(int d = 0; d <= 9; d++)
        {
            idleLeftStr[d] = "img/ninjagirl/Idle__00" + d + ".png";
            
        }
        
        Animation idleLeft = new Animation(50, idleLeftStr);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(13, 4, 75, 80);
        
        
        String[] climbRightStr = new String[10];
        for(int p = 0; p <= 9; p++)
        {
            climbRightStr[p] = "img/ninjagirl/Climb_00" + p + ".png";
            
        }
        Animation climbRight = new Animation(50, climbRightStr);
        climbRight.scale(100, 87);
        climbRight.setBounds(13, 4, 75, 80);
        
        String[] climbLeftStr = new String[10];
        for(int q = 0; q <= 9; q++)
        {
            climbLeftStr[q] = "img/ninjagirl/Climb_00" + q + ".png";
            
        }
        
        Animation climbLeft = new Animation(50, climbLeftStr);
        climbLeft.scale(100, 87);
        climbLeft.mirrorHorizontally();
        climbLeft.setBounds(13, 4, 75, 80);
        
        
        
        walk = new Animation(50, str);
        walk.scale(100, 87);
        walk.setTransparency(50);
        walk.setBounds(23, 4, 75, 80);
        //walk.mirrorHorizontally();
        //setAnimation(walk);
        
        //animationTimer = new Timer(100000000);
        String[] leftStr = new String[10];
        for(int z = 0; z <= 9; z++)
        {
            leftStr[z] = "img/ninjagirl/Run__00" + z + ".png";
            
        }
        walkLeft = new Animation(50, leftStr);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(23, 4, 75, 80);
        
        
        setWalkRightAnimation(walk);
        setIdleAnimation(idle);
        setWalkLeftAnimation(walkLeft);
        setIdleLeftAnimation(idleLeft);
        
        String[] fallLeftStr = new String[10];
        String[] fallRightStr = new String[10];
        
        
        for(int r = 0; r <= 9; r++)
        {
            fallRightStr[r] = "img/ninjagirl/Glide_00" + r + ".png";
            
        }
        fallingRight = new Animation(50, fallRightStr);
        fallingRight.scale(100, 87);
        fallingRight.setBounds(13, 4, 75, 80);
        
        for(int l = 0; l <= 9; l++)
        {
            fallLeftStr[l] = "img/ninjagirl/Glide_00" + l + ".png";
            
        }
        
        fallingLeft = new Animation(50, fallLeftStr);
        fallingLeft.scale(100, 87);
        fallingLeft.mirrorHorizontally();
        fallingLeft.setBounds(23, 4, 75, 80);
        
        setFallingLeftAnimation(fallingLeft);
        setFallingRightAnimation(fallingRight);
        
        String[] throwLeftStr = new String[10];
        String[] throwRightStr = new String[10];
        
        for(int tr = 0; tr <= 9; tr++)
        {
            //throwRightStr[tr] = "img/ninjagirl/Throw__00" + tr + ".png";
            throwRightStr[tr] = "img/ninjagirl/Attack__00" + tr + ".png";
            
        }
        
        throwingRight = new Animation(50, throwRightStr);
        throwingRight.scale(100, 87);
        throwingRight.setBounds(23, 4, 75, 80);
        
        for(int tl = 0; tl <= 9; tl++)
        {
           // throwLeftStr[tl] = "img/ninjagirl/Throw__00" + tl + ".png";
            throwLeftStr[tl] = "img/ninjagirl/Attack__00" + tl + ".png";
            
        }
        
        throwingLeft = new Animation(50, throwLeftStr);
        throwingLeft.scale(100, 87);
        throwingLeft.mirrorHorizontally();
        throwingLeft.setBounds(23, 4, 75, 80);
        
        setThrowRightAnimation(throwingRight);
        setThrowLeftAnimation(throwingLeft);
        
        
        
        String[] jumpLeftStr = new String[10];
        String[] jumpRightStr = new String[10];
        
        for(int jr = 0; jr <= 9; jr++)
        {
            jumpRightStr[jr] = "img/ninjagirl/Jump__00" + jr + ".png";
            
        }
        
        jumpingRight = new Animation(50, jumpRightStr);
        jumpingRight.scale(100, 87);
        jumpingRight.setBounds(23, 4, 75, 80);
        
        for(int jl = 0; jl <= 9; jl++)
        {
            jumpLeftStr[jl] = "img/ninjagirl/Jump__00" + jl + ".png";
            
        }
        
        jumpingLeft = new Animation(50, jumpLeftStr);
        jumpingLeft.scale(100, 87);
        jumpingLeft.mirrorHorizontally();
        jumpingLeft.setBounds(23, 4, 75, 80);
        
        setjumpRightAnimation(jumpingRight);
        setjumpLeftAnimation(jumpingLeft);
        
        setClimbLeftAnimation(climbLeft);
        setClimbRightAnimation(climbRight);
        
        
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
        //System.out.println("level: " + level + "Score: " + score);
        /*if (isTouching(Tori.class) || score >= 5)
        {
            level++;
        }*/
        if (level == 1)
        {
            if(score >= 5)
            {
                System.out.println("level: " + level + "Score: " + score);
                level = 2;
                Mayflower.setWorld(new Level2());
                score = 0;
                lives = 5;
                System.out.println("Going to level2");
            }
        }
        else if (level == 2)
        {
            if(score >= 5)
            {
                System.out.println("level: " + level + "Score: " + score);
                level = 3;
                Mayflower.setWorld(new Level3());
                score = 0;
                lives = 5;
                System.out.println("Going to level3");
            }
        } 
        else if (level == 3)
        {
            if(score >= 5)
            {
                //level = 3;
                Mayflower.setWorld(new YouWin());
            }
        }
        
       /* if(score >= 5)
        {
            Mayflower.setWorld(new Level2());
        }*/
        
        
       /* if(getLives()==0)
        {
            Mayflower.setWorld(new YouLose());
        }*/
    }
    
    public void increaseScore(int amount)
    {
        score = score + amount;
        System.out.println(score);
        updateText();
    }
    
    public int getScore()
    {
        System.out.println(score);
        return score;
    }
    
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    public void decreaseLives(int lifeCount)
    {
        lives = lives - lifeCount;
        updateText();
        if (lives == 0)
        {
            World w = getWorld();
            w.removeObject(this);
            Mayflower.setWorld(new YouLose());
        }
        System.out.println(lives);
    }
    
    public int getLives()
    {
        return lives;
    }
    
    public boolean levelOneComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
    
    public boolean levelTwoComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
    
    public boolean levelThreeComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
}
