package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Creates a gamelevel
 */
public abstract class GameLevel extends World {
    mario character;
    coin token;
   // Door door;

    /** Initialise a new GameLevel
     * @param g gives access to Game for levels
     */
     public GameLevel (Game g){

//         setCharacter(g);
//         setBasket();
    }

    /**
     * Called to create basket holding character
     */
    private void setBasket() {
        // ground of the basket like shape
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -20f));

        // walls of the basket like shape
        Shape wallShape = new BoxShape(0.05f, 3f);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-1, -20));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(1, -20));
    }

    /**
     * Called to return mario
     * @return character
     */
    public mario getCharacter(){
        return this.character;
    }


    /**
     * Called to set mario
     * @param m describes the character
     *
     */
    public void setCharacter(mario m){
         this.character = m;
    }


    /**
     * Called to return coin
     * @return token
     */
    public coin getCoin(){
        return this.token;
    }


    /**
     * Called to set coin
     * @param c describes the coin
     *
     */
   public void setCoin (coin c){this.token = c;}


    /**
     * Called to create mario character
     * @param g describes the character
     * @return new character
     */
    private void setCharacter(Game g) {
        //  make mario
        character = new mario(this);
        character.setPosition(new Vec2(-0, -19));
    }

    /**
     * Called to populate
     * @param game describes the level
     *
     */
    public void populate(Game game){
        setCharacter(game);
        setBasket();
    }


    /**
     * Called to see if level is complete
     * @return false
     */
    public boolean isComplete(){
        return false;
    }


    /**
     * Called to get level number
     * @return LevelNumber;
     */
    public abstract int getLevelNumber();
}


