// 318816477 Simon Fraiberg.
package Collidables;

import BasicShapes.Ball;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Mechanics.GameLevel;
import Mechanics.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * class of paddle.
 */
public class Paddle implements Sprite, Collidable {
    private final biuoop.KeyboardSensor keyboard;
    private final Block block;
    private final Color color;
    private final int speed;

    /**
     * constructor.
     *
     * @param block    block to set.
     * @param color    color ot set
     * @param keyboard keyboardSensor to set.
     * @param speed    the speed to set
     */
    public Paddle(KeyboardSensor keyboard, Block block, Color color, int speed) {
        this.keyboard = keyboard;
        this.block = block;
        this.color = color;
        this.speed = speed;
    }

    /**
     * movers paddle to the left.
     */
    public void moveLeft() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() - this.speed < 20) {
            this.block.getCollisionRectangle().setUpperLeft(new Point(20,
                    this.block.getCollisionRectangle().getUpperLeft().getY()));
        } else {
            this.block.getCollisionRectangle().setUpperLeft(new Point(this.block.getCollisionRectangle()
                    .getUpperLeft().getX() - this.speed, this.block.getCollisionRectangle().getUpperLeft().getY()));
        }
    }

    /**
     * movers paddle to the right.
     */
    public void moveRight() {
        if (this.block.getCollisionRectangle().getUpperLeft().getX() + this.speed > 780 - block.getCollisionRectangle()
                .getWidth()) {
            this.block.getCollisionRectangle().setUpperLeft(new Point(780 - block.getCollisionRectangle().getWidth(),
                    this.block.getCollisionRectangle().getUpperLeft().getY()));
        } else {
            this.block.getCollisionRectangle().setUpperLeft(new Point(this.block.getCollisionRectangle()
                    .getUpperLeft().getX() + this.speed, this.block.getCollisionRectangle().getUpperLeft().getY()));
        }
    }

    /**
     * checks if key is pressed and moves the paddle accordingly.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }

    }

    /**
     * draws paddle to surface.
     *
     * @param d the surface to draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        Rectangle rectangle = getCollisionRectangle();
        d.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        d.setColor(Color.red);
        d.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * @return the rectangle shape of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     * calculates the new velocity of the ball after it hits the paddle.
     * based on where it hit the paddle.
     *
     * @param collisionPoint  the collison point in the paddle.
     * @param currentVelocity the current velocity of the ball.
     * @param ball            the ball that hit.
     * @return new velocity.
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        Rectangle rectangle = getCollisionRectangle();
        double regionsDevider = 0;
        boolean impact = false;
        double[] regions;
        regions = new double[6];
        regionsDevider = rectangle.getWidth() / 5;
        double angle = 0;
        double location = rectangle.getUpperLeft().getX();
        regions[0] = location;
        regions[1] = location + regionsDevider;
        regions[2] = location + regionsDevider * 2;
        regions[3] = location + regionsDevider * 3;
        regions[4] = location + regionsDevider * 4;
        regions[5] = location + regionsDevider * 5;
        if (collisionPoint.getX() >= regions[0] && collisionPoint.getX() < regions[1]) {
            angle = 300;
        }
        if (collisionPoint.getX() >= regions[1] && collisionPoint.getX() < regions[2]) {
            angle = 330;
        }
        if (collisionPoint.getX() >= regions[2] && collisionPoint.getX() < regions[3]) {
            angle = 360;
        }
        if (collisionPoint.getX() >= regions[3] && collisionPoint.getX() < regions[4]) {
            angle = 30;
        }
        if (collisionPoint.getX() >= regions[4] && collisionPoint.getX() < regions[5]) {
            angle = 60;
        }
        Velocity velocity = Velocity.fromAngleAndSpeed(angle, 5);
        return velocity;
    }

    /**
     * Adds this paddle to the game.
     *
     * @param g the game to add to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}