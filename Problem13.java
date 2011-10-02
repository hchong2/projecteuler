import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class Problem13 {

	/**
	 * Euler Project Problem 13
	 * http://projecteuler.net/problem=13
	 */
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(new File("Problem13.txt"));
		
		//Parse file
		List<String> list = new ArrayList<String>();
		while(scan.hasNextLine()){
			list.add(scan.nextLine().trim());
		}
		
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
		
		System.out.println("Sum: " + answer);
		System.out.println("Digits: " + answer.length());
		System.out.println("Answer: " + answer.substring(0,10));
	}
}
