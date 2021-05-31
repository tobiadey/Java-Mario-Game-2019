package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Creates a level2
 */
public class Level2 extends GameLevel {

    /** Initialise a new Level2
     * @param g to get access to Game
     */
public Level2(Game g){
    super(g);
    //SET PLATFORMS
    populate(g);
    setPlatform();
    setBoo();
    setmovingPlatform();
    setCoins();
   // setDoor(g);
}
    /**
     * Called to initialize platforms in level
     */
    public void setPlatform(){
        // make a platforms (with images)

        //top left
        Shape platformShape = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-9, 4.5f));
        platform1.addImage(new BodyImage("data/platform.png", 1.25f));

        // top right
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(12, 5.5f));
        platform3.setAngleDegrees(15);
        platform3.addImage(new BodyImage("data/platform.png", 1.25f));

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
        token1.setPosition(new Vec2(-9,5.5f));
        token1.setGravityScale(0);


        //middle coin
        coin token2= new coin(this);
        token2.setPosition(new Vec2(0,3.5f));
        token2.setGravityScale(0);
    }
    /**
     * Called to initialize moving platforms in level
     */
    public void setmovingPlatform() {
        // moving platforms
        for (int i = 0; i < 1000; i = i + 8) {
            platform rect = new platform(this);
            rect.setPosition(new Vec2(i, -5.5f));
            rect.startWalking(-16);
            rect.setGravityScale(0);
            rect.setAngularVelocity(6.5f);
        }
    }
    /**
     * Called to initialize boo character in level
     */
    public void setBoo(){
        //moving boo in a for loop
        for (int i = 0; i<100; i=i+10) {

            boo ball= new boo(this);
            ball.setPosition(new Vec2(i+10,-0.3f));
            ball.startWalking(-4);
            ball.setGravityScale(0);

            boo ball1 = new boo(this);
            ball1.setPosition(new Vec2(i, -10.5f));
            ball1.startWalking(-1);
            ball1.setGravityScale(0);
        }
    }


    /**
     * Called to see if criteria is met to go to next level
     * @return boolean
     */
    @Override
    public boolean isComplete() {
       // System.out.println("complete"+isComplete());
        if (this.getCharacter().getLivesCount() == 2&& this.getCoin().getCoinCount()>2 )
            return true;
        else return false;

    }

    /**
     * Called to get level number
     * @return 2
     */
    @Override
    public int getLevelNumber() {
        return 2;
    }
}

