/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author Sama
 */
public class easyLevel implements Strategy {

    public int getPlatesDelay() {
        return 1900;
    }
    public int getBallsDelay() {
        return 1900;
    }

    public int getBombsDelay() {
        return 5000;
    }

    public int getSpeed() {
        return 17;
    }
}
