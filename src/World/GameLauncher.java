package World;

import Builder.GameBuilder;
import Factory.ObjectsFactory;
import Factory.StrategyFactory;
import Objects.Background;
import Objects.ImageObject;
import static Objects.ObjectType.BALL;
import static Objects.ObjectType.BOMB;
import static Objects.ObjectType.CLOWN;
import static Objects.ObjectType.PLATE;
import Strategy.Strategy;
import Strategy.StrategyType;
import static Strategy.StrategyType.EASY;
import eg.edu.alexu.csd.oop.game.GameEngine;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class GameLauncher {

    private int width = 950;
    private int height = 590;

    public GameLauncher(StrategyType type, int lives) {
        GameBuilder builder = new GameBuilder(this);
        ObjectsFactory factory = new ObjectsFactory();
        ImageObject background = new Background(0, 0, "circus2.jpg");
        StrategyFactory strategyFactory = new StrategyFactory();
        Strategy level = strategyFactory.getLevel(type);
        int plates = level.getPlatesDelay();
        int bombs = level.getBombsDelay();
        int speed = level.getSpeed();
        int balls = level.getBallsDelay();

        builder.addConstantObject(background)
                .addConstantObject(factory.createObject(5, 0, "heart.png"))
                .addConstantObject(factory.createObject(55, 0, "heart.png"))
                .addConstantObject(factory.createObject(105, 0, "heart.png"));

        builder.setWidth(width)
                .setHeight(height)
                .setLevel(type)
                .setLives(lives)
                .setSpeed(speed)
                .addControlObject(factory.createObject(width / 3, (int) (height * 0.52), "clown.png"))
                .setObjectType(CLOWN);

        Game game = builder.build();
//        final GameEngine.GameController gameController = GameEngine.start("Circus Game", game);
        JMenuBar menuBar = new JMenuBar();;
        JMenu menu = new JMenu("File");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exitMenuItem);
        menuBar.add(menu);
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem pauseMenuItem = new JMenuItem("Pause");
        JMenuItem resumeMenuItem = new JMenuItem("Resume");
        menu.add(newMenuItem);
        menu.addSeparator();
        menu.add(pauseMenuItem);
        menu.add(resumeMenuItem);
        menuBar.add(menu);
        final GameEngine.GameController gameController = GameEngine.start("Circus Game", game, menuBar);
        newMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.getGameLauncher().closeGameWindow();
                CurtainsClosed curtainsClosed = new CurtainsClosed();
                curtainsClosed.setVisible(true);
                game.setShouldStop(true);
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.pause();
            }
        });
        resumeMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.resume();
            }
        });

    }

    public void closeGameWindow() {

        java.awt.Window win[] = java.awt.Window.getWindows();
        for (Window windows : win) {
            windows.dispose();

        }
    }

}
