package Collidables;

import BasicShapes.Ball;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Mechanics.GameLevel;
import Mechanics.HitListener;
import Mechanics.HitNotifier;
import Mechanics.Velocity;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * class of block that implements Collidable and Sprite interfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle rectangle;
    private final List<HitListener> hitListeners = new ArrayList<>();
    private Color color;

    /**
     * setter.
     * sets rectangle to block.
     *
     * @param rectangle the rectangle to set.
     */
    public Block(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    /**
     * setter
     * sets color to bloack.
     *
     * @param color the color to set.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    // Return the "collision shape" of the object.

    /**
     * returns the "collision shape" of the object.
     *
     * @return the shape.
     */
    public Rectangle getCollisionRectangle() {
        return rectangle;
    }

    /**
     * Notifies the object that we collided with it at collisionPoint with a given velocity.
     *
     * @param collisionPoint  the point of collision.
     * @param currentVelocity the given velocity.
     * @param hitter          the ball that hit.
     * @return he new velocity expected after the hit.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        if (collisionPoint.getX() == rectangle.getUpperLeft().getX()) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        if (collisionPoint.getX() == rectangle.getUpperLeft().getX() + rectangle.getWidth()) {
            newVelocity.setDx(-currentVelocity.getDx());
        }
        if (collisionPoint.getY() == rectangle.getUpperLeft().getY()) {
            newVelocity.setDy(-currentVelocity.getDy());

        }
        if (collisionPoint.getY() == rectangle.getUpperLeft().getY() + rectangle.getHeight()) {
            newVelocity.setDy(-currentVelocity.getDy());

        }
        this.notifyHit(hitter);
        return newVelocity;

    }

    /**
     * time passed function (currently does nothing).
     */
    public void timePassed() {
    }

    /**
     * draws the block on the surface.
     *
     * @param surface the surface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
        surface.setColor(this.color);
        surface.fillRectangle((int) rectangle.getUpperLeft().getX(), (int) rectangle.getUpperLeft().getY(),
                (int) rectangle.getWidth(), (int) rectangle.getHeight());
    }

    /**
     * adds block to game by adding it to sprite and collidable lists.
     *
     * @param g the game to add to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * removes the block from the game by removing it from the sprite and collidable lists.
     *
     * @param gameLevel the game to remove from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
