import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Hadouken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hadouken2 extends Actor
{
    private static final int Hdamage = -10;
    private GreenfootImage image1;
    
   
    
    public Hadouken2()
    {
        image1 = new GreenfootImage("Hadouken2.png");
        setImage(image1);
    }
    
    /**
     * Act - do whatever the Hadouken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(9);
        addYoStreak();
        checkBallCollision();
        deleteBall();
    }
    
    private void deleteBall()
    {
        Player1 P1 = (Player1) getOneIntersectingObject(Player1.class);
        Hadouken H = (Hadouken) getOneIntersectingObject(Hadouken.class);
        Streak S = (Streak) getOneIntersectingObject(Streak.class);
        if(isAtEdge() || P1 != null || H != null || S != null)
        {
            World world = (World) getWorld();
            world.removeObject(this);
        }
    }
    
    public void addYoStreak()
    {
        Streak2 streak2= new Streak2();
        MyWorld myworld = (MyWorld) getWorld();
        getWorld().addObject(streak2, getX(), getY());
    }
    
    private void checkBallCollision()
    {
        MyWorld myworld = (MyWorld) getWorld();
        
        Player1 player1 = (Player1) getOneIntersectingObject(Player1.class);     
        
        if(player1 != null)
        {
            myworld.subtractHealthP1(Hdamage);
        }
    }
}
