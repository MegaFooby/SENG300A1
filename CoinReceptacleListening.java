package ca.ucalgary.seng300.a1;
import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class CoinReceptacleListening implements CoinReceptacleListener {
	private boolean isOn;
	private int value;
	private int coinCount;
	
	public CoinReceptacleListening(int maxCap) {
		isOn = true;
		value = 0;
		coinCount = 0;
	}
	
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}

	public void coinAdded(CoinReceptacle receptacle, Coin coin) {
		coinCount++;
		value += coin.getValue();
	}

	public void coinsRemoved(CoinReceptacle receptacle) {
		value = 0;
		coinCount = 0;
	}

	public void coinsFull(CoinReceptacle receptacle) {}

	public void coinsLoaded(CoinReceptacle receptacle, Coin... coins) {
		for(Coin coin : coins) {
			value += coin.getValue();
			coinCount++;
		}
	}

	public void coinsUnloaded(CoinReceptacle receptacle, Coin... coins) {
		for(Coin coin:coins) {
			value -= coin.getValue();
			coinCount--;
		}
	}
	
	public void Purchase(int amount) {
		value -= amount;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isOn() {
		return isOn;
	}
	
	public int coinCount() {
		return coinCount;
	}

}
