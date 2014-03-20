import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * this class redirects user back to the mode selection screen
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayAgainButton extends CommandButton implements IScreen
{
    //List canvas;
    World pw;
    MessageBoard receiver = new MessageBoard();
    PlayAgainCommand playAgainCommand = null;

    public PlayAgainButton(World world)
    {
        pw = world; 
    }

    public void act() 
    {
        //World pw = getWorld();
        playAgainCommand = new PlayAgainCommand(pw);
        playAgainCommand.setReceiverScreen(receiver);
        if(Greenfoot.mousePressed(this))
        {
            //World pw = getWorld();
            playAgainCommand.executeCommand();
        }   
    }

}
