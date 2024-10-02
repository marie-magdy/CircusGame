/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import static Objects.ObjectType.BOMB;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Sama
 */
public class Bomb extends ImageObject{
    
    private ObjectType objectType;
    
    public Bomb(int x, int y, String imagePath) {
        super(x, y, imagePath);
    }

    public Bomb(int x, int y, ObjectType type, String imageName) {
        this(x, y, imageName);
        this.objectType = objectType;
    }
    
    
       public void loadImage() {
        try {
           String imagePath=super.getImagePath();
            BufferedImage originalImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));

            // Specify the desired width and height
            int newWidth = 80; // Change this value to your desired width
            int newHeight = 80; // Change this value to your desired height

            // Resize the image
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            spriteImages[0] = resizedImage;
        } catch (IOException e) {
         
        }
    }
       public ObjectType getType(){
        return BOMB;
    }
    
}
