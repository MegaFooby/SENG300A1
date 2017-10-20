package ca.ucalgary.seng300.a1;
import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class CoinReceptacleListening implements CoinReceptacleListener {
	private boolean isOn;
	private int value;
	private Coin[] coins;
	private int coinCount;
	
	public CoinReceptacleListening(int maxCap) {
		isOn = true;
		coins = null;
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
		if(coins == null) {
			coins = new Coin[receptacle.getCapacity()];
		}
		coins[coinCount] = coin;
		coinCount++;
		value += coin.getValue();
	}

	public void coinsRemoved(CoinReceptacle receptacle) {
		if(coins == null) {
			coins = new Coin[receptacle.getCapacity()];
		}
		value = 0;
		for(int i = 0; i < coinCount; i++) {
			coins[i] = null;
		}
		coinCount = 0;
	}

	public void coinsFull(CoinReceptacle receptacle) {}

	public void coinsLoaded(CoinReceptacle receptacle, Coin... coins) {
		if(this.coins == null) {
			this.coins = new Coin[receptacle.getCapacity()];
		}
	}

	public void coinsUnloaded(CoinReceptacle receptacle, Coin... coins) {
		if(this.coins == null) {
			this.coins = new Coin[receptacle.getCapacity()];
		}
		for(Coin rmCoin:coins) {
			for(Coin rmHere:this.coins) {
				if(rmHere != null && rmHere.getValue() == rmCoin.getValue()) {
					value -= rmHere.getValue();
					coinCount--;
					rmHere = null;
					break;
				}
			}
		}
		for(int i = 0; i < receptacle.getCapacity()-1; i++) {
			if(coins[i] == null) {
				coins[i] = coins[i+1];
				coins[i+1] = null;
			}
		}
		coins[receptacle.getCapacity()-1] = null;
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

}
