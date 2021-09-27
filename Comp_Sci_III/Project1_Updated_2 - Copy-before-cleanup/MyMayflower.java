import mayflower.*;

public class MyMayflower extends Mayflower 
{
    //Constructor
    public MyMayflower()
    {
        //Create a window with 800x600 resolution
        super("Project1", 800, 600);
    }

    public void init()
    {
        //Change this to true to run this program in fullscreen mode
        Mayflower.setFullScreen(false);
        //here it should create a new titlescreen object
        //World w =  new MyWorld();
        //Mayflower.setWorld(w);
        TitleScreen t = new TitleScreen();
        Mayflower.setWorld(t);
    }
}
