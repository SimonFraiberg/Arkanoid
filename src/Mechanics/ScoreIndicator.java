package Mechanics;

import Collidables.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * displays score.
 */
public class ScoreIndicator implements Sprite {
    private final Counter currentScore;
    private final String levelName;

    /**
     * constructor.
     *
     * @param currentScore the counter to set.
     * @param levelName    the level name to set.
     */
    public ScoreIndicator(Counter currentScore, String levelName) {
        this.currentScore = currentScore;
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.yellow);
        surface.fillRectangle(0, 0, 800, 30);
        surface.setColor(Color.black);
        surface.drawRectangle(0, 0, 800, 30);
        surface.drawText(350, 20, "Score:" + currentScore.getValue(), 20);
        surface.drawText(600, 20, "Level Name:" + levelName, 20);
    }

    @Override
    public void timePassed() {

    }
}
