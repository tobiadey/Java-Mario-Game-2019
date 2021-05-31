package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.WorldView;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * A mouse listener
 */
public class MouseHandler extends MouseAdapter {

    private WorldView view;
    private mario character;
    private coin token;

    /**
     * Initialize the listener.
     * @param game gives access to current level
     * @param view gives access to WorldView
     */
    public MouseHandler(WorldView view, Level1 game) {
        this.view = view;
        this.character = game.getCharacter();
        this.token = game.getCoin();
    }

    /**
     * Called when the mouse enters a component.
     * @param e description of the mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        view.requestFocus();
        bowl bl = new bowl(view.getWorld());
        bl.setPosition(view.viewToWorld(e.getPoint()));
        bl.addCollisionListener(new collision(character));
        bl.addCollisionListener(new coinCollision(token));
    }

}