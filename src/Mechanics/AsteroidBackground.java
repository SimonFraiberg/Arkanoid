// 318816477 Simon Fraiberg.
package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * displays background.
 */
public class AsteroidBackground implements Sprite {
    private final Counter count = new Counter();
    private int[] stars;
    private int[] asteroids;

    /**
     * creates an array for stars coordinates.
     *
     * @param amount amount of stats.
     */
    public void stars(int amount) {
        Random random = new Random();
        this.stars = new int[amount * 2];
        for (int i = 0; i < amount * 2; i++) {
            this.stars[i] = random.nextInt(780);
        }
    }

    /**
     * creates an array for stars coordinates.
     */
    public void asteroids() {
        Random random = new Random();
        this.asteroids = new int[12];
        for (int i = 0; i < 12; i++) {
            this.asteroids[i] = random.nextInt(780);
        }
    }

    @Override
    public void drawOn(DrawSurface surface) {
        Random random = new Random();
        surface.setColor(Color.BLACK);
        surface.fillRectangle(0, 0, 800, 600);
        surface.setColor(Color.white);
        for (int i = 0; i < this.stars.length / 2; i++) {
            surface.fillCircle(20 + this.stars[i], 20 + this.stars[i + 1], 2);
        }

        if (this.count.getValue() > 550) {
            this.count.decrease(550);
            this.asteroids = new int[12];
            for (int i = 0; i < 12; i++) {
                this.asteroids[i] = random.nextInt(780);
            }
        }
        this.count.increase(5);
        surface.setColor(new Color(240, 92, 81));
        surface.fillCircle(this.asteroids[0] + count.getValue() * 2, -50 + count.getValue() * 2, 50);
        surface.fillCircle(this.asteroids[1] + count.getValue(), -100 + count.getValue() * 2, 50);
        surface.fillCircle(this.asteroids[2] + count.getValue(), -200 + count.getValue() * 2, 50);
        surface.setColor(new Color(199, 108, 101));
        surface.fillCircle(this.asteroids[3] + (count.getValue() * 2), -50 + (count.getValue() * 2), 20);
        surface.setColor(new Color(186, 24, 17));
        surface.fillCircle(this.asteroids[4] + (count.getValue()), -400 + (count.getValue() * 3), 25);
        surface.fillCircle(this.asteroids[5] + (count.getValue()), -500 + (count.getValue() * 2), 25);

        surface.setColor(new Color(181, 76, 71));
        surface.fillCircle(this.asteroids[6] + (count.getValue() * 4), -600 + (count.getValue() * 4), 5);
        surface.fillCircle(this.asteroids[7] + (count.getValue() * 2), -200 + (count.getValue() * 4), 5);
        surface.fillCircle(this.asteroids[8] + (count.getValue() * 4), 0 + (count.getValue() * 4), 5);
        surface.fillCircle(this.asteroids[9] + (count.getValue() * 4), 0 + (count.getValue() * 3), 5);
        surface.fillCircle(this.asteroids[10] + (count.getValue() * 4), 0 + (count.getValue() * 4), 5);
        surface.fillCircle(this.asteroids[11] + count.getValue(), -100 + count.getValue() * 2, 20);


    }

    @Override
    public void timePassed() {

    }
}

