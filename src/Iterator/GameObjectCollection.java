/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class GameObjectCollection implements Collection {

    private List<GameObject> list;

    public GameObjectCollection(List<GameObject> list) {
        //list = new ArrayList<>();
        this.list = list;
    }

    public void add(GameObject gameObject) {
        list.add(gameObject);
    }

    @Override
    public Iterator createIterator() {
        return new GameObjectIterator(list);
    }

}
