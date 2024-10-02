/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.List;

public class GameObjectIterator implements Iterator {

    private List<GameObject> list;
    private int pos = 0;

    public GameObjectIterator(List<GameObject> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (pos < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public GameObject getNext() {
        if (hasNext()) {
            GameObject element = list.get(pos);
            pos++;
            return element;
        }
        return null;
    }
}
