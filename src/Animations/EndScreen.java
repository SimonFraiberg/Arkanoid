package Animations;

import Mechanics.Counter;
import Mechanics.LoseBackground;
import Mechanics.WinBackground;
import biuoop.DrawSurface;

/**
 * Show the end screen animation.
 */
public class EndScreen implements Animation {
    private boolean stop;
    private boolean win;
    private Counter score;
    private WinBackground winBackground;
    private LoseBackground loseBackground;

    /**
     * constructor.
     *
     * @param score the score to set
     * @param win   sets if the player won or not.
     */
    public EndScreen(Counter score, boolean win) {
        this.score = score;
        this.stop = false;
        this.win = win;
        this.winBackground = new WinBackground();
        this.loseBackground = new LoseBackground();
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (win) {
            this.winBackground.drawOn(d);
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        } else {
            this.loseBackground.drawOn(d);
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score.getValue(), 32);
        }

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    @Override
    public boolean isStop() {
        return stop;
    }

    @Override
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
