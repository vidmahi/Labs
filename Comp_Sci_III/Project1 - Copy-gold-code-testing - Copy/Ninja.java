
/**
 * This class is used to create Ninja objects and sets the animation for its various actions like walk, jump, fall, etc.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class Ninja extends MoveableAnimatedActor
{
    //instance variables created for the animations the ninja object will need to appear as if it is moving
    //other instance variables, like score, life, and level, are ints to dictate the score and life of the object, as
    //well as the level it is on
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
    private int level;
    
    //the constructor of the ninja class keeps track of the level it is in, so the ninja can spawn in the correct level
    //when being created
    public Ninja(int lvl) 
    {
        //score, life, and level are instantiated
        score = 0;
        lives = 5;
        level = lvl;
    
        //a string array holding 10 strings is created - for the run right animation
        String[] str = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the run animation in the ninja class, so when called, it will appear as if the ninja is running
        for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/ninjagirl/Run__00" + x + ".png";
        }
        
        //a string array holding 10 strings is created - for the idle right animation
        String[] idleStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the idle animation in the ninja class, so when called, it will appear as if the ninja is idling
        for(int y = 0; y <= 9; y++)
        {
            idleStr[y] = "img/ninjagirl/Idle__00" + y + ".png";
        }
        
        //instantiates the idle animation with the images from its array, scales it to the appropriate size, and sets its bounds
        Animation idle = new Animation(50, idleStr);
        idle.scale(100, 87);
        idle.setBounds(13, 4, 75, 80);
        
        //a string array holding 10 strings is created - for the idle left animation
        String[] idleLeftStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the idle animation in the ninja class, so when called, it will appear as if the ninja is idling
        for(int d = 0; d <= 9; d++)
        {
            idleLeftStr[d] = "img/ninjagirl/Idle__00" + d + ".png";
            
        }
        
        //instantiates the idle animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        Animation idleLeft = new Animation(50, idleLeftStr);
        idleLeft.scale(100, 87);
        idleLeft.mirrorHorizontally();
        idleLeft.setBounds(13, 4, 75, 80);
        
        //a string array holding 10 strings is created - for the climbing right animation
        String[] climbRightStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the climb animation in the ninja class, so when called, it will appear as if the ninja is climbing
        for(int p = 0; p <= 9; p++)
        {
            
            climbRightStr[p] = "img/ninjagirl/Climb_00" + p + ".png";
            
        }
        
        //instantiates the climb animation with the images from its array, scales it to the appropriate size, and sets its bounds
        Animation climbRight = new Animation(50, climbRightStr);
        climbRight.scale(100, 87);
        climbRight.setBounds(13, 4, 75, 80);
        
        //a string array holding 10 strings is created - for the climbing left animation
        String[] climbLeftStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the climb animation in the ninja class, so when called, it will appear as if the ninja is climbing
        for(int q = 0; q <= 9; q++)
        {
            climbLeftStr[q] = "img/ninjagirl/Climb_00" + q + ".png";
            
        }
        
        //instantiates the climb animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        Animation climbLeft = new Animation(50, climbLeftStr);
        climbLeft.scale(100, 87);
        climbLeft.mirrorHorizontally();
        climbLeft.setBounds(13, 4, 75, 80);
        
        //instantiates the walk / run animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //it also sets the transparency of these images to be 50% of their original transparency
        walk = new Animation(50, str);
        walk.scale(100, 87);
        walk.setTransparency(50);
        walk.setBounds(23, 4, 75, 80);
        
        //a string array holding 10 strings is created - for the run left animation
        String[] leftStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the run animation in the ninja class, so when called, it will appear as if the ninja is running
        for(int z = 0; z <= 9; z++)
        {
            leftStr[z] = "img/ninjagirl/Run__00" + z + ".png";
            
        }
        
        //instantiates the walk / run animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        walkLeft = new Animation(50, leftStr);
        walkLeft.scale(100, 87);
        walkLeft.mirrorHorizontally();
        walkLeft.setBounds(23, 4, 75, 80);
        
        
        //sets the according animation for running and idling by calling the appropriate method
        setWalkRightAnimation(walk);
        setIdleAnimation(idle);
        setWalkLeftAnimation(walkLeft);
        setIdleLeftAnimation(idleLeft);
        
        //a string array holding 10 strings is created - for the fall left animation
        String[] fallLeftStr = new String[10];
        
        //a string array holding 10 strings is created - for the fall right animation
        String[] fallRightStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the fall animation in the ninja class, so when called, it will appear as if the ninja is falling
        for(int r = 0; r <= 9; r++)
        {
            fallRightStr[r] = "img/ninjagirl/Glide_00" + r + ".png";
            
        }
        
        //instantiates the fall animation with the images from its array, scales it to the appropriate size, and sets its bounds
        fallingRight = new Animation(50, fallRightStr);
        fallingRight.scale(100, 87);
        fallingRight.setBounds(13, 4, 75, 80);
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the fall animation in the ninja class, so when called, it will appear as if the ninja is falling
        for(int l = 0; l <= 9; l++)
        {
            fallLeftStr[l] = "img/ninjagirl/Glide_00" + l + ".png";
            
        }
        
        //instantiates the falling animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        fallingLeft = new Animation(50, fallLeftStr);
        fallingLeft.scale(100, 87);
        fallingLeft.mirrorHorizontally();
        fallingLeft.setBounds(23, 4, 75, 80);
        
        //sets the according animation for falling by calling the appropriate method
        setFallingLeftAnimation(fallingLeft);
        setFallingRightAnimation(fallingRight);
        
        //a string array holding 10 strings is created - for the animation left animation
        String[] throwLeftStr = new String[10];
        
        //a string array holding 10 strings is created - for the attack right animation
        String[] throwRightStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the attack animation in the ninja class, so when called, it will appear as if the ninja is attacking
        for(int tr = 0; tr <= 9; tr++)
        {
            throwRightStr[tr] = "img/ninjagirl/Attack__00" + tr + ".png";
        }
        
        //instantiates the attacking animation with the images from its array, scales it to the appropriate size, and sets its bounds
        throwingRight = new Animation(50, throwRightStr);
        throwingRight.scale(100, 87);
        throwingRight.setBounds(23, 4, 75, 80);
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the attack animation in the ninja class, so when called, it will appear as if the ninja is attacking
        for(int tl = 0; tl <= 9; tl++)
        {
           throwLeftStr[tl] = "img/ninjagirl/Attack__00" + tl + ".png";
        }
        
        //instantiates the attacking animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        throwingLeft = new Animation(50, throwLeftStr);
        throwingLeft.scale(100, 87);
        throwingLeft.mirrorHorizontally();
        throwingLeft.setBounds(23, 4, 75, 80);
        
        //sets the according animation for attacking by calling the appropriate method
        setThrowRightAnimation(throwingRight);
        setThrowLeftAnimation(throwingLeft);
        
        
        //a string array holding 10 strings is created - for the jump left animation
        String[] jumpLeftStr = new String[10];
        
        //a string array holding 10 strings is created - for the jump right animation
        String[] jumpRightStr = new String[10];
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the jump animation in the ninja class, so when called, it will appear as if the ninja is jumping
        for(int jr = 0; jr <= 9; jr++)
        {
            jumpRightStr[jr] = "img/ninjagirl/Jump__00" + jr + ".png";
            
        }
        
        //instantiates the jumping animation with the images from its array, scales it to the appropriate size, and sets its bounds
        jumpingRight = new Animation(50, jumpRightStr);
        jumpingRight.scale(100, 87);
        jumpingRight.setBounds(23, 4, 75, 80);
        
        //this for loop loops through the string array, str, just created, and assigns the indices the images
        //of the jump animation in the ninja class, so when called, it will appear as if the ninja is jumping
        for(int jl = 0; jl <= 9; jl++)
        {
            jumpLeftStr[jl] = "img/ninjagirl/Jump__00" + jl + ".png";
            
        }
        
        //instantiates the jumping animation with the images from its array, scales it to the appropriate size, and sets its bounds
        //also, the mirrorHorizontally method call allows the images to appear like they are facing left when appropriate, in this
        //case, when the left arrow key is being pressed
        jumpingLeft = new Animation(50, jumpLeftStr);
        jumpingLeft.scale(100, 87);
        jumpingLeft.mirrorHorizontally();
        jumpingLeft.setBounds(23, 4, 75, 80);
        
        //sets the according animation for jumping by calling the appropriate method
        setjumpRightAnimation(jumpingRight);
        setjumpLeftAnimation(jumpingLeft);
        
        //sets the according animation for climbing by calling the appropriate method
        setClimbLeftAnimation(climbLeft);
        setClimbRightAnimation(climbRight);
        
        
    }
    public void act()
    {
        //calls the act mathod of its parent class
        super.act();
        
        //checking to see if the level is one - if so, and if the ninja's score is greater than or equal to 5, then a
        //new instance of a Level2 object is created, and the world is set to that of the Level2 class - also, the
        //score and lives are reset to their original values
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
        
        //checking to see if the level is two - if so, and if the ninja's score is greater than or equal to 5, then a
        //new instance of a Level3 object is created, and the world is set to that of the Level3 class - also, the
        //score and lives are reset to their original values
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
        
        //checking to see if the level is three - if so, and if the ninja's score is greater than or equal to 5, then a
        //new instance of a YouWin object is created, and the world is set to that of the YouWin class
        else if (level == 3)
        {
            if(score >= 5)
            {
                Mayflower.setWorld(new YouWin());
            }
        }
        
        /*while(isTouching(Ladder.class))
        {
            setLocation(getX(), getY()-1);
        }*/
    }
    
    //this method increases the score of the ninja by a certain amount, and updates the score accordingly
    //on screen
    public void increaseScore(int amount)
    {
        score = score + amount;
        System.out.println(score);
        updateText();
    }
    
    //returns the score of the ninja
    public int getScore()
    {
        System.out.println(score);
        return score;
    }
    
    //this method displays the score and the number of lives the ninja has on screen at the location (10, 30)
    //in black text
    private void updateText()
    {
        World w = getWorld();
        w.removeText(10, 30);
        w.showText("Score: " + score + " Lives: " + lives, 10, 30, Color.BLACK);
    }
    
    //this method decreases the lives the ninja has - lives is equal to the lifeCount argument, and the text on screen, indicating
    //the number of lives it has, gets updated based on the number of lives it has. If there are 0 lives, the ninja is removed
    //from the world, and an instance of a YouLose object is created, setting the world to the background of the YouLose screen
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
    
    //returns the number of lives the ninja object has
    public int getLives()
    {
        return lives;
    }
    
    //checks to see if the score is greater than or equal to 5, and if so, returns true. Otherwise, it returns false, and
    //this indicates whether level 1 is complete or not - if it returns true, the level is complete, whereas, if it returns
    //false, the level is incomplete
    public boolean levelOneComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
    
    
    //checks to see if the score is greater than or equal to 5, and if so, returns true. Otherwise, it returns false, and
    //this indicates whether level 2 is complete or not - if it returns true, the level is complete, whereas, if it returns
    //false, the level is incomplete
    public boolean levelTwoComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
    
    //checks to see if the score is greater than or equal to 5, and if so, returns true. Otherwise, it returns false, and
    //this indicates whether level 3 is complete or not - if it returns true, the level is complete, whereas, if it returns
    //false, the level is incomplete
    public boolean levelThreeComplete()
    {
        if (score >= 5)
            return true;
        return false;
    }
}
