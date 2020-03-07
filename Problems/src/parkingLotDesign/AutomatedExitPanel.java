package parkingLotDesign;

public class AutomatedExitPanel extends ExitPoint {
	CashierClass cashierClass = null;

	public void payParkingFee(long payment, String paymentType, ParkingTicket parkingTicket) {
		cashierClass.payParkingFee(payment, paymentType, parkingTicket);
	}
}
