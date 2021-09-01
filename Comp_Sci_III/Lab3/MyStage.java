/**
 * @(#)MyStage.java
 *
 *    Lab 3 Starter Code
 *
 * @author Mr May
 * @version 1.00 2016/7/18
 */
import mayflower.*;
import javafx.stage.*;

//import javafx.stage.*;



public class MyStage extends Stage {

    private Cat cat;
    
    public MyStage() 
    {
        setBackground("img/BG/BG.png");
        
        cat = new Cat();
        addActor(cat, 400, 300);
    }
    
    public void update()
    {
    }
    
}