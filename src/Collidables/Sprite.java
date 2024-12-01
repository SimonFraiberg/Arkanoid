// 318816477 Simon Fraiberg.
package Collidables;

import biuoop.DrawSurface;

/**
 * sprite interface.
 */
public interface Sprite {
    /**
     * draws the sprite to the screen.
     *
     * @param d the surface to drawn on.
     */
    void drawOn(DrawSurface d);

    /**
     * notifies the sprite that time has passed.
     */
    void timePassed();
}