/**
 * Challenge 2: Buy and Sell trades
 * 
 * The Investment Department has an account with a certain balance (€) and for legal reasons we
 * must keep track of the buying and selling activity on that account. The trading orders are
 * received every 10 seconds and they are provided in the following format:
 * 
 * 	SELL=amount_in_euros (e.g. SELL=10000)
 * 	BUY=amount_in_euros (e.g. BUY=10000)
 * 
 * In some cases, a hold order is received which indicates that no operation is performed on the
 * account for the next 10 seconds. It has the following format (without parameters):
 * 
 * 	HOLD
 *
 * SELL orders increase the account balance (since some assets are sold) while BUY orders decrease
 * it (part of the balance is used to buy assets). HOLD order does not affect the account balance.
 * 
 * Given an initial account balance and a string containing a set of instructions, display the 
 * resulting account balance, the total time(in secs) of operations in the account, the number
 * of buy operations, sell operations and hold operations
 * 
 * RULES
 * 		1. The output must be a valid JSON string
 * 		2. If the incoming operation bring the account balance below 0 the program should stop
 * 		   immediately and append a field "error_at": val where val is the index of the invalid
 * 		   order.
 * 		3. Data inside instructions is not always consistent, (missing quantities, negative values)
 * 		   In those cases the program should stop and the output should contain the "error_at" field
 * 		   as well.
 * 		4. You can assume the instructions will be provided correctly separated by single spaces.
 * 		5. The program should be case-insensitive.
 * 
 */
import java.util.Arrays;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

//https://stackoverflow.com/questions/8997598/importing-json-into-an-eclipse-project
//https://www.tutorialspoint.com/json/json_java_example.htm
public class challenge2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int balance = Integer.parseInt(sc.nextLine());
		String tradingOrder = sc.nextLine();
		sc.close();
		String delims = "[ ,=]";
		String[] tokens = tradingOrder.split(delims);
			
		//Performing trading order rules on tokens.
		int buy_ops = 0, sell_ops = 0, hold_ops = 0, time = 0, error_at = -1;
		
		for(int i = 0;i < tokens.length;i++) {
			if(tokens[i].equalsIgnoreCase("HOLD")) {
				hold_ops++;
				time += 10;
			}
			
			else if(tokens[i].equalsIgnoreCase("BUY")) {
				buy_ops++;
				time += 10;
				//Missing or negative value
				if(tokens[i + 1].equals("") || tokens[i + 1].startsWith("-")) {
					error_at = i;
					break;
				}
				
				//Decrease the balance by the BUY amount
				else {
					balance -= Integer.parseInt(tokens[i + 1]);
					if(balance < 0) {
						error_at = i;
						break;
					}
				}
			}
			
			else if(tokens[i].equalsIgnoreCase("SELL")) {
				sell_ops++;
				time += 10;
				//Missing or negative value
				if(tokens[i + 1].equals("") || tokens[i + 1].startsWith("-")) {
					error_at = i;
					break;
				}
				
				else balance += Integer.parseInt(tokens[i + 1]);
			}
		}
		
		//Creating and printing JSON object
		JSONObject obj = new JSONObject();
		try {
			obj.put("balance", balance);
			obj.put("time", time);
			obj.put("buy_ops", buy_ops);
			obj.put("sell_ops", sell_ops);
			obj.put("hold_ops", hold_ops);
			if(error_at != -1) obj.put("error_at", error_at);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(tokens));
		System.out.println(obj);
	}
}
