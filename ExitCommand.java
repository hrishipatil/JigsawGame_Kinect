import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitCommand extends Actor implements ICommand
{
    GameScreen exitReceiver = new GameScreen();
    World pw = null;
    /**
     * Act - do whatever the ExitCommand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public ExitCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           exitReceiver.doAction(pw);
       } 
       
    public void setReceiverScreen(GameScreen receiver)
       {
           exitReceiver = receiver;
       }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
