 package game;

 import javax.swing.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 /**
  * Creates a ControlPanel
  */
 public class ControlPanel{
     public JPanel mainPanel;
     private JButton resumeButton;
     private JButton pauseButton;
     private JButton nextLevelButton;
     private JButton previousLevelButton;
     private JButton nextLevelSKIPButton;
     private Game game;
     private int LevelNumber;
     private boolean ispause;


     /** Initialise a new GameLevel
      * @param game give access to Game
      */
     public ControlPanel(Game game) {
         this.game=game;
         this.LevelNumber=game.getLevelNumber();
         ispause=false;




         /**
          * Called to resume game
          */
         resumeButton.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 System.out.println("Start");
                 game.resume();
             }
         });

         /**
          * Called to pause game
          */
         pauseButton.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 System.out.println("Pause");
                 game.pause();

             }
         });

         /**
          * Called to go to next level
          */
         nextLevelButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 game.goToNextLevel();

             }
         });

         /**
          * Called to go to previous level
          */
         previousLevelButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 game.goToPreviousLevel();
             }
         });


         /**
          * Called to skip level
          */
         nextLevelSKIPButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 game.goToNextLevelSkip();
             }
         });
     }

 }
