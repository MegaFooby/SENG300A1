package ca.ucalgary.seng300.a1;
import org.lsmr.vending.hardware.*;

public class SelectionButtonListening implements SelectionButtonListener {
	private boolean isOn;
	private boolean pressed;
	
	public SelectionButtonListening() {
		pressed = false;
		isOn = true;
	}
	
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}

	public void pressed(SelectionButton button) {
		pressed = true;
	}
	
	public boolean isPressed() {
		boolean temp = pressed;
		pressed = false;
		return temp;
	}
	
	public boolean isOn() {
		return isOn;
	}

}
