public class Road {
	public String name;
	public Location endLocation;

	// road constructor
	public Road(String roadName, Location location){
		name = roadName;
		endLocation = location;
	}

	// return the end location variable
	public Location getEndLocation(){
		return endLocation;
	}

}