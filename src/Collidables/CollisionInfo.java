// 318816477 Simon Fraiberg.
package Collidables;

import BasicShapes.Point;

/**
 * CollisionInfo class.
 */
public class CollisionInfo {
    private final Point collisionPoint;
    private final Collidable collisionObject;

    /**
     * setter.
     *
     * @param collisionObject the collisionObject to set.
     * @param collisionPoint  the collisionPoint to set.
     */
    public CollisionInfo(Point collisionPoint, Collidable collisionObject) {
        this.collisionPoint = collisionPoint;
        this.collisionObject = collisionObject;
    }

    /**
     * getter.
     *
     * @return the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return collisionPoint;
    }

    /**
     * getter.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}