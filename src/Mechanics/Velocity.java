// 318816477 Simon Fraiberg.
package Mechanics;

import BasicShapes.Point;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * class of Velocity object
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * constructor function.
     * builds Velocity object.
     *
     * @param dx is the x axle speed.
     * @param dy is the y axle speed.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * constructor function.
     * builds Velocity object with angle and speed.
     *
     * @param angle the angle of the ball.
     * @param speed the speed of the ball.
     * @return new Velocity object
     */


    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = sin(Math.toRadians(angle)) * speed;
        double dy = cos(Math.toRadians(angle)) * -speed;
        return new Velocity(dx, dy);
    }

    /**
     * getter function.
     *
     * @return dx.
     */
    public double getDx() {
        return dx;
    }

    /**
     * setter function.
     *
     * @param dx the dx to set.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     * getter function.
     *
     * @return dy.
     */
    public double getDy() {
        return dy;
    }

    /**
     * setter function.
     *
     * @param dy the dy to set.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * adds to point 2 values.
     *
     * @param p the point to add from.
     * @return new point.
     */
    public Point applyToPoint(Point p) {
        Point newPoint = new Point(p.getX() + this.dx, p.getY() + this.dy);
        return newPoint;
    }
}