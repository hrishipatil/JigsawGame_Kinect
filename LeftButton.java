import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class LeftButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftButton extends CommandButton implements IScreen
{

    LeftRotateCommand leftRotateCommand = null;
    ImageContainer receiver = new ImageContainer();
    public static boolean leftbutton_pressed = false;
    
    private int x, y;
    public static Boolean startPush = false;
    GreenfootImage image;
    int rightHandX;
    int rightHandY;
    boolean isImageInHand = false;
    JigsawWorld pw ;
    UserData[] users;
    static boolean flag=true;
    int i=0;
    
    public LeftButton(){
        image = getImage();
    }
    
    public LeftButton(int X, int Y)
    {
        this.x = X;
        this.y = Y;
        image = getImage();
    }
    
    public void oldAct() 
    {
        World pw = getWorld();
        leftRotateCommand = new LeftRotateCommand(pw);
        leftRotateCommand.setReceiverScreen(receiver);
        leftRotateCommand.executeCommand();
         
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
                            && (rightHand.getY() >= getY() - (image.getWidth() / 2) && rightHand.getY() <= getY() + (image.getWidth() / 2)) // chk overlapping of righthand and image,
                            && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY() // chk for lefthand is up
                            && !isImageInHand  //chk if image is in hand
                            && flag && ModeScreen.pushMeFlag==true ) // flag to select only 1 image in hand at a time
            {
                //this.setLocation(rightHand.getX(),rightHand.getY());
                this.i++;
                this.flag = false;
                this.isImageInHand = true;
                oldAct();
            } 
            else if( this.i > 0 && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY() & !flag && ModeScreen.pushMeFlag==true) // executes if left hand is in up position & image is selected
            {
                //this.setLocation(rightHand.getX(),rightHand.getY());
                this.isImageInHand = true;
                oldAct();
            } 
            else if(!flag && isImageInHand && user.getJoint(Joint.LEFT_HAND).getY() > user.getJoint(Joint.HEAD).getY()) //executes if left hand is down
            {
                this.isImageInHand = false;
                this.flag = true;
                this.i = 0;
            } 
        }
    }   
    
    
    
    public void invoke()
    {
        leftRotateCommand.executeCommand();
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
