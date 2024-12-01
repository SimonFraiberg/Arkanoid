package BasicShapes;

import java.util.ArrayList;

/**
 * class of rectangle object.
 */
public class Rectangle {
    private final double width;
    private final double height;
    private Point upperLeft;
    // Create a new rectangle with location and width/height.

    /**
     * constructor.
     * Creates a new rectangle with location, width and height.
     *
     * @param height    height to set.
     * @param upperLeft upper left corner point to set.
     * @param width     width to set.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * getter.
     *
     * @return the upperLeft corner.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * setter.
     *
     * @param upperLeft the corner point to set.
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * getter.
     *
     * @return the rectangle width
     */
    public double getWidth() {
        return width;
    }

    /**
     * getter.
     *
     * @return the rectangle height
     */
    public double getHeight() {
        return height;
    }

    /**
     * getter.
     *
     * @param line the specified line.
     * @return a (possibly empty) List of intersection points with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        java.util.List<Point> intersections = new ArrayList<Point>();
        Line topLine = new Line(upperLeft, new Point(upperLeft.getX() + this.width, upperLeft.getY()));
        if (topLine.isIntersecting(line) && topLine.intersectionWith(line) != null) {
            intersections.add(topLine.intersectionWith(line));
        }
        Line bottomLine = new Line(new Point(upperLeft.getX(), upperLeft.getY() + this.height),
                new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height));
        if (bottomLine.isIntersecting(line) && bottomLine.intersectionWith(line) != null) {
            intersections.add(bottomLine.intersectionWith(line));
        }
        Line leftLine = new Line(upperLeft, new Point(upperLeft.getX(), upperLeft.getY() + this.height));
        if (leftLine.isIntersecting(line) && leftLine.intersectionWith(line) != null) {
            intersections.add(leftLine.intersectionWith(line));
        }
        Line rightLine = new Line(new Point(upperLeft.getX() + this.width, upperLeft.getY()),
                new Point(upperLeft.getX() + this.width, upperLeft.getY() + this.height));
        if (rightLine.isIntersecting(line) && rightLine.intersectionWith(line) != null) {
            intersections.add(rightLine.intersectionWith(line));
        }

        return intersections;
    }
}


