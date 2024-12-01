package BasicShapes;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Collidables.GameEnvironment;
import Collidables.Sprite;
import Mechanics.GameLevel;
import Mechanics.HitListener;
import Mechanics.Velocity;
import biuoop.DrawSurface;

/**
 * class of ball object.
 */
public class Ball implements Sprite {
    public static final double EPSILON = Math.pow(10, -10);
    private final java.awt.Color color;
    private final List<HitListener> hitListeners = new ArrayList<>();
    private Point center;
    private int r;
    private Velocity v;
    private Point border;
    private GameEnvironment game;

    /**
     * constructor function.
     * builds Ball object with point.
     *
     * @param center the ball's position.
     * @param r      the radius of the ball.
     * @param color  the ball's color.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this(center, r, color, null);
    }

    /**
     * constructor function.
     * builds Ball object with point.
     *
     * @param border the borders for the ball to move.
     * @param x      the ball's position in x axle.
     * @param y      the ball's position in y axle.
     * @param r      the radius of the ball.
     * @param color  the ball's color.
     */
    public Ball(int x, int y, int r, java.awt.Color color, Point border) {
        this(new Point(x, y), r, color, border);
    }

    /**
     * constructor function.
     * builds Ball object with point.
     *
     * @param border the borders for the ball to move.
     * @param center the ball's position.
     * @param r      the radius of the ball.
     * @param color  the ball's color.
     */
    public Ball(Point center, int r, java.awt.Color color, Point border) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.border = border;
    }

    /**
     * removes the ball from the game by removing it from the sprite list.
     *
     * @param gameLevel the game to remove from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * getter function.
     *
     * @return returns border.
     */
    public Point getBorder() {
        return border;
    }

    /**
     * setter function.
     * sets border.
     *
     * @param border the border to set.
     */
    public void setBorder(Point border) {
        this.border = border;
    }

    /**
     * getter function.
     *
     * @return (int)center.getX().
     */
    public int getX() {
        return (int) center.getX();
    }

    /**
     * getter function.
     *
     * @return (int)center.getY().
     */
    public int getY() {
        return (int) center.getY();
    }

    /**
     * getter function.
     *
     * @return r.
     */
    public int getSize() {
        return r;
    }

    /**
     * setter function.
     *
     * @param size size to set
     */
    public void setSize(int size) {
        this.r = size;
    }

    /**
     * getter function.
     *
     * @return center.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * draws a ball on a given DrawSurface.
     *
     * @param surface is the given DrawSurface.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(getX(), getY(), r);
        surface.setColor(Color.orange);
        surface.drawCircle(getX(), getY(), r);
    }

    /**
     * setter function.
     * creates new velocity and sets it to v.
     *
     * @param dx is the x axle speed.
     * @param dy is the y axle speed.
     */
    public void setVelocity(double dx, double dy) {
        Velocity v = new Velocity(dx, dy);
        this.v = v;
    }

    /**
     * getter function.
     *
     * @return v.
     */
    public Velocity getVelocity() {
        return v;
    }

    /**
     * setter function.
     *
     * @param v is the velocity to set.
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     * setter function.
     * sets GameEnvironment
     *
     * @param game the game environment to set
     */
    public void setGame(GameEnvironment game) {
        this.game = game;
    }

    /**
     * movers a point one step.
     */
    public void moveOneStep() {
        double trajecortyX = center.getX();
        double trajecortyY = center.getY();
        double minBorder = border.getX();
        double maxBorder = border.getY();
        double borderSize = 20;
        double borderHeight = 600;
        double blockMargin = 0.00000001;
        while (trajecortyX >= minBorder && trajecortyY >= minBorder
                && trajecortyX <= maxBorder && trajecortyY <= maxBorder) {
            trajecortyX += v.getDx();
            trajecortyY += v.getDy();
        }
        boolean impact = false;
        boolean stuckInBorder = false;
        Line trajectory = new Line(this.center, new Point(trajecortyX, trajecortyY));
        if (game.getClosestCollision(trajectory) == null) {
            this.center = this.getVelocity().applyToPoint(this.center);
            return;
        }
        Rectangle collisionBlock = game.getClosestCollision(trajectory).collisionObject().getCollisionRectangle();
        Point collisionPoint = game.getClosestCollision(trajectory).collisionPoint();
        /**
         * stuck in paddle.
         */
        if (((Math.abs(this.center.getY() - 590) < blockMargin) && collisionBlock.getUpperLeft().getY() == 585)) {
            this.center.setY(580);
        }
        if (this.center.distance(collisionPoint) <= this.r) {
            impact = true;
            /**
             * left side hit.
             */
            if (game.getClosestCollision(trajectory) != null) {
                this.setVelocity(game.getClosestCollision(trajectory)
                        .collisionObject().hit(this, collisionPoint, this.v));
            } else {
                stuckInBorder = true;
            }
            if (collisionBlock.getUpperLeft().getX() == collisionPoint.getX()) {
                this.center.setX(collisionPoint.getX() - EPSILON);
                this.center.setY(collisionPoint.getY());
                if (stuckInBorder) {
                    this.center.setX(borderSize + (this.r * 2));
                    this.center.setY(collisionPoint.getY());
                }
            }
            /**
             * right side hit.
             */
            if (collisionBlock.getUpperLeft().getX() + collisionBlock.getWidth() == collisionPoint.getX()) {
                this.center.setX(collisionPoint.getX() + EPSILON);
                this.center.setY(collisionPoint.getY());
                if (stuckInBorder) {
                    this.center.setX(maxBorder - borderSize - (this.r * 2));
                    this.center.setY(collisionPoint.getY());
                }
            }
            /**
             * bottom side hit.
             */
            if (collisionBlock.getUpperLeft().getY() == collisionPoint.getY()) {
                this.center.setX(collisionPoint.getX());
                this.center.setY(collisionPoint.getY() - EPSILON);
                if (stuckInBorder) {
                    this.center.setX(collisionPoint.getX());
                    this.center.setY(borderSize + (this.r * 2));
                }
            }
            /**
             * top side hit.
             */
            if (collisionBlock.getUpperLeft().getY() + collisionBlock.getHeight() == collisionPoint.getY()) {
                this.center.setX(collisionPoint.getX());
                this.center.setY(collisionPoint.getY() + EPSILON);
                if (stuckInBorder) {
                    this.center.setX(collisionPoint.getX());
                    this.center.setY(borderHeight - (borderSize * 2));
                }
            }
        }
        if (!impact) {
            this.center = this.getVelocity().applyToPoint(this.center);
        }

    }

    /**
     * sets the ball velocity of given ball array.
     * sets random angle.
     * factors the size.
     */
    public void setSpeed() {
        Random rand = new Random();
        if (this.r <= 50) {
            int angle = rand.nextInt(180) + 1;
            Velocity v = Velocity.fromAngleAndSpeed(angle, (60 - this.r) / 2);
            this.setVelocity(v);
        } else {
            int angle = rand.nextInt(180) + 1;
            Velocity v = Velocity.fromAngleAndSpeed(angle, 5);
            this.setVelocity(v);
        }
    }

    /**
     * moves ball on step.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * ads ball to game.
     *
     * @param g game to set the ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

}


