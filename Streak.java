import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Streak here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Streak extends Actor
{
    private GreenfootImage image1;
    private int scaleWidth = 30;
    private int scaleHeight = 30;
    
    public Streak()
    {
        image1 = new GreenfootImage("Hadouken.png");
        setImage(image1);
    }
    /**
     * Act - do whatever the Streak wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        shrink();
    }
    
    public void shrink()
    {
      if (scaleWidth <= 0)
      {
        MyWorld myworld = (MyWorld) getWorld();
        getWorld().removeObject(this);
        }
        else{
            image1.scale(scaleWidth, scaleHeight);
            scaleWidth = scaleWidth -1;
            scaleHeight = scaleHeight -1;
        }
    }
}
