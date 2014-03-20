import greenfoot.*;  
import javax.imageio.ImageIO;  
import java.awt.image.BufferedImage;  
import java.io.*;  
import java.awt.*;  
import java.util.*;

public class Canvas extends Actor implements Observer,IImageMovementObserver
{
    public static HashMap splitImagesMap = null;
    public static ArrayList splitImagesList = null;
    public static String split_flag = "false";
    private ImageMonitor imgMonitor;
    public static String image = "left";
    
    private  java.util.List<PuzzleMonitorSubject>  pzzMonitor=null;
    private  java.util.List<MessageBoard> lstMessageBoard=null;
    World pw;

    public Canvas()//This code will be removed later
    {     
        splitImagesMap = new HashMap();
        splitImagesList =  new ArrayList();
        imgMonitor.register(this);

    }     

    public Canvas(ImageMonitor im,World world)
    {     
        splitImagesMap = new HashMap();
        splitImagesList =  new ArrayList();
        pw = world;
        setSubject();

        //Monitor subject for image 
        imgMonitor = im;    
        imgMonitor.register(this);

        
        try{
            lstMessageBoard=pw.getObjects(MessageBoard.class);
            //System.out.println(" MessageBoard found in world");
            //lstMessageBoard.get(0).getPuzzleMonitor().setPuzzleStatus("Unsolved");

        }catch(NullPointerException e)
        {
            //System.out.println("No MessageBoard found in world");            
        }
    }

    public java.util.List<MessageBoard> getLstMessageBoard()
    {
        return lstMessageBoard;
    }

    public ImageMonitor getImageMonitor()
    {
        return imgMonitor;
    }

    public void setSubject()
    {
        //System.out.println("Timer Set");
        Timer timer = (Timer) pw.getObjects(Timer.class).get(0);
        //this.timer = timer;
        timer.register(this); 
    }

    public void update()
    {

        Greenfoot.stop();

    }

    public void act() 
    {

        if(ModeScreen.modeFlag==false){
            if(isTouching(LeftImage.class))
            {
                splitImageIntoChunks("panda.jpg",3);
                split_flag = "true";
                notifyImageBoard(9);
                image = "left";
                removeTouching(LeftImage.class);
                updateImageContainer(image);
            }

            else if(isTouching(MiddleImage.class))
            {
                splitImageIntoChunks("penguin.jpg",3);
                split_flag = "true";
                notifyImageBoard(9);
                image = "middle";
                removeTouching(MiddleImage.class);
                updateImageContainer(image);
            }

            else if(isTouching(RightImage.class))
            {
                splitImageIntoChunks("minion.jpg",3);
                split_flag = "true";
                notifyImageBoard(9);
                image = "right";
                removeTouching(RightImage.class);
                updateImageContainer(image);
            }
        }

        else if(ModeScreen.modeFlag==true)
        {
            if(isTouching(LeftImage.class))
            {
                //System.out.println("Left Image Split");
                splitImageIntoChunks("panda.jpg",4);
                split_flag = "true";
                notifyImageBoard(16);
                image = "left";
                removeTouching(LeftImage.class);
                updateImageContainer(image);
            }

            else if(isTouching(MiddleImage.class))
            {
                //System.out.println("Middle Image Split");
                splitImageIntoChunks("penguin.jpg",4);
                split_flag = "true";
                notifyImageBoard(16);
                image = "middle";
                removeTouching(MiddleImage.class);
                updateImageContainer(image);
            }

            else if(isTouching(RightImage.class))
            {
               // System.out.println("Right Image Split");
                splitImageIntoChunks("minion.jpg",4);
                split_flag = "true";
                notifyImageBoard(16);
                image = "right";
                removeTouching(RightImage.class);
                updateImageContainer(image);
            }
        }

    }   

    public void splitImageIntoChunks(String imageName, int pieces)
    {
        try{

            File file = new File("images/" + imageName); // I have bear.jpg in my working directory  
            FileInputStream fis = new FileInputStream(file);  
            BufferedImage image = ImageIO.read(fis); //reading the image file  

            int rows = pieces; //You should decide the values for rows and cols variables  
            int cols = pieces;  
            int chunks = rows * cols;  

            int chunkWidth = image.getWidth() / cols; // determines the chunk width and height  
            int chunkHeight = image.getHeight() / rows;  
            int count = 0;  
            BufferedImage imgs[] = new BufferedImage[chunks]; //Image array to hold image chunks  
            for (int x = 0; x < rows; x++) {  

                for (int y = 0; y < cols; y++) {  
                    //Initialize the image array with image chunks  
                    imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());  
                    // draws the image chunk  
                    Graphics2D gr = imgs[count++].createGraphics();  
                    gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, chunkWidth * y, chunkHeight * x, chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);  
                    gr.dispose();  
                }

            }  
            //System.out.println("Splitting done");  

            //writing mini images into image files  
            for (int i = 0; i < imgs.length; i++) {  
                ImageIO.write(imgs[i], "jpg", new File("img" + i + ".jpg"));  

            }  
            //System.out.println("Image split into chunks");  
        }catch(Exception e)
        {
            //System.out.println("Exception ocurred:"+e);  
        }
    }  

    public void notifyImageBoard(int displayPieces)
    {
        int cnt=0;
        int colLeft=580,colRight=690;
        World w = getWorld();

        for (int i=0;i<displayPieces;i++)
        {
            SplitImageDrag chunk = new SplitImageDrag(pw);
            GreenfootImage img = new GreenfootImage("img"+i+".jpg");
            chunk.setImage(img); 
            if(i<5)
            {
                w.addObject(chunk,colLeft,60);
            }

            else{
                w.addObject(chunk,colRight,60);
            }
            String splitImageName  = "img"+i+".jpg";
            splitImagesMap.put(chunk.getImage(),splitImageName);
           // System.out.println("kalyani :: " + chunk.getImage());
        }

        System.out.println("splitImages:: " + splitImagesMap.size());

    }

    public void updateImageContainer(String image)
    {
        System.out.println("Inside update image container");
        CommandButton btnPlayAgain = new PlayAgainButton(pw);
        CommandButton btnExit = new ExitButton();

        IScreen screen = new Screen(pw);

        if(image.equalsIgnoreCase("left")) {
            IScreen middleimage = (IScreen)pw.getObjects(MiddleImage.class).get(0);
            screen.RemoveComponents(middleimage);
        }
        else if(image.equalsIgnoreCase("right")){
            IScreen middleimage = (IScreen)pw.getObjects(MiddleImage.class).get(0);
            screen.RemoveComponents(middleimage);
        }
        else if(image.equalsIgnoreCase("middle")){
            if(RightButton.rightbutton_pressed == true){
                IScreen rightimage = (IScreen)pw.getObjects(RightImage.class).get(0);
                screen.RemoveComponents(rightimage);
            }
            else if(RightButton.rightbutton_pressed == false){
                IScreen leftimage = (IScreen)pw.getObjects(LeftImage.class).get(0);
                screen.RemoveComponents(leftimage);
            }

        }
        java.util.List leftbutton = pw.getObjects(LeftButton.class);
        pw.removeObjects(leftbutton);
        java.util.List rightbutton = pw.getObjects(RightButton.class);
        pw.removeObjects(rightbutton);

        //pw.addObject(btnPlayAgain,250,530);
        pw.addObject(btnExit,390,527);
    }

    //This method is invoked by the Image observer to notify the change in the status of the puzzle status 
    public void updateImageDetails(String imagesArrangmnt){

       // System.out.println("Images Arrangement:"+imagesArrangmnt);  
        //System.out.println("Puzzle Solved Inside Canvas--Notifying MessageBoard");
        pzzMonitor=getWorld().getObjects(PuzzleMonitorSubject.class);
        pzzMonitor.get(0).setPuzzleStatus("PuzzleSolved");
        pzzMonitor.get(0).notifyObservers();
        /*
        //Notifying message board---Puzzle is solved
        try{
        System.out.println("Images Arrangement:"+imagesArrangmnt);  

        lstMessageBoard.get(0).getPuzzleMonitor().setPuzzleStatus("PuzzleSolved");
        lstMessageBoard.get(0).getPuzzleMonitor().notifyObservers();
        }catch(NullPointerException e)
        {
        getWorld().addObject(new MessageBoard(), 650, 350);

        System.out.println("Notifying messageboard that puzzle is solved:"+imagesArrangmnt);  
        lstMessageBoard=getWorld().getObjects(MessageBoard.class);
        lstMessageBoard.get(0).getPuzzleMonitor().setPuzzleStatus("PuzzleSolved");
        lstMessageBoard.get(0).getPuzzleMonitor().notifyObservers();

        }catch(Exception e){
        System.out.println("Exception:"+e);
        }
        //  lstMessageBoard.get(0).getImageMonitor().notifyObservers();

         */
    }

}
