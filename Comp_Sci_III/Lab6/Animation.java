import mayflower.*;
public class Animation
{
    // instance variables - replace the example below with your own
    private MayflowerImage[] frames;
    private int framerate;
    private int currentFrame;
    //private Timer animationTimer;

    /**
     * Constructor for objects of class Animation
     */
    public Animation(int fr, String[] filenames)
    {
        framerate = fr;
        
        frames = new MayflowerImage[filenames.length];
        
        //System.out.println(filenames.length);
        
        /*for(int j = 0; j < filenames.length; j++)
        {
            System.out.println(filenames[j]);
        }*/
        
        for(int i = 0; i < filenames.length; i++)
        {
            //System.out.println("i=" + i + ", filename(i)="+filenames[i]);
            frames[i] = new MayflowerImage(filenames[i]);
            //System.out.println("i+1=" + (i+1) + ", filename(i)="+filenames[i+1]);
        }
        currentFrame = 0;
        
        //animationTimer = new Timer(100000000);
    }
    
    public int getFrameRate()
    {
        return framerate;
    }
    
    public MayflowerImage getNextFrame()
    {
        MayflowerImage mf = frames[currentFrame];
        currentFrame++;
        currentFrame = (currentFrame >= frames.length) ? 0 : currentFrame;
        return mf;
    }
    
    public void scale(int w, int h)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].scale(w, h);
        }
    }
    
    public void setTransparency(int percent)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].setTransparency(percent);
        }
    }
    
    public void mirrorHorizontally()
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].mirrorHorizontally();
        }
        
        //mirrorHorizontally();
    }
    
    public void setBounds(int x, int y, int w, int h)
    {
        for(int i = 0; i < frames.length; i++)
        {
            frames[i].crop(x, y, w, h);
        }
    }
}
