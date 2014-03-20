import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Screen extends Actor implements IScreen
{
    private int x, y;
    public static ArrayList<IScreen> screenTwoComponents=null;
    
    World pw =null;

    public Screen(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }

    public Screen(World w) {
        
        pw  = w;
        screenTwoComponents = new ArrayList();

    }

    public void act() {}

    public void addToWorld(){

        Iterator<IScreen> screenIterator = screenTwoComponents.iterator();  
        
        while(screenIterator.hasNext()){  
            
            IScreen screen = screenIterator.next();  
            Actor actor = (Actor)screen;
            //System.out.println(" *** " + actor + " : " + screen.getXCoordinate() + " : " + screen.getYCoordinate());
            pw.addObject(actor, screen.getXCoordinate(), screen.getYCoordinate()); 

        }  
    }

    public void AddComponents(IScreen screen){
        
        screenTwoComponents.add(screen);
        //System.out.println("kal ArrayList :: " + screenTwoComponents.size() + "  " + screenTwoComponents );
        
    }   

    public void RemoveComponents(IScreen screen){
        
        pw.removeObject((Actor)screen);
    }

    public int getXCoordinate(){
        return x;
    }

    public int getYCoordinate(){
        return y;
    }

}

