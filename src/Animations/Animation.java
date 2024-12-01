// 318816477 Simon Fraiberg.

package Animations;

import biuoop.DrawSurface;

/**
 * animation interface.
 */
public interface Animation {
    /**
     * getter to stop.
     *
     * @return stop.
     */
    boolean isStop();

    /**
     * setter to stop.
     *
     * @param stop value to set.
     */
    void setStop(boolean stop);

    /**
     * draws single frame.
     *
     * @param d the drawsurface to draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * checks if the animation should stop.
     *
     * @return true if should stop false otherwise.
     */
    boolean shouldStop();
}