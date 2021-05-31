

package game;

import city.cs.engine.World;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Loads saved values
 */
public class GameLoader {
    private String fileName;
    private Game game;
    private mario character;
    /**
     * Initialise a new HighScoreReader
     * @param fileName the name of the high-score file
     */
    public GameLoader(String fileName) {
        this.fileName = fileName;
        //   game=  g;
        // this.character= character;
    }


    /**
     * Read the high-score data from the file and print it to
     * the terminal window.
     * @return level
     * @throws IOException if game cannont be loaded
     */
    public GameLevel LoadGame() throws IOException {
        //this.character= character;
        FileReader fr = null;
        BufferedReader reader = null;
        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();


            String[] tokens = line.split(",");


            int levelNumber = Integer.parseInt(tokens[0]);
            int coinCount = Integer.parseInt(tokens[1]);
            int livesCount = Integer.parseInt(tokens[2]);

            //boolean t=true;

            GameLevel level = null;
            if (levelNumber == 1) {
                level = new Level1(game);
                level.populate(game);
                // character.isLoading()==t;
                //level.setCharacter(level.getCharacter());
                //level.getCharacter().setLivesCount(livesCount);
                //coins= level.getCoin().setCoinCount(coinCount);

            } else if (levelNumber == 2) {
                level = new Level2(game);
                level.populate(game);
                //  level.setCharacter(game);
                //level.getCharacter().setLivesCount(livesCount);
                //  level.getCoin().setCoinCount(coinCount);
            }
            else if (levelNumber == 3) {
                level = new Level3(game);
                level.populate(game);
                //  character=new mario(level);
                //   character.setLivesCount(livesCount);
                //System.out.println("level"+ character.getLivesCount());
                //  character = new mario(game);
                //character = new mario(level);
                //character.setLivesCount();
//               System.out.println("character object"+ character.getLivesCount());

            }
            return level;


        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }

    }


}
