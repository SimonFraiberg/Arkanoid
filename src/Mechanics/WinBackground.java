// 318816477 Simon Fraiberg.
package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;

/**
 * displays background.
 */
public class WinBackground implements Sprite {
    private final Counter count = new Counter();
    private int[] stars;

    /**
     * default constructor.
     */
    public WinBackground() {
        count.increase(550);
        this.stars(100);
    }

    /**
     * generates random Red color.
     *
     * @return the random color.
     */
    private static Color randomRed() {
        Random rand = new Random();
        int g = rand.nextInt(200);
        return new Color(255, g, 0);
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
        surface.setColor(randomRed());
        for (int i = 0; i < 5; i++) {

            int setX = 500 + i * 20;
            int setY = 435;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65, setX + 60,
                    setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100, setY + 110,
                    setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            int numberofpoints = 11;
            surface.fillPolygon(new Polygon(x, y, numberofpoints));

        }
        for (int i = 0; i < 5; i++) {

            int setX = 560 + i * 20;
            int setY = 440;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65, setX + 60,
                    setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100,
                    setY + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            int numberofpoints = 11;
            surface.fillPolygon(new Polygon(x, y, numberofpoints));

        }
        surface.setColor(Color.blue);
        surface.fillOval((65 + count.getValue()), 525, 25, 50);
        surface.setColor(Color.white);
        surface.drawCircle((80 + count.getValue()), 550, 50);
        surface.setColor(Color.green);
        surface.fillOval((63 + count.getValue()), 520, 30, 20);
        surface.drawOval((-70 + count.getValue()), 550, 300, 100);
        surface.fillOval((-70 + count.getValue()), 550, 300, 100);
        surface.setColor(Color.orange);
        surface.fillCircle((-30 + count.getValue()), 590, 16);
        surface.fillCircle((20 + count.getValue()), 605, 18);
        surface.fillCircle((70 + count.getValue()), 620, 20);
        surface.fillCircle((120 + count.getValue()), 605, 18);
        surface.fillCircle((170 + count.getValue()), 590, 16);
        surface.setColor(Color.red);
        surface.drawCircle((-30 + count.getValue()), 590, 16);
        surface.drawCircle((20 + count.getValue()), 605, 18);
        surface.drawCircle((70 + count.getValue()), 620, 20);
        surface.drawCircle((120 + count.getValue()), 605, 18);
        surface.drawCircle((170 + count.getValue()), 690, 16);
        surface.setColor(Color.black);
        surface.fillOval((68 + count.getValue()), 525, 11, 7);
        surface.drawLine(68 + count.getValue(), 525, 65 + count.getValue(), 122);
        surface.fillOval((80 + count.getValue()), 525, 11, 7);
        surface.drawCircle((-20 + count.getValue()), 530, 8);
        surface.drawCircle((-40 + count.getValue()), 525, 7);
        surface.drawCircle((-60 + count.getValue()), 520, 7);
        surface.drawCircle((count.getValue()), 525, 7);
        surface.drawCircle((20 + count.getValue()), 520, 7);
        surface.setColor(randomRed());
        for (int i = 0; i < 5; i++) {

            int setX = 450 + i * 20;
            int setY = 455;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65,
                    setX + 60, setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100,
                    setY + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            int numberofpoints = 11;
            surface.fillPolygon(new Polygon(x, y, numberofpoints));

        }
        for (int i = 0; i < 3; i++) {

            int setX = 580 + i * 20;
            int setY = 440;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65, setX + 60,
                    setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100, setY + 110,
                    setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            int numberofpoints = 11;
            surface.fillPolygon(new Polygon(x, y, numberofpoints));

        }
        for (int i = 0; i < 3; i++) {

            int setX = 620 + i * 20;
            int setY = 470;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65, setX + 60,
                    setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100, setY + 110,
                    setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            int numberofpoints = 11;
            surface.fillPolygon(new Polygon(x, y, numberofpoints));

        }


    }

    @Override
    public void timePassed() {

    }
}

