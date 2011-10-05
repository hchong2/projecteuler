import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem13 {
	/**
	 * Euler Project Problem 13
	 * http://projecteuler.net/problem=13
	 */
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("../Problem13.txt"));
		
		//Parse file
		List<String> list = new ArrayList<String>();
		while(scan.hasNextLine()){
			list.add(scan.nextLine().trim());
		}
		
		double startTime = System.currentTimeMillis();
		String answer = "";
		int carryover = 0;
		for(int i=49; i>=0; i--){
			
			int total = carryover;
			for(int y=0; y<list.size(); y++){
				int number = Integer.parseInt(list.get(y).substring(i, i+1));
				total += number;
			}
			int digit = total%10;
			carryover = (total - digit)/10;
			answer = Integer.toString(digit) + answer;
			if(i == 0){
				answer = Integer.toString(carryover) + answer;
			}
		}
		double endTime = System.currentTimeMillis();
		System.out.println("Sum: " + answer);
		System.out.println("Number of digits: " + answer.length());
		System.out.println("Answer: " + answer.substring(0,10));
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
}
