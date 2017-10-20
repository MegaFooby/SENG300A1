package ca.ucalgary.seng300.a1;
import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

public class PopCanRackListening implements PopCanRackListener {
	private boolean isOn;
	private boolean isEmpty;
	
	public void enabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = true;
	}

	public void disabled(AbstractHardware<? extends AbstractHardwareListener> hardware) {
		isOn = false;
	}
	@Override
	public void popCanAdded(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCanRemoved(PopCanRack popCanRack, PopCan popCan) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansFull(PopCanRack popCanRack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansEmpty(PopCanRack popCanRack) {
		isEmpty = true;
	}

	@Override
	public void popCansLoaded(PopCanRack rack, PopCan... popCans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popCansUnloaded(PopCanRack rack, PopCan... popCans) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public boolean isOn() {
		return isOn;
	}

}
