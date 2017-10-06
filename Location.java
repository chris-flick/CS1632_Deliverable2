import java.util.ArrayList;

public class Location {
	public String name;
	public ArrayList<Road> roadsList;
	public boolean isEnd;

	// instantiate Location object
	public Location(String locationName, boolean end){
		name = locationName;
		isEnd = end;
		roadsList = new ArrayList<Road>();
	}

	// add road to arraylist
	public int addRoad(Road road){
		if(road == null){
			return -1;
		}

		roadsList.add(road);

		return 1;
	}

	// random integer will be passed through to randomly select road.
	// return the Location found at the end of the road
	public Location getNextLocation(int randomIndex){
		Road road = getNextRoad(randomIndex);
		return road.getEndLocation();
	}

	// random integer will be passed through to randomly select road.
	// return the road
	public Road getNextRoad(int randomIndex){
		return roadsList.get(randomIndex);
	}
}