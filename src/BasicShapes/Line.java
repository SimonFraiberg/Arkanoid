// 318816477 Simon Fraiberg.
package BasicShapes;

import java.util.ArrayList;

/**
 * class of line object.
 */
public class Line {
    private final Point p1;
    private final Point p2;

    /**
     * constructor function.
     * builds point object.
     *
     * @param start the start point of the line.
     * @param end   the end point of the line
     */
    public Line(Point start, Point end) {
        this.p1 = start;
        this.p2 = end;
    }

    /**
     * constructor function.
     * builds point object.
     *
     * @param x1 x value of first point
     * @param x2 x value of second point
     * @param y1 y value of first point
     * @param y2 y value of second point
     */
    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);
    }

    /**
     * measures the length of the line
     * builds point object.
     *
     * @return the length.
     */
    public double length() {
        return start().distance(end());
    }

    /**
     * measures the middle of the line
     * builds point object.
     *
     * @return the middle point.
     */
    public Point middle() {
        Point point = new Point((this.p1.getX() + (this.p2.getX())) / 2, (this.p1.getY() + (this.p2.getY())) / 2);
        return point;
    }

    /**
     * Returns the start point of the line.
     *
     * @return start point.
     */
    public Point start() {
        return this.p1;
    }

    /**
     * Returns the end point of the line.
     *
     * @return end point.
     */
    public Point end() {
        return this.p2;
    }

    /**
     * calculates the slope of a line.
     *
     * @return slope of the line.
     */
    public double slope() {
        if (this.p1.getX() == this.p2.getX()) {
            return 180.0;
        }
        return (this.p1.getY() - this.p2.getY()) / (this.p1.getX() - this.p2.getX());
    }

    /**
     * calculates the interception point the line with the y axle.
     *
     * @return interception point.
     */
    public double intercept() {
        return (this.p1.getY() - (slope() * this.p1.getX()));
    }

    /**
     * Returns the maximum value.
     *
     * @param num1 first value
     * @param num2 second value
     * @return max value.
     */
    public double max(double num1, double num2) {
        if (num1 >= num2) {
            return num1;
        } else {
            return num2;
        }
    }

    /**
     * Returns the maximum value.
     *
     * @param num1 first value
     * @param num2 second value
     * @return min value.
     */
    public double min(double num1, double num2) {
        if (num1 <= num2) {
            return num1;
        } else {
            return num2;
        }
    }

    /**
     * check if point it's on the line.
     *
     * @param point is the given point to check. if it's in the line.
     * @return true if the point in on the line false otherwise.
     */
    public boolean pointInLine(Point point) {

        if (point.getX() > max(p1.getX(), p2.getX()) || point.getX() < min(p1.getX(), p2.getX())) {
            return false;
        }
        return !(point.getY() > max(p1.getY(), p2.getY())) && !(point.getY() < min(p1.getY(), p2.getY()));

    }

    /**
     * check if the lines overlap.
     *
     * @param other the other line.
     * @return true if the lines overlap, false overlap.
     */
    public boolean ovrelap(Line other) {


        if (this.pointInLine(other.start()) || this.pointInLine(other.end())) {
            return true;
        }
        return other.pointInLine(this.start()) || other.pointInLine(this.end());
    }

    /**
     * if the lines have the same slope.
     *
     * @param other the other line.
     * @return return intersection point or null.
     */
    public Point sameSlope(Line other) {
        if (min(other.start().getX(), other.end().getX()) == max(this.start().getX(), this.end().getX())) {
            if (min(other.start().getX(), other.end().getX()) == other.start().getX()) {
                return new Point(other.start().getX(), other.start().getY());
            } else {
                return new Point(other.end().getX(), other.end().getY());
            }
        }
        if (max(other.start().getX(), other.end().getX()) == min(this.start().getX(), this.end().getX())) {
            if (max(other.start().getX(), other.end().getX()) == other.start().getX()) {
                return new Point(other.start().getX(), other.start().getY());
            } else {
                return new Point(other.end().getX(), other.end().getY());
            }

        }
        return null;
    }

    /**
     * if the one line has 180 slope.
     *
     * @param other the other line.
     * @return return intersection point or null.
     */
    public Point yAxleSlope(Line other) {
        Point intersection = new Point(0, 0);
        if (other.slope() == 180) {
            intersection.setX(other.start().getX());
            intersection.setY(this.slope() * intersection.getX() + this.intercept());
            if (other.pointInLine(intersection) && this.pointInLine(intersection)) {

                return intersection;
            }
        }
        if (slope() == 180) {
            intersection.setX(this.start().getX());
            intersection.setY(other.slope() * intersection.getX() + other.intercept());
            if (this.pointInLine(intersection) && other.pointInLine(intersection)) {
                return intersection;
            }
        }
        return null;
    }

    /**
     * check if lines are intersecting.
     * presents them in y = mx +b form.
     *
     * @param other the other line.
     * @return true if the lines intersect, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        Point intersection = new Point(0.0, 0.0);
        if (other.slope() == slope()) {
            return this.ovrelap(other);
        }
        if (this.yAxleSlope(other) != null) {
            return true;
        }
        double m = other.slope() - slope();
        double b = this.intercept() - other.intercept();
        double x = b / m;
        double y = slope() * x + intercept();
        intersection.setX(x);
        intersection.setY(y);
        return this.pointInLine(intersection) && other.pointInLine(intersection);
    }


    /**
     * check if lines are intersecting.
     * presents them in y = mx +b form.
     *
     * @param other the other line
     * @return Returns the intersection point if the lines intersect,
     * and null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (other.equals(this)) {
            return null;
        }

        if (!this.isIntersecting(other)) {
            return null;
        }

        if (other.slope() == slope()) {
            return this.sameSlope(other);
        }

        if (this.yAxleSlope(other) != null) {
            return this.yAxleSlope(other);
        }

        double m = other.slope() - slope();
        double b = intercept() - other.intercept();
        double x = b / m;
        double y = slope() * x + intercept();
        Point intersection = new Point(x, y);
        if (this.pointInLine(intersection) && other.pointInLine(intersection)) {
            return intersection;
        } else {
            return null;
        }
    }

    /**
     * checks if line are equal.
     *
     * @param other the other line.
     * @return true if the lines are equal, false otherwise.
     */
    public boolean equals(Line other) {
        return other.start().equals(this.start()) && other.end().equals((this.end()));
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.

    /**
     * @param rect the rectangle that may intersect with.
     * @return If this line does not intersect with the rectangle, returns null.
     * Otherwise, returns the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersections = new ArrayList<Point>();
        intersections = rect.intersectionPoints(new Line(this.start(), this.end()));
        if (intersections.isEmpty()) {
            return null;
        }
        double minDistance = intersections.get(0).distance(this.start());
        Point closestPoint = new Point(0, 0);
        for (Point point : intersections) {
            if (point.distance(this.start()) <= minDistance) {
                minDistance = point.distance(this.start());
                closestPoint.setX(point.getX());
                closestPoint.setY(point.getY());
            }
        }
        return closestPoint;
    }
}