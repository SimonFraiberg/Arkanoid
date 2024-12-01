package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Polygon;
import java.util.Random;

/**
 * displays background.
 */
public class LoseBackground implements Sprite {
    private int[] stars;
    private Counter count = new Counter();

    /**
     * default constructor.
     */
    public LoseBackground() {
        count.increase(-35);
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

    /**
     * creates aliens animation.
     *
     * @param x       the x coordinates to draw on.
     * @param y       the y coordinates to draw on.
     * @param surface the surface to draw om.
     */
    public void aliens(int x, int y, DrawSurface surface) {
        surface.setColor(Color.white);
        surface.drawCircle((-20 + count.getValue()) + x, 100 + y, 25);
        surface.setColor(Color.blue);
        surface.fillRectangle((-23 + count.getValue()) + x, 55 + y, 5, 20);
        surface.setColor(Color.green);
        surface.drawOval((-70 + count.getValue() + x), 100 + y, 100, 50);
        surface.fillOval((-70 + count.getValue() + x), 100 + y, 100, 50);
        surface.setColor(Color.orange);
        surface.fillCircle((-20 + count.getValue() + x), 50 + y, 6);
        surface.fillCircle((-20 + count.getValue() + x), 130 + y, 8);
        surface.fillCircle((-40 + count.getValue() + x), 125 + y, 7);
        surface.fillCircle((-60 + count.getValue() + x), 120 + y, 7);
        surface.fillCircle((count.getValue() + x), 125 + y, 7);
        surface.fillCircle((20 + count.getValue() + x), 120 + y, 7);
        surface.setColor(Color.black);
        surface.drawCircle((-20 + count.getValue() + x), 130 + y, 8);
        surface.drawCircle((-40 + count.getValue() + x), 125 + y, 7);
        surface.drawCircle((-60 + count.getValue() + x), 120 + y, 7);
        surface.drawCircle((count.getValue() + x), 125 + y, 7);
        surface.drawCircle((20 + count.getValue() + x), 120 + y, 7);

    }


    @Override
    public void drawOn(DrawSurface surface) {

        surface.setColor(Color.BLACK);
        surface.fillRectangle(0, 0, 800, 600);
        surface.setColor(Color.white);
        for (int i = 0; i < this.stars.length / 2; i++) {
            surface.fillCircle(20 + this.stars[i], 20 + this.stars[i + 1], 2);
        }
        aliens(0, 0, surface);
        aliens(-20, 300, surface);
        aliens(-150, 300, surface);
        aliens(-20, 150, surface);
        aliens(-40, 450, surface);
        aliens(-220, 400, surface);
        aliens(-250, 40, surface);


        if (this.count.getValue() > 850) {
            this.count.decrease(850);
        }
        this.count.increase(1);
        surface.setColor(Color.blue);
        surface.fillCircle(1000, 300, 500);
        int[] x1 = {600, 700, 805, 805, 900, 705, 600};
        int[] y1 = {300, 100, 125, 225, 250, 375, 300};
        int[] x2 = {850, 950, 925, 775, 850, 675, 500};
        int[] y2 = {550, 500, 525, 625, 650, 775, 700};
        int[] x3 = {600, 700, 805, 805, 900, 705, 600};
        int[] y3 = {400, 420, 425, 525, 550, 575, 500};
        int numberofpoints = 7;
        surface.setColor(Color.green);
        surface.fillPolygon(new Polygon(x1, y1, numberofpoints));
        surface.fillPolygon(new Polygon(x2, y2, numberofpoints));
        surface.fillPolygon(new Polygon(x3, y3, numberofpoints));
        surface.setColor(new Color(184, 85, 4));
        surface.drawPolygon(new Polygon(x1, y1, numberofpoints));
        surface.drawPolygon(new Polygon(x2, y2, numberofpoints));
        surface.setColor(randomRed());
        for (int i = 0; i < 5; i++) {

            int setX = 600 + i * 20;
            int setY = 150;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65, setX
                    + 60, setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY
                    + 105, setY + 110, setY + 100, setY + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            surface.fillPolygon(new Polygon(x, y, 11));

        }
        for (int i = 0; i < 4; i++) {

            int setX = 700 + i * 20;
            int setY = 50;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX
                    + 65, setX + 60, setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY
                    + 100, setY + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            surface.fillPolygon(new Polygon(x, y, 11));

        }
        for (int i = 0; i < 3; i++) {

            int setX = 580 + i * 20;
            int setY = 400;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65,
                    setX + 60, setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110,
                    setY + 100, setY + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            surface.fillPolygon(new Polygon(x, y, 11));

        }
        for (int i = 0; i < 3; i++) {

            int setX = 620 + i * 20;
            int setY = 420;
            int[] x = {setX + 50, setX + 45, setX + 55, setX + 50, setX + 60, setX + 55, setX + 65,
                    setX + 60, setX + 70, setX + 65, setX + 80, setX + 75, setX + 90};

            // y coordinates of vertices
            int[] y = {setY + 120, setY + 110, setY + 115, setY + 105, setY + 110, setY + 100, setY
                    + 110, setY + 100, setY + 105, setY + 95, setY + 120};

            // number of vertices
            surface.fillPolygon(new Polygon(x, y, 11));

        }


    }

    @Override
    public void timePassed() {

    }
}

