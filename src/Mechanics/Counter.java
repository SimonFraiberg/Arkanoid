// 318816477 Simon Fraiberg.
package Mechanics;

/**
 * Counter class.
 */
public class Counter {
    private int count;

    /**
     * default constructor sets count to 0.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * adds number to current count.
     *
     * @param number to add.
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * subtracts number from current count.
     *
     * @param number to subtract.
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * getter for count.
     *
     * @return count.
     */
    public int getValue() {
        return this.count;
    }
}