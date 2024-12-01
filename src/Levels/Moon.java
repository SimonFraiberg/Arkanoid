package Levels;

import BasicShapes.Point;
import Collidables.Block;
import Collidables.Sprite;
import Mechanics.MoonBackground;
import Mechanics.Velocity;

import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * moon level.
 */
public class Moon implements LevelInformation {
    /**
     * generates random Yellow.
     *
     * @return the random color.
     */
    private static Color randomYellow() {
        Random rand = new Random();
        int b = rand.nextInt(200);
        return new Color(229, 245, b);
    }

    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(295 + (i * 15), 5));
        }
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 700;
    }

    @Override
    public Point paddleCoordinates() {
        return new Point(50, 585);
    }

    @Override
    public String levelName() {
        return "Moon";
    }

    @Override
    public Sprite getBackground() {
        MoonBackground moonBackground = new MoonBackground();
        moonBackground.stars(100);
        return moonBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        double blockHeight = 20;
        double blockWidth = 53;
        Color color = randomYellow();
        for (int j = 0; j < 14; j++) {
            Block block = new Block(new BasicShapes.Rectangle(new Point(
                    (blockWidth + 1) * (j + 1) - 30, 300), blockWidth, blockHeight));
            block.setColor(color);
            blocks.add(block);
        }
        return blocks;
    }

    @Override
    public List<Point> initialBallCoordinates() {
        List<Point> cordinates = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cordinates.add(new Point(410, 550));
        }
        return cordinates;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
