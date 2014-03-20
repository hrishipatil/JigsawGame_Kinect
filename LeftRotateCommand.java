import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LeftRotateCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftRotateCommand extends Actor implements ICommand
{
    ImageContainer leftRotateReceiver = new ImageContainer();
    World pw = null;
    /**
     * Act - do whatever the LeftRotateCommand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public LeftRotateCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           leftRotateReceiver.doAction(pw);
       } 
       
    public void setReceiverScreen(ImageContainer receiver)
       {
           leftRotateReceiver = receiver;
       }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
