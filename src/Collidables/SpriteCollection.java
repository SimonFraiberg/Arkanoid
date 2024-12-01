package Collidables;

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * collection of sprites class.
 */
public class SpriteCollection {
    private final java.util.List<Sprite> sprites = new ArrayList<Sprite>();

    /**
     * add sprites to list.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * @param s removes the given sprite from the environment.
     */
    public void removeSprite(Sprite s) {
        this.sprites.remove(s);
    }

    /**
     * calls timePassed function on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }

    /**
     * calls draw on function on all sprites.
     *
     * @param d the surface to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.sprites) {
            sprite.drawOn(d);
        }
    }

}

