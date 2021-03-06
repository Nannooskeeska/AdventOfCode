package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day_03_01 {
	
	final static char NORTH = '^';
	final static char SOUTH = 'v';
	final static char EAST = '>';
	final static char WEST = '<';
	static int[][] houses = new int[1000][1000];
	static int x = 500;
	static int y = 500;

	public static void main(String[] args) {
		
		houses[500][500]++;
		
		int answer = 0;
		
		File file = null;
		BufferedReader br;
		try {
			// Go through lines and separate them
			file = new File("src/day3/input.txt");
			br = new BufferedReader(new FileReader(file));
			String line = null;  
			while ((line = br.readLine()) != null)  
			{
				// Do stuff with the lines
//				System.out.println(line);
				answer = solve(line);
			}
			// Wrong answers: 2573
			System.out.println(answer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int solve(String line) {
		int total = 0;
		
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == NORTH) {
				System.out.println(x + "," + y);
				houses[x][y++]++;
			} else if(c == SOUTH) {
				System.out.println(x + "," + y);
				houses[x][y--]++;
			} else if(c == EAST) {
				System.out.println(x + "," + y);
				houses[x++][y]++;
			} else if(c == WEST) {
				System.out.println(x + "," + y);
				houses[x--][y]++;
			} else {
				System.out.println("Invalid input");
			}
		}
		
		for(int i = 0; i < 1000; i++) {
			for(int j = 0; j < 1000; j++) {
				if(houses[i][j] > 0) {
					total++;
				}
			}
		}
		return total;
	}
}