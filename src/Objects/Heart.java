/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import static Objects.ObjectType.CLOWN;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Sama
 */
public class Heart extends ImageObject {

    private ObjectType objectType;

    public Heart(int x, int y, String imagePath) {
        super(x, y, imagePath);
        loadImage();
    }

    public Heart(int x, int y, ObjectType objectType, String imagePath) {
        this(x, y, imagePath);
        this.objectType = objectType;
    }

    @Override
    public void setY(int y) {

    }

    @Override
    public void loadImage() {
        try {
            String imagePath = super.getImagePath();
            BufferedImage originalImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));

            // Specify the desired width and height
            int newWidth = 50; // Change this value to your desired width
            int newHeight = 50; // Change this value to your desired height

            // Resize the image
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
            resizedImage.getGraphics().drawImage(originalImage, 0, 0, newWidth, newHeight, null);

            spriteImages[0] = resizedImage;
        } catch (IOException e) {

        }
    }

    public ObjectType getType() {
        return CLOWN;
    }

    @Override
    public void setType(ObjectType type) {
        super.setType(type);
    }
}
