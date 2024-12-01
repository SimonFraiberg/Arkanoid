package Mechanics;

import BasicShapes.Ball;
import Collidables.Block;

/**
 * hit listener interface.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param beingHit the block t hit.
     * @param hitter   the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
