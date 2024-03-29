import java.util.Random;

public class CitySimDriver{
	public static void main(String [] args)
	{
		int seed = Helpers.checkValidArgument(args);

		if (seed == -1){
			System.out.println("Please enter one integer argument.");
			return;
		}
		else if (seed == -2){
			System.out.println("Input was not an integer. Please enter one integer argument.");
			return;
		}

		Random rand = new Random(seed);

		CitySim9005 cs = new CitySim9005();

		// starting for loop at i = 1 to make first driver equals Driver 1
		for (int i = 1; i < 6; i++)
			cs.runCitySim(rand, i);
	}
}

