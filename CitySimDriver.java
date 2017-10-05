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
		cs.runCitySim(rand);
	}
}

