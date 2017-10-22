//SENG300 Group Assignment 1
//Tae Chyung, Cameron Davies & Grace Ferguson (30004869)

package ca.ucalgary.seng300.a1.test;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

import ca.ucalgary.seng300.a1.*;

import java.util.*;

public class Test {
	public static void main(String[] args) throws DisabledException, EmptyException, CapacityExceededException {
		int[] coinTypes = { 5, 10, 25, 100, 200 };
		int numButtons = 6;
		int coinCap = 200;
		int popCap = 10;
		int reCap = 50;
		CoinSlotListening slot = new CoinSlotListening();
		CoinRackListening[] racks = new CoinRackListening[coinTypes.length];
		ArrayList<String> popNames = new ArrayList<String>(6);
		String[] names = { "Coke", "Sprite", "Root Beer", "default1", "default2", "default3" };
		for (String name : names) {
			popNames.add(name);
		}
		ArrayList<Integer> prices = new ArrayList<Integer>(6);
		int[] costs = { 100, 75, 200, 50, 300, 25 };
		for (int cost : costs) {
			prices.add(cost);
		}

		VendingMachine machine = new VendingMachine(coinTypes, numButtons, coinCap, popCap, reCap);

		// communicator needs to be created before selection buttons, since
		// selection button takes in a reference to the communicator
		VendCommunicator communicator = new VendCommunicator();

		SelectionButtonListening[] buttons = new SelectionButtonListening[numButtons];
		CoinReceptacleListening receptacle = new CoinReceptacleListening(reCap);
		PopCanRackListening[] canRacks = new PopCanRackListening[6];
		DeliveryChuteListening chute = new DeliveryChuteListening();

		machine.configure(popNames, prices);
		machine.disableSafety();
		machine.getCoinSlot().register(slot);
		machine.getCoinReceptacle().register(receptacle);
		machine.getDeliveryChute().register(chute);
		for (int i = 0; i < coinTypes.length; i++) {
			racks[i] = new CoinRackListening(coinTypes[i]);
			machine.getCoinRack(i).register(racks[i]);
		}
		for (int i = 0; i < numButtons; i++) {
			buttons[i] = new SelectionButtonListening(i, communicator);
			machine.getSelectionButton(i).register(buttons[i]);
		}
		for (int i = 0; i < 6; i++) {
			canRacks[i] = new PopCanRackListening();
			machine.getPopCanRack(i).register(canRacks[i]);
			machine.getPopCanRack(i).load(new PopCan(machine.getPopKindName(i)));
		}

		communicator.linkVending(receptacle, canRacks, machine);

		// TEST INSTANCE
		// We can structure our tests cases like this, with button presses and
		// coins being added into the machine
		machine.getSelectionButton(3).press();
		machine.getCoinSlot().addCoin(new Coin(200));
		machine.getSelectionButton(3).press();
		machine.getSelectionButton(3).press();

	}

}
