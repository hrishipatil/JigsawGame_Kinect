import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class ModeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ModeScreen extends Actor implements IScreen, IReceiver
{
    /**
     * Act - do whatever the ModeScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int mouseX,prevMouseX = 0,prevMouseY = 0, mouseY, index,x,y;
    World pw=null;
    Actor knob;
    List modeKnblist;
    public static HashMap matrix =  null;
    public static Boolean modeFlag = false;
    public static Boolean pushMeFlag = false;
    GreenfootImage image;
        
    public ModeScreen(int X,int Y)
    {
        this.x = X;
        this.y = Y;
        image = getImage();
    }
    
    public ModeScreen(){
         image = getImage();
    }
    
    public void doAction(World pw)
    {
            //pw = (JigsawWorld)getWorld();
           pushMeFlag =true;
           modeKnblist = pw.getObjects(ModeKnob.class);
            GreenfootImage img = new GreenfootImage("game_screen_background.jpg");
            pw.setBackground(img);
            List hand = pw.getObjects(UserHand.class);
            List thmb = pw.getObjects(Thumbnail.class);
            
            
            IScreen screen = new Screen(pw);
            IScreen modeScreen =  (IScreen)pw.getObjects(ModeScreen.class).get(0);
            screen.RemoveComponents(modeScreen);
            IScreen modeBtn = (IScreen) pw.getObjects(SelectModeButton.class).get(0);
            screen.RemoveComponents(modeBtn);
            pw.removeObjects(hand);
            pw.removeObjects(thmb);
            
            
            List bckg = pw.getObjects(Background.class);
            pw.removeObjects(bckg);
            List lbl = pw.getObjects(Label.class);
            pw.removeObjects(lbl);
           
            IScreen dashBoard = new Dashboard(890,140);
            IScreen leftButton = new LeftButton(100,535);
            IScreen rightButton = new RightButton(650,535);
            IScreen leftImage = new LeftImage(320,535);
            IScreen middleImage = new MiddleImage(500,535);
            IScreen msgboard = new MessageBoard(650,350);
            IScreen imagecontainerboard = new ImageContainerBoard(650,100);
            //screen.AddComponents(dashBoard);
            screen.AddComponents(leftButton);
            screen.AddComponents(rightButton);
            screen.AddComponents(leftImage);
            screen.AddComponents(middleImage);
            screen.AddComponents(dashBoard);
            screen.AddComponents(msgboard);
            screen.AddComponents(imagecontainerboard);        
            
            
            GreenfootImage images = new GreenfootImage("start_screen_background2.jpg");
            pw.addObject(new Background(images), 400, 190);
            
            
            for (Object obj : modeKnblist)  
            {  
                ModeKnob knob = (ModeKnob) obj; // sub-casting  
                mouseX = knob.getX();
                mouseY = knob.getY();
                //System.out.println("Knob cooridnates are "+ mouseX + " and "+ mouseY );

                if (mouseY > 240
                && mouseY < 260)
                {
                    if(mouseX < 585) 
                    {
                       // System.out.println("Its easy level!");
                        IScreen timer = new Timer(210, 400);
                        screen.AddComponents(timer);
                        screen.addToWorld();
                        Level easy = LevelFactory.selectLevel(LevelTypeEnum.EASY,pw);
                        pw.addObject(easy,890,140);
                        modeFlag=false;

                    }  
                    else 
                    //if(mouseX > 668 
                    //&& mouseX < 680)
                    {
                       // System.out.println("Its hard level!");
                        IScreen timer = new Timer(210, 400);
                        IScreen timeoutmsg = new TimeOutMessage(pw,650,350);
                        screen.AddComponents(timer);
                        screen.AddComponents(timeoutmsg);
                        screen.addToWorld();
                        TimeOutMessage.addToWorld = true;
                        Level hard = LevelFactory.selectLevel(LevelTypeEnum.HARD,pw);
                        pw.addObject(hard,890,140);
                        modeFlag = true;
                    }
                    pw.addObject(new UserHand(), 500, 150);
                    //pw.addObject(new Thumbnail(), getWorld().getWidth() - 80/2, getWorld().getHeight() - 60/2);
                }
            }
    }
    
    public void act() 
    {
        if(Greenfoot.mousePressed(this)) 
        {
         MouseInfo mouse = Greenfoot.getMouseInfo();  
         mouseX=mouse.getX();  
         mouseY=mouse.getY(); 
        // System.out.println("X cordiante in screen is"+mouseX + "Y coordiante is"+ mouseY );
         
         if(mouseX > 466 
         && mouseX < 480
         && mouseY > 240
         && mouseY < 260)
         {
         //System.out.println("Condition Satified!");
         knob = getOneObjectAtOffset(100,100,ModeKnob.class);
         /////knob.setLocation(460,250);
         //knob.setLocation();
         }
        }
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
