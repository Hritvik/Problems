package parkingLotDesign;

public class ParkingAttendant {
	CashierClass cashierClass = null;

	public void payParkingFee(long payment, String paymentType, ParkingTicket parkingTicket) {
		cashierClass.payParkingFee(payment, paymentType, parkingTicket);
	}
}
