public class Helpers{
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