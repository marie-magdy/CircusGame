/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import static Objects.ObjectType.BALL;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import javax.imageio.ImageIO;

/**
 *
 * @author Sama
 */
public class Ball extends Shape {

    private Color color;
    private ObjectType objectType;

    public Ball(int x, int y, String imagePath) {
        super(x, y, imagePath);
        this.color = setColor(imagePath);

    }
    public Ball(int x, int y, ObjectType objectType,String imagePath) {
        this(x,y,imagePath);
        this.objectType = objectType;
    }

    
    @Override
    public void loadImage() {
        try {
            String imagePath = super.getImagePath();
            BufferedImage originalImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));

            int newWidth = getWidth( imagePath);
            int newHeight = getHeight(imagePath);

            // Resize the image
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            spriteImages[0] = resizedImage;
        } catch (IOException e) {

        }
    }

    private int getWidth(String imagePath) {
             switch (imagePath) {
            case "ball0.png":
                return 30;
            case "ball1.png":
                return 36;
            case "ball2.png":
                return 31;
            case "ball3.png":
                return 36;
            default:
                return 0;
        }
    }

    private int getHeight(String imagePath) {
             switch (imagePath) {
            case "ball0.png":
                return 30;
            case "ball1.png":
                return 36;
            case "ball2.png":
                return 31;
            case "ball3.png":
                return 36;
            default:
               return 0;
        }
    }

    private Color setColor(String imagePath) {

        switch (imagePath) {
            case "ball0.png":
                return Color.RED;
            case "ball1.png":
                return Color.BLUE;
            case "ball2.png":
                return Color.GREEN;
            case "ball3.png":
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    public Color getColor() {
        return this.color;
    }
    
    public ObjectType getType(){
        return BALL;
    }
}
