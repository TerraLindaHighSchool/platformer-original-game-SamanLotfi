import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Creates a templete for all obstacles
 * 
 * @author (Saman Lotfizad) 
 * @version (Sep 23, 2021)
 */
public abstract class Obstacle extends Actor
{
    protected abstract void fall();
    
    protected boolean isOnGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2,
                                            Platform.class);
        return ground != null;
    }

    protected void removeOutOfBounds(Obstacle obstacle)
    {
        if(obstacle.getY() > getWorld().getHeight() +
                             obstacle.getImage().getHeight() / 2)
        {
            getWorld().removeObject(obstacle);
        }
    }
}
