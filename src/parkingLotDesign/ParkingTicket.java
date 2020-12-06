package parkingLotDesign;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParkingTicket {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	String entryTime = null;

	public void setEntryTime() {
		entryTime = sdf.format(new Date());
	}

	public String getEntryTime() {
		return entryTime;
	}
}
