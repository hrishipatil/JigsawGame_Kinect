import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class CommandButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CommandButton extends Actor implements IScreen
{
    public int x, y;

    public CommandButton()
    {
    }
    
    public CommandButton(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
        
    public void act() 
    {
    }    
    
    public void setCommand(ICommand cmd){}
	public void invoke(){}
    
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
