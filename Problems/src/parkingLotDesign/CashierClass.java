package parkingLotDesign;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CashierClass {
	public boolean payParkingFee(long payment, String paymentType, ParkingTicket parkingTicket) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		try {
			String entryTime = parkingTicket.getEntryTime();
			Date entryTimeObj = sdf.parse(entryTime);
			Date now = new Date();
			long diff = now.getTime() - entryTimeObj.getTime();
			int parkingHours = (int) diff / 3600000;
			double fee = 0;
			if (paymentType.equals("Cash") || paymentType.equals("Credit Card")) {
				if (parkingHours < 1) {
					fee = 4;
				} else if (parkingHours > 1 && parkingHours < 2) {
					fee = 7.5;
				} else if (parkingHours > 2 && parkingHours < 3) {
					fee = 11;
				} else {
					fee = 11 + (parkingHours - 3) * 2.5;
				}
				if (payment > fee) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public ParkingTicket collectParkingTicket() {
		return new ParkingTicket();
	}
}
