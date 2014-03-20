import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class TimeOutMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeOutMessage extends MessageBoard implements Observer,IScreen
{
    public static Boolean addToWorld = false;
    World pw;
    public TimeOutMessage(World world, int X, int Y)
    {
        this.x = X;
        this.y = Y;
        pw = world;
        
    }
    
    public TimeOutMessage()
    {
    }
    
    public void setSubject()
    {
        if(addToWorld == true)
        {
            Timer timer = (Timer) pw.getObjects(Timer.class).get(0);
            timer.register(this);
            addToWorld = false;
        }
    }
    
    public void act() 
    {
        setSubject();
    }  
    public void update()
    {
        List msgBoard= pw.getObjects(MessageBoard.class);
        pw.removeObjects(msgBoard);
        pw.addObject(new TimeOutMessage(), 650,350);
        
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

