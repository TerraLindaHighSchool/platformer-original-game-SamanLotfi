import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    
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
        addObject(Gem,1145,50);
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
        brickWall2.setLocation(1120,290);
        brickWall2.setLocation(748,264);
        smBrickWall4.setLocation(411,415);
        smBrickWall.setLocation(215,228);
        smBrickWall4.setLocation(395,430);
        smBrickWall2.setLocation(196,572);
        brickWall.setLocation(806,660);
        brickWall.setLocation(1049,683);
        smBrickWall2.setLocation(1074,521);
        brickWall.setLocation(449,699);
        Cookie cookie = new Cookie();
        addObject(cookie,75,189);
        Bomb bomb2 = new Bomb(0.0667f);
        addObject(bomb2,210,188);
        Bomb bomb3 = new Bomb(0.0067f);
        addObject(bomb3,830,211);
        Cookie cookie2 = new Cookie();
        addObject(cookie2,1052,213);
        Bomb bomb4 = new Bomb(0.0667f);
        addObject(bomb4,643,648);
        removeObject(brickWall2);
        BrickWall brickWall3 = new BrickWall();
        addObject(brickWall3,845,257);
        removeObject(brickWall);
        BrickWall brickWall4 = new BrickWall();
        addObject(brickWall4,767,697);
        removeObject(smBrickWall);
        SmBrickWall smBrickWall5 = new SmBrickWall();
        addObject(smBrickWall5,150,236);
        removeObject(smBrickWall4);
        removeObject(smBrickWall2);
        VerySmBrickWall verySmBrickWall = new VerySmBrickWall();
        addObject(verySmBrickWall,433,423);
        VerySmBrickWall verySmBrickWall2 = new VerySmBrickWall();
        addObject(verySmBrickWall2,1025,553);
        VerySmBrickWall verySmBrickWall3 = new VerySmBrickWall();
        addObject(verySmBrickWall3,742,451);
        removeObject(bomb4);
        bomb4.setLocation(636,655);
    }
}
