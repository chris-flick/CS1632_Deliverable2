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

	public void runCitySim(Random rand){
		Location location = chooseStartLocation(rand);

		while(true){

		}
	}

	// randomly return one of the 4 possible locations: hotel, diner, coffee, library
	public Location chooseStartLocation(Random rand){
		return cityMatrix[rand.nextInt(2) + 1][rand.nextInt(2) + 1];
	}
	
}