/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author Sama
 */
public class mediumLevel implements Strategy{
    public int getPlatesDelay() {
        return 2500;
    }
      public int getBallsDelay() {
        return 2500;
    }

    public int getBombsDelay() {
        return 2000;
    }

    public int getSpeed() {
        return 7;
    }
}
