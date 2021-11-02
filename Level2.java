import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    
    public Level2()
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

        Player player = new Player(3, 5.6f, GRAVITY, 3, 3, Level3.class, MUSIC);
        addObject(player,55,692);
        Door door = new Door();
        addObject(door,1150,59);

        SmBrickWall smbrickWall = new SmBrickWall();
        addObject(smbrickWall,318,606);
        SmBrickWall smbrickWall2 = new SmBrickWall();
        addObject(smbrickWall2,1050,122);
        SmBrickWall smbrickWall3 = new SmBrickWall();
        addObject(smbrickWall3,150,400);
        SmBrickWall smbrickWall4 = new SmBrickWall();
        addObject(smbrickWall4,700,250);
        Bomb bomb = new Bomb(GRAVITY);
        addObject(bomb,700,220);
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
        bomb.setLocation(696,193);
        VerySmBrickWall verySmBrickWall = new VerySmBrickWall();
        addObject(verySmBrickWall,491,172);
        VerySmBrickWall verySmBrickWall2 = new VerySmBrickWall();
        addObject(verySmBrickWall2,331,136);
        VerySmBrickWall verySmBrickWall3 = new VerySmBrickWall();
        addObject(verySmBrickWall3,171,100);
        VerySmBrickWall verySmBrickWall4 = new VerySmBrickWall();
        addObject(verySmBrickWall4,680,514);
        VerySmBrickWall verySmBrickWall5 = new VerySmBrickWall();
        addObject(verySmBrickWall5,1024,392);
        Bomb bomb2 = new Bomb(0.0667f);
        addObject(bomb2,680,464);
        door.setLocation(1140,68);
        Cookie cookie = new Cookie();
        addObject(cookie,106,358);
    }
}
