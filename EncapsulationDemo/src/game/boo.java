package game;

import city.cs.engine.*;
/**
 * A boo chaacter.
 */

public class boo extends Walker {
    private static final Shape booShape = new PolygonShape(
            -0.489f,-0.435f, 0.489f,-0.43f, 0.438f,0.434f, -0.518f,0.437f);
    private static final BodyImage image =
            new BodyImage("data/boo.png", 2.25f);
    /**
     * Construct a boo character.
     * @param world the world in which this body exists.
     */
    public boo (World world) {
        super(world, booShape);
        addImage(image);
    }




}