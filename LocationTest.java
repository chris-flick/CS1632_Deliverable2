import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.*;

public class LocationTest {

	// testing that Location name was instantiated correctly
	@Test
	public void createLocationTestName(){
		Location loc = new Location("testName", false);

		assertEquals("testName", loc.name);
	}

	// testing that Location isEnd boolean is instantiated to false correctly
	@Test
	public void createLocationTestIsEnd1(){
		Location loc = new Location("testName", false);

		assertEquals(false, loc.isEnd);
	}

	// testing that Location isEnd boolean is instantiated to true correctly
	@Test
	public void createLocationTestIsEnd2(){
		Location loc = new Location("testName", true);

		assertEquals(true, loc.isEnd);
	}

	// testing that Location roads Arraylist is instantiated correctly
	@Test
	public void createLocationTestArraylist(){
		Location loc = new Location("testName", true);

		assertNotNull(loc.roadsList);
	}

	// test that road gets added to ArrayList
	// can verify by seeing if the arraylist's size was incremented
	@Test
	public void addRoadTest(){
		Location loc = new Location("testName", false);
		Road road = Mockito.mock(Road.class);

		loc.addRoad(road);

		assertEquals(1, loc.roadsList.size());
	}


	// test that correct location gets returned from arraylist given an index
	@Test
	public void getNextLocationTest(){
		Location loc = new Location("testName", false);

		// locations to act as endpoints for roads
		Location loc1 = new Location("testName1", false);
		Location loc2 = new Location("testName2", false);
		Location loc3 = new Location("testName3", false);

		Road r1 = Mockito.mock(Road.class);
		Road r2 = Mockito.mock(Road.class);
		Road r3 = Mockito.mock(Road.class);

		// r1 should be at index 0
		loc.addRoad(r1);
		// r2 should be at index 1
		loc.addRoad(r2);
		// r3 should be at index 2
		loc.addRoad(r3);

		// EndLocation of r1 will equal loc1
		Mockito.when(r1.getEndLocation()).thenReturn(loc1);
		// EndLocation of r2 will equal loc2
		Mockito.when(r2.getEndLocation()).thenReturn(loc2);
		// EndLocation of r2 will equal loc3
		Mockito.when(r3.getEndLocation()).thenReturn(loc3);

		assertEquals(loc2, loc.getNextLocation(1));
	}

	//test that a road gets returned
	@Test
	public void getNextRoadTest(){
		Location loc = new Location("TestName", false);

		Road r1 = Mockito.mock(Road.class);
		Road r2 = Mockito.mock(Road.class);
		Road r3 = Mockito.mock(Road.class);

		// r1 should be at index 0
		loc.addRoad(r1);
		// r2 should be at index 1
		loc.addRoad(r2);
		// r3 should be at index 2
		loc.addRoad(r3);

		assertEquals(r2, loc.getNextRoad(1));
	}
}