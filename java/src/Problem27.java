import java.util.*;

public class Problem27{
	public static void main(String [] args){
		
		//Find all primes between 2 and 1000
		ArrayList<Integer> bprime = new ArrayList<Integer>();
		for(int i=2; i<1000; i++){
			if(isPrime(i)){
				bprime.add(i);
			}
		}

		//Find all possible values for a and find the answer
		ArrayList<Integer> aList = new ArrayList<Integer>();
		int maxa=0;
		int maxb=0;
		int maxConsecutivePrime=0;
		for(int i=0; i<bprime.size(); i++){
			int quadrant = 4*bprime.get(i)-163;
			int possible = (int)Math.sqrt(quadrant);

			if(Math.abs(possible) < 1000 && Math.pow(possible, 2)== quadrant){
				int positiveAConsecutivePrimes = consecutivePrimes(possible, bprime.get(i));
				int negativeAConsecutivePrimes = consecutivePrimes(possible*-1, bprime.get(i));
				if(positiveAConsecutivePrimes > negativeAConsecutivePrimes){
					maxConsecutivePrime = positiveAConsecutivePrimes;
					maxa = possible;
					maxb = bprime.get(i);
				}else if(positiveAConsecutivePrimes == negativeAConsecutivePrimes){
					System.out.println("GRRR");
					System.exit(0);
				}else{
					maxConsecutivePrime = negativeAConsecutivePrimes;
					maxa = possible*-1;
					maxb = bprime.get(i);
				}

			}
		}
		System.out.println(maxa*maxb);
		
	}
	public static int consecutivePrimes(int a, int b){
		int n=0;
		while(true){
			int value = (int)Math.pow(n,2) + a*n + b;
			if(isPrime(value)){
				n++;
				continue;
			}else{
				break;
			}
		}
		return n;
	}
	public static boolean isPrime(int num){
		if(num==0 || num==1){
			return false;
		}

		int root = (int)Math.sqrt(num);

		for(int i=2; i<=root; i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
}