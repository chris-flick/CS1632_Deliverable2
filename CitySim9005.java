public class CitySim9005{

	public CitySim9005(){

	}
	

	public int checkValidArgument(String args []){

		if (args.length != 1){
			System.out.println("Please enter one integer argument.");
			return -1;
		}
		else{
			try{
				int seed = Integer.parseInt(args[0]);
			}
			catch(NumberFormatException nfe){
				System.out.println("Please enter one integer argument.");
			}
		}

		return -1;
	}
}