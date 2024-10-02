/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import Objects.ImageObject;
import java.awt.Color;


public abstract class Shape extends ImageObject {
    
    public Shape(int x, int y,String imagePath){
        super(x,y,imagePath);
    }
    
    public abstract Color getColor();
    
}
