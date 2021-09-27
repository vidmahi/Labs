import mayflower.*;
public class AnimatedActor extends GravityActor
{
    // instance variables - replace the example below with your own
    private Animation animation;
    private Timer animationTimer;

    /**
     * Constructor for objects of class AnimatedActor
     */
    public AnimatedActor()
    {
        //animationTimer = new Timer(100000000);
        animationTimer = new Timer(1000000);
        String[] str = new String[10];
        
        //String[] str = new String[10];
        
       /* for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/cat/Walk (" + (x+1) + ").png";
            
        }
        animation = new Animation(50,str);*/
        //setAnimation(animation);
    }
    
    public void act()
    {
        if(animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage img = new MayflowerImage(animation.getNextFrame());
            setImage(img);
        }
        super.act();
    }
    
    public void setAnimation(Animation a)
    {
        animation = a;
    }
}
