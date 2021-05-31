package game;

import city.cs.engine.*;
/**
 * A Platform body.
 */

public class platform extends Walker {
    private static final Shape platformShape = new PolygonShape(
            -1.318f,0.421f, 1.312f,0.415f, 1.312f,-0.419f,
            -1.306f,-0.419f);
    private static final BodyImage image =
            new BodyImage("data/platform1.png", 1.75f);
    /**
     * Construct a Platform.
     * @param world the world in which this body exists.
     */
    public platform (World world) {
        super(world, platformShape);
        addImage(image);
    }




}