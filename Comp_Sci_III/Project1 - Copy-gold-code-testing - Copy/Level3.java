
/**
 * This class is used to create the Level3 World
 *
 * @author (Vidmahi Sistla)
 * @version (09/26/2021)
 */

import mayflower.*;


public class Level3 extends World {
    //Creates the instance variables needed for the world. These are the objects
    //that populate the world, and the tiles array stores and keeps track of them
    private String[][] tiles;
    private Mushroom2 m2;
    private TitleScreen ts;
    private Water water;
    private Stone s;
    private int objectCounter;
    private Villain v3;
    
    // This is the constructor for the Level3 class
    
    public Level3() 
    {
        //sets the background of the level
        setBackground("img/BG/Level3.png");
        
        //creates the tiles array with a specified number of rows and columns
        tiles = new String[6][8];
        
        //calls the buildWorld method and populates the world with specified objects
        buildWorld();
        
        //adds permanent objects to the world in certain locations
        Tori t = new Tori();
        addObject(t, 10,20);
        Villain v1 = new Villain();
        addObject(v1, 100,20);
        Villain v2 = new Villain();
        addObject(v2, 600,338);
        Ninja ninja = new Ninja(3);
        addObject(ninja, 0, 350);
        Stone stone1 = new Stone();
        addObject(stone1, 0, 150);
        Spikes spike1 = new Spikes();
        addObject(spike1, 90, 150);
        Stone stone2 = new Stone();
        addObject(stone2, 210, 150);
        Spikes spike2 = new Spikes();
        addObject(spike2, 300, 150);
        Stone stone3 = new Stone();
        addObject(stone3, 420, 150);
        Spikes spike3 = new Spikes();
        addObject(spike3, 510, 150);
        
        //calls the addRandomObjects method and populates the world with random objects
        addRandomObjects();
        
        //displays the text of the levevel, score, and lives
        showText("Level 3 - Score: " + ninja.getScore() + " Lives: " + ninja.getLives(), 10, 30, Color.BLACK);
        
    }
    
    //adds random objects to the world by looping through the tiles array and
    //checking if there is an empty spot. It there is, a certain object is
    //added at that random location
    public void addRandomObjects()
    {
        

        for(int a = 2; a < tiles.length; a++)
        {
            for(int b = 0;  b< tiles[0].length; b++)
            {
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    
                    if (tiles[a][b] == "")
                    {
                        m2 = new Mushroom2();
                        addObject(m2, a*100, b*205);
                        tiles[a][b] = "m2";
                        objectCounter++;
                    }
                    
                }
            }
        }
        for(int c = 2; c < tiles.length; c++)
        {
            for(int d = 0;  d< tiles[0].length; d++)
            {
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    if (tiles[c][d] == "")
                    {
                        s = new Stone();
                        addObject(s, c*100, d*205);
                        tiles[c][d] = "stone";
                    }
                }
            }
        }
        
        
    }
    
    //this method builds the world by populating it with objects in specified
    //locations by looping through the tiles array and making sure no other object
    //is in that location
    public void buildWorld()
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[0].length; j++)
            {
                tiles[i][j] = "";
            }
        }
        
        for(int k = 0; k < 1; k++)
        {
            tiles[3][k] = "ground";
        }
        
        for(int k = 1; k < 2; k++)
        {
            tiles[3][k] = "water";
        }
        
        for(int k = 2; k < 4; k++)
        {
            tiles[3][k] = "ground";
        }
        
        for(int k = 4; k < 6; k++)
        {
            tiles[3][k] = "water";
        }
        
        for(int k = 6; k < 8; k++)
        {
            tiles[3][k] = "ground";
        }
        
        for(int r = 0; r < tiles.length; r++)
        {
            for(int c = 0; c < tiles[0].length; c++)
            {
                if(tiles[r][c]=="ground")
                {
                    addObject(new Block(), 100*c, 155*r);
                }
                if(tiles[r][c]=="water")
                {
                    addObject(new Water(), 100*c, 165*r);
                }
            }
        }
    }
    
    public void act()
    {
        
    }
    
}