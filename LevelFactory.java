import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelFactory extends Actor
{
  public  static  World tempWorld;
  
    public void act()
    {
        
    }
    
    public static Level selectLevel(LevelTypeEnum level, World world) {
        
        Level levelSelect = null;
        tempWorld = world;
        
        switch (level) {
            
        case EASY:
            levelSelect = new SelectEasyLevel(tempWorld);
            break;

        case HARD:
            levelSelect = new SelectHardLevel(tempWorld);
            break;

        default:
            // throw some exception
          //  break;
        }
        return levelSelect;
    }
}
