// 318816477 Simon Fraiberg.
package Collidables;

import BasicShapes.Ball;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Mechanics.Velocity;

/**
 * collidable interface.
 */
public interface Collidable {
    /**
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * Notifies the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the point of collision.
     * @param currentVelocity the given velocity.
     * @param hitter          the ball that hit.
     * @return he new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}