
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import mayflower.*;

public class Cat extends Actor
{
    private int score;
    private int lives;
    
    /**
     * Constructor for objects of class Cat
     */
    public Cat()
    {
        setImage("img/cat.png");
        score = 0;
        lives = 3;
    } 
    
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getWidth();
        int h = getHeight();
        
        World world = getWorld();
        
        //int rightScreen = world.getWidth() -1 - w;
        //int bottomScreen = world.getHeight() - 1 - h;
        
        //int rightScreen = 800 - w;
        //int bottomScreen = 600 - h;
        
        int rightScreen = world.getWidth() - w - 10;
        int bottomScreen = world.getHeight() - h - 10;
        
        
    
        if(Mayflower.isKeyDown(Keyboard.KEY_RIGHT) && x < rightScreen)
        {
            setLocation(x + 1, y);
        
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_LEFT) && x > 0)
        {
            setLocation(x - 1, y);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_UP) && y > 0)
        {
            setLocation(x, y - 1);
        }
        else if(Mayflower.isKeyDown(Keyboard.KEY_DOWN) && y < bottomScreen)
        {
            setLocation(x, y + 1);
        }
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
        }
        System.out.println(lives);
    }
    
    public int getLives()
    {
        return lives;
    }
}
