import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    private String[][] tiles;
    private Yarn yarn;
    private Dog dog;
    private Ninja ninja;
    private Jack jack;
    private Mushroom2 m2;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        
        tiles = new String[6][8];
        
        buildWorld();
        
        addRandomObjects();
        
        addMainCharacter();
        /*cat = new Cat();
        addObject(cat, 100, 100);
        Dog dog = new Dog();
        addObject(dog, 300, 100);
        Jack jack = new Jack();
        addObject(jack, 200, 100);
        Ninja ninja = new Ninja();
        addObject(ninja, 400, 100);*/
    }
    
    public void act()
    {
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
        
        for(int k = 0; k < 8; k++)
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
            }
        }
    }
    
    public void addRandomObjects()
    {
        for(int i = 0; i < tiles.length; i++)
        {
            for(int j = 0; j < tiles[0].length; j++)
            {
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    yarn = new Yarn();
                    addObject(yarn, i*100, j*205);
                    tiles[i][j] = "yarn";
                }
                if(((int)(Math.random()*tiles[0].length)) < 3)
                {
                    m2 = new Mushroom2();
                    addObject(m2, i*100, j*205);
                    tiles[i][j] = "m2";
                }
            }
        }
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
    }
    
    public void addMainCharacter()
    {
        cat = new Cat();
        dog = new Dog();
        jack = new Jack();
        ninja = new Ninja();
        boolean added = false;
        
        while(added == false)
        {
            int row = (int)(Math.random()*tiles.length);
            int col = (int)(Math.random()*tiles[0].length);
            
            int row1 = (int)(Math.random()*tiles.length);
            int col1 = (int)(Math.random()*tiles[0].length);
            
            
            if(tiles[row][col] == "")
            {
                addObject(cat, row, col);
                tiles[row][col] = "cat";
                //added = true;
            }
            
            if(tiles[row1][col1] == "")
            {
                addObject(ninja, row1, col1);
                tiles[row1][col1] = "ninja";
                added = true;
            }
        }
    }
}
