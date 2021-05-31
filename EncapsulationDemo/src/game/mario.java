
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * A Mario chaacter.
 */
public class mario extends Walker {
    private static final Shape marioShape = new PolygonShape(
            -0.207f,0.496f, 0.191f,0.488f, 0.195f,-0.484f,
            -0.201f,-0.484f, -0.207f,0.478f);
    private static final BodyImage image =
        new BodyImage("data/mario.png", 3.25f);

   private int LivesCount;
    private static SoundClip marioSound;

    static {
        try {
            marioSound = new SoundClip("data/mario.wav");
            System.out.println("Loading orange sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Construct a Mario character.
     * @param world the world in which this body exists.
     */
    public mario (World world) {
        super(world, marioShape);
        addImage(image);
        LivesCount = 6;
    }

    /**
     * Getter for livesCount
     * @return LivesCount
     */
    //field called lives decremnet as it is hit
    public int getLivesCount(){
        return LivesCount;
    }

    /**
     * decrement for LivedCount.
     */
    public void decrementLivesCount(){
        LivesCount--;
        marioSound.play();
        System.out.println("Lives:"+ LivesCount);
    }

    public void setLivesCount(int lives) {
        LivesCount = lives;
    }
}
