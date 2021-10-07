import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private final GreenfootImage[] WALK_ANIMATION;
    private Health[] health;
    private Powerup[] powerup;
    private int healthCount;
    private int speed;
    private int walkIndex;
    private int frame;
    private float yVelocity;
    private boolean isWalking;
    private boolean isJumping;
    private boolean isFacingLeft;
    private final GreenfootImage STANDING_IMAGE;
    private final float JUMP_FORCE;
    private final float GRAVITY;
    private final Class NEXT_LEVEL;
    private final GreenfootSound MUSIC;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
    
       
        animator();
        fall();
        onCollision();
    

    }
    public Player(int speed, float jumpForce, float gravity, int maxHealth, int maxPowerup, Class nextLevel, GreenfootSound music)
    {
        WALK_ANIMATION = new GreenfootImage[]
        { new GreenfootImage("walk0.png"),
            new GreenfootImage("walk1.png"),
            new GreenfootImage("walk2.png"),
            new GreenfootImage("walk3.png"),
            new GreenfootImage("walk4.png"),
            new GreenfootImage("walk5.png"),
        };
        STANDING_IMAGE = new GreenfootImage("standing.png");
        JUMP_FORCE = jumpForce;
        GRAVITY = gravity;
        NEXT_LEVEL = nextLevel;
        MUSIC = music;
        this.speed = speed;

    }
    private void animator()
    {
        if(frame % (15 - 2 * speed) == 0)
        {
            if(walkIndex < WALK_ANIMATION.length)
            {
                setImage(WALK_ANIMATION[walkIndex]);
                walkIndex++;
            }
            else
            {
                walkIndex = 0;
            }
        }
        frame++;
    }
    
    private void jump()
    { 
        if(Greenfoot.isKeyDown("space") && isOnGround())
        {
            yVelocity = JUMP_FORCE;
            isJumping = true;
        }
        
        if(isJumping && yVelocity > 0.0)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
        else
        {
            isJumping = false;
        }
    }
    
    private void fall()
    {
        if(!isOnGround() && !isJumping)
        {
            setLocation(getX(), getY() - (int) yVelocity);
            yVelocity -= GRAVITY;
        }
    }

    private void mirrorImages()
    {
        for(int i = 0; i < WALK_ANIMATION.length; i++)
        {
              WALK_ANIMATION[i].mirrorHorizontally();
              
        }
    }
    private boolean isOnGround()
    {
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight() / 2, 
                       Platform.class);
        return ground != null;
    }
     
    private void onCollision( )
    {
        if(isTouching(Door.class))
        {
            World world = null;
            try 
            {
                world = (World) NEXT_LEVEL.newInstance();
            }   
            catch (InstantiationException e) 
            {
                System.out.println("Class cannot be instantiated");
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access class constructor");
            } 
            Greenfoot.setWorld(world);
        }
        
        if(isTouching(Obstacle.class))
        {
            removeTouching(Obstacle.class);
        }
        
        if(isTouching(Platform.class) && !isOnGround())
        {
            yVelocity = -1;
            fall();
        }
    }
    
    private void checkKeyPress()
    {
        if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX() +4,getY());
        }
    
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX() -4,getY());
        }
    }
        private void walk()
    {
        if(isWalking)
        {
            animator();
        }
        else
        {
            setImage(STANDING_IMAGE);
            walkIndex = 0;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            if(isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = false;
            isWalking = true;
            
            
            move(speed);
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            if(!isFacingLeft)
            {
                mirrorImages();
            }
            isFacingLeft = true;
            isWalking = true;
            move(-speed);
        }
        
        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("right")))
        {
            isWalking = false;
        }
    } 
}   
