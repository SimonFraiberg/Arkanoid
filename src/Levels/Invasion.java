package Levels;

import BasicShapes.Point;
import Collidables.Block;
import Collidables.Sprite;
import Mechanics.InvasionBackground;
import Mechanics.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Invasion level.
 */
public class Invasion implements LevelInformation {
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
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, 5));
        return velocities;
    }

    @Override
    public List<Point> initialBallCoordinates() {
        List<Point> cordinates = new ArrayList<>();
        cordinates.add(new Point(410, 550));
        return cordinates;
    }

    @Override
    public Point paddleCoordinates() {
        return new Point(360, 585);
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
        return "Invasion";
    }

    @Override
    public Sprite getBackground() {
        InvasionBackground invasionBackground = new InvasionBackground();
        invasionBackground.stars(100);
        return invasionBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        double blockHeight = 20;
        double blockWidth = 50;
        Color color = randomColor();
        Block block = new Block(new BasicShapes.Rectangle(new Point(
                385, 100), blockWidth, blockHeight));
        block.setColor(color);
        blocks.add(block);
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
