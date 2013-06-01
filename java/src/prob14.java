public class prob14 {
	/**
	 * Euler Project Problem 14 
	 * http://projecteuler.net/problem=14
	 * 
	 * Find starting number, less than a million, with longest chain
	 * Brute force approach.
	 */
	public static void main(String [] args){
		double startTime = System.currentTimeMillis();
		final int million = 1000000;
		
		double max = getChainLength(2);
		double maxN = 0;
		System.out.print("Calculating...");
		for(int i=3; i<=million; i++){
			if(i%100000 == 0)
				System.out.print(".");
			double num = getChainLength(i);
			if(num>max){
				max = num;
				maxN = i;
			}
		}
		System.out.println("\nAnswer: " + (int)maxN + " Length: " + (int)max);
		double endTime = System.currentTimeMillis();
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
	static double getChainLength(double number){
		int count = 1;
		while(number > 1){
			//System.out.println(number);
			if(number%2 == 0){
				number = number/2;
			}
			else{
				number = 3*number+1;
			}
			count++;
		}
		return count;
	}
}
