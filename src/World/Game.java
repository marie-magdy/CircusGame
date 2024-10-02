/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package World;

import Builder.GameBuilder;
import Factory.ObjectsFactory;
import Factory.StrategyFactory;
import Iterator.GameObjectCollection;
import Iterator.GameObjectIterator;
import Iterator.Iterator;
import Objects.Ball;
import Objects.Bomb;
import Objects.ImageObject;
import Objects.ObjectType;
import static Objects.ObjectType.BALL;
import static Objects.ObjectType.PLATE;
import Objects.Plate;
import State.*;
import Factory.ObjectsFactory;
import static Objects.ObjectType.BOMB;
import Objects.Shape;
import Strategy.Strategy;
import Strategy.StrategyType;
import static Strategy.StrategyType.EASY;
import static Strategy.StrategyType.HARD;
import static Strategy.StrategyType.MEDIUM;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.awt.Color;
import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class Game implements World {

    private final int width;
    private final int height;
    private int lives;
    private final List<GameObject> constant;
    private final List<GameObject> moving;
    private final List<GameObject> control;
    private static int MAX_TIME = 1 * 120 * 1000;
    private int score = 0;
    private int flag = 0;
    private long startTime = System.currentTimeMillis();
    // private long timeSeconds = startTime / 1000;
    // private long lastTime = System.currentTimeMillis();
    private State currentState;
    private StrategyType level;
    private int speed;
    private GameObjectCollection gameCollection;
    private GameObject clown;
    private GameBuilder builder;
    private List<GameObject> RightHand;
    private List<GameObject> LeftHand;
    private ObjectsFactory factory;
    private long lastTimePlates = System.currentTimeMillis();
    private long lastTimeBalls = System.currentTimeMillis();
    private long lastTimeBombs = System.currentTimeMillis();
    private StrategyFactory strategyFactory;
    private Strategy strategy;
    private GameLauncher gameLauncher;
    private boolean shouldStop = false;

    public Game(GameBuilder builder, GameLauncher gameLauncher) {
        this.width = builder.getWidth();
        this.height = builder.getHeight();
        this.constant = builder.getConstantList();
        this.moving = builder.getMovingList();
        this.control = builder.getControlList();
        this.level = builder.getLevel();
        this.lives = builder.getLives();
        this.speed = builder.getSpeed();
        this.builder = builder;
        gameCollection = new GameObjectCollection(moving);
        clown = control.get(0);
        RightHand = new ArrayList<>();
        LeftHand = new ArrayList<>();
        factory = new ObjectsFactory();
        this.gameLauncher = gameLauncher;
    }

    private void addMovingObjects() {
        StrategyFactory strategyFactory = new StrategyFactory();
        Strategy level = strategyFactory.getLevel(this.level);
        int plates = level.getPlatesDelay();
        int bombs = level.getBombsDelay();
        int speed = level.getSpeed();
        int balls = level.getBallsDelay();
        Random random = new Random();
        int randomIndex = random.nextInt(4);
        ObjectsFactory factory = new ObjectsFactory();

       if (System.currentTimeMillis() - lastTimePlates > plates) {
            String plateImagePath = "Plate" + randomIndex + ".png";
            builder.addMovingObject(factory.createObject((int) (Math.random() * width - 30), 0, plateImagePath))
                    .setObjectType(PLATE);
            lastTimePlates = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - lastTimeBalls > balls) {
            String BallImagePath = "ball" + randomIndex + ".png";
            builder.addMovingObject(factory.createObject((int) (Math.random() * width - 20), 0, BallImagePath))
                    .setObjectType(BALL);
            lastTimeBalls = System.currentTimeMillis();
        }

        if (System.currentTimeMillis() - lastTimeBombs > bombs) {
            String BombImagePath = "bomb.png";
            builder.addMovingObject(factory.createObject((int) (Math.random() * width - 30), 0, BombImagePath))
                    .setObjectType(BOMB);
            lastTimeBombs = System.currentTimeMillis();
        }
      
    }

    private void updateStackObjects() {

        GameObjectCollection RightCollection = new GameObjectCollection(RightHand);
        GameObjectCollection LeftCollection = new GameObjectCollection(LeftHand);
        Iterator iteratorRight = RightCollection.createIterator();
        Iterator iteratorlLeft = LeftCollection.createIterator();
        int i = 0;
        while (iteratorRight.hasNext()) {
            GameObject shape = iteratorRight.getNext();
            shape.setX(clown.getX() + 30);
            int YHand = height - 180;
            if (i == 0) {
                shape.setY(YHand - 10 * i);
            } else {
                shape.setY(YHand - shape.getHeight() / 2 - 10 * i);
            }
            i++;
        }

        i = 0;
        while (iteratorlLeft.hasNext()) {
            GameObject shape = iteratorlLeft.getNext();
            shape.setX(clown.getX() + clown.getWidth() / 2 + 65);
            int YHand = height - 190;
            if (i == 0) {
                shape.setY(YHand - 10 * i);
            } else {
                shape.setY(YHand - shape.getHeight() / 2 - 10 * i);
            }
            i++;
        }
    }

    private void updateMovingObjects() {
        List<GameObject> objectsToRemove = new ArrayList<>();
        Iterator iterator = gameCollection.createIterator();
        while (iterator.hasNext()) {
            GameObject shape = iterator.getNext();
            shape.setY(shape.getY() + 1);
            // Check if the object has reached the bottom
            if (shape.getY() >= getHeight()) {
                objectsToRemove.add(shape);
            }
        }
        // Remove the objects that have reached the bottom
        moving.removeAll(objectsToRemove);
    }

    private boolean intersect(GameObject shape, int x, int y) {
        if (shape instanceof Bomb) {
            int xheadRight = clown.getX() + 32; 
            int xheadLeft = xheadRight + 125;
            if ((xheadRight <= shape.getX() && xheadLeft >= shape.getX()
                    && (shape.getY() <= y && (shape.getY() > height - clown.getHeight())))
                    || (Math.abs((clown.getX() + clown.getWidth()/2) - (shape.getX()+ shape.getWidth()/2)) <= shape.getWidth()
                    && shape.getY() == y)) {
                return true ;
            }
       }
        return (Math.abs((x + 10) - (shape.getX() + shape.getWidth() / 2)) <= 20
                && shape.getY() == y);
    }

    private void controlStack() {
        Iterator iterator = gameCollection.createIterator();
        while (iterator.hasNext()) {
            GameObject shape = iterator.getNext();
            int xCenter = clown.getX() + clown.getWidth() / 2;
            int XLeftHand = xCenter + 80;
            int XRightHand = xCenter - 100;
            int YLeftHand = height - 182;
            int YRightHand = height - 190;
            if (RightHand.isEmpty()) {
                if (intersect(shape, XRightHand, YRightHand)) {
                    if (shape instanceof Bomb) {
                        moving.remove(shape);
                        //System.out.println("bomb");
                        constant.remove(constant.size() - 1);
                        lives--;
                        continue;
                    }
                    RightHand.add(shape);
                    stopMoving(shape);
                    calculateScore(RightHand);
                }
            } else {
                int yLastShape = RightHand.get(RightHand.size() - 1).getY();
                if (intersect(shape, XRightHand, yLastShape)) {
                    if (shape instanceof Bomb) {
                        moving.remove(shape);
                        constant.remove(constant.size() - 1);
                        lives--;
                        continue;
                    }
                    RightHand.add(shape);
                    stopMoving(shape);
                    calculateScore(RightHand);
                }
            }
            if (LeftHand.isEmpty()) {
                if (intersect(shape, XLeftHand, YLeftHand)) {
                    // System.out.println("LEFT Hand");
                    if (shape instanceof Bomb) {
                        moving.remove(shape);
                        constant.remove(constant.size() - 1);
                        lives--;
                        continue;
                    }
                    LeftHand.add(shape);
                    stopMoving(shape);
                    calculateScore(LeftHand);
                }
            } else {
                int yLastShape = LeftHand.get(LeftHand.size() - 1).getY();
                if (intersect(shape, XLeftHand, yLastShape)) {
                    if (shape instanceof Bomb) {
                        moving.remove(shape);
                        constant.remove(constant.size() - 1);
                        lives--;
                        continue;
                    }
                    LeftHand.add(shape);
                    stopMoving(shape);
                    calculateScore(LeftHand);
                }
            }

        }
    }

    public void Lose() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        if (lives <= 0) {
            Lost state = new Lost(this);
            state.CheckScore();
        }
    }

    public void Win() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME;
        if (lives > 0 && timeout) {
            Won state = new Won(this);
            state.CheckScore();

        }
    }

    public GameLauncher getGameLauncher() {
        return gameLauncher;
    }

    public void setGameLauncher(GameLauncher gameLauncher) {
        this.gameLauncher = gameLauncher;
    }

    public boolean isShouldStop() {
        return shouldStop;
    }

    public void setShouldStop(boolean shouldStop) {
        this.shouldStop = shouldStop;
    }

    public void levelUp() {
        strategyFactory = new StrategyFactory();
        if ((level.equals(EASY) && score >= 3) || (level.equals(MEDIUM) && score >= 5)) {
            LevelUp state = new LevelUp(this);
            state.CheckScore();
            strategy = strategyFactory.getLevel(level);
            this.speed = strategy.getSpeed();
            control.removeAll(LeftHand);
            control.removeAll(RightHand);
            LeftHand.clear();
            RightHand.clear();
            addLives();
            setLives(3);
            MAX_TIME = 120 * 1000;
        }
    }

    private void addLives() {

        for (int i = 0; i < 3 - lives; i++) {
            int x = constant.get(constant.size() - 1).getX();
            constant.add(factory.createObject(x + 50, 0, "heart.png"));
        }

    }

    private void calculateScore(List posList) {
        int sizeRight = posList.size();

        Shape last = (Shape) posList.get(sizeRight - 1);
        Color c1 = last.getColor();
        if (c1.equals(Color.YELLOW) || c1.equals(Color.ORANGE)) {
            score++;
            return;
        } else if (sizeRight >= 3) {
            Shape middle = (Shape) posList.get(sizeRight - 2);
            Color c2 = middle.getColor();

            Shape first = (Shape) posList.get(sizeRight - 3);
            Color c3 = first.getColor();

            if (c1.equals(c2) && c2.equals(c3) && c3.equals(c1)) {
                score++;
            }

        }
    }

    private void stopMoving(GameObject shape) {
        moving.remove(shape);
        control.add(shape);
    }

    public StrategyType getLevel() {
        return level;
    }

    public void setLevel(StrategyType level) {
        this.level = level;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getMAX_TIME() {
        return MAX_TIME;
    }

    public StrategyType getStrategyType() {
        return level;
    }

    public void setStrategyType(StrategyType strategyType) {
        this.level = strategyType;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
        if (shouldStop) {
            return false;
        }
        addMovingObjects();
        updateMovingObjects();
        controlStack();
        updateStackObjects();
        Lose();
        Win();
        levelUp();

        return true;
    }

    @Override
    public String getStatus() {
        return "Score = " + score + "   |   Time = " + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000) + "   |   Lives = " + getLives();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getControlSpeed() {
        return 10;
    }
}
