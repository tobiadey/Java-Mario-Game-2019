package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Creates a Level1
 */
public class Level1 extends GameLevel {

    /** Initialise a new Level1
     * @param g to get access to Game
     */
    public Level1(Game g){
        super(g);
        populate(g);
        setPlatform();
        setCoins();
        setmovingPlatforms();
    }

    /**
     * Called to initialize movingPlatforms in level
     */
    public void setmovingPlatforms(){
        for (int i = 0; i < 1000; i = i + 8) {
            platform rect = new platform(this);
            rect.setPosition(new Vec2(i, -5.5f));
            rect.startWalking(-16);
            rect.setGravityScale(0);

        }
    }

    /**
     * Called to initialize static platforms in level
     */
    public void setPlatform(){
        // make a platforms (with images)

        //top left
        Shape platformShape = new BoxShape(3, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-9, 1.5f));
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
        token1.setPosition(new Vec2(-9,1.5f));
        token1.setGravityScale(0);

        //middle coin
        coin token2= new coin(this);
        token2.setPosition(new Vec2(0,3.5f));
        token2.setGravityScale(0);
    }


    /**
     * Called to see if criteria is met to go to next level
     * @return boolean
     */
    @Override
    public boolean isComplete() {
     //   System.out.println(this.getCharacter().getLivesCount());
        if (this.getCharacter().getLivesCount() ==4 && this.getCoin().getCoinCount()>0)
            return true;
        else return false;

    }

    /**
     * Called to get level number
     * @return 1
     */
    @Override
    public int getLevelNumber() {
        return 1;
    }
}

