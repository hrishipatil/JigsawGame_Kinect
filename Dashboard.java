import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dashboard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dashboard extends Actor implements IScreen
{
    int x,y;
    
    public Dashboard(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }
    
    public Dashboard()
    {}
    
    public void act() 
    {
    }    
    
    public void addToWorld(){}

    public void AddComponents(IScreen screen){

    }

    public void RemoveComponents(IScreen screen){}

    public int getXCoordinate(){

        return x;
    }

    public int getYCoordinate(){

        return y;
    }
}
