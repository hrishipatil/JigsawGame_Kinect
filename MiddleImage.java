import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiddleImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiddleImage extends Image implements IScreen
{
      GreenfootImage image;
    int mouseX, mouseY, index,x,y;
    String name=null;
    
    public static Boolean startPush = false;
    int rightHandX;
    int rightHandY;
    boolean isImageInHand = false;
    JigsawWorld world ;
    UserData[] users;
    static boolean flag=true;
    int i=0;
  
     public MiddleImage(){
         image = getImage();
     }
     
     public MiddleImage(int X, int Y)
     {
         this.x = X;
         this.y = Y;
         image = getImage();
     }
     
     
    public void act() 
      {
        world = (JigsawWorld)getWorld();
        users = world.getTrackedUsers();

        for(UserData user : users)
        {

            Joint rightHand = user.getJoint(Joint.RIGHT_HAND);
            Joint leftHand = user.getJoint(Joint.LEFT_HAND);

            //this condition executes only once when image is not selected
            if((rightHand.getX() >= getX() - (image.getHeight() / 2) && rightHand.getX() <= getX() + (image.getHeight() / 2) ) 
                            && (rightHand.getY() >= getY() - (image.getWidth() / 2) && rightHand.getY() <= getY() + (image.getWidth() / 2)) // chk overlapping of righthand and image,
                            && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY() // chk for lefthand is up
                            && !isImageInHand  //chk if image is in hand
                            && flag ) // flag to select only 1 image in hand at a time
            {
                this.setLocation(rightHand.getX(),rightHand.getY());
                this.i++;
                this.flag = false;
                this.isImageInHand = true;
            } 
            else if( this.i > 0 && user.getJoint(Joint.LEFT_HAND).getY() < user.getJoint(Joint.HEAD).getY() & !flag) // executes if left hand is in up position & image is selected
            {
                this.setLocation(rightHand.getX(),rightHand.getY());
                this.isImageInHand = true;
            } 
            else if(!flag && isImageInHand && user.getJoint(Joint.LEFT_HAND).getY() > user.getJoint(Joint.HEAD).getY()) //executes if left hand is down
            {
                this.isImageInHand = false;
                this.flag = true;
                this.i = 0;
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
