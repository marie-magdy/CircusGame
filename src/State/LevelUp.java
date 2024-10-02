/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import static Strategy.StrategyType.*;
import World.Game;


public class LevelUp extends State{

    public LevelUp(Game game) {
        super(game);
    }

    @Override
    public void CheckScore() {

        if (game.getLevel().equals(EASY) && game.getScore() >= 3) {
            game.setLevel(MEDIUM);
            System.out.println("Level Up to Medium");
            
        } else if (game.getLevel().equals(MEDIUM) && game.getScore() >= 5) {
            game.setLevel(HARD);
            System.out.println("Level up to Hard");
            
        }

    }
    
}
