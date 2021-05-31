// Adewunmi Oluwatobi
// adbb245
// 190012965


package game;

import city.cs.engine.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A world in which the bodies move and interact
 * @author tobiadewunmi
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private Level1 level1;
    private Level2 level2;
    private Level3 level3;


    private MyView view;
    private SoundClip gameMusic1;
    private SoundClip gameMusic2;
    private SoundClip gameMusic3;
    private static SoundClip level1c;
    private static SoundClip level2c;
    private static SoundClip level3c;
    private static SoundClip gameOver;
    private static SoundClip level1Skipped;
    private static SoundClip level2Skipped;
    private static SoundClip cheat;
    private int level;
    private int LevelNumber;
    private Timer timer;


    /** Initialise a new Game */
    public Game() {

        // make the world
        //world is an object instantiating a new game class
        level1 = new Level1(this);
        level2 = new Level2(this);
        level3 = new Level3(this);

        LevelNumber=1;

        /**
         * creates view MyView
         */
        view = new MyView(level1, 500, 780,this, level1.getCharacter(),level1.getCoin());
        view.setBackground(new Color(255,255,255));

        try {
            /**
             * Variables of sounds
             */
            gameMusic1 = new SoundClip("data/music.wav");// Open an audio input stream
            gameMusic2 = new SoundClip("data/music3.wav");// Open an audio input stream
            gameMusic3 = new SoundClip("data/music.wav");// Open an audio input stream
           // gameMusic.loop();  // Set it to continous playback (looping)
            level1c= new SoundClip("data/level1.wav"); //level 1 complete
            level2c= new SoundClip("data/level2.wav"); //level 2 complete
            level3c= new SoundClip("data/level3.wav"); //level 3 complete
            gameOver= new SoundClip("data/gameOver.wav"); //game over
            level1Skipped= new SoundClip("data/level1Skipped.wav");//level 1 skipped
            level2Skipped= new SoundClip("data/level2Skipped.wav");//level 2 skipped
            cheat= new SoundClip("data/cheat.wav"); //cheat
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
        // JFrame window = new JFrame("Menu");
       // window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /**
         * control panel set to view
         */
        ControlPanel p = new ControlPanel(this);
        view.add(p.mainPanel, BorderLayout.NORTH);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        /**
         * mouselistener set to view
         */
        view.addMouseListener(new MouseHandler(view,level1));


        // display the view in a frame
        /**
         * display the view in a frame
         */
        final JFrame frame = new JFrame("Tobi's Game");

        // quit the application when the game window is closed(or else it keeps running in background)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);


        // size the game window to fit the world view
        frame.pack();
        frame.setLocationRelativeTo(null);
        // don't let the game window be resized
        frame.setResizable(false);
        // make the window visible
        frame.setVisible(true);

        frame.setBackground(Color.black);
        // start!  (is this from a thread)

        //add key listener to star game
        /**
         * keylistener set to view
         */
        view.addKeyListener(new Controller(level1,this,level1.getCharacter()));


        /**
         * Start level
         */
        level1.start();
        playBackgroundMusic();
    }

    /**
     * Called when the backgroundmusic changes.
     */
    public void playBackgroundMusic(){

        if(LevelNumber == 1){
            gameMusic1.play();
       //     LevelNumber++;
            System.out.println(LevelNumber);
        }
        else if(LevelNumber == 2){
            gameMusic1.stop();
            gameMusic2.play();
          //  LevelNumber++;
            System.out.println(LevelNumber);
        }
        else if(LevelNumber==3){
            gameMusic2.stop();
            gameMusic3.play();
          //  LevelNumber++;
            System.out.println(LevelNumber);
        }
    }

    /**
     * Called when volume needs to be increased.
     */

    public void increaseVolume(){
        if(LevelNumber == 1){
            gameMusic1.setVolume(2);
        }
        else if(LevelNumber == 2){
            gameMusic2.setVolume(2);
        }
        else if(LevelNumber==3){
            gameMusic3.setVolume(2);
        }
    }

    /**
     * Called when volume needs to be normal.
     */
    public void regularVolume(){
        if(LevelNumber == 1){
            gameMusic1.setVolume(1.5);
        }
        else if(LevelNumber == 2){
            gameMusic2.setVolume(1.5);
        }
        else if(LevelNumber==3){
            gameMusic3.setVolume(1.5);
        }

    }

    /**
     * Called when volume needs to be decreased.
     */
    public void decreaseVolume(){
        if(LevelNumber == 1){
            gameMusic1.setVolume(0.5);
        }
        else if(LevelNumber == 2){
            gameMusic2.setVolume(0.5);
        }
        else if(LevelNumber==3){
            gameMusic3.setVolume(0.5);
        }
    }

    /**
     * Called when a level is needed to be loaded from a saved state.
     * @param lev description of the current level
     */

    public void goToLevel(GameLevel lev ){  //to load the game


        level1.stop();
        level = lev.getLevelNumber();



        if(level == 1 ) {
            view.setWorld(level1);
            level1.start();
            view.addLevel();

        }
        else if(level == 2 ) {
            view.setWorld(level2);
            level2.start();
            view.addLevel();
            level1.stop();

        }
        else if(level == 3 ) {
            view.setWorld(level3);
            level3.start();
            view.addLevel();
            view.addLevel();
            lev.character.setLivesCount(2);

            //currentMario = level3.setCharacter(lev.character);
            //lev.character.
            //System.out.println("game"+ lev.character.getLivesCount());
            level1.stop();
            level2.stop();

        }



    }

    /**
     * Called to go to next level.
     */
    public void goToNextLevel(){


        if (LevelNumber== 3 && level3.isComplete()){
            gameOver.play();
            try {
                Thread.sleep(1000); // wait 1 second before exiting game
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Game Over!! Mario is dead");
            System.exit(0 );


        }
        else if(LevelNumber== 1 &&level1.isComplete()) {

            view.setWorld(level2);
            level2.setCoin(level1.getCoin());
            level2.setCharacter(level1.getCharacter());

            level2.start();
            view.addLevel();
            level1.stop();
            LevelNumber++;
            System.out.println("Level1 Completed");
            level1c.play();
            playBackgroundMusic();
        }
        else if(LevelNumber== 2 &&level2.isComplete()) {

            view.setWorld(level3);
            level3.setCoin(level2.getCoin());
            level3.setCharacter(level2.getCharacter());
            level3.start();
            view.addLevel();
            level2.stop();
            LevelNumber++;
            System.out.println("Level2 Completed");
            level2c.play();
            playBackgroundMusic();
        }
    }

    /**
     * Called to go to Previous level.
     */

    public void goToPreviousLevel(){

        if (LevelNumber== 1 ){
            System.exit(0 );
        }
        else if(LevelNumber== 2 ) {
            view.setWorld(level1);
            level1.setCoin(level1.getCoin());
            level1.setCharacter(level1.getCharacter());
            level1.start();
            view.BackLevel();
            level2.stop();
            LevelNumber--;
        }
        else if(LevelNumber== 3 ) {

            view.setWorld(level2);
            level2.setCoin(level2.getCoin());
            level2.setCharacter(level2.getCharacter());
            level2.start();
            view.BackLevel();
            level3.stop();
            LevelNumber--;
        }
    }


    /**
     * Called to get level number.
     * @return LevelNumber
     */
    public int getLevelNumber(){
     //  System.out.println("gotten lNO in main"+ LevelNumber);
        return this.LevelNumber;
    }

    /**
     * Called to resume game
     */
    public void resume(){
        level1.start();
        gameMusic1.resume();
        level2.start();
        gameMusic2.resume();
        level3.start();
        gameMusic3.resume();
    }
    /**
     * Called to pause game
     */
    public void pause(){
        level1.stop();
        gameMusic1.pause();
        level2.stop();
        gameMusic2.pause();
        level3.stop();
        gameMusic3.pause();

    }

    /**
     * Called to skip levels
     */
    public void goToNextLevelSkip(){

        if (LevelNumber== 3 ){
            cheat.play();
            System.out.println("Game Over!! Mario is dead");
            System.exit(0 );
        }
        else if(LevelNumber== 1 ) {

            view.setWorld(level2);
            level2.setCoin(level1.getCoin());
            level2.setCharacter(level1.getCharacter());
            level2.start();
            view.addLevel();
            level1.stop();
            LevelNumber++;
            System.out.println("Level1 Completed");
            level1Skipped.play();
        }
        else if(LevelNumber== 2 ) {

            view.setWorld(level3);
            level3.setCoin(level2.getCoin());
            level3.setCharacter(level2.getCharacter());
            level3.start();
            view.addLevel();
            level2.stop();
            LevelNumber++;
            System.out.println("Level2 Completed");
            level2Skipped.play();
        }
    }

    /** Run the Game.
     * @param args
     */

    public static void main(String[] args) {
        new Game();
    }
}





