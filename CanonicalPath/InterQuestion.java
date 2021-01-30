/**
 * EXAMPLE
 * Path of the given file : path : ..\.\Java.txt 
 * absolute path : C:\Users\WINDOWS 8\workspace\Demo\..\.\Java.txt 
 * canonical path : C:\Users\WINDOWS 8\workspace\Java.txt 
 * 
 * Path of the parent file : path : ..\. 
 * absolute path : C:\Users\WINDOWS 8\workspace\Demo\..\. 
 * canonical path : C:\Users\WINDOWS 8\workspace
 */
import java.util.ArrayList;
import java.util.Scanner;

public class InterQuestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		sc.close();

		System.out.println("unixCanonicalPath: " + InterQuestion.unixCanonicalPath(path));
	}
	
	public static String unixCanonicalPath(String unixFilePath) {
		String[] tokens = unixFilePath.split("/");
		ArrayList<String> remainingTokens = new ArrayList<String>();
		String result = "";
		
		for(int i = 0;i < tokens.length;i++) {
			if(tokens[i].equals("..")) {
				if(!remainingTokens.isEmpty()) {
					remainingTokens.remove(remainingTokens.size() - 1);
				}
			}
			
			else if(!tokens[i].equals(".")) remainingTokens.add(tokens[i]);
		}
		
		for(int i = 0;i < remainingTokens.size();i++)
			result += "/" + remainingTokens.get(i);
		
		remainingTokens.clear();
		
		return result;
	}
}
