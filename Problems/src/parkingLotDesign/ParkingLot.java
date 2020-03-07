package parkingLotDesign;

import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot implements ObservableInterface {
	private ArrayList<ExitPoint> exitPoints = null;
	private ArrayList<EntryPoint> entryPoints = null;
	private ArrayList<ParkingAttendant> parkingAttendants = null;
	private ArrayList<ParkingLotFloor> parkingLotFloors = null;
	public DisplayBoard entrancePanel = null;
	private ArrayList<ObserverInterface> observerList = null;

	private HashMap<String, Integer> getCapacity() {
		HashMap<String, Integer> capacityMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingLotFloors.size(); i++) {
			HashMap<String, Integer> capacityMapTemp = parkingLotFloors.get(i).getCapacity();
			for (String type : capacityMapTemp.keySet()) {
				if (capacityMap.containsKey(type)) {
					capacityMap.put(type, capacityMap.get(type) + capacityMapTemp.get(type));
				} else {
					capacityMap.put(type, capacityMapTemp.get(type));
				}
			}
		}
		return capacityMap;
	}

	public HashMap<String, Integer> getOccupancy() {
		HashMap<String, Integer> occupancyMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingLotFloors.size(); i++) {
			HashMap<String, Integer> occupancyMapTemp = parkingLotFloors.get(i).getOccupancy();
			for (String type : occupancyMapTemp.keySet()) {
				if (occupancyMap.containsKey(type)) {
					occupancyMap.put(type, occupancyMap.get(type) + occupancyMapTemp.get(type));
				} else {
					occupancyMap.put(type, occupancyMapTemp.get(type));
				}
			}
		}
		return occupancyMap;
	}

	public HashMap<String, Integer> getFreeSpots() {
		HashMap<String, Integer> freeSpotMap = new HashMap<String, Integer>();
		for (int i = 0; i < parkingLotFloors.size(); i++) {
			HashMap<String, Integer> freeSpotMapTemp = parkingLotFloors.get(i).getFreeSpots();
			for (String type : freeSpotMapTemp.keySet()) {
				if (freeSpotMap.containsKey(type)) {
					freeSpotMap.put(type, freeSpotMap.get(type) + freeSpotMapTemp.get(type));
				} else {
					freeSpotMap.put(type, freeSpotMapTemp.get(type));
				}
			}
		}
		return freeSpotMap;
	}

	public boolean isFull() {
		if (getFreeSpots().size() > 0) {
			return true;
		}
		return false;
	}

	public void addParkingAttendants(ParkingAttendant parkingAttendant) {
		this.parkingAttendants.add(parkingAttendant);
	}

	public void deleteParkingAttendants(ParkingAttendant parkingAttendant) {
		for (int i = 0; i < parkingAttendants.size(); i++) {
			if (parkingAttendants.get(i).equals(parkingAttendant)) {
				parkingAttendants.remove(i);
				break;
			}
		}
	}

	public void addParkingLotFloor(ParkingLotFloor parkingLotFloor) {
		this.parkingLotFloors.add(parkingLotFloor);
	}

	public void deleteParkingLotFloor(ParkingLotFloor parkingLotFloor) {
		for (int i = 0; i < parkingLotFloors.size(); i++) {
			if (parkingLotFloors.get(i).equals(parkingLotFloor)) {
				parkingLotFloors.remove(i);
				break;
			}
		}
	}

	public void addExitPoint(ExitPoint exitPoint) {
		this.exitPoints.add(exitPoint);
	}

	public void deleteExitPoints(ExitPoint exitPoint) {
		for (int i = 0; i < exitPoints.size(); i++) {
			if (exitPoints.get(i).equals(exitPoint)) {
				exitPoints.remove(i);
				break;
			}
		}
	}

	public void addEntryPoint(EntryPoint entryPoint) {
		this.entryPoints.add(entryPoint);
	}

	public void deleteEntryPoints(EntryPoint entryPoint) {
		for (int i = 0; i < entryPoints.size(); i++) {
			if (entryPoints.get(i).equals(entryPoint)) {
				entryPoints.remove(i);
				break;
			}
		}
	}

	@Override
	public void add(ObserverInterface observerInterface) {
		this.observerList.add(observerInterface);
	}

	@Override
	public void remove(ObserverInterface observerInterface) {
		for (int i = 0; i < observerList.size(); i++) {
			if (observerList.get(i).equals(observerInterface)) {
				observerList.remove(i);
				break;
			}
		}

	}

	@Override
	public void notifyALL() {
		String message = getFreeSpots().toString();
		for (int i = 0; i < observerList.size(); i++) {
			observerList.get(i).updateData(message);
		}
	}

}
