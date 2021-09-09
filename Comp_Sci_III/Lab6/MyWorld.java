import mayflower.*;


public class MyWorld extends World {

    private Cat cat;
    
    public MyWorld() 
    {
        setBackground("img/BG/BG.png");
        cat = new Cat();
        addObject(cat, 400, 100);
        Dog dog = new Dog();
        addObject(dog, 300, 100);
        Jack jack = new Jack();
        addObject(jack, 200, 100);
        Ninja ninja = new Ninja();
        addObject(ninja, 100, 100);
        Block block = new Block();
        addObject(block, 400, 500);
        Block block1 = new Block();
        addObject(block1, 528, 372);
        Mayflower.showBounds(true);
    }
    
    public void act()
    {
    }
    
}
