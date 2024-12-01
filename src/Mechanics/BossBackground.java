// 318816477 Simon Fraiberg.
package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * displays background.
 */
public class BossBackground implements Sprite {
    private final Counter count = new Counter();
    private int[] stars;
    private int direction = 1;

    /**
     * default constructor sets starts array of 100 in size and sets count to 150.
     */
    public BossBackground() {
        count.increase(150);
        this.stars(100);
    }

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


    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.fillRectangle(0, 0, 800, 600);
        surface.setColor(Color.white);
        for (int i = 0; i < this.stars.length / 2; i++) {
            surface.fillCircle(20 + this.stars[i], 20 + this.stars[i + 1], 2);
        }
        surface.setColor(Color.BLACK);
        surface.fillRectangle(0, 0, 800, 600);
        surface.setColor(Color.white);
        for (int i = 0; i < this.stars.length / 2; i++) {
            surface.fillCircle(20 + this.stars[i], 20 + this.stars[i + 1], 2);
        }
        surface.setColor(Color.blue);
        surface.fillOval((65 + count.getValue()), 125, 25, 50);
        surface.setColor(Color.white);
        surface.drawCircle((80 + count.getValue()), 150, 50);
        surface.setColor(Color.green);
        surface.fillOval((63 + count.getValue()), 120, 30, 20);
        surface.drawOval((-70 + count.getValue()), 150, 300, 100);
        surface.fillOval((-70 + count.getValue()), 150, 300, 100);
        surface.setColor(Color.orange);
        surface.fillCircle((-30 + count.getValue()), 190, 16);
        surface.fillCircle((20 + count.getValue()), 205, 18);
        surface.fillCircle((70 + count.getValue()), 220, 20);
        surface.fillCircle((120 + count.getValue()), 205, 18);
        surface.fillCircle((170 + count.getValue()), 190, 16);
        surface.setColor(Color.red);
        surface.drawCircle((-30 + count.getValue()), 190, 16);
        surface.drawCircle((20 + count.getValue()), 205, 18);
        surface.drawCircle((70 + count.getValue()), 220, 20);
        surface.drawCircle((120 + count.getValue()), 205, 18);
        surface.drawCircle((170 + count.getValue()), 190, 16);
        surface.setColor(Color.black);
        surface.fillOval((68 + count.getValue()), 125, 11, 7);
        surface.drawLine(68 + count.getValue(), 125, 65 + count.getValue(), 122);
        surface.fillOval((80 + count.getValue()), 125, 11, 7);
        surface.drawCircle((-20 + count.getValue()), 130, 8);
        surface.drawCircle((-40 + count.getValue()), 125, 7);
        surface.drawCircle((-60 + count.getValue()), 120, 7);
        surface.drawCircle((count.getValue()), 125, 7);
        surface.drawCircle((20 + count.getValue()), 120, 7);
        count.increase(direction);
        if (this.count.getValue() > 500 || this.count.getValue() < 150) {
            direction = -direction;
        }


    }

    @Override
    public void timePassed() {

    }
}

