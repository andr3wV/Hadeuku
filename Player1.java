import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Actor
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
    private GreenfootImage dead1;
    private static final int hadoukenReloadTime = 100;
    private int hadoukenDelayCount;
    
    private boolean isKick;
    private boolean isPunch;
    private boolean isSpecial;
    
    int health;
    
    public Player1()
    {
        punch = new GreenfootImage("pixil-frame-1.png");
        kick = new GreenfootImage("pixil-frame-kick.png");
        stand1 = new GreenfootImage("pixil-frame-normal.png");
        
        walk1 = new GreenfootImage("pixil-frame-walk1.png");
        walk2 = new GreenfootImage("pixil-frame-walk2.png");
        dead1 = new GreenfootImage("pixil-frame-dead.png");
        setImage(stand1);
        
        health = 200;
        
        
        hadoukenDelayCount = 130;
    }
    
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Keys();
        hadoukenDelayCount++;
    }
    
    
    public void Keys()
    {
        Player2 P2 = (Player2) getOneIntersectingObject(Player2.class);
        MyWorld myworld = (MyWorld) getWorld();//gets the world
        if (Greenfoot.isKeyDown("k"))//left
        {
            move(-5);
            setImage(walk1);
        }
        if (Greenfoot.isKeyDown("l"))//right
        {
            move(5);
            setImage(walk2);
        }
        if (Greenfoot.isKeyDown(";") && !isPunch)//punch
        {
            setImage(punch);
            if (P2 != null)
            {
                myworld.subtractHealthP2(punchdamage);
            }
            isPunch = true;
        }
        else if(!Greenfoot.isKeyDown(";") && isPunch)
        {
            setImage(stand1);
            isPunch = false;
        }
        if (Greenfoot.isKeyDown("'") && !isKick)//kick
        {
            setImage(kick);
            Greenfoot.playSound("Kick.mp3");
            if (P2 != null)
            {
                myworld.subtractHealthP2(kickdamage);//uses method subtractHealth in world and add -5
            }
            isKick = true;
        }
        else if(!Greenfoot.isKeyDown("'") && isKick)
        {
            setImage(stand1);
            isKick = false;
        }
        if (Greenfoot.isKeyDown("p"))//special
        {
            //setImage();
            Greenfoot.playSound("Hadouken.mp3");
            HADOUKEN();
        }
        
        if (healthP1() <= 0)
        {
            setImage(dead1);
            Greenfoot.stop();
        }
    }
    
    private void HADOUKEN()
    {
        if (hadoukenDelayCount >= hadoukenReloadTime) 
        {
            Hadouken hadouken = new Hadouken();
            getWorld().addObject (hadouken, getX(), getY());
            hadoukenDelayCount = 0;
        }
    }

    
    public void hitP1(int damage)
    {
        health += damage;
    }
    
    public int healthP1()
    {
         return health;
    }
}
