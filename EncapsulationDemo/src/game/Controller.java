package game;

import city.cs.engine.World;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


/**
 * key handler to control walker
 */
public class Controller extends KeyAdapter {
    private Game game;
    private MyView v;
    private mario character;
    private coin c;
    private int score;
    private GameLevel currentLevel;



    public Controller(GameLevel level,Game game,mario character) {
        this.game=game;
        this.character= character;
//    this.c=c;
//    score= v.getScore();
        currentLevel = level;

    }



    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
            System.out.println("keyPressed");
        }
        else if(code== KeyEvent.VK_S){ // S= save
            GameSaver sw= new GameSaver("data/scores.txt");
            try {
                sw.saveGame(currentLevel,game);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if(code== KeyEvent.VK_R){ // R=read
            GameLoader sr= new GameLoader("data/scores.txt");
            try {
                GameLevel loadedGame= sr.LoadGame();
                game.goToLevel(loadedGame);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            }
        else if(code== KeyEvent.VK_1){
            game.increaseVolume();
            System.out.println("vol up");
        }
        else if(code== KeyEvent.VK_2){
            game.regularVolume();
            System.out.println("vol normal");
        }
        else if(code== KeyEvent.VK_3){
            game.decreaseVolume();
            System.out.println("vol down");
        }

    }

}