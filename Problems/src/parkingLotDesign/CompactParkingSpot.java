package parkingLotDesign;

public class CompactParkingSpot extends ParkingSpot {

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
