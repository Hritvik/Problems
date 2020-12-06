package parkingLotDesign;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLotFloor {
	ArrayList<ParkingSpot> parkingSpots = null;
	public InfoPortal infoPortal = null;
	public DisplayBoard displayBoard = null;
	private int floorNumber = 0;

	public int getFloorNumber() {
		return floorNumber;
	}

	public HashMap<String, Integer> getCapacity() {
		HashMap<String, Integer> capacityMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingSpots.size(); i++) {
			String type = parkingSpots.get(i).getType();
			if (capacityMap.containsKey(type)) {
				capacityMap.put(type, capacityMap.get(type) + 1);
			} else {
				capacityMap.put(type, 1);
			}
		}
		return capacityMap;
	}

	public HashMap<String, Integer> getOccupancy() {
		HashMap<String, Integer> occupancyMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingSpots.size(); i++) {
			if (parkingSpots.get(i).isOccupied()) {
				String type = parkingSpots.get(i).getType();
				if (occupancyMap.containsKey(type)) {
					occupancyMap.put(type, occupancyMap.get(type) + 1);
				} else {
					occupancyMap.put(type, 1);
				}
			}
		}
		return occupancyMap;
	}

	public HashMap<String, Integer> getFreeSpots() {
		HashMap<String, Integer> freeSpotMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingSpots.size(); i++) {
			if (!parkingSpots.get(i).isOccupied()) {
				String type = parkingSpots.get(i).getType();
				if (freeSpotMap.containsKey(type)) {
					freeSpotMap.put(type, freeSpotMap.get(type) + 1);
				} else {
					freeSpotMap.put(type, 1);
				}
			}
		}
		return freeSpotMap;
	}

	public void addParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpots.add(parkingSpot);
	}

	public void deleteParkingSpot(ParkingSpot parkingSpot) {
		for (int i = 0; i < parkingSpots.size(); i++) {
			if (parkingSpots.get(i).equals(parkingSpot)) {
				parkingSpots.remove(i);
				break;
			}
		}
	}

}
