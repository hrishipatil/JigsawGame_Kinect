/**
 * Write a description of class IPuzzleObserverSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IPuzzleObserverSubject  
{
      public void register(IPuzzleObserver o);
  public void unregister(IPuzzleObserver o);
  public void notifyObservers();
}
