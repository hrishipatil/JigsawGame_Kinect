import java.util.*;

/**
 * Write a description of class PuzzleMonitor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PuzzleMonitor implements IPuzzleObserverSubject 
{
  // A Collection to keep track of all Registered Observers
  ArrayList observers = new ArrayList();

  // Stores latest stock quote (example is purposely simplistic)
  String puzzleStatus = "Unsolved";
  
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
