import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ImageContainerBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageContainerBoard extends Dashboard implements IScreen, IReceiver
{
    int x,y;
    public ImageContainerBoard(int X, int Y){
        this.x = X;
        this.y = Y;
    }

    public ImageContainerBoard(){

    }

    public void act() 
    {
        // Add your action code here.
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
        RightButton.rightbutton_pressed = true;
        LeftButton.leftbutton_pressed = false;
        List leftImage = pw.getObjects(LeftImage.class);
        List rightImage = pw.getObjects(RightImage.class);
        List middleImage = pw.getObjects(MiddleImage.class);
        pw.removeObjects(leftImage);
        pw.removeObjects(middleImage);
        pw.removeObjects(rightImage);
        pw.addObject(new MiddleImage(), 320,535);
        pw.addObject(new RightImage(),500,535);// Add your action code here.
    }
}
