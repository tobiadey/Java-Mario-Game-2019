package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * collision listener for coin
 */
public class coinCollision implements CollisionListener {
    private coin token;

    /**
     * Initialize the collision.
     * @param token which is the coin
     *
     */

    public coinCollision(coin token){
        this.token = token;
    }

    /**
     * Called when the collision happens.
     * @param e description of the collision
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof coin && e.getReportingBody() instanceof bowl) {
            e.getOtherBody().destroy();
            token.incrementCoinCount();
        }
    }
}