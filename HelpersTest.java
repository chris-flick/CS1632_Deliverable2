import static org.junit.Assert.*;

import org.junit.*;

public class HelpersTest{
	// checkValidArgument() should not allow a string to be an accepted command line argument.
	// -2 should be returned to designate invalid type
	@Test
	public void checkInvalidStringParameter(){
		String args[] = {"hello"};
		int actualResult = Helpers.checkValidArgument(args);
		int expectedResult = -2;

		assertEquals(actualResult, expectedResult);
	}

	// checkValidArgument should reject more than one argument.  Check return value with 2 arguments
	// checkValidArgument should return -1 for more than one argument
	@Test
	public void checkInvalidTwoParameters(){
		String args[] = {"1", "2"};
		int actualResult = Helpers.checkValidArgument(args);
		int expectedResult = -1;

		assertEquals(actualResult, expectedResult);
	}

	// testing to make sure that checkValildArgument() returns seed value
	// if one integer is passed as parameter
	@Test
	public void checkValidCorrectResult(){
		String args[] = {"64"};
		int actualResult = Helpers.checkValidArgument(args);
		int expectedResult = 64;

		assertEquals(actualResult, expectedResult);
	}
}