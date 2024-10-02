package Builder;

import Objects.ObjectType;
import Strategy.StrategyType;
import World.Game;
import World.GameLauncher;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.*;

public class GameBuilder {

    private final List<GameObject> constantList = new ArrayList<>();
    private final List<GameObject> movingList = new ArrayList<>();
    private final List<GameObject> controlList = new ArrayList<>();
    private int width;
    private int height;
    private StrategyType level;
    private int lives;
    private int speed;
    private ObjectType objectType;
    private GameLauncher launcher;

    public GameBuilder(GameLauncher launcher) {
       this.launcher=launcher;
    }

    public GameBuilder setObjectType(ObjectType objectType) {
        this.objectType = objectType;
        return this;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public int getSpeed() {
        return speed;
    }

    public GameBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    public GameBuilder setLives(int lives) {
        this.lives = lives;
        return this;
    }

    public GameBuilder setLevel(StrategyType level) {
        this.level = level;
        return this;
    }

    public List<GameObject> getConstantList() {
        return constantList;
    }

    public List<GameObject> getMovingList() {
        return movingList;
    }

    public List<GameObject> getControlList() {
        return controlList;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public StrategyType getLevel() {
        return level;
    }

    public int getLives() {
        return lives;
    }

    public GameBuilder setWidth(int width) {
        this.width = width;
        return this;
    }

    public GameBuilder setHeight(int height) {
        this.height = height;
        return this;
    }

    public GameBuilder addControlObject(GameObject gameObject) {
        controlList.add(gameObject);
        return this;
    }

    public GameBuilder addMovingObject(GameObject gameObject) {
        movingList.add(gameObject);
        return this;
    }

    public GameBuilder addConstantObject(GameObject gameObject) {
        constantList.add(gameObject);
        return this;
    }

    public Game build() {
        return new Game(this,launcher);
    }
}
