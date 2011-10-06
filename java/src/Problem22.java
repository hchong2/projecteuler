import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem22 {
	public static void main(String[] args) throws Exception{
		List<String> nameList = new ArrayList<String>();
		
		//Read names from file
		BufferedReader br = new BufferedReader(new FileReader("Problem22.txt"));
		String line = br.readLine();
		line = line.replaceAll("\"", "");
		line = line.replaceAll(" ", "");

		//Store names in an arrays
		String [] nameArray = line.split(",");
		
		//Create a list collection of names
		for(String name: nameArray){
			nameList.add(name);
		}
		double startTime = System.currentTimeMillis();
		//Sort the list
		Collections.sort(nameList);
		
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int sum = 0;
		
		for(int i=0; i<nameList.size(); i++){
			int nameSum = 0;
			for(int y=0; y<nameList.get(i).length(); y++){
				nameSum += alphabet.indexOf(nameList.get(i).charAt(y)) + 1;
			}
			sum += nameSum * (i+1);
		}
		double endTime = System.currentTimeMillis();
		System.out.println("Answer: " +sum);
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}

}
