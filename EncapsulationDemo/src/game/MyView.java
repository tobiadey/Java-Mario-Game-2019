package game;

import city.cs.engine.UserView;
import city.cs.engine.World;
import city.cs.engine.WorldView;

import javax.swing.*;
import java.awt.*;
/**
 * Creates a MyView
 */
public class MyView extends UserView {


    Image background1,background2,background3;
    private Game game;

    private int LevelNumber;

    private boolean level;


   private mario character;
   private coin c;
   private int score;


    /**
     * Initialize MyView.
     * @param w  gets access to World
     * @param game gets access to Game
     * @param c gets access to coin
     * @param character gets access to Mario
     * @param height use a parameter for super
     * @param width use a parameter for super
     */
    public MyView(World w, int width, int height,Game game, mario character,coin c) {
        super(w, width, height);
        this.game=game;
        background1 = new ImageIcon("data/game-background1.jpg").getImage();
        background2 = new ImageIcon("data/game-background2.jpg").getImage();
        background3 = new ImageIcon("data/game-background3.jpg").getImage();
        this.LevelNumber=game.getLevelNumber();
        this.character= character;
        this.c=c;
        score=0;
    }

    /**
     * Called to initialize paint background
     * @param g
     */
   @Override
     protected void paintBackground(Graphics2D g){
        super.paintBackground(g);

       if (this.LevelNumber==1 ) {

          // System.out.println("level 1 background");

           g.drawImage(background1 ,0,0,null);
           g.drawString("Mario's Lives:"+ character.getLivesCount(),5,15);
           g.drawString("Score: " +score++,5,30);
           g.drawString("Coins Collected:"+ c.getCoinCount(),370,15);

       }

        else if (this.LevelNumber==2 ) {

              // System.out.println("level 2 background");

               g.drawImage(background2 ,0,0,null);
           g.drawString("Mario's Lives:"+ character.getLivesCount(),5,15);
           g.drawString("Score: " +score++,5,30);
           g.drawString("Coins Collected:"+ c.getCoinCount(),370,15);

        }


       else if (this.LevelNumber==3 ) {
           //System.out.println("level 3 background");

            g.drawImage(background3 ,0,0,null);

           g.drawString("Mario's Lives:"+ character.getLivesCount(),5,15);
           g.drawString("Score: " +score++,5,30);
           g.drawString("Coins Collected:"+ c.getCoinCount(),370,15);
       }
}

    /**
     * Called to initialize platforms in level
     * @param g
     */
    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);
    }

    /**
     * Called to increment LevelNumber
     */
    public void addLevel(){
        LevelNumber++;
    }


    /**
     * Called to decrement LevelNumber
     */
    public void BackLevel(){
        LevelNumber--;
    }

}



