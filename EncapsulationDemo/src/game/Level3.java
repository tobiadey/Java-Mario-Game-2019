package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Creates a level2
 */
public class Level3 extends GameLevel {

    /** Initialise a new Level3
     * @param g to get access to Game
     */
    public Level3(Game g) {
        super(g);
        populate(g);
        setPlatform();
        setDragon();
        setCoins();
        setMagneto();
        setBullets();
        setmovingPlatforms();
    }

    /**
     * Called to initialize moving platforms in level
     */
    public void setmovingPlatforms(){
        for (int i = 0; i < 1000; i = i + 8) {
            platform rect = new platform(this);
            rect.setPosition(new Vec2(-i, -14.5f));
            rect.startWalking(16);
            rect.setGravityScale(0);
            //  rect.applyForce(this,10);
            //rect.setAngularVelocity(6.5f);
        }}

    /**
     * Called to initialize platforms in level
     */
    public void setPlatform(){
        // make a platforms (with images)

        //right
        Shape platformShape = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(12, 5.5f));
        platform1.addImage(new BodyImage("data/platform.png", 1.25f));

        // left
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(-9, 1.5f));
        platform3.setAngleDegrees(340);
        platform3.addImage(new BodyImage("data/platform.png", 1.25f));

        //bottom left
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(-11, -9.3f));
        //platform2.setAngleDegrees(340);
        platform2.addImage(new BodyImage("data/platform.png", 1.25f));

    }

    /**
     * Called to initialize coins in level
     */
    public void setCoins(){
        //make coins

        token = new coin(this);
        token.setPosition(new Vec2(12,5.5f));
        token.setGravityScale(0);

        //left coin
        coin token1= new coin(this);
        token1.setPosition(new Vec2(0,-9.5f));
        token1.setGravityScale(0);

        //middle coin
        coin token2= new coin(this);
        token2.setPosition(new Vec2(0,3.5f));
        token2.setGravityScale(0);
    }

    /**
     * Called to initialize magneto in level
     */
    public void setMagneto(){

         Magneto magneto = new Magneto(this);
        magneto.setPosition(new Vec2(-11, -7.7f));
         magneto.setGravityScale(0);
    }

    /**
     * Called to initialize dragons in level
     */
    public void setDragon(){
        for (int i = 0; i<1000; i=i+10) {
            Dragon dragon = new Dragon(this);
            dragon.setPosition(new Vec2(10+i, -1.3f));
            dragon.startWalking(-4);
            dragon.setGravityScale(0);

        }
     }

    /**
     * Called to initialize bullets in level
     */
    public void setBullets(){
        for (int i = 0; i < 1000; i = i + 10) {
            Bullets bullets = new Bullets(this);
            bullets.setPosition(new Vec2(i+4.5f, -7.0f));
            bullets.startWalking(-10);
            bullets.setGravityScale(0);
    }
}

//private static final Shape magnetoShape = new PolygonShape(
//        -1.74f,0.34f, 1.5f,0.26f, 1.4f,-0.9f, -1.77f,-0.9f);

    /**
     * Called to see if criteria is met to go to next level
     * @return boolean
     */
    @Override
    public boolean isComplete() {
       // System.out.println(this.getCharacter().getLivesCount());
        if (this.getCharacter().getLivesCount() ==0 && this.getCoin().getCoinCount()>4)
            return true;
        else return false;

    }

    /**
     * Called to get level number
     * @return 3
     */
    @Override
    public int getLevelNumber() {
        return 3;
    }
}
