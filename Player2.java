import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2 extends Actor
{
    
    public static int kickdamage = -2;
    public static int punchdamage = -3;
    
    private boolean notStanding;
    private GreenfootImage stand1;
    private GreenfootImage stand2;
    private GreenfootImage punch;
    private GreenfootImage kick;
    private GreenfootImage walk1;
    private GreenfootImage walk2;
    private GreenfootImage dead2;
    private static final int hadoukenReloadTime2 = 100;
    private int hadoukenDelayCount2;
    
    private boolean isKick;
    private boolean isPunch;
    private boolean isSpecial;
    
    int health;
    
    public Player2()
    {
        punch = new GreenfootImage("pixil-frame-punch2.png");
        kick = new GreenfootImage("pixil-frame-kick2.png");
        stand1 = new GreenfootImage("pixil-frame-normal2.png");
        
        walk1 = new GreenfootImage("pixil-frame-walk1-2.png");
        walk2 = new GreenfootImage("pixil-frame-walk2-2.png");
        dead2 = new GreenfootImage("pixil-frame-dead2.png");
        setImage(stand1);
        
        
        
        health = 200;
        hadoukenDelayCount2 = 130;
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Keys();
        hadoukenDelayCount2 ++;
    }
    
    
    public void Keys()
    {
        Player1 P1 = (Player1) getOneIntersectingObject(Player1.class);
        MyWorld myworld = (MyWorld) getWorld();
        if (Greenfoot.isKeyDown("a"))//left
        {
            move(-5);
            setImage(walk1);
        }
        if (Greenfoot.isKeyDown("s"))//right
        {
            move(5);
            setImage(walk2);
        }
        if (Greenfoot.isKeyDown("d") && !isPunch)//punch
        {
            setImage(punch);
            if (P1 != null) 
            {
                myworld.subtractHealthP1(punchdamage);
            }
            isPunch = true;
        }
        else if(!Greenfoot.isKeyDown("d") && isPunch)
        {
            setImage(stand1);
            isPunch = false;
        }
        if (Greenfoot.isKeyDown("f") && !isKick)//kick
        {
            setImage(kick);
            if (P1 != null) 
            {
                myworld.subtractHealthP1(kickdamage);
            }
            isKick = true;
        }
        else if(!Greenfoot.isKeyDown("f") && isKick)
        {
            setImage(stand1);
            isKick = false; 
        }
        if (Greenfoot.isKeyDown("w"))//special
        {
            HADOUKEN();
        }
        
        if (healthP2() <= 0)
        {
            setImage(dead2);
            Greenfoot.stop();
        }
    }
    
    private void HADOUKEN()
    {
        if (hadoukenDelayCount2 >= hadoukenReloadTime2) 
        {
            Hadouken2 hadouken2 = new Hadouken2();
            getWorld().addObject (hadouken2, getX(), getY());
            hadoukenDelayCount2 = 0;
        }
    }

    
    public void hitP2(int damage)
    {
        health += damage;
    }
    
    public int healthP2()
    {
         return health;   
    }
}
