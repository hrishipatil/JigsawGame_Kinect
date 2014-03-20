/**
 * Write a description of class IImageMovementSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IImageMovementSubject  
{
       public void register(IImageMovementObserver o);
  public void unregister(IImageMovementObserver o);
  public void notifyObservers();
}
