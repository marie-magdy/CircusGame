/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author Sama
 */
import Objects.ImageObject;
import Objects.*;

public class ObjectsFactory {

    public ImageObject createObject(int x, int y, String imagePath) {
        switch (imagePath) {
            case "clown.png":
                return new ClownObject(x, y, imagePath);
            case "ball0.png":
            case "ball1.png":
            case "ball2.png":
            case "ball3.png":
                return new Ball(x, y, imagePath);
            case "bomb.png":
                return new Bomb(x, y, imagePath);
            case "heart.png":
                    return new Heart(x, y, imagePath);
            default:
                return new Plate(x, y, imagePath);
        }
    }
}
