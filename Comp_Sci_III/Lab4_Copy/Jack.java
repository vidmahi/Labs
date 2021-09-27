import mayflower.*;

//public class Cat extends Actor
public class Jack extends AnimatedActor
{
    private Animation walk;
    //private Timer animationTimer;
    public Jack() 
    {
        String[] str = new String[10];
        
        for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/jack/Slide (" + (x+1) + ").png";
            
        }
        
        walk = new Animation(50, str);
        walk.scale(150, 137);
        walk.setTransparency(80);
        setAnimation(walk);
        //animationTimer = new Timer(100000000);
    }
    public void act()
    {
        super.act();
       // scale(100, 87);
       /* if(animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage img = new MayflowerImage(walk.getNextFrame());
            setImage(img);
        }*/
        
    }
}
