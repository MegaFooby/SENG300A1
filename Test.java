package ca.ucalgary.seng300.a1.test;

import org.lsmr.vending.*;
import org.lsmr.vending.hardware.*;

import ca.ucalgary.seng300.a1.*;

import java.util.*;

public class Test {
	public static void main(String[] args) throws DisabledException, EmptyException, CapacityExceededException {
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		int[] coinTypes = {5, 10, 25, 100, 200};
		int numButtons = 6;
		int coinCap = 200;
		int popCap = 10;
		int reCap = 50;
		CoinSlotListening slot = new CoinSlotListening();
		CoinRackListening[] racks = new CoinRackListening[coinTypes.length];
		ArrayList<String> popNames = new ArrayList<String>(6);
		String[] names = {"Coke", "Sprite", "Root Beer", "default1", "default2", "default3"};
		for(String name:names) {
			popNames.add(name);
		}
		ArrayList<Integer> prices = new ArrayList<Integer>(6);
		int[] costs = {100, 75, 200, 50, 300, 25};
		for(int cost:costs) {
			prices.add(cost);
		}
		SelectionButtonListening[] buttons = new SelectionButtonListening[numButtons];
		CoinReceptacleListening receptacle = new CoinReceptacleListening(reCap);
		PopCanRackListening[] canRacks = new PopCanRackListening[6];
		DeliveryChuteListening chute = new DeliveryChuteListening();
		
		VendingMachine machine = new VendingMachine(coinTypes, numButtons, coinCap, popCap, reCap);
		machine.configure(popNames, prices);
		machine.disableSafety();
		machine.getCoinSlot().register(slot);
		machine.getCoinReceptacle().register(receptacle);
		machine.getDeliveryChute().register(chute);
		for(int i = 0; i < coinTypes.length; i++) {
			racks[i] = new CoinRackListening(coinTypes[i]);
			machine.getCoinRack(i).register(racks[i]);
		}
		for(int i = 0; i < numButtons; i++) {
			buttons[i] = new SelectionButtonListening();
			machine.getSelectionButton(i).register(buttons[i]);
		}
		for(int i = 0; i < 6; i++) {
			canRacks[i] = new PopCanRackListening();
			machine.getPopCanRack(i).register(canRacks[i]);
			machine.getPopCanRack(i).load(new PopCan("Test"));
		}
		
		while(!input.equalsIgnoreCase("quit")) {
			//interpret inputs
			Coin insert = null;
			input = keyboard.next();
			switch(input) {
			case "b1": {
				machine.getSelectionButton(0).press();
				break;
			}
			case "b2": {
				machine.getSelectionButton(1).press();
				break;
			}
			case "b3": {
				machine.getSelectionButton(2).press();
				break;
			}
			case "b4": {
				machine.getSelectionButton(3).press();
				break;
			}
			case "b5": {
				machine.getSelectionButton(4).press();
				break;
			}
			case "b6": {
				machine.getSelectionButton(5).press();
				break;
			}
			default: {
				try {
					int i = Integer.parseInt(input);
					insert = new Coin(i);
				}
				catch(NumberFormatException e) {}
			}
			}
			if(insert != null) {
				machine.getCoinSlot().addCoin(insert);
				System.out.print(receptacle.getValue() + "\n");
			}
			for(int i = 0; i < numButtons; i++) {
				if(buttons[i].isPressed()) {
					if(!canRacks[i].isEmpty()) {
						if(receptacle.getValue() >= costs[i]) {
							receptacle.Purchase(costs[i]);
							machine.getPopCanRack(i).dispensePopCan();
							System.out.print("Pop should dispense\n");
						} else {
							//not enough change
							System.out.print("No change\n");
						}
					} else {
						//out of pop in the rack
						System.out.print("No pop\n");
					}
				}
			}
		}
		keyboard.close();
	}
	
}
