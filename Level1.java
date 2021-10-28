import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    
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
    
    public void act()
    {
        spawn();    
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
        addObject(new Bomb(GRAVITY), 435, 220);
        addObject(floor,600,800);
        player.setLocation(49,750);

        removeObject(brickWall3);
        removeObject(brickWall4);
        removeObject(brickWall);
        removeObject(gem);
        SmBrickWall smBrickWall = new SmBrickWall();
        addObject(smBrickWall,961,676);
        VerySmBrickWall verySmBrickWall = new VerySmBrickWall();
        addObject(verySmBrickWall,565,546);
        VerySmBrickWall verySmBrickWall2 = new VerySmBrickWall();
        addObject(verySmBrickWall2,944,391);
        SmBrickWall smBrickWall2 = new SmBrickWall();
        addObject(smBrickWall2,518,267);
        VerySmBrickWall verySmBrickWall3 = new VerySmBrickWall();
        addObject(verySmBrickWall3,120,376);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
