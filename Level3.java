import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level3()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.

        super(1200, 800, 1, false); 
        
        prepare();
    }
    
    public void act()
    {
        spawn();
    }
    
    public void spawn()
    {
        if(Math.random() < 0.005)
        {
            addObject(new AcidRain(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);

        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level3.class, MUSIC);
        addObject(player,55,692);
        
        Gem Gem = new Gem();
        addObject(Gem,1150,70);
        addObject(new Bomb(GRAVITY), 650, 560);
        
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,150,500);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,1000,450);
        SmBrickWall smBrickWall3 = new SmBrickWall();
        addObject(smBrickWall3,1130,105);
        SmBrickWall smBrickWall4 = new SmBrickWall();
        addObject(smBrickWall4,500,400);
        
        BrickWall brickWall = new BrickWall();
        addObject(brickWall,700,700);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,1250,280);
        
        Floor floor = new Floor();
        addObject(floor,800,779);
        Floor floor2 = new Floor();
        addObject(floor2,896,649);
        floor2.setLocation(916,649);
        removeObject(floor2);

        addObject(floor2,596,729);
        player.setLocation(53,668);
        removeObject(floor2);
        player.setLocation(53,708);
        floor.setLocation(639,791);
        player.setLocation(56,743);
        floor.setLocation(759,743);
        player.setLocation(68,661);
        floor.setLocation(102,729);
        removeObject(floor);

        addObject(floor,600,800);
        player.setLocation(49,750);
    }
    
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
}
