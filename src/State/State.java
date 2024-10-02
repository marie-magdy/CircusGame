/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

import Strategy.Strategy;
import World.Game;


public abstract class State {
    protected Game game;
   // protected long gameTime;

    public State(Game game) {
        this.game = game;
        //this.gameTime = gameTime;
    }
    
    public abstract void CheckScore();
}
