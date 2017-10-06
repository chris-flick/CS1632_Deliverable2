public class Helpers{

	// check for valid input
	// check to make sure only one argument is accepted
	// check to make sure one argument is passed
	// check to make sure argument is integer
	public static int checkValidArgument(String args []){
		int seed = -3;

		if (args.length != 1){
			return -1;
		}
		else{
			try{
				seed = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException nfe){
				return -2;
			}
		}

		return seed;
	}
}