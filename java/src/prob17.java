import java.util.HashMap;
import java.util.Map;

public class prob17 {
	/**
	 * Euler Project Problem 17
	 * http://projecteuler.net/problem=17
	 */
	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "");
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		map.put(8, "eight");
		map.put(9, "nine");
		map.put(10, "ten");
		map.put(11, "eleven");
		map.put(12, "twelve");
		map.put(13, "thirteen");
		map.put(14, "fourteen");
		map.put(15, "fifteen");
		map.put(16, "sixteen");
		map.put(17, "seventeen");
		map.put(18, "eighteen");
		map.put(19, "nineteen");
		map.put(20, "twenty");
		map.put(30, "thirty");
		map.put(40, "forty");
		map.put(50, "fifty");
		map.put(60, "sixty");
		map.put(70, "seventy");
		map.put(80, "eighty");
		map.put(90, "ninety");
		
		String string = "";
		for(int i=1; i<=1000; i++){
			if(i==1000)
				string+="one thousand";
			else if(i >= 100){
				string+= map.get(Integer.parseInt(Integer.toString(i).substring(0,1)))+" hundred";
				if(i%100 != 0){
					int s = i%100;
					if(s<20)
						string+=" and" + map.get(s);
					else{
						int ones = s%10;
						int tens = s-ones;
						string+= " and" + map.get(tens) + " " + map.get(ones);
					}
				}
			}
			else if(i<20){
				string+=map.get(i);
			}
			else{
				int ones = i%10;
				int tens = i - ones;
				string+= map.get(tens) + " " + map.get(ones);
			}
			//string+="\n";
		}
		string = string.replaceAll(" ", "");
		double endTime = System.currentTimeMillis();
		System.out.println("Answer: " +string.length());
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}

}
