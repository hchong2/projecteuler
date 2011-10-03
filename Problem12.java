import java.util.HashSet;

public class Problem12 {
	/**
	 * Euler Project Problem 12
	 * http://projecteuler.net/problem=12
	 */ 
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		int triangleNumber = 0;
		for(int i=1; true; i++){
			triangleNumber += i;
			int answer = numberOfDivisors(triangleNumber);
			System.out.println(triangleNumber + " " + answer + " " + i );
			if(answer >= 500){
				System.out.println("Answer: " + triangleNumber);
				break;
			}	
		}
		double endTime = System.currentTimeMillis();
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
	static int numberOfDivisors(int number){
		HashSet<Integer> set = new HashSet<Integer>();
		int limit = number;
		for(int i=1; i<=limit; i++){
			if(number%i == 0){
				limit = number/i;
				set.add(limit);
				set.add(i);
			}
		}
		return set.size();
	}
}
