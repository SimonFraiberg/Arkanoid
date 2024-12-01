// 318816477 Simon Fraiberg.

package Mechanics;

import BasicShapes.Ball;
import Collidables.Block;

/**
 * listener class to keep track on score..
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter score to set.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * adds 5 to the score.
     *
     * @param beingHit block that got hi.
     * @param hitter   the ball that hit.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}