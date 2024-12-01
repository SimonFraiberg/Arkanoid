package Levels;

import BasicShapes.Point;
import Collidables.Block;
import Collidables.Sprite;
import Mechanics.Velocity;

import java.util.List;

/**
 * interface of classes that contain information about the levels.
 */
public interface LevelInformation {
    /**
     * the number of balls in the game.
     *
     * @return number of balls.
     */
    int numberOfBalls();


    /**
     * The initial velocity of each ball.
     *
     * @return the list of velocities
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddle speed.
     */
    int paddleSpeed();

    /**
     * @return the paddle width.
     */
    int paddleWidth();

    /**
     * @return the level name to be displayed at the top of the screen.
     */
    String levelName();

    /**
     * @return Returns a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * The Blocks that make up the level, each block contains
     * its size, color and location.
     *
     * @return list of blocks.
     */
    List<Block> blocks();

    /**
     * Number of blocks that should be removed
     * before the level is considered to be "cleared".
     * This number should be <= blocks.size();
     *
     * @return the number of blocks to be removed.
     */
    int numberOfBlocksToRemove();

    /**
     * the paddle coordinates.
     *
     * @return the point of the coordinates.
     */
    Point paddleCoordinates();

    /**
     * the balls coordinates.
     *
     * @return list of coordinates.
     */
    List<Point> initialBallCoordinates();
}