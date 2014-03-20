/**
 * Write a description of class ConcreteDecoratorTimer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteDecoratorTimer  extends Decorator
{
    private String canvasMsg;
 
    public ConcreteDecoratorTimer( Component c)
    {
        super( c ) ;
    }

    public String successMessage()
    {
        canvasMsg = super.successMessage() ;
        return addedBehavior( canvasMsg ) ;
    }

	private String addedBehavior(String msg) {
	    
	    //System.out.println("Timer :: " + Timer.usedTime);
		return canvasMsg + " " +Timer.usedTime ;
	}
    
    
    
}
