import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ImageContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageContainer extends Actor implements IScreen, IReceiver
{
    int x,y;

    public ImageContainer(int X, int Y)
    {
        this.x = X;
        this.y = Y;
        GreenfootSound sound = new GreenfootSound("Background_Music.mp3");
        sound.playLoop();
    }
     

    public ImageContainer(){}

    public void act() 
    {
        
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

    public void doAction(World pw) 
    {
        RightButton.rightbutton_pressed = false;
        LeftButton.leftbutton_pressed = true;

        List leftImage = pw.getObjects(LeftImage.class);
        List rightImage = pw.getObjects(RightImage.class);
        List middleImage = pw.getObjects(MiddleImage.class);
        pw.removeObjects(rightImage);
        pw.removeObjects(middleImage);
        pw.removeObjects(leftImage);
        pw.addObject(new LeftImage(),320,535);
        pw.addObject(new MiddleImage(),500,535);
    }
}
