/**
 * Write a description of class Decorator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Decorator  implements Component
{
    private Component component;
    
    public Decorator(Component c)
    {
        component = c;
    }
    
    public String successMessage(){
    
        return component.successMessage();
    }
    
}
