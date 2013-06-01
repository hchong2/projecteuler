import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class prob11 {
	/**
	 * Euler Project Problem 11
	 * http://projecteuler.net/problem=11
	 * 
	 * Solution: I create two grids: original and a 90-degree rotated one.
	 * 	Then I find the max in every row and diagonals in each grid using 
	 * 	helper functions: getMaxInRows and getMaxInDiagonals.  The answer is 
	 * 	the max of the four values.
	 */
	public static void main(String[] args) throws Exception {
		// Parse text
		Scanner scan = new Scanner(new File("../Problem11.txt"));
		List<String> rows = new ArrayList<String>();
		while (scan.hasNextLine()) {
			rows.add(scan.nextLine());
		}
		// End of parse text
		
		double startTime = System.currentTimeMillis();
		int[][] grid = new int[20][20];
		
		//Store initial grid
		for (int i = 0; i < rows.size(); i++) {
			String[] rowSplit = rows.get(i).split(" ");
			for (int y = 0; y < rowSplit.length; y++) {
				grid[i][y] = Integer.parseInt(rowSplit[y]);
			}
		}
		
		int[][] gridRotated90Degrees = new int[20][20];
		gridRotated90Degrees = rotate90Degrees(grid);
		
		//Find max
		int rowMax = Math.max(getMaxInRows(grid, 4), getMaxInRows(gridRotated90Degrees, 4));
		int diagonalMax = Math.max(getMaxInDiagonals(grid, 4), getMaxInDiagonals(gridRotated90Degrees, 4));
		double endTime = System.currentTimeMillis();
		System.out.println("Max: " + Math.max(rowMax, diagonalMax));
		System.out.println("Time: " + (double)(endTime-startTime)/1000 +" seconds");
	}

	static int getMaxInRows(int[][] grid, final int factor) {
		int max = Integer.MIN_VALUE;
		for(int row=0; row<grid.length; row++){
			for(int i=0; i<=grid[row].length-factor; i++){
				int product = grid[row][i] * grid[row][i + 1] * grid[row][i + 2] * grid[row][i + 3];
				if (product > max)
					max = product;
			}
		}
		return max;
	}
	
	static int getMaxInDiagonals(int[][] grid, final int factor){
		int max = Integer.MIN_VALUE;
		
		//Check upper diagonal
		for(int i = factor-1; i<grid.length; i++){
			for(int b=0, a=i; a>=factor-1; a--, b++){
				int product = grid[a][b] * grid[a-1][b+1] * grid[a-2][b+2] * grid[a-3][b+3]; 
				if(product > max){
					max = product;
				}
			}
		}
		
		//Check lower diagonal
		int lastRowLength = grid[grid.length-1].length;
		for(int i=1; i<=lastRowLength-factor; i++){
			for(int a = grid.length-1, b=i; b<=lastRowLength-factor; b++, a--){
				int product = grid[a][b] * grid[a-1][b+1] *  grid[a-2][b+2] *  grid[a-3][b+3];
				if(product > max){
					max = product;
				}
			}
		}
		return max;
	}

	static int[][] rotate90Degrees(int[][] xGrid) {
		int depth = xGrid.length;
		int length = xGrid[0].length;
		
		int[][] rotated = new int[length][depth];

		for (int a = 0; a < xGrid.length; a++) {
			for (int b = 0; b < xGrid[a].length; b++) {
				int indexA = a;
				int indexB = b;

				// Swap indexA and indexB
				int temp = indexA;
				indexA = indexB;
				indexB = temp;

				// Multiply indexB by -1
				indexB *= -1;

				// Add offset to indexB
				indexB += xGrid[a].length-1;

				rotated[indexA][indexB] = xGrid[a][b];
			}
		}
		return rotated;
	}
	
	static void printGrid(int [][] grid){
		for(int i=0; i<grid.length; i++){
			for(int y: grid[i])
				System.out.print(y + " ");
			System.out.println();
		}
	}
}
