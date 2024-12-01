package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.Random;

/**
 * displays background.
 */
public class MoonBackground implements Sprite {
    private final Counter count = new Counter();
    private int[] stars;

    /**
     * constructor.
     */
    public MoonBackground() {
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
        surface.setColor(Color.white);
        surface.drawCircle((-20 + count.getValue()), 100, 25);
        surface.setColor(Color.blue);
        surface.fillRectangle((-23 + count.getValue()), 55, 5, 20);
        surface.setColor(Color.green);
        surface.drawOval((-70 + count.getValue()), 100, 100, 50);
        surface.fillOval((-70 + count.getValue()), 100, 100, 50);
        surface.setColor(Color.orange);
        surface.fillCircle((-20 + count.getValue()), 50, 6);
        surface.fillCircle((-20 + count.getValue()), 130, 8);
        surface.fillCircle((-40 + count.getValue()), 125, 7);
        surface.fillCircle((-60 + count.getValue()), 120, 7);
        surface.fillCircle((count.getValue()), 125, 7);
        surface.fillCircle((20 + count.getValue()), 120, 7);
        surface.setColor(Color.black);
        surface.drawCircle((-20 + count.getValue()), 130, 8);
        surface.drawCircle((-40 + count.getValue()), 125, 7);
        surface.drawCircle((-60 + count.getValue()), 120, 7);
        surface.drawCircle((count.getValue()), 125, 7);
        surface.drawCircle((20 + count.getValue()), 120, 7);
        surface.setColor(Color.yellow);
        surface.drawLine((count.getValue()), 150, 30 + count.getValue(), 180);
        surface.drawLine((-40 + count.getValue()), 150, -70 + count.getValue(), 180);
        surface.drawOval((-69 + count.getValue()), 178, 98, 5);
        if (this.count.getValue() < 850) {
            this.count.increase(1);
        }
        surface.setColor(new Color(217, 213, 210));
        surface.fillCircle(1000, 300, 500);
        surface.setColor(new Color(184, 182, 180));
        surface.fillCircle(720, 500, 80);
        surface.setColor(new Color(168, 163, 158));
        surface.fillCircle(600, 150, 50);
        surface.setColor(new Color(145, 140, 134));
        surface.fillCircle(700, 200, 60);
        surface.fillCircle(750, 20, 60);
        surface.setColor(Color.BLACK);
        surface.drawLine(700, 500, 700, 560);
        surface.setColor(Color.white);
        surface.fillRectangle(700, 500, 60, 40);
        surface.setColor(Color.blue);
        surface.fillRectangle(700, 530, 60, 5);
        surface.fillRectangle(700, 505, 60, 5);
        surface.drawLine(730, 515, 735, 522);
        surface.drawLine(730, 515, 725, 522);
        surface.drawLine(725, 522, 735, 522);
        surface.drawLine(730, 525, 735, 517);
        surface.drawLine(730, 525, 725, 517);
        surface.drawLine(725, 517, 735, 517);


    }

    @Override
    public void timePassed() {

    }
}

