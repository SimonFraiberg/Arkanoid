package Levels;

import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collidables.Block;
import Collidables.Sprite;
import Mechanics.AsteroidBackground;
import Mechanics.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Asteriods level.
 */
public class Asteroids implements LevelInformation {
    /**
     * generates random color.
     *
     * @return the random color.
     */
    private static Color randomColor() {
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        return new Color(r, g, b);
    }

    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(30, 5));
        velocities.add(Velocity.fromAngleAndSpeed(330, 5));

        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Asteroids";
    }

    @Override
    public Sprite getBackground() {
        AsteroidBackground asteroidBackground = new AsteroidBackground();
        asteroidBackground.stars(100);
        asteroidBackground.asteroids();
        return asteroidBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        double blockHeight = 20;
        double blockWidth = 51;
        for (int i = 0; i < 5; i++) {
            Color color = randomColor();
            for (int j = 0; j < 10 - i; j++) {
                Block block = new Block(new Rectangle(new Point(
                        800 - blockHeight - (blockWidth * (j + 1)), 20 * i + 200), blockWidth, blockHeight));
                block.setColor(color);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public Point paddleCoordinates() {
        return new Point(360, 585);
    }

    @Override
    public List<Point> initialBallCoordinates() {
        List<Point> cordinates = new ArrayList<>();
        cordinates.add(new Point(410, 570));
        cordinates.add(new Point(410, 570));
        return cordinates;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
