package Mechanics;

import BasicShapes.Ball;
import Collidables.Block;

/**
 * a BlockRemover is in charge of removing blocks from the game.
 * as well as keeping count of the number of blocks that remain.
 */
public class BlockRemover implements HitListener {
    private final GameLevel gameLevel;
    private final Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param gameLevel       the game to set.
     * @param remainingBlocks the counter to set.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * removes blocks that were hit from the game and listener.
     *
     * @param beingHit the block to remove.
     * @param hitter   the ball that hit the block.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.gameLevel);
        this.remainingBlocks.decrease(1);
    }
}
