import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor implements IScreen,Subject
{
    long initialTime = System.currentTimeMillis();
    public static int elapsedTime = 0, secs = 0, millis = 0, mins = 0;
    //public static String IsPuzzleSolved = null;
    public List<Observer> observers = null;
    public static String usedTime = null;
    int x,y;
    public boolean isTimerStopped = false;

    public Timer(int X, int Y)
    {
        this.x = X;
        this.y = Y;
        updateImage();
        observers = new ArrayList<Observer>();
    }

    public void act()
    {
        start_timer();
    }

    public void start_timer()
    {
        if(Canvas.split_flag == "true"){
            elapsedTime = (int) (System.currentTimeMillis() - initialTime);
            updateImage();

        }
        else 
        {
            updateBlankImage();
        }
    }

    public void updateImage()
    {
        millis = elapsedTime % 1000;
        secs = (elapsedTime / 1000) % 60;
        mins = elapsedTime / 60000;
        if(secs == 45 && ModeScreen.modeFlag == true)
        {
            notifyObservers();
        }
        String millisText = String.format("%02d", millis);
        String secsText = String.format("%02d", secs);

        String minsText = "" + mins;
        String text = minsText + ":" + secsText + ":" + millisText;
        GreenfootImage img = new GreenfootImage(text, 30, Color.white, null);
        setImage(img);

    }

    public void updateBlankImage()
    {
        int milli = millis;
        int sec = secs;
        int min = mins;
        String millisText = String.format("%02d", milli);
        String secsText = String.format("%02d", sec);
        String minsText = "" + mins;
        String text = minsText + ":" + secsText + ":" + millisText;

        if (MessageBoard.IsPuzzleSolved && !isTimerStopped)
        {
            isTimerStopped = MessageBoard.IsPuzzleSolved;
            usedTime = text;
            //System.out.println("Inside Flag"+ MessageBoard.IsPuzzleSolved + "with time"+ usedTime);

            Component obj = new ConcreteDecoratorTimer( new ConcreteDecoratorLevel(new ConcreteComponent()));
            String result = obj.successMessage();
           // System.out.println( "Decorator calling :: " + result );
            GreenfootImage img = new GreenfootImage(result, 20, Color.white, null);
            setImage(img);
        }
    }

    public void register(Observer obj) {
        if(obj == null) 
        {
            throw new NullPointerException("Null Observer");
        }
        if(!observers.contains(obj)) 
        {
            observers.add(obj);
        }
    }

    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers(){
        try{
            for (Observer observer : observers) {
                observer.update();
                //System.out.println("observer" + observer);
            }
        }
        catch(Exception e)
        {}
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

