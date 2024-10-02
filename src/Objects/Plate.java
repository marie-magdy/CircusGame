/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import static Objects.ObjectType.PLATE;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 *
 * @author DELL
 */
public class Plate extends Shape {

    private Color color;
    private ObjectType objectType; 

    public Plate(int x, int y, String imagePath) {
        super(x, y, imagePath);
        this.color = setColor(imagePath);
    }

    public Plate(int x, int y,ObjectType objectType, String imagePath) {
        this(x, y, imagePath);
        this.objectType = objectType;
    }
    
    @Override
    public void loadImage() {
        try {
            String imagePath = super.getImagePath();
            BufferedImage originalImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));

            int newWidth = 50;
            int newHeight = 12;

            // Resize the image
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            spriteImages[0] = resizedImage;
        } catch (IOException e) {

        }
    }

    private Color setColor(String imagePath) {

        switch (imagePath) {
            case "Plate1.png":
                return Color.RED;
            case "Plate2.png":
                return Color.BLUE;
            case "Plate3.png":
                return Color.GREEN;
            case "Plate0.png":
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }

    public Color getColor() {
        return this.color;
    }
    
    public ObjectType getType(){
        return objectType;
    }
    
    public void setType(ObjectType objectType){
        this.objectType = objectType;
    }
}