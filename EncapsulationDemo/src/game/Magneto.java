package game;

import city.cs.engine.*;

/**
 * A Magneto chaacter.
 */
public class Magneto extends DynamicBody {
    private static final Shape magnetoShape = new PolygonShape(
            -0.557f,0.481f, 0.534f,0.477f, 0.522f,-0.375f,
            -0.55f,-0.414f, -0.562f,0.458f);
    private static final BodyImage image =
            new BodyImage("data/magneto.gif", 3.25f);

    /**
     * Construct a Magneto character.
     * @param world the world in which this body exists.
     */
    public Magneto (World world) {
        super(world);
       addImage(image);
        Fixture c= new GhostlyFixture(this,magnetoShape);

    }



}
