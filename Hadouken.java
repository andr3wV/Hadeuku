import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Hadouken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hadouken extends Actor
{
    private static final int Hdamage = -10;
    private GreenfootImage image1;
    
   
    
    public Hadouken()
    {
        image1 = new GreenfootImage("Hadouken.png");
        setImage(image1);
    }
    
    /**
     * Act - do whatever the Hadouken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(-9);
        addYoStreak();
        checkBallCollision();
        deleteBall();
    }
    
    private void deleteBall()
    {
        Player2 P2 = (Player2) getOneIntersectingObject(Player2.class);
        Hadouken2 H2 = (Hadouken2) getOneIntersectingObject(Hadouken2.class);
        Streak2 S2 = (Streak2) getOneIntersectingObject(Streak2.class);
        if(isAtEdge() || P2 != null || H2 != null || S2 != null)// if hadouken is touching the edge, a player, a streak, or another hadouken then eliminate it 
        {
            World world = (World) getWorld();//gets world 
            world.removeObject(this);//removes it
        }
    }
    
    public void addYoStreak()
    {
        Streak streak= new Streak();
        MyWorld myworld = (MyWorld) getWorld();
        getWorld().addObject(streak, getX(), getY());
    }
    
    private void checkBallCollision()
    {
        MyWorld myworld = (MyWorld) getWorld();
        
        Player2 player2 = (Player2) getOneIntersectingObject(Player2.class);     
        
        if(player2 != null)
        {
            myworld.subtractHealthP2(Hdamage);//subtracts HDamge in the subtractHealth method in world
        }
    }
}
