
package game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Saves values in a text file
 */
public class GameSaver {
    private String fileName;
    /**
     * Initialise a new GameSaver
     * @param fileName the name of the file
     */
    public GameSaver(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Initialise a savegame
     * @param gameWorld to access Gamelevel
     * @param game to access Game
     * @throws IOException if game cannot be saved
     */

    public void saveGame(GameLevel gameWorld,Game game) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, false);
            writer.write(game.getLevelNumber()+","
                    +gameWorld.getCoin().getCoinCount()+","
                    +gameWorld.getCharacter().getLivesCount()
            );
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
