
/**
 * This class keeps track of the different Mayflower images, and other aspects like framerate to properly animate an object.
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class Animation
{
    // instance variables - creates an instance of a MayflowerImage array, and two
    //ints to represent framerate and currentFrame
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;

    /**
     * Constructor for objects of class Animation
     */
    public Animation(int fr, String[] filenames)
    {
        framerate = fr;
        
        frames = new MayflowerImage[filenames.length];
        
        for(int i = 0; i < filenames.length; i++)
        {
            frames[i] = new MayflowerImage(filenames[i]);
        }
        currentFrame = 0;
    }
    
    public int getFrameRate()
    {
        //returns the framerate
        return framerate;
    }
    
    //this method gets the next frame in the MayflowerImage array of frames
    public MayflowerImage getNextFrame()
    {
        MayflowerImage mf = frames[currentFrame];
        currentFrame++;
        currentFrame = (currentFrame >= frames.length) ? 0 : currentFrame;
        return mf;
    }
    
    //this method loops through all the images in the frames array and scales them
    //to be the same size (width and height)
    public void scale(int w, int h)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].scale(w, h);
        }
    }
    
    //this method sets the transparency of the actor to a certain percent of its
    //original transparency - this happens in all of the images in the frames array
    public void setTransparency(int percent)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].setTransparency(percent);
        }
    }
    
    //this method sets all of the images in the frames array to be mirrored horizontally
    //so that they face the other way
    public void mirrorHorizontally()
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].mirrorHorizontally();
        }
        
        //mirrorHorizontally();
    }
    
    //this method sets the bounds of an actor depending on their dimsensions, and crops
    //each of the images in the frames array, so the objects in an animation will be
    //the same size
    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].crop(x, y, w, h);
        }
    }
}
