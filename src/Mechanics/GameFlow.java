package Mechanics;

import Animations.AnimationRunner;
import Animations.EndScreen;
import Animations.KeyPressStoppableAnimation;
import Levels.LevelInformation;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;

/**
 * class to set the flow of the game.
 */
public class GameFlow {
    private final KeyboardSensor keyboardSensor;
    private final AnimationRunner animationRunner;
    private final Counter score = new Counter();
    private final GUI gui;

    /**
     * constructor.
     *
     * @param animationRunner animation to set.
     * @param keyboardSensor  the keyboard.
     * @param gui             the gui to show on.
     */
    public GameFlow(AnimationRunner animationRunner, KeyboardSensor keyboardSensor, GUI gui) {
        this.animationRunner = animationRunner;
        this.keyboardSensor = keyboardSensor;
        this.gui = gui;

    }

    /**
     * runs all the levels that are in the list.
     *
     * @param levels the levels information.
     */
    public void runLevels(List<LevelInformation> levels) {
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.score, gui);
            level.initialize();

            while (level.getBallCounter().getValue() > 0 && level.getBlockCounter().getValue() > 0) {
                level.run();
            }

            if (level.getBallCounter().getValue() == 0) {
                animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space",
                        new EndScreen(this.score, false)));
                break;
            }
            if (levels.indexOf(levelInfo) == levels.size() - 1) {
                animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, "space",
                        new EndScreen(this.score, true)));
            }

        }

    }
}
