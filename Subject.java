/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject  
{
    // instance variables - replace the example below with your own
    public void register(Observer obj);
    public void unregister(Observer obj);
    public void notifyObservers();
}
