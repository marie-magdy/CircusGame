/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author Sama
 */
public class hardLevel implements Strategy{
    public int getPlatesDelay() {
        return 2700;
    }
      public int getBallsDelay() {
        return 2700;
    }

    public int getBombsDelay() {
        return 800;
    }

    public int getSpeed() {
        return 1;
    }
}
