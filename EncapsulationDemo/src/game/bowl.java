package game;

import city.cs.engine.*;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * A ball.
 */
public class bowl extends DynamicBody {
    //private  mario character;
    private static final float radius = 0.5f;
    private static final Shape ballShape = new CircleShape(radius);
    private static final BodyImage ballImage =
            new BodyImage("data/bowl.png", 2*radius);

    /**
     * Construct a bowling ball.
     * @param world the world in which this body exists.
     */



    public bowl(World world) {

        super(world, ballShape);
        addImage(ballImage);

    }
}
