/**
 * Challenge 3: A Custodian problem
 * 
 * A custodian is a financial institution that holds clients' assets for safekeeping so as to minimize
 * the risk of their theft or loss. The Custody Department has the capacity to store a certain number
 * of assets from different clients and of course some clients pay better then others, so deciding
 * which clients to prioritize is crucial in order to maximize the benefit. The department has a budget
 * that cannot exceed; ideally as much of the available budget as possible should be used.
 * 
 * Write a program that takes as input the available budget and calculates the combination of clients
 * that delivers the highest benefit without exceeding the initial given budget.
 * 
 * The result must be given as a JSON list containing the list of selected clients and the total 
 * benefit of the solution.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

//https://stackoverflow.com/questions/9560600/java-no-enclosing-instance-of-type-foo-is-accessible
public class challenge3 {		
	public static void main(String[] args) {
		//Getting user input
		Scanner sc = new Scanner(System.in);
		int budget = Integer.parseInt(sc.nextLine());
		sc.close();
		
		//Creating ArrayList of potential clients
		ArrayList<Client> potentialClients = new ArrayList<>();
		potentialClients.add(new Client(1, 11, 3));
		potentialClients.add(new Client(2, 10, 2));
		potentialClients.add(new Client(3, 7, 8));
		potentialClients.add(new Client(4, 5, 1));
		potentialClients.add(new Client(5, 4, 1));
		potentialClients.add(new Client(6, 30, 7));
		potentialClients.add(new Client(7, 15, 4));
		potentialClients.add(new Client(8, 3, 6));
		Collections.sort(potentialClients); // Sorting clients according to benefit
		
		//Selecting clients
		HashSet<Integer> selectedClients = new HashSet<>(); 
		int totalBenefit = 0, i = potentialClients.size() - 1;
		
		//While we have not exceeded the budget and there are still clients to check
		while((budget > 0) && (i > 0)) {
			if(potentialClients.get(i).getCost() <= budget) {
				selectedClients.add(potentialClients.get(i).getName());
				budget -= potentialClients.get(i).getCost();
				totalBenefit += potentialClients.get(i).getBenefit(); 
			}
			i--;
		}
		
		//Creating and printing JSON object
		JSONObject obj = new JSONObject();
		try {
			obj.put("clients", selectedClients);
			obj.put("benefit", totalBenefit);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(obj);
		potentialClients.clear(); //Cleanup
		selectedClients.clear(); //Cleanup
	}
}
