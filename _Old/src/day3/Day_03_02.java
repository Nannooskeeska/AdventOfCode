package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Day_03_02 {
	
	final static char NORTH = '^';
	final static char SOUTH = 'v';
	final static char EAST = '>';
	final static char WEST = '<';
	static int[][] houses = new int[1000][1000];
	static int santaX = 500;
	static int santaY = 500;
	static int roboX = 500;
	static int roboY = 500;

	public static void main(String[] args) {
		
		houses[500][500] += 2;
		
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
		
		// Santa: even, Robo: odd
		for(int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if(c == NORTH) {
				if(i == 0 || i % 2 == 0) {
					houses[santaX][santaY++]++;
				} else {
					houses[roboX][roboY++]++;
				}
			} else if(c == SOUTH) {
				if(i == 0 || i % 2 == 0) {
					houses[santaX][santaY--]++;
				} else {
					houses[roboX][roboY--]++;
				}
			} else if(c == EAST) {
				if(i == 0 || i % 2 == 0) {
					houses[santaX++][santaY]++;
				} else {
					houses[roboX++][roboY]++;
				}
			} else if(c == WEST) {
				if(i == 0 || i % 2 == 0) {
					houses[santaX--][santaY]++;
				} else {
					houses[roboX--][roboY]++;
				}
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