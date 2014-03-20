import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JigsawWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JigsawWorld extends GameWorld
{

    /**
     * Constructor for objects of class JigsawWorld.
     * 
     */
    
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    
    private long leftHandUp;
    private Label leftHandWarning;
    
    public void init()
    {
       
       
        
//          ImageContainer imageContainer  = new ImageContainer();
//          CommandButton btnStart=new StartButton();
//           
//          addObject(imageContainer, 400, 525);
//          addObject(btnStart,749,137);
        
    }

    public JigsawWorld()
    {    
        super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.25, false);
       
        init();
       
        final int width = getWidth();
        final int height = getHeight();
        
        

        //addObject(new Brush(width, height), width/2, height/2);
        //addObject(new Instructions(), width/2, height/2);
        addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        //addObject(new MoveMe(600,100), 300, 100);
        //addObject(new MoveMe(500,100), 400, 200)0
        addObject(new Background(), 400, 190);
        
          ImageContainer imageContainer  = new ImageContainer();
        CommandButton btnStart=new StartButton();
         
        addObject(imageContainer, 400, 525);
         addObject(new Thumbnail(), width - THUMBNAIL_WIDTH/2, height - THUMBNAIL_HEIGHT/2);
        addObject(btnStart,577,190);
        addObject(new UserHand(), 450, 150);
        
        //addObject(new List<MoveMe>(new MoveMe(500,100),new MoveMe(500,200)));

        //Label instr = new Label("Raise both hand to select or Drag image.(Mouse click/dra = raise left hand)", 20);
        //addObject(instr, instr.getImage().getWidth() / 2, getBackground().getHeight() - (instr.getImage().getHeight() / 2));
        
        // Class [] classes = {UserHand.class, MoveMe.class};
        // setPaintOrder(classes);
        
         Class [] classes = {Joint.class};
        setPaintOrder(classes);
    }
    
    public void act()
    {
        super.act();
        if (!isConnected())
            return;
        
        UserData[] us = getTrackedUsers();
        getBackground().setColor(java.awt.Color.WHITE);
        getBackground().fill();
        
        boolean anyLeftHandUp = false;
        
        for (UserData u: us)
        {
            //Draws their stick figure:
            //u.drawStickFigure(getBackground(), 60);
            
            anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }
        
        // This is extra code used to warn the user if any of them is keeping their
        // left hand in the air, which effectively prevents any painting because
        // the brush will be cleared every frame:        
        if (anyLeftHandUp)
        {
            if (leftHandUp == -1)
            {
                leftHandUp = System.currentTimeMillis();
            }
            else
            {
                if (System.currentTimeMillis() - leftHandUp > 5000 && leftHandWarning == null)
                {
                    //leftHandWarning = new Label("Put your left hand down to stop clearing the screen.", 40);
                    //addObject(leftHandWarning, getWidth() / 2, getHeight() / 2);
                }
            }
        }
        else
        {
            leftHandUp = -1;
            if (leftHandWarning != null)
            {
                removeObject(leftHandWarning);
                leftHandWarning = null;
            }
        }
        
    }
}
