import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.*;

public class RoadTest {

	// test that the road name gets instantiated correctly
	@Test
	public void createRoadTest(){
		Location loc = Mockito.mock(Location.class);
		Road road = new Road("road name", loc);

		assertEquals("road name", road.name);
	}

	// test that the location gets instantiated correctly
	@Test
	public void createRoadTestLocation(){
		Location loc = Mockito.mock(Location.class);
		Road road = new Road("road name", loc);

		assertNotNull(road.endLocation);
	}

	// test that location gets returned correctly
	@Test
	public void getLocationTest(){
		Location loc = Mockito.mock(Location.class);
		Road road = new Road("road name", loc);

		Location newLoc = road.getEndLocation();

		assertEquals(loc, newLoc);
	}
}