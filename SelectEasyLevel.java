import greenfoot.*; 
import java.util.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectEasyLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectEasyLevel extends Level
{
    int mouseX, mouseY;
    List modeScreen,modeBtn,Htile,modeKnb;
    public static Boolean modeFlag = false;
    World pw;

    public SelectEasyLevel(World world)
    {
        super(world);
        pw = world;
        int cntX =0;
        int cntY =0;
        int i=0;
        
        
        
        for (int x = 0; x < 3; x++) {  

            for (int y = 0; y < 3; y++) {  
                imgMonitor  =new ImageMonitor();
                Canvas chunkgrid = new Canvas(imgMonitor,pw);
                GreenfootImage imggrid = new GreenfootImage("3x3grid.jpg");
                imggrid.scale(105,100);
                chunkgrid.setImage(imggrid); 
                pw.addObject(chunkgrid,105+cntX,99+cntY);
                cntX=cntX+106;
                int midX = imggrid.getWidth();
                int midY = imggrid.getHeight();
                String imageName = "img"+ i +".jpg";
                System.out.println("Image Name ::" + imageName+ "   mid points :: " + midX + "  " + midY);
                ModeScreen.matrix.put(i,imageName);
                i++;
            }
            cntY = cntY+101;
            cntX=0;
        }
        // Add your action code here.
    }

    public void act() 
    {

    }    
}
