package game.items;

import edu.monash.fit2099.engine.Item;
import game.enums.Abilities;

/**
 * Class representing an estus flask
 *
 * @see edu.monash.fit2099.engine
 * @see Abilities
 */
public class EstusFlask extends Item {

    /***
     * The current charge count
     */
    private int chargeCount;

    /***
     * Constructor.
     * @param name the name of this Item
     * @param displayChar the character to use to represent this item if it is on the ground
     * @param portable true if and only if the Item can be picked up
     */
    public EstusFlask(String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.addCapability(Abilities.ESTUS_FLASK);
        chargeCount = 3;
    }

    /**
     * Returns the charge count of EstusFlask.
     *
     * @return the charge count
     */
    public int getChargeCount() {
        return chargeCount;
    }

    /**
     * Setter for attribute chargeCount.
     *
     * @param chargeCount the number of chargeCount
     */
    public void setChargeCount(int chargeCount) {
        if (chargeCount > -1) {
            this.chargeCount = chargeCount;
        }
    }

    /**
     * Resets the charge count of EstusFlask
     */
    public void resetChargeCount() {
        chargeCount = 3;
    }
}
