package parkingLotDesign;

public abstract class ParkingSpot {

	public abstract String getType();

	public abstract boolean isOccupied();

	public abstract void occupySpot();

	public abstract void freeSpot();

}
