import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class prob18 {
	/**
	 * Euler Project Problem 18
	 * http://projecteuler.net/problem=18
	 */	
	public static void main(String [] args)throws Exception{
		List<int[]> list = new ArrayList<int[]>();
		
		BufferedReader br = new BufferedReader(new FileReader("../Problem18.txt"));
		String line = br.readLine();
		while(line!=null){
			list.add(convertToIntegerArray(line.split(" ")));
			line = br.readLine();
		}
		double startTime = System.currentTimeMillis();
		for(int i=list.size()-2; i>=0; i--){
			for(int y=0; y<list.get(i).length; y++){
				int a = list.get(i+1)[y];
				int b = list.get(i+1)[y+1];;
				list.get(i)[y] += Math.max(a, b);
			}
		}
		double endTime = System.currentTimeMillis();
		for(int [] a: list){
			for(int b: a){
				System.out.print(b+ " ");
			}
			System.out.println();
		}
		
		System.out.println("Answer: " + list.get(0)[0]);
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
	static int[] convertToIntegerArray(String [] s){
		int[] i = new int[s.length];
		for(int x=0; x<s.length; x++){
			i[x] = Integer.parseInt(s[x]);
		}
		return i;
	}
}
