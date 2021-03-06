/**
 * SENG300 Group Assignment 1
 * @author Tae Chyung (10139101), Cameron Davies (30003456) & Grace Ferguson (30004869)
 * 
 * Class for selection button listener
 */

package ca.ucalgary.seng300.a1;

import org.lsmr.vending.hardware.*;

public class SelectionButtonListening implements SelectionButtonListener {
	private boolean isOn;
	private int index;
	private VendCommunicator communicator;

	/**
	 * listener object for selection button
	 * @param num numerical representation of button pressed
	 * @param com communicator 
	 */
	public SelectionButtonListening(int num, VendCommunicator com) {
		isOn = true;
		index = num;
		communicator = com;
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
	 * method for dealing with button pressed
	 */
	public void pressed(SelectionButton button) {
		communicator.purchasePop(index);
	}

	/**
	 * method for retrieving state of listener
	 * @return boolean state of listener
	 */
	public boolean isOn() {
		return isOn;
	}

}
