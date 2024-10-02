/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import Strategy.Strategy;
import World.CurtainsClosed;
import World.Game;
import javax.swing.JOptionPane;

public class Lost extends State {

    public Lost(Game game) {
        super(game);
    }

    @Override
    public void CheckScore() {

        int choice = JOptionPane.showConfirmDialog(null, "Game Ended, You Lost !!\nDo you want to play again?", "You Lost!", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            game.getGameLauncher().closeGameWindow();

            CurtainsClosed curtainsClosed = new CurtainsClosed();
            curtainsClosed.setVisible(true);
            game.setShouldStop(true);
        } else {
            System.exit(0);
        }

    }

}
