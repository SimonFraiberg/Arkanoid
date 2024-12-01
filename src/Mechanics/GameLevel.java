// 318816477 Simon Fraiberg.
package Mechanics;

import Animations.Animation;
import Animations.AnimationRunner;
import Animations.CountdownAnimation;
import Animations.KeyPressStoppableAnimation;
import Animations.PauseScreen;
import BasicShapes.Ball;
import BasicShapes.Point;
import BasicShapes.Rectangle;
import Collidables.Collidable;
import Collidables.GameEnvironment;
import Collidables.Sprite;
import Collidables.Block;
import Collidables.Paddle;
import Collidables.SpriteCollection;
import Levels.LevelInformation;
import biuoop.DrawSurface;
import biuoop.GUI;

import java.util.List;
import java.awt.Color;

import biuoop.KeyboardSensor;


/**
 * class of gameLevel object.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites = new SpriteCollection();
    private GameEnvironment environment = new GameEnvironment();
    private Counter blockCounter = new Counter();
    private Counter ballCounter = new Counter();
    private Counter score;
    private GUI gui;
    private AnimationRunner runner;
    private boolean running;
    private KeyboardSensor keyboard;
    private LevelInformation levelInformation;

    /**
     * constructor.
     *
     * @param levelInfo       the level information.
     * @param keyboardSensor  the keyboard sensor.
     * @param animationRunner the animation to run.
     * @param score           the score.
     * @param gui             the gui to run on.
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter score, GUI gui) {
        this.levelInformation = levelInfo;
        this.keyboard = keyboardSensor;
        this.runner = animationRunner;
        this.score = score;
        this.gui = gui;

    }
    /**
     * getter.
     *
     * @return the counter of blocks
     */
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * getter.
     *
     * @return the counter of balls.
     */
    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * adds collidable to list.
     *
     * @param c the collidable to add.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * adds sprite to list.
     *
     * @param s the sprite to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * removes collidable to list.
     *
     * @param c the collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * removes sprite to list.
     *
     * @param s the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * sets the border blocks for the game.
     *
     * @param width       the width of the border.
     * @param height      the height of the borcer.
     * @param ballRemover listener for DeathBlock
     */
    public void addBorders(int width, int height, BallRemover ballRemover) {
        double borderHeight = 20;
        double scoreMargin = 30;
        Block topBorder = new Block(new Rectangle(new Point(0, scoreMargin), width, borderHeight));
        Block deathBorder = new Block(new Rectangle(new Point(0, height), width, borderHeight));
        Block rightBorder = new Block(new Rectangle(new Point(width - borderHeight, scoreMargin),
                borderHeight, height - scoreMargin));
        Block leftBorder = new Block(new Rectangle(new Point(0, 30), borderHeight, height - scoreMargin));
        topBorder.setColor(Color.gray);
        deathBorder.setColor(Color.gray);
        rightBorder.setColor(Color.gray);
        leftBorder.setColor(Color.gray);
        topBorder.addToGame(this);
        deathBorder.addToGame(this);
        deathBorder.addHitListener(ballRemover);
        rightBorder.addToGame(this);
        leftBorder.addToGame(this);
    }

    /**
     * sets the blocks for the game.
     *
     * @param scoreTrackingListener score listener.
     * @param counter               block counter.
     * @param blockRemover          blockRemover listener.
     */
    public void addBlockes(ScoreTrackingListener scoreTrackingListener, Counter counter, BlockRemover blockRemover) {
        List<Block> blocks = levelInformation.blocks();
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).addToGame(this);
            blocks.get(i).addHitListener(blockRemover);
            blocks.get(i).addHitListener(scoreTrackingListener);
            counter.increase(1);
        }
    }

    /**
     * sets the balls for the game.
     *
     * @param amount the amount of balls to set.
     */
    public void addBalls(int amount) {
        List<Velocity> velocities = levelInformation.initialBallVelocities();
        List<Point> cordinates = levelInformation.initialBallCoordinates();
        for (int i = 0; i < amount; i++) {
            Ball ball = new Ball(cordinates.get(i), 5, Color.red, new Point(0, 800));
            ball.setVelocity(velocities.get(i));
            ball.addToGame(this);
            ball.setGame(this.environment);
        }

    }

    /**
     * Initialize a new game
     * creates the Blocks , Balls and Paddle and adds them to the game.
     */
    public void initialize() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(score, levelInformation.levelName());
        this.addSprite(levelInformation.getBackground());
        this.addSprite(scoreIndicator);
        int width = 800;
        int height = 600;
        BallRemover ballRemover = new BallRemover(this, ballCounter);
        addBalls(levelInformation.numberOfBalls());
        ballCounter.increase(levelInformation.numberOfBalls());
        BlockRemover blockRemover = new BlockRemover(this, blockCounter);
        addBorders(width, height, ballRemover);
        addBlockes(scoreTrackingListener, blockCounter, blockRemover);
        this.keyboard = gui.getKeyboardSensor();
        Paddle player = new Paddle(keyboard, new Block(new Rectangle(levelInformation.paddleCoordinates(),
                levelInformation.paddleWidth(), 5)), Color.blue, levelInformation.paddleSpeed());
        player.addToGame(this);
    }

    /**
     * Runs the game (starts the animation loop).
     */
    public void run() {
        CountdownAnimation countdown = new CountdownAnimation(2, 3, this.sprites);
        this.runner.run(countdown);
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner = new AnimationRunner(this.gui);
        this.runner.run(this);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
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

        boolean paussed = false;
        if (this.keyboard.isPressed("p")) {
            paussed = true;
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, "space", new PauseScreen()));
        }

        this.sprites.drawAllOn(d);
        if (paussed) {
            CountdownAnimation countdown = new CountdownAnimation(2, 3, this.sprites);
            this.runner.run(countdown);
        }
        this.sprites.notifyAllTimePassed();

        if (blockCounter.getValue() == 0) {
            this.score.increase(100);
            this.running = false;
        }
        if (ballCounter.getValue() == 0) {
            this.running = false;
        }
    }
}