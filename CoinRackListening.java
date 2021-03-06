/**
 * SENG300 Group Assignment 1
 * @author Tae Chyung (10139101), Cameron Davies (30003456) & Grace Ferguson (30004869)
 * 
 * Listener for the coin rack. Take in messages about the state of the coin rack
 * and convey them to others
 */


package ca.ucalgary.seng300.a1;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class CoinRackListening implements CoinRackListener {
	private boolean isOn;
	private int coinCount;
	private int value;

	/**
	 * constructor for coin rack listener object, stores value of coins in rack
	 * 
	 * @param value
	 *            value of coins in rack
	 */
	public CoinRackListening(int value) {
		this.value = value;
	}

	/**
	 * method for enabling coin rack
	 */
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	/**
	 * method for disabling coin rack
	 */
	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}

	public void coinsFull(CoinRack rack) {
	}

	public void coinsEmpty(CoinRack rack) {
	}

	/**
	 * method for adding coin
	 */
	public void coinAdded(CoinRack rack, Coin coin) {
		coinCount++;
	}

	/**
	 * method for removing all coins
	 */
	public void coinRemoved(CoinRack rack, Coin coin) {
		coinCount = 0;
	}

	/**
	 * method for loading coins in to rack
	 */
	public void coinsLoaded(CoinRack rack, Coin... coins) {
		coinCount += coins.length;
	}

	/**
	 * method for unloading coins
	 */
	public void coinsUnloaded(CoinRack rack, Coin... coins) {
		coinCount -= coins.length;
	}

	/**
	 * method to retrieve value of coin rack
	 * 
	 * @return value integer value of coins in rack
	 */
	public int getValue() {
		return value;
	}

	/**
	 * method for checking state of listener
	 * 
	 * @return boolean representing state of listener
	 */
	public boolean isOn() {
		return isOn;
	}

	/**
	 * method for getting amount of coins in rack
	 * 
	 * @return integer amount of coins in rack
	 */
	public int getCoins() {
		return coinCount;
	}

}
