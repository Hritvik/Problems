package parkingLotDesign;

public class ExitPoint {
	ParkingAttendant parkingAttendant = null;
	AutomatedExitPanel automatedExitPanel = null;

	public void payParkingFee(long payment, String paymentType, String via, ParkingTicket parkingTicket) {
		if (via.equals("ParkingAttendant")) {
			parkingAttendant.payParkingFee(payment, paymentType, parkingTicket);
		} else if (via.equals("automatedExitPanel")) {
			automatedExitPanel.payParkingFee(payment, paymentType, parkingTicket);
		}

	}
}
