public class Helpers{
	public static int checkValidArgument(String args []){
		int seed = -3;

		if (args.length != 1){
			System.out.println("Please enter one integer argument.");
			return -1;
		}
		else{
			try{
				seed = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException nfe){
				System.out.println("Please enter one integer argument.");
				return -2;
			}
		}

		return seed;
	}
}