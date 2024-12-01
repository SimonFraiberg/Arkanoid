package Animations;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * animation that is waiting for key input.
 */
public class KeyPressStoppableAnimation implements Animation {
    private final KeyboardSensor sensor;
    private final String key;
    private final Animation animation;
    private boolean isAlreadyPressed;
    private boolean stop;

    /**
     * constructor.
     *
     * @param sensor    the keyboard to set.
     * @param key       the key to respond to.
     * @param animation the animation to draw.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
        this.isAlreadyPressed = true;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.animation.doOneFrame(d);
        if (this.key == "space") {
            if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY) && !isAlreadyPressed) {
                this.animation.setStop(true);
            } else {
                isAlreadyPressed = false;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.animation.isStop();
    }

    @Override
    public boolean isStop() {
        return stop;
    }

    @Override
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    // ...
    // think about the implementations of doOneFrame and shouldStop.
}