package Mechanics;

import BasicShapes.Ball;
import Collidables.Block;

/**
 * a BallRemover is in charge of removing balls from the game.
 * as well as keeping count of the number of balls that remain.
 */
public class BallRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBalls;

    /**
     * constructor.
     *
     * @param gameLevel      the game to set.
     * @param remainingBalls the counter to set.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * removes balls that  hit the death block from the game and listener.
     *
     * @param deathBlock the block to hit.
     * @param hitter     the ball that hit the block.
     */
    public void hitEvent(Block deathBlock, Ball hitter) {
        hitter.removeFromGame(this.gameLevel);
        this.remainingBalls.decrease(1);
    }
}
