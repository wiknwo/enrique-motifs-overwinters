/**
 * Challenge 5: Encrypt trade order inside IBAN codes
 * 
 * In order to supply trading orders to our trading team without comprising the orders we
 * need to make them look like standard bank statements and nothing less suspicious than
 * regular IBAN accounts.
 * 
 * A valid IBAN code following the standard must contain the following sections:
 * 
 * 1)	2-letters country-code e.g.:
 * 			BE(Belgium)
 * 			IE(Ireland)
 * 			FR(France)
 * 			DE(Germany)
 * 			GR(Greece)
 * 			RO(Romania)
 * 
 * 2)	2-digits for validation purposes
 * 
 * 3)	Bank account number: up to 30 alphanumerical characters(no spaces)
 * 
 * Ex. DE00 1234 5678 9111 (characters are usually displayed in groups of four clarity, the
 * space just serves representation purposes.)
 * 
 * The trade orders we need to send have the following format (space-separated order, positive
 * quantity and stock string).
 * 
 * 		BUY 200 IBM (buy 200 IBM shares)
 * 		SELL 100 TSLA (sell 100 Tesla shares)
 * 
 * Write a program to encrypt a trade order as a valid IBAN code. In order to convert the string
 * characters to numbers we will use their ASCII code shifed a certain number of positions.
 * Caesar Cypher.
 * 
 * Country code and check section can be randomly assigned. Ex. DE02 6786 9033 5049 4933 8584 7766
 *
 */
import java.util.Scanner;

public class challenge5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] tradeOrder = sc.nextLine().split("");
		int shift = sc.nextInt(); //Caesar Cypher shift value
		sc.close();
		
		//Encrypting trading order to IBAN
		String iban = "";
		int tmp = 0;
		for(int i = 0;i < tradeOrder.length;i++) {
			tmp = tradeOrder[i].charAt(0) + shift;
			//if(tmp > 90) tmp -= 26; //Keep ascii in range 65 - 90
			iban += tmp;
			if(i % 2 == 1) iban += " ";
		}
		
		//Print IBAN code
		iban = "DE02 " + iban.substring(0);
		System.out.println(iban);
	}
}
