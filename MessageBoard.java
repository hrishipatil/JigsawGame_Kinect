import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MessageBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessageBoard extends Actor implements IScreen, IPuzzleObserver, IReceiver
{
    int x,y;
    private PuzzleSolvedMessage pzzleSolved;
    private PuzzleMonitorSubject pzzlMonitor;
    public static boolean IsPuzzleSolved = false;
    private World w;

    public MessageBoard(int X, int Y)
    {
        this.x = X;
        this.y = Y;
    }

    public  MessageBoard(World pw,PuzzleMonitorSubject pm)
    {      
        try{
            pzzlMonitor= pm;
            pzzlMonitor.register(this);
            //System.out.println(" PuzzleMonitor found in world");
            //lstMessageBoard.get(0).getPuzzleMonitor().setPuzzleStatus("Unsolved");

        }catch(NullPointerException e)
        {
            //System.out.println("No PuzzleMOnitor found in world");            
        }
    }

    public MessageBoard()
    {
    }

    MessageBoard(PuzzleMonitorSubject pMonitor)
    {
        pzzlMonitor=pMonitor;
        pzzlMonitor.register(this);
    }

    public PuzzleMonitorSubject getPuzzleMonitor()
    {
        return pzzlMonitor;
    }

    public void addToWorld(){}

    public void AddComponents(IScreen screen){

    }

    public void RemoveComponents(IScreen screen){}

    public int getXCoordinate(){

        return x;
    }

    public int getYCoordinate(){

        return y;
    }

    public void act() 
    {
    }    

    private void updateMessageBoard(String msg)
    {
        if(msg.compareTo("PuzzleSolved")==0)   
        {
            IsPuzzleSolved = true;
            w=getWorld();
            List msgBoard= w.getObjects(MessageBoard.class);
            w.removeObjects(msgBoard);
            w.addObject(new PuzzleSolvedMessage(), 650,350);

           
            // GreenfootImage img = new GreenfootImage(result, 30, Color.white, null);
            // setImage(img);

        }

        else{
           // System.out.println("Puzzle Status:Unsolved");
        }
    }

    public void doAction(World pw) 
    {
        resetAllVariables();
        pw.removeObjects(pw.getObjects(null)); 
        GreenfootImage img = new GreenfootImage("game_screen_background.jpg");
        pw.setBackground(img);
        IScreen screen = new Screen(pw);
        IScreen modeScreen = new ModeScreen(400,260);
        IScreen selectModeButton = new SelectModeButton(170,300);
        IScreen modeKnob = new ModeKnob(470,250);
        IScreen image_Container = new ImageContainer(400,525);

        screen.AddComponents(modeScreen);
        screen.AddComponents(selectModeButton);
        screen.AddComponents(modeKnob);
        screen.AddComponents(image_Container);
        screen.addToWorld();
    }
    //This is a notification method on event 'PuzzleSolved'--invoked by Puzzle observer
    public void updatePuzzleStatus(String puzzleStatus){
        updateMessageBoard(puzzleStatus);
    }

    public void resetAllVariables()
    {
        Canvas.splitImagesMap = new HashMap();;
        Canvas.split_flag = "false";
        Screen.screenTwoComponents.clear();
        Canvas.splitImagesList = new ArrayList();;
        Canvas.image = "left";

        //SplitImageDrag.coordiantesArray.clear();
        SplitImageDrag.tempArray = new ArrayList();
        SplitImageDrag.imageCoordinateMap = new HashMap();
        SplitImageDrag.correct = false; //this is final flag. it will true only if all images are place correctly.
        SplitImageDrag.nameImage = null;
        SplitImageDrag.noOfSplitImages = 0;
        Timer.elapsedTime = 0;
        Timer.secs = 0;
        Timer.millis = 0;
        Timer.mins = 0;
    }

}
