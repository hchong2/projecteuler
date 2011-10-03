import java.text.DecimalFormat;

public class Problem15 {
	/**
	 * Euler Project Problem 15
	 * http://projecteuler.net/problem=15
	 */
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#");
		
		double startTime = System.currentTimeMillis();
		double [][] grid = new double[20+1][20+1];
		//Populate initial values
		grid[0][0] = 0;
		for(int i=1; i< grid.length; i++){
			grid[i][0] = 1;
		}
		for(int i=1; i<grid[0].length; i++){
			grid[0][i] = 1;
		}
		
		//Populate values
		for(int a=1; a<grid.length; a++){
			for(int b=1; b<grid[a].length; b++){
				grid[a][b] = grid[a-1][b] + grid[a][b-1];
			}
		}
		double endTime = System.currentTimeMillis();
		printGrid(grid);
		System.out.println("Answer: " + df.format(grid[20][20]));
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}
	static void printGrid(int [][] grid){
		for(int i=0; i<grid.length; i++){
			for(int y: grid[i])
				System.out.print(y + " ");
			System.out.println();
		}
	}
	static void printGrid(double [][] grid){
		for(int i=0; i<grid.length; i++){
			for(double y: grid[i])
				System.out.print(y + " ");
			System.out.println();
		}
	}
}
