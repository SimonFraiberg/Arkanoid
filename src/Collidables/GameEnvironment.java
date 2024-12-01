// 318816477 Simon Fraiberg.
package Collidables;


import BasicShapes.Line;
import BasicShapes.Point;

import java.util.ArrayList;

/**
 * Game environment class.
 */
public class GameEnvironment {
    private final java.util.List<Collidable> collidables = new ArrayList<Collidable>();

    /**
     * @param c adds the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        this.collidables.add(c);
    }

    /**
     * @param c removes the given collidable from the environment.
     */
    public void removeCollidable(Collidable c) {
        this.collidables.remove(c);

    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * If this object will not collide with any of the collidables returns null.
     * else returns the information about the closest collision that is going to occur.
     *
     * @param trajectory is the ball trajectory without collisions.
     * @return null or collision information.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Point closestCollisionPoint = new Point(0, 0);
        int index = 0;
        int objectPlace = 0;
        double minDistance = Double.MAX_VALUE;
        boolean impact = false;
        for (Collidable object : this.collidables) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(object.getCollisionRectangle());
            if (collisionPoint != null) {

                impact = true;
                if (collisionPoint.distance(trajectory.start()) <= minDistance) {
                    minDistance = collisionPoint.distance(trajectory.start());
                    closestCollisionPoint.setX(collisionPoint.getX());
                    closestCollisionPoint.setY(collisionPoint.getY());
                    objectPlace = index;
                }

            }
            index++;
        }
        if (!impact) {
            return null;
        }
        CollisionInfo info = new CollisionInfo(closestCollisionPoint, collidables.get(objectPlace));
        return info;
    }

}
