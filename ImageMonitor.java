import java.util.*;
/**
 * Subject class to support split images' arrangement observer design pattern
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageMonitor implements IImageMovementSubject
{
  
  // A Collection to keep track of all Registered Observers
  ArrayList observers = new ArrayList();

  // Stores latest puzzle status
  String status = "PuzzleUnsolved";
  
  public void setStatus(String newStatus)
  {
    status = newStatus;
    //System.out.println("Puzzle Status:"+status);
  }
  
  public void register(IImageMovementObserver o)
  {
    observers.add(o);
    //System.out.println("Canvas Registered"+observers.size());
  }

  public void unregister( IImageMovementObserver o)
  {
    int i = observers.indexOf(o);
    observers.remove(i);
  }

  public void notifyObservers()
  {
      System.out.println("Notify Observers Called"+observers.size());
    for (int i=0;i < observers.size();i++)
    {
       IImageMovementObserver ob = (IImageMovementObserver)observers.get(i);
      ob.updateImageDetails(status);
    }
  }
}
