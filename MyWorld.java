import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    public static int kickdamage = -2;
    public static int punchdamage = -5;
    
    private int health;
    
    public Player1 p1 = new Player1();
    public Player2 p2 = new Player2();
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1);
        setBackground("pixil-frame-0.png");
    }
    
    public void act()
    {
        LoadWorld();
    }
    
    public void LoadWorld()
    {
        if(Greenfoot.isKeyDown("1"))
        {
            Ground ground = new Ground();
            P1CounterImage p1CounterImage = new P1CounterImage();
            P2CounterImage p2CounterImage = new P2CounterImage();
        
            addObject(ground, 500, 575);
            addObject(p1CounterImage, 80, 50);
            addObject(p2CounterImage, 920, 50);
        
            addObject(p1, 600, 200);
            addObject(p2,200,200);
        
            health = 100;
            showHealth();
            showHealth2();
            setBackground("BackGround.png");
        }
    }
    
    private void showHealth2()
    {
        showText("Health:" + p1.healthP1(), 920, 45);
    }
    
    private void showHealth()
    {
        showText("Health:" + p2.healthP2(), 80, 45);
    }
    
    public void subtractHealthP1(int d)
    {
        p1.hitP1(d);
        showHealth2();
    }
    
    public void subtractHealthP2(int d)
    {
        p2.hitP2(d);
        showHealth();
    }
    
}



