package parkingLotDesign;

import java.util.ArrayList;

public class Car extends Vehicle {
	ArrayList<ParkingTicket> pocket = null;
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

}
