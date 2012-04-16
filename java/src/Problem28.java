public class Problem28{
	
	public static void main(String [] args){
		
		int sum=1;
		int lastNumber=1;
		int addFactor=2;

		for(int i=3; i<=1001; i+=2){
			for(int y=1; y<=4; y++){
				lastNumber += addFactor;
				sum += lastNumber;
			}
			addFactor+=2;
		}

		System.out.println(sum);
	}
}