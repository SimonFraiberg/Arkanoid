package Animations;

import Mechanics.BossBackground;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * pause screen animation.
 */
public class PauseScreen implements Animation {
    private final BossBackground bossBackground;
    private boolean stop;

    /**
     * constructor.
     * sets default false to stop.
     * sets default background.
     */
    public PauseScreen() {
        this.stop = false;
        this.bossBackground = new BossBackground();
    }

    @Override
    public boolean isStop() {
        return stop;
    }

    @Override
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.bossBackground.drawOn(d);
        d.setColor(Color.red);
        d.drawText(100, d.getHeight() / 2, "The Game Is Paused", 40);
        d.drawText(130, d.getHeight() / 2 + 50, "The aliens are waiting....", 40);

    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}
