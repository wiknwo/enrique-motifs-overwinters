/**
 * Challenge 1: I love words, not binary
 * 
 * Given a binary matrix, and a string of letters, replace all 1's in the matrix from 
 * left to right with the letters of the string. Once the letters have been formed into
 * the shape of the matrix, print the matrix, replacing all 0's with dots.
 */
import java.util.Scanner;

public class challenge1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] binMatrix = sc.nextLine().split(" ");
		String str = sc.nextLine();
		int strIndex = 0;
		sc.close();
		
		
		//Replacing 1's with str chars and 0's with '.'
		for(int i = 0;i < binMatrix.length;i++) {
			if(binMatrix[i].equals("1")) {
				binMatrix[i] = String.valueOf(str.charAt(strIndex));
				strIndex = (strIndex + 1) % str.length();
			}
			else if(binMatrix[i].equals("0")) binMatrix[i] = ".";
		}
		
		//Printing binary matrix
		for(int i = 0;i < binMatrix.length;i++) {
			if(i % Math.sqrt(binMatrix.length) == 0) System.out.println("");
			System.out.print(binMatrix[i]);
		}
	}
}
