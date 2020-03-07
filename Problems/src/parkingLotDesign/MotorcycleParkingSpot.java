package parkingLotDesign;

public class MotorcycleParkingSpot extends ParkingSpot {
	private boolean occupied = false;

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

	@Override
	public boolean isOccupied() {
		return occupied;
	}

	@Override
	public void occupySpot() {
		occupied = true;
	}

	@Override
	public void freeSpot() {
		occupied = false;
	}

}
