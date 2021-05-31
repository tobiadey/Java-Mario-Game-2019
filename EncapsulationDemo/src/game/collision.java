package game;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * collision listener for character
 */
public class collision implements CollisionListener {
    private  mario character;
    //private bowl ball;
    Game game;
    /**
     * Initialize the collision.
     * @param character which is mario
     */

    public collision(mario character){
        this.character = character;
    }


    /**
     * Called when the collision happens.
     * @param e description of the collision
     */
    @Override
    public void collide(CollisionEvent e) {


       // System.out.println(e.getOtherBody());
       // System.out.println(e.getReportingBody());

        if(e.getOtherBody() instanceof  mario && e.getReportingBody() instanceof bowl){

            e.getReportingBody().destroy();
            character.decrementLivesCount();
            if(character.getLivesCount()==4 || character.getLivesCount()==2 || character.getLivesCount()==0){
                e.getOtherBody().destroy();
              //  character.resetLives();
               // character.setLivesCount();
               // game.goToNextLevel();
               //System.out.println("Level Completed");

                //go to next level
            }
        }
    }
}
