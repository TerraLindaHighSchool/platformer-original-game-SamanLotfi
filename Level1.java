import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.

        super(1200, 800, 1, false); 
        
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);

        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level2.class, MUSIC);
        addObject(player,55,692);
        Door door = new Door();
        addObject(door,1150,59);

        BrickWall brickWall = new BrickWall();
        addObject(brickWall,565,501);
        Gem gem = new Gem();
        addObject(gem,478,192);
        BrickWall brickWall2 = new BrickWall();
        addObject(brickWall2,958,122);
        BrickWall brickWall3 = new BrickWall();
        addObject(brickWall3,329,261);
        brickWall.setLocation(318,606);
        gem.setLocation(806,76);
        BrickWall brickWall4 = new BrickWall();
        addObject(brickWall4,954,411);
        gem.setLocation(143,204);
        Floor floor = new Floor();
        addObject(floor,595,779);
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
