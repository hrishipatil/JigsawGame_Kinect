import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class IScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IScreen
{

    public void addToWorld(); 

    public void AddComponents(IScreen screen);

    public void RemoveComponents(IScreen screen);

    public int getXCoordinate();

    public int getYCoordinate();

        
}
