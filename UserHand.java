import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UserHand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UserHand extends Actor
{
    /**
     * Act - do whatever the UserHand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image;
    
    public UserHand(){
        
        image = getImage();
        image.setTransparency(150);
        image.scale(50,50);
        
    }
    
    public void act() 
    {
        JigsawWorld world = (JigsawWorld)getWorld();
        //Greenfoot.playSound("Background_Music.mp3");

        UserData[] users = world.getTrackedUsers();
        for (UserData user : users)
        {
           
            Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
            this.setLocation(rightHand.getX(), rightHand.getY());
        }
    }    
}
