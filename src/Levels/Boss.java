package Levels;

import BasicShapes.Point;
import Collidables.Block;
import Collidables.Sprite;
import Mechanics.BossBackground;
import Mechanics.Velocity;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Boss level.
 */
public class Boss implements LevelInformation {
    /**
     * generates random Green.
     *
     * @return the random color.
     */
    private static Color randomGreen() {
        Random rand = new Random();
        int r = rand.nextInt(200);
        int b = rand.nextInt(200);
        return new Color(r, 255, b);
    }

    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(30, 5));
        velocities.add(Velocity.fromAngleAndSpeed(360, 5));
        velocities.add(Velocity.fromAngleAndSpeed(330, 5));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 7;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "Boss";
    }

    @Override
    public Sprite getBackground() {
        BossBackground bossBackground = new BossBackground();
        bossBackground.stars(100);
        return bossBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        double blockHeight = 20;
        double blockWidth = 53;
        for (int i = 0; i < 7; i++) {
            Color color = randomGreen();
            for (int j = 0; j < 14; j++) {
                Block block = new Block(new BasicShapes.Rectangle(new Point(
                        (blockWidth + 1) * (j + 1) - 30, (blockHeight + 1) * (i + 1) + 250),
                        blockWidth, blockHeight));
                block.setColor(color);
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public List<Point> initialBallCoordinates() {
        List<Point> cordinates = new ArrayList<>();
        cordinates.add(new Point(410, 570));
        cordinates.add(new Point(410, 570));
        cordinates.add(new Point(410, 570));
        return cordinates;
    }

    @Override
    public Point paddleCoordinates() {
        return new Point(310, 585);
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
