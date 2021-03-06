package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import day2.Box;

public class Day_05_01 {

	public static void main(String[] args) {
		int numTrue = 0;
		
		File file = null;
		BufferedReader br;
		try {
			// Go through lines and separate them
			file = new File("src/day5/input.txt");
			br = new BufferedReader(new FileReader(file));
			String line = null;  
			while ((line = br.readLine()) != null)  
			{
				System.out.println(line);
				if(checkString(line)) {
					numTrue++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(numTrue);
	}
	
	public static boolean checkString(String s) {
		int numVowels = 0;
		int numDoubles = 0;
		
		System.out.println("***** NEW LINE *****");
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// Check for vowels
			if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				numVowels++;
				System.out.println("Vowels:  \t" + numVowels);
			}
			
			// Check for two-letter sequences
			// Have to make sure that we don't go over the length
			if(i != s.length() - 1) {
				
				// Check for doubles
				if(s.charAt(i) == s.charAt(i + 1)) {
					numDoubles++;
					System.out.println("Doubles:\t" + numDoubles);
				}
				
				// Check for specific sequences
				if(		s.charAt(i) == 'a' && s.charAt(i + 1) == 'b' ||
						s.charAt(i) == 'c' && s.charAt(i + 1) == 'd' ||
						s.charAt(i) == 'p' && s.charAt(i + 1) == 'q' ||
						s.charAt(i) == 'x' && s.charAt(i + 1) == 'y') {
					System.out.println("false");
					return false;
				}
			}
		}
		
		// Check numbers and return
		// At least three vowels
		// At least one letter appears twice in a row
				// None of the specific strings: already checked
		if(numVowels >= 3 || numDoubles >= 1) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}
}