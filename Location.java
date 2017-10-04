import java.util.ArrayList;

public class Location {
	public String name;
	public ArrayList<Road> roads;
	public boolean isEnd;

	public Location(String locationName, boolean end){
		name = locationName;
		isEnd = end;
		roads = new ArrayList<Road>();
	}

	public int addRoad(Road road){
		if(road == null)
			return -1;

		roads.add(road);

		return 1;
	}
}