
/**
 * This class is used to create Blocks objects
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;

public class Block extends Actor
{
    // Constructor for class Block
    
    public Block()
    {
        
    }
    
    //sets the image of the Block actor to be an image of a block stored in the Tiles
    //folder of the img folder
    public void act()
    {
        setImage("img/Tiles/2.png");
    }
}

