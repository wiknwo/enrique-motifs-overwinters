/**
 * Challenge 4: Evaluating companies
 * 
 * We define default as the failure to repay a loan to someone(individual or entity)
 * The Rating department receives a daily feed containing the Default Estimation Value (DEV)
 * associated to each of the clients the company lends money to. 
 * 
 * A low DEV (<10) indicates very low default risk. While 1 is the min value, the upper limit
 * is not bounded so, higher the DEV the higher the risk. DEV values are not clear but encoded
 * using a custom notation. Having the encrypted string, the unencrypted DEV can be obtained 
 * using the following rules:
 * 
 * 		1. ()	When () is given no arguments, it evaluates to 1
 * 				When () is given 1 or more arguments, it evaluates to the max value of the arguments
 * 
 * 		2. []	When [] is given no arguments, it evaluates to 2
 * 				When [] is given 1 or more arguments, it evaluates to the sum of the arguments
 * 
 * 		3. <>	When <> is given no arguments, it evaluates to 3
 * 				When <> is given 1 or more arguments, it evaluates to 2 * (1 + sum of the arguments)
 *
 * Given an encrypted DEV string as input, calculate and print its numerical value. You can 
 * assume the input string is correctly formatted with balanced brackets and no spaces.
 * 
 * ex. <()[]<>> -> 2 * (1 + sum(2,1, 2, 3)) = 14
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;


public class challenge4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String encryptedDEV = sc.nextLine();
		sc.close();
		Stack<String> delimiters = new Stack<>();
		int flag = -1; // 0 = push, 1 = pop
		ArrayList<Integer> arguments = new ArrayList<>();
		
		//Decrypting DEV
		for(int i = 0;i < encryptedDEV.length();i++) {
			if( (encryptedDEV.charAt(i) == '(') || (encryptedDEV.charAt(i) == '[') || (encryptedDEV.charAt(i) == '<') ) {
				delimiters.push(String.valueOf(encryptedDEV.charAt(i)));
				flag = 0;
			} else if( (encryptedDEV.charAt(i) == ')') || (encryptedDEV.charAt(i) == ']') || (encryptedDEV.charAt(i) == '>') ) { 
				//
				String openingBracket = delimiters.pop();	
				//Previous operation was a pop, count arguments
				if(flag == 1) {
					int tmp = 0;
					if(openingBracket.equals("(")) {
						tmp = Collections.max(arguments);
						arguments.clear();
						arguments.add(tmp);
					}
					
					else if(openingBracket.equals("[")) {
						tmp = 0;
						for(Integer arg : arguments) tmp += arg;
						arguments.clear();
						arguments.add(tmp);
					}
					
					else if(openingBracket.equals("<")) {
						tmp = 0;
						for(Integer arg : arguments) tmp += arg;
						arguments.clear();
						arguments.add(2 * (1 + tmp));
					}
					
					flag = 1;
				} 
				
				//Previous operation was a push
				else {
					if(openingBracket.equals("(")) arguments.add(1);
					else if(openingBracket.equals("[")) arguments.add(2);
					else if(openingBracket.equals("<")) arguments.add(3);
					flag = 1;
				}
			}
		}
		
		//Print DEV
		System.out.println(arguments.get(0));
	}
}
