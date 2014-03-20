import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class SplitImageDrag extends Image implements Observer
{
    public static ArrayList coordiantesArray = null;
    public static ArrayList tempArray = new ArrayList();
    public static HashMap imageCoordinateMap = new HashMap();
    public static Boolean correct = false; //this is final flag. it will true only if all images are place correctly.
    GreenfootImage image;
    int mouseX, mouseY, index;
    String nameCanvas= null;
    String nameimage = null;
    String nameimage1 = null;
    String name=null;
    private   ImageMonitor imgMonitor;
    public  List<Canvas> list=null;
    public static ArrayList<String> nameImage = null; 
    public static int noOfSplitImages = 0;
    List splitDragImage;
    World pw;
    
    
    public SplitImageDrag(World world)
    {
        nameImage = new ArrayList<String>();
        noOfSplitImages = Canvas.splitImagesMap.size() + 1;
        try{
            list=world.getObjects(Canvas.class);
        }catch(NullPointerException e)
        {
            //System.out.println("Exception"+e);
        }
        pw = world;
        setSubject();
        image = getImage();
    }

    public ImageMonitor getImageMonitor()
    {
        return imgMonitor;
    }

    public void setSubject()
    {
        Timer timer = (Timer) pw.getObjects(Timer.class).get(0);
        //this.timer = timer;
        timer.register(this); 
    }

    public void update()
    {
        Canvas.split_flag = "false";
        splitDragImage = pw.getObjects(SplitImageDrag.class);
        pw.removeObjects(splitDragImage); 
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
                  oldAct(rightHand.getX(), rightHand.getY());
            } 
            else if(!flag && isImageInHand && user.getJoint(Joint.LEFT_HAND).getY() > user.getJoint(Joint.HEAD).getY()) //executes if left hand is down
            {
                this.isImageInHand = false;
                this.flag = true;
                this.i = 0;
                  oldAct(rightHand.getX(), rightHand.getY());
            } 
        }
    }
    

    public void oldAct(int mouseX, int mouseY) 
    {

        int finalX = mouseX;
        int finalY = mouseY;
        coordiantesArray = new ArrayList();
        coordiantesArray.add(finalX);
        coordiantesArray.add(finalY);
        coordiantesArray.add(name);
        coordiantesArray.add(index);
        String name = (String) Canvas.splitImagesMap.get(this.getImage());
        //System.out.println("name :: " + name + "  " + this.getImage());
        list = pw.getObjects(Canvas.class);
        List matrixList = pw.getObjectsAt(finalX, finalY, Canvas.class);

        if(!matrixList.isEmpty()){
           // System.out.println("am in matrixlist");
            Actor canvas = (Actor) matrixList.get(0);
            //System.out.println("Size :: " + list.size() + "  " + matrixList.size());

            for(int i =0;i<list.size();i++)
            {
                Actor canvasAll = (Actor) list.get(i);

                if(canvas.equals(canvasAll))
                {
                    //System.out.println("Found");
                    nameCanvas = (String)ModeScreen.matrix.get(i);
                    break;
                }

            }

           // System.out.println("kal split image name::: "+ Canvas.splitImagesMap.get(this.getImage()) + "kal canvas name:: "+ nameCanvas);

            if(nameCanvas.equals(Canvas.splitImagesMap.get(this.getImage())))
            {
                if(nameImage.contains(name)){
                    //System.out.println("same image");
                   // System.out.println("matching");
                    correct = true;
                }
                else
                {

                    //System.out.println("matching");

                    correct = true;
                    nameImage.add(name);

                }
            }           
            else
            {
                correct = false;
                //System.out.println("not matching");
            }
            // this is final flag. it will true only if all images are place correctly.
            //System.out.println("Final Flag :: " + correct);
            //System.out.println("noOfSplitImages :: " + noOfSplitImages);
            //System.out.println("nameImage.size() :: " + nameImage.size());
            
            if(nameImage.size() == noOfSplitImages)
            { 
                //System.out.println("game complete");
                Canvas.split_flag = "false";
                //System.out.println("Puzzle Solved Inside SplitImage Drag");
                list.get(0).getImageMonitor().setStatus("PuzzleSolved");
                list.get(0).getImageMonitor().notifyObservers();
                correct = true;
                nameImage.add(name);

            }

        }
    }
    
}
    /*  if(correct)
    {

    System.out.println("Puzzle Solved Inside SplitImage Drag");
    list.get(0).getImageMonitor().setStatus("PuzzleSolved");
    list.get(0).getImageMonitor().notifyObservers();
    correct = true;
    nameImage.add(name);
    }*/
