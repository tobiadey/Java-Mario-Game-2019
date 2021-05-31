package game;

        import city.cs.engine.*;

/**
 * A Dragon character.
 */
public class Dragon extends Walker {
    private static final Shape DragonShape = new PolygonShape(
            -1.74f,0.34f, 1.5f,0.26f, 1.4f,-0.9f, -1.77f,-0.9f);
    private static final BodyImage image =
            new BodyImage("data/flyingDragon.gif", 5.25f);
    /**
     * Construct a Dragon.
     * @param world the world in which this body exists.
     */
    public Dragon (World world) {
        super(world, DragonShape);
        addImage(image);
    }




}