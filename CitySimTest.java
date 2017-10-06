import static org.junit.Assert.*;
import java.util.Random;
import org.junit.*;
import org.mockito.*;

public class CitySimTest {

	CitySim9005 _c;

	// create a new CitySim9005 object before each test
	@Before
	public void setup(){
		_c = new CitySim9005();
	}

	// test that Hotel Location object added to cityMatrix[0][1] has correct name
	@Test
	public void cityMatrixHotelTestName(){
		assertEquals("Hotel", _c.cityMatrix[0][1].name);
	}

	// test that Hotel Location object added to cityMatrix[0][1] has reference to diner object in cityMatrix[0][2] through road
	@Test
	public void cityMatrixHotelTestRoad1(){
		Location diner = _c.cityMatrix[0][2];
		Location hotel = _c.cityMatrix[0][1];

		// grab Fourth Ave road stored in Hotel object and access its EndLocation
		Location dinerThroughHotel = hotel.roadsList.get(0).getEndLocation();

		assertEquals(diner, dinerThroughHotel);
	}

	// test that Hotel Location object added to cityMatrix[0][1] has reference to library object in cityMatrix[1][1] through road
	@Test
	public void cityMatrixHotelTestRoad2(){
		Location library = _c.cityMatrix[1][1];
		Location hotel = _c.cityMatrix[0][1];

		// grab bill st road stored in Hotel object and access its EndLocation
		Location libraryThroughHotel = hotel.roadsList.get(1).getEndLocation();

		assertEquals(library, libraryThroughHotel);
	}

	// test that Diner Location object added to cityMatrix[0][2] has correct name
	@Test
	public void cityMatrixDinerTestName(){
		assertEquals("Diner", _c.cityMatrix[0][2].name);
	}

	// test that Diner Location object added to cityMatrix[0][2] has reference to philly object in cityMatrix[0][3] through road
	@Test
	public void cityMatrixDinerTestRoad1(){
		Location philly = _c.cityMatrix[0][3];
		Location diner = _c.cityMatrix[0][2];

		// grab Fourth Ave road stored in Diner object and access its EndLocation
		Location phillyFromDiner = diner.roadsList.get(0).getEndLocation();

		assertEquals(philly, phillyFromDiner);
	}

	// test that Diner Location object added to cityMatrix[0][2] has reference to coffee object in cityMatrix[1][2] through road
	@Test
	public void cityMatrixDinerTestRoad2(){
		Location coffee = _c.cityMatrix[1][2];
		Location diner = _c.cityMatrix[0][2];

		// grab phil st road stored in Diner object and access its EndLocation
		Location coffeeFromDiner = diner.roadsList.get(1).getEndLocation();

		assertEquals(coffee, coffeeFromDiner);
	}

	// test that library Location object added to cityMatrix[1][1] has correct name
	@Test
	public void cityMatrixLibraryTestName(){
		assertEquals("Library", _c.cityMatrix[1][1].name);
	}

	// test that library Location object added to cityMatrix[1][1] has reference to cleveland object in cityMatrix[1][0] through road
	@Test
	public void cityMatrixLibraryTestRoad1(){
		Location cleveland = _c.cityMatrix[1][0];
		Location library = _c.cityMatrix[1][1];

		// grab fifth Ave road stored in library object and access its EndLocation
		Location clevelandFromLibrary = library.roadsList.get(0).getEndLocation();

		assertEquals(cleveland, clevelandFromLibrary);
	}

	// test that Library Location object added to cityMatrix[1][1] has reference to hotel object in cityMatrix[0][1] through road
	@Test
	public void cityMatrixLibraryTestRoad2(){
		Location hotel = _c.cityMatrix[0][1];
		Location library = _c.cityMatrix[1][1];

		// grab bill st road stored in library object and access its EndLocation
		Location hotelFromLibrary = library.roadsList.get(1).getEndLocation();

		assertEquals(hotel, hotelFromLibrary);
	}

	// test that coffee Location object added to cityMatrix[1][2] has correct name
	@Test
	public void cityMatrixCoffeeTestName(){
		assertEquals("Coffee", _c.cityMatrix[1][2].name);
	}

	// test that Coffee Location object added to cityMatrix[1][2] has reference to library object in cityMatrix[1][1] through road
	@Test
	public void cityMatrixCoffeeTestRoad1(){
		Location coffee = _c.cityMatrix[1][2];
		Location library = _c.cityMatrix[1][1];

		// grab fifth Ave road stored in coffee object and access its EndLocation
		Location libraryFromCoffee = coffee.roadsList.get(0).getEndLocation();

		assertEquals(library, libraryFromCoffee);
	}

	// test that Coffee Location object added to cityMatrix[1][2] has reference to diner object in cityMatrix[0][2] through road
	@Test
	public void cityMatrixCoffeeTestRoad2(){
		Location coffee = _c.cityMatrix[1][2];
		Location diner = _c.cityMatrix[0][2];

		// grab phil st road stored in coffee object and access its EndLocation
		Location dinerFromCoffee = coffee.roadsList.get(1).getEndLocation();

		assertEquals(diner, dinerFromCoffee);
	}

	// test that chooseStartLocation() returns correct object
	// should return location at cityMatrix[0][1]
	@Test
	public void chooseStartLocationTest(){
		Random rand = Mockito.mock(Random.class);

		Mockito.when(rand.nextInt(2)).thenReturn(0);
		Location loc = _c.chooseStartLocation(rand);

		assertEquals(loc, _c.cityMatrix[0][1]);
	}

	// test that chooseStartLocation() returns correct object
	// should return location at cityMatrix[1][2]
	@Test
	public void chooseStartLocationTest2(){
		Random rand = Mockito.mock(Random.class);

		Mockito.when(rand.nextInt(2)).thenReturn(1);
		Location loc = _c.chooseStartLocation(rand);

		assertEquals(loc, _c.cityMatrix[1][2]);
	}

}