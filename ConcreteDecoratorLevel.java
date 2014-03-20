/**
 * Write a description of class ConcreteDecoratorLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteDecoratorLevel  extends Decorator
{
    private String canvasMsg;
 
    public ConcreteDecoratorLevel( Component c)
    {
        super( c ) ;
    }

    public String successMessage()
    {
        canvasMsg = super.successMessage() ;
        return addedBehavior( canvasMsg ) ;
    }

    private String addedBehavior(String msg) 
    {
        
        if(ModeScreen.modeFlag)
        {
            String modeSelected = "Hard";
            return  canvasMsg + " " + modeSelected + " level in time";
        }
        else
        {
            String modeSelected = "Easy";
            return  canvasMsg + " " + modeSelected + " level in time";
        }
         
    }
   
}
