import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RightRotateCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightRotateCommand extends Actor implements ICommand
{
    ImageContainerBoard rightRotateReceiver = new ImageContainerBoard();
    World pw;
    
    public RightRotateCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           rightRotateReceiver.doAction(pw);
       } 
       
    public void setReceiverScreen(ImageContainerBoard receiver)
       {
           rightRotateReceiver = receiver;
       }
       
    public void act() 
    {
        // Add your action code here.
    }    
}
