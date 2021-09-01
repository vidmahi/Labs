import mayflower.*;

//public class Cat extends Actor
public class Dog extends AnimatedActor
{
    private Animation walk;
    //private Timer animationTimer;
    public Dog() 
    {
        String[] str = new String[10];
        
        for(int x = 0; x <= 9; x++)
        {
            str[x] = "img/dog/Walk (" + (x+1) + ").png";
            
        }
        
        walk = new Animation(50, str);
        walk.scale(20, 7);
        walk.setTransparency(40);
        setAnimation(walk);
        //animationTimer = new Timer(100000000);
    }
    public void act()
    {
        super.act();
       /* if(animationTimer.isDone())
        {
            animationTimer.reset();
            MayflowerImage img = new MayflowerImage(walk.getNextFrame());
            setImage(img);
        }*/
        
    }
}
