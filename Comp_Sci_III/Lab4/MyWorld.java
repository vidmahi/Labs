import mayflower.*;


public class MyWorld extends World {

	private Cat cat;
	
    public MyWorld() 
    {
    	setBackground("img/BG/BG.png");
    	
    	cat = new Cat();
    	addObject(cat, 100, 100);
    	Dog dog = new Dog();
    	addObject(dog, 300, 100);
    	Jack jack = new Jack();
    	addObject(jack, 200, 100);
    	Ninja ninja = new Ninja();
    	addObject(ninja, 400, 100);
    }
    
    public void act()
    {
    }
    
}
