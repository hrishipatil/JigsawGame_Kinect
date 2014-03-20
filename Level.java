import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Level extends Actor
{
    List modeScreen,modeBtn,imageContainer,modeKnb;
    int x,y;
    World pw ;
    protected PuzzleMonitorSubject pzzlMonitor;//This reference is used by the messageBoard to receive puzzle update status 
    protected   ImageMonitor imgMonitor;//This reference is used by the levels to receive image arrangement update status 
  
    public Level(World world)
    {
        pw = world;
        ModeScreen.matrix = new HashMap();
        IScreen screen = new Screen(pw);
        IScreen modeKnob =  (IScreen)pw.getObjects(ModeKnob.class).get(0);
        screen.RemoveComponents(modeKnob);
        pzzlMonitor= new PuzzleMonitorSubject();
         pw.addObject(pzzlMonitor,650,350);
        pw.addObject(new MessageBoard(pw, pzzlMonitor),650,350);
      
    }
    
    public void act()
    {}
    
    
    

    
}
