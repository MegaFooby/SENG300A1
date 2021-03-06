/**
 * SENG300 Group Assignment 1
 * @author Tae Chyung (10139101), Cameron Davies (30003456) & Grace Ferguson (30004869)
 * 
 * A coin receptacle listener class
 */

package ca.ucalgary.seng300.a1;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class CoinReceptacleListening implements CoinReceptacleListener {
	private boolean isOn;
	private int value;
	private int coinCount;

	// not sure why this listening takes in a variable, don't see it being used
	// anywhere - thomas
	public CoinReceptacleListening(int reCap) {
		isOn = true;
		value = 0;
		coinCount = 0;
	}

	/**
	 * method for enabling listener
	 */
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	/**
	 * method for disabling listener
	 */
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}

	/**
	 * method adds coin and value of the coin
	 */
	public void coinAdded(CoinReceptacle receptacle, Coin coin) {
		coinCount++;
		value += coin.getValue();
	}

	/**
	 * method for removing all coins
	 */
	public void coinsRemoved(CoinReceptacle receptacle) {
		value = 0;
		coinCount = 0;
	}

	public void coinsFull(CoinReceptacle receptacle) {
	}

	/**
	 * method for loading coins in to receptacle
	 */
	public void coinsLoaded(CoinReceptacle receptacle, Coin... coins) {
		for (Coin coin : coins) {
			value += coin.getValue();
			coinCount++;
		}
	}

	/**
	 * method for unloading coins
	 */
	public void coinsUnloaded(CoinReceptacle receptacle, Coin... coins) {
		for (Coin coin : coins) {
			value -= coin.getValue();
			coinCount--;
		}
	}

	/**
	 * subtracts amound spent when purchase is made
	 * 
	 * @param amount
	 *            amount of purchase
	 */
	public void Purchase(int amount) {
		value -= amount;
	}

	/**
	 * method to get value of coins in receptacle
	 * 
	 * @return value of coins
	 */
	public int getValue() {
		return value;
	}

	/**
	 * method to check state of listener
	 * 
	 * @return boolean state of listener
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * method to get amount of coins
	 * 
	 * @return integer coin amount
	 */
	public int coinCount() {
		return coinCount;
	}

}
