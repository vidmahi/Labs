/**
 * @(#)Cat.java
 *
 *    Lab 3 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;

public class Cat extends Actor 
{
    public Cat() 
    {
        //Create a Picture object from the specified image file
        
        //Picture p = new Picture("img/cat/Walk (1).png");
        MayflowerImage p = new MayflowerImage("img/cat/Walk (1).png");
        
        //Set this Actor's image to the Picture object p
        //setPicture(p);
        p.scale(0.3);
        setImage(p);
    }
    
    public void update()
    {
    }
    
    public void act()
    {
        
    }
    
}