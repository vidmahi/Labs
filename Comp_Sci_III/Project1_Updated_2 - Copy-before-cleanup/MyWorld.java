import mayflower.*;


public class MyWorld extends World {

    //private Cat cat;
    private String[][] tiles;
    private Mushroom2 m2;
    private TitleScreen ts;
    private Water water;
    private Stone s;
    
    public MyWorld() 
    {
       /* setBackground("img/BG/BG.png");
        
        //setBackground("img/BG/Level1.png");
      //setBackground("img/BG/TitleScreen.png");
        tiles = new String[6][8];
        buildWorld();
        addRandomObjects();  
        Ninja ninja = new Ninja();
        addObject(ninja, 400, 100);
        
        //Block block = new Block();
        //addObject(block, 400, 500);
        //Block block1 = new Block();
        //addObject(block1, 528, 372);
        //Mayflower.showBounds(true);
        showText("Score: " + ninja.getScore() + " Lives: " + ninja.getLives(), 10, 30, Color.BLACK);*/
    }
    
    public void addRandomObjects()
    {
        
        for(int a = 0; a < tiles.length; a++)
        {
            for(int b = 0;  b< tiles[0].length; b++)
            {
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    m2 = new Mushroom2();
                    addObject(m2, a*100, b*205);
                    tiles[a][b] = "m2";
                }
            }
        }
        for(int c = 0; c < tiles.length; c++)
        {
            for(int d = 0;  d< tiles[0].length; d++)
            {
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    s = new Stone();
                    addObject(s, c*100, d*205);
                    tiles[c][d] = "stone";
                }
            }
        }
    }
    
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
        for(int k = 3; k < 8; k++)
        {
            tiles[3][k] = "ground";
        }
        for(int k = 1; k < 3; k++)
        {
            tiles[3][k] = "water";
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
                    addObject(new Water(), 100*c, 155*r);
                }
            }
        }
    }
    
    public void act()
    {
    }
    
}