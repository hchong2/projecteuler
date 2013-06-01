import java.util.HashSet;

public class prob21 {
	public static void main(String[] args) {
		final int tenThousand = 10000;
		HashSet<Integer> set = new HashSet<Integer>();
		double startTime = System.currentTimeMillis();
		for(int a=1; a<=tenThousand; a++){
			int b = d(a);
			if(b != a && d(b) == a){
				set.add(a);
				set.add(b);
			}
		}
		int sum = 0;
		for(int x: set){
			sum += x;
		}
		double endTime = System.currentTimeMillis();
		System.out.println("Answer: " + sum);
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");

	}
	
	static int d(int number){
		HashSet<Integer> set = new HashSet<Integer>();
		int limit = number;
		for(int i=1; i<=limit; i++){
			if(number%i == 0){
				limit = number/i;
				set.add(limit);
				set.add(i);
			}
		}
		int sum = -1*number;
		for(int x: set){
			sum +=x;
		}
		return sum;
	}

}
