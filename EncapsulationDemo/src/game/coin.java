package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * A coin.
 */
public class coin extends Walker {
    private static final Shape coinShape = new PolygonShape(
            -0.489f,-0.435f, 0.489f,-0.43f, 0.438f,0.434f, -0.518f,0.437f);
    private static final BodyImage image =
            new BodyImage("data/coin.png", 1.25f);
    private static SoundClip coinSound;


    static {
        try {
            coinSound = new SoundClip("data/coin.wav");
            System.out.println("Loading orange sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    private int coinCount=0;

    /**
     * Construct a coin.
     * @param world the world in which this body exists.
     */
    public coin (World world) {
        super(world, coinShape);
        addImage(image);
    }

    /**
     * Getter for coinCount
     * @return coinCount
     */
    public int getCoinCount(){
        return coinCount;
    }


    /**
     * increment for coinCount.
     */
    public void incrementCoinCount(){
        coinCount++;
        coinSound.play();
        System.out.println("Coins Collected: "+ coinCount);
    }

}



