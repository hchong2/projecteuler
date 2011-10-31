import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args) {	
		assert getNthFibonacci(1) == 1;
		assert getNthFibonacci(2) == 7;
		assert getNthFibonacci(3) == 12;
		
		double startTime = System.currentTimeMillis();
		System.out.println(getNthFibonacci(1000));
		double endTime = System.currentTimeMillis();

		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
	static int getNthFibonacci(int numberOfDigits){
		if(numberOfDigits == 1)
			return 1;
		int n=3;
		
		BigInteger f1 = new BigInteger("1");
		BigInteger f2 = new BigInteger("1");
		BigInteger f3 = f1.add(f2);
		for(;;){
			if(f3.toString().length() == numberOfDigits)
				return n;
			else{
				f1 = f2;
				f2 = f3;
				f3 = f1.add(f2);
				n++;
			}
		}
		
	}
}
