/**
 * SENG300 Group Assignment 1
 * @author Tae Chyung (10139101), Cameron Davies (30003456) & Grace Ferguson (30004869)
 * 
 * listener for pop can rack
 */

package ca.ucalgary.seng300.a1;
import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class PopCanRackListening implements PopCanRackListener {
	private boolean isOn;
	private boolean isEmpty;
	
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

	public void popCanAdded(PopCanRack popCanRack, PopCan popCan) {
		if(isEmpty)
		{
			isEmpty = false;
		}
	}

	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {}

	public void popCansFull(PopCanRack popCanRack) {}

	public void popCansEmpty(PopCanRack popCanRack) {
		isEmpty = true;
	}

	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		if(isEmpty)
		{
			isEmpty = false;
		}
	}

	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		isEmpty = true;
	}
	
	/**
	 * check if pop can rack is empty
	 * @return boolean state of pop can rack
	 */
	public boolean isEmpty() {
		return isEmpty;
	}
	/**
	 * check if listener is enabled
	 * @return boolean state of listener
	 */
	public boolean isOn() {
		return isOn;
	}

}
