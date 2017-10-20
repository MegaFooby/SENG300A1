package ca.ucalgary.seng300.a1;
import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class CoinSlotListening implements CoinSlotListener {
	private boolean isOn;
	
	public CoinSlotListening() {
		isOn = true;
	}

	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}

	public void validCoinInserted(CoinSlot slot, Coin coin) {}

	public void coinRejected(CoinSlot slot, Coin coin) {}
	
	public boolean isOn() {
		return isOn;
	}

}
