// 318816477 Simon Fraiberg.

import Animations.AnimationRunner;
import Levels.Asteroids;
import Levels.Invasion;
import Levels.Boss;
import Levels.LevelInformation;
import Levels.Moon;
import Mechanics.GameFlow;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.ArrayList;
import java.util.List;


/**
 * class to run the game.
 */
public class Ass6Game {
    /**
     * creates an integer array from string array.
     *
     * @param numbers is the array to convert.
     * @return returns the integer array.
     */
    public static int[] stringsToInts(String[] numbers) {
        int[] arr = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            try {
                arr[i] = Integer.parseInt(numbers[i]);
            } catch (NumberFormatException nfe) {
            }
        }
        return arr;
    }

    /**
     * Creates a game object, initializes and runs it.
     *
     * @param args is not used
     */
    public static void main(String[] args) {
        int[] arr = stringsToInts(args);
        GUI gui = new GUI("game", 800, 600);
        AnimationRunner animationRunner = new AnimationRunner(gui);
        KeyboardSensor keyboardSensor = gui.getKeyboardSensor();
        GameFlow gameFlow = new GameFlow(animationRunner, keyboardSensor, gui);
        List<LevelInformation> levels = new ArrayList<>();

        levels.add(new Invasion());
        levels.add(new Moon());
        levels.add(new Asteroids());
        levels.add(new Boss());
        gameFlow.runLevels(levels);

        gui.close();
    }

}
