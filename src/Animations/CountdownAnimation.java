package Animations;

import Collidables.SpriteCollection;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before
 * it is replaced with the next one.
 */
public class CountdownAnimation implements Animation {
    private  int countFrom;
    private  SpriteCollection gameScreen;
    private double numOfSeconds;

    /**
     * constructor.
     *
     * @param countFrom    the number to count from.
     * @param gameScreen   the screen to display on the countdown
     * @param numOfSeconds num of seconds to run.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = (numOfSeconds / countFrom) * 1000;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
    }

    @Override
    public boolean isStop() {
        return false;
    }

    @Override
    public void setStop(boolean stop) {

    }

    @Override
    public void doOneFrame(DrawSurface d) {
        gameScreen.drawAllOn(d);
        d.setColor(Color.yellow);
        d.drawText(400, (d.getHeight() / 2) - 2, Integer.toString(countFrom), 100);
        this.countFrom = countFrom - 1;
    }

    @Override
    public boolean shouldStop() {
        Sleeper sleeper = new Sleeper();
        if (this.countFrom != 3) {
            sleeper.sleepFor((int) numOfSeconds);
        }
        return this.countFrom == 0;
    }
}
