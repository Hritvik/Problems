package parkingLotDesign;

import java.util.ArrayList;

public class Van extends Vehicle {
	ArrayList<ParkingTicket> pocket = null;
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

}
