import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class SelectModeButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectModeButton extends CommandButton implements IScreen
{
    /**
     * Act - do whatever the SelectModeButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int mouseX, mouseY,x,y;
    SelectModeCommand selectModeCommand = null;
    ModeScreen receiver = new ModeScreen();
    
    List modeKnblist;
    public static HashMap matrix =  null;
    public static Boolean modeFlag = false;
    public static Boolean pushMeFlag = false;
    public static Boolean startPush = false;
    GreenfootImage image;
    int rightHandX;
    int rightHandY;
    boolean isImageInHand = false;
    JigsawWorld pw ;
    UserData[] users;
    static boolean flag=true;
    int i=0;
    
    public SelectModeButton(int X, int Y)
    {
        this.x = X;
        this.y = Y;
        image = getImage();
        pw = (JigsawWorld)getWorld();
       
    }

    public SelectModeButton(){}
    
    public void invoke()
    {
        selectModeCommand.executeCommand();
    }
    
     public void act() 
    {
        pw = (JigsawWorld)getWorld();
        users = pw.getTrackedUsers();

        for(UserData user : users)
        {
            Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
            Joint leftHand = user.getJoint(Joint.LEFT_HAND);
         
            //this condition executes only once when image is not selected
            if((rightHand.getX() >= getX() - (image.getHeight() / 2) && rightHand.getX() <= getX() + (image.getHeight() / 2) ) 
            && (rightHand.getY() >= getY() - (image.getWidth() / 2) && rightHand.getY() <= getY() + (image.getWidth() / 2))     // chk overlapping of righthand and image,
            && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY()                                         // chk for lefthand is up
            && !isImageInHand  //chk if image is in hand
            && flag ) // flag to select only 1 image in hand at a time
            {
                //this.setLocation(rightHand.getX(),rightHand.getY());
                this.i++;
                this.flag = false;
                this.isImageInHand = true;
                
                selectModeCommand = new SelectModeCommand(pw);
                selectModeCommand.setReceiverScreen(receiver);
                selectModeCommand.executeCommand();

            } 
            else if( this.i > 0 && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY() & !flag) // executes if left hand is in up position & image is selected
            {
                //this.setLocation(rightHand.getX(),rightHand.getY());
                this.isImageInHand = true;
                selectModeCommand.executeCommand();
            } 
            else if(!flag && isImageInHand && user.getJoint(Joint.LEFT_HAND).getY() > user.getJoint(Joint.HEAD).getY()) //executes if left hand is down
            {
                this.isImageInHand = false;
                this.flag = true;
                this.i = 0;
            }
        }
    } 
    
    

    public void AddComponents(IScreen screen){}

    public void RemoveComponents(IScreen screen){}

    public int getXCoordinate(){

        return x;
    }

    public int getYCoordinate(){
        return y;
    }
}

