import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ConcreteCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartCommand extends Actor implements ICommand
{
    StartScreen startReceiver = new StartScreen();
    World pw = null;
    
    public StartCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           startReceiver.doAction(pw);
       } 
       
    public void setReceiverScreen(StartScreen receiver)
       {
           startReceiver = receiver;
       }
       
    public void act() 
    {
        // Add your action code here.
    }    
}
