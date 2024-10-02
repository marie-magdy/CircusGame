/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public abstract class ImageObject implements GameObject {

    private static final int MAX_MSTATE = 1;

    BufferedImage[] spriteImages;
    private int x;
    private int y;
    private boolean visible;
    private ObjectType type;
    private String imagePath;

    public ImageObject(int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.spriteImages = new BufferedImage[1];
        this.visible = true;
        this.imagePath = imagePath;
        loadImage();
    }

    public void loadImage() {
        try {
            this.spriteImages[0] = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
        } catch (IOException ex) {
            Logger.getLogger(Plate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ImageObject(int x, int y, ObjectType type, String imageName) {
        this(x,y,imageName);
        this.type = type;
    }
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}
