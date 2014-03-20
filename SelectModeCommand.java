import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectModeCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectModeCommand extends Actor implements ICommand
{
    ModeScreen selectModeReceiver = new ModeScreen();
    World pw = null;
    
    public SelectModeCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           selectModeReceiver.doAction(pw);
       } 
       
    public void setReceiverScreen(ModeScreen receiver)
       {
           selectModeReceiver = receiver;
       }
    public void act() 
    {
        // Add your action code here.
    }    
}
