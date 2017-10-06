import java.util.Random;

public class CitySim9005{

	public Location cityMatrix[][];

	public CitySim9005(){
		cityMatrix = new Location[2][4];

		// create all possible locations
		Location hotel = new Location("Hotel", false);
		Location diner = new Location("Diner", false);
		Location library = new Location("Library", false);
		Location coffee = new Location("Coffee", false);
		Location philly = new Location("Philadelphia", true);
		Location cleveland = new Location("Cleveland", true);

		// create roads coming out of Hotel. Add it to Hotel Object
		Road fourthAveHotelToDiner = new Road("Fourth Ave", diner);
		Road billStHotelToLibrary = new Road("Bill St.", library);
		hotel.addRoad(fourthAveHotelToDiner);
		hotel.addRoad(billStHotelToLibrary);

		// create road coming out of Diner. Add them to Diner object.
		Road fourthAveDinerToPhilly = new Road("Fourth Ave", philly);
		Road philStDinerToCoffee = new Road("Phil St.", coffee);
		diner.addRoad(fourthAveDinerToPhilly);
		diner.addRoad(philStDinerToCoffee);

		// create roads coming out of coffee. Add them to coffee object
		Road fifthAveCoffeeToLibrary = new Road("Fifth Ave", library);
		Road philStCoffeeToDiner = new Road("Phil St.", diner);
		coffee.addRoad(fifthAveCoffeeToLibrary);
		coffee.addRoad(philStCoffeeToDiner);

		// create roads coming out of library. Add them to library object
		Road fifthAveLibraryToCleveland = new Road("Cleveland", cleveland);
		Road billStLibraryToHotel = new Road("Bill St.", hotel);
		library.addRoad(fifthAveLibraryToCleveland);
		library.addRoad(billStLibraryToHotel);

		// store locations in matrix so that other methods/classes can access
		cityMatrix[0][0] = cleveland;
		cityMatrix[0][1] = hotel;
		cityMatrix[0][2] = diner;
		cityMatrix[0][3] = philly;
		cityMatrix[1][0] = cleveland;
		cityMatrix[1][1] = library;
		cityMatrix[1][2] = coffee;
		cityMatrix[1][3] = philly;

	}

	public void runCitySim(Random rand, int driver){
		// grab starting location
		Location currentLocation = chooseStartLocation(rand);

		while(true){
			// grab next road to travel
			Road nextRoad = currentLocation.getNextRoad(rand.nextInt(2));
			// grab location at the end of next road
			Location nextLocation = nextRoad.getEndLocation();

			// if the next location is philly in [0][3] or cleveland in [1][0], then exit loop to break simulation
			if (nextLocation == cityMatrix[0][3] || nextLocation == cityMatrix[1][0]){
				System.out.println("Driver " + driver + " heading from " + currentLocation.name + " to Outside City via "
			 + nextRoad.name + ".");

				currentLocation = nextLocation;
				break;
			}

			System.out.println("Driver " + driver + " heading from " + currentLocation.name + " to " + nextLocation.name + " via "
			 + nextRoad.name + ".");

			// driver is now at next location
			currentLocation = nextLocation;
		}

		System.out.println("Driver " + driver + " has gone to " + currentLocation.name + "!");
	}

	// randomly return one of the 4 possible locations: hotel, diner, coffee, library
	// possible start locations are [0][1], [0][2], [1][1], [1][2]
	// row ranges from 0-1 so use nextInt(2)
	// column ranges from 1-2 so use nextInt(2) + 1
	public Location chooseStartLocation(Random rand){
		return cityMatrix[rand.nextInt(2)][rand.nextInt(2) + 1];
	}

/*	// randomly return one of the roads that are contained within Location's roadList
	public Location getNextLocation(Random rand, Location currentLocation){
		int randomIndex = rand.nextInt(2);

		return currentLocation.getNextLocation(randomIndex);
	}*/
	
}