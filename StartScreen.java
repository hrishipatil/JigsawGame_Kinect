import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends Actor implements IScreen, IReceiver
{
    int x,y;
    
    public StartScreen(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
    
    public StartScreen()
    {
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction(World pw) 
    {
            IScreen screen = new Screen(pw);
            List startBtn =  pw.getObjects(CommandButton.class);
            List imageCont =pw.getObjects(ImageContainer.class);
             List hand = pw.getObjects(UserHand.class);
            List thmbnail = pw.getObjects(Thumbnail.class);
            pw.removeObjects(startBtn);
            pw.removeObjects(imageCont);
             pw.removeObjects(hand);
            pw.removeObjects(thmbnail);

            GreenfootImage img = new GreenfootImage("game_screen_background.jpg");
            pw.setBackground(img);

            IScreen modeScreen = new ModeScreen(400,260);
            IScreen selectModeButton = new SelectModeButton(170,300);
            IScreen modeKnob = new ModeKnob(470,250);
            IScreen imageContainer = new ImageContainer(400,525);
            IScreen leftButton = new LeftButton(100,535);
            IScreen rightButton = new RightButton(650,535);

            screen.AddComponents(modeScreen);
            screen.AddComponents(selectModeButton);
            screen.AddComponents(modeKnob);
            screen.AddComponents(imageContainer);
            //  screen.AddComponents(leftButton);
            // screen.AddComponents(rightButton);
            screen.addToWorld();
            pw.addObject(new UserHand(), 500, 150);
            pw.addObject(new Thumbnail(), pw.getWidth() - 80/2, pw.getHeight() - 60/2);
    }
    
    public void addToWorld(){}

    public void AddComponents(IScreen screen){}

    public void RemoveComponents(IScreen screen){}

    public int getXCoordinate(){

        return x;
    }

    public int getYCoordinate(){

        return y;
    }
}
