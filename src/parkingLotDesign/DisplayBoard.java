package parkingLotDesign;

public class DisplayBoard implements ObserverInterface {
	private String message = null;

	public void displayMessage() {
		System.out.println(message);
	}

	@Override
	public void updateData(String message) {
		this.message = message;
	}

}
