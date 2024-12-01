package BasicShapes;

/**
 * class of point object.
 */
public class Point {
    public static final double EPSILON = Math.pow(10, -10);
    private double x;
    private double y;

    /**
     * constructor function.
     * builds point object.
     *
     * @param x is the x axel value to set
     * @param y is the y axel value to set
     */
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    /**
     * getter function.
     *
     * @return returns x.
     */
    public double getX() {
        return x;
    }

    /**
     * setter function.
     * sets x.
     *
     * @param x is the parameter to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * getter function.
     *
     * @return returns y.
     */
    public double getY() {
        return y;
    }

    /**
     * setter function.
     * sets y.
     *
     * @param y is the parameter to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * measures distance between 2 points.
     *
     * @param other the point to measure the distance from.
     * @return the distance
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.getX()) * (this.x - other.getX()))
                + ((this.y - other.getY()) * (this.y - other.getY())));
    }

    /**
     * checks if 2 points are equals.
     *
     * @param other the other point to check.
     * @return true if the points are equal, false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return (Math.abs(this.x - other.getX()) < EPSILON) && (Math.abs(this.y - other.getY()) < EPSILON);
    }
}

