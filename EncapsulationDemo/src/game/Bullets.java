package game;

import city.cs.engine.*;

/**
 * A bullet body.
 */
public class Bullets extends Walker {
    private static final Shape BulletShape = new PolygonShape(
            -1.74f,0.34f, 1.5f,0.26f, 1.4f,-0.9f, -1.77f,-0.9f);
    private static final BodyImage image =
            new BodyImage("data/Bullets.png", 2.75f);
    /**
     * Construct a bullet shape body.
     * @param world the world in which this body exists.
     */
    public Bullets (World world) {
        super(world, BulletShape);
        addImage(image);
    }




}
