import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class PuzzleMonitorSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuzzleMonitorSubject extends Actor implements IPuzzleObserverSubject 
{
    
      // A Collection to keep track of all Registered Observers
  ArrayList observers = new ArrayList();

  // Stores latest stock quote (example is purposely simplistic)
  String puzzleStatus = "Unsolved";
    /**
     * Act - do whatever the PuzzleMonitorSubject wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    



  
  public void setPuzzleStatus(String status)
  {
    puzzleStatus=status;
  }
  
  public void register( IPuzzleObserver o)
  {
    observers.add(o);
  }

  public void unregister( IPuzzleObserver o)
  {
    int i = observers.indexOf(o);
    observers.remove(i);
  }

  public void notifyObservers()
  {
    for (int i=0;i < observers.size();i++)
    {
       IPuzzleObserver ob = ( IPuzzleObserver)observers.get(i);
      ob.updatePuzzleStatus(puzzleStatus);
    }
  }


}
