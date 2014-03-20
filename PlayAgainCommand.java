import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayAgainCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainCommand extends Actor implements ICommand
{
    MessageBoard playAgainReciver = null;
    World pw = null;
    
    public PlayAgainCommand(World world)
    {
        pw = world;
    }
    
    public void executeCommand()
       {
           playAgainReciver.doAction(pw);
       } 
       
    public void setReceiverScreen(MessageBoard receiver)
       {
           playAgainReciver = receiver;
       }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
