/**
 * Client in our Custody department whose assets are being held.
 */
public class Client implements Comparable<Client> {
	//Attributes
	private int name;
	private int benefit;
	private int cost;
	
	//Constructor
	/**
	 * Clients are represented by name ids, costs and benefits
	 * associated with them.
	 * 
	 * @param name
	 * @param benefit
	 * @param cost
	 */
	public Client(int name, int benefit, int cost) {
		this.name = name;
		this.benefit = benefit;
		this.cost = cost;
	}
	
	//Helper methods
	/**
	 * Implementation of Comparable interface method
	 * @param other
	 */
	@Override
	public int compareTo(Client other) {
		return Integer.compare(this.costBenefitRatio(), other.costBenefitRatio());
	}
	
	/**
	 * Method to determine priority given to client.
	 * This method will be used in the compareTo
	 * implementation.
	 * 
	 * @return ratio
	 */
	private int costBenefitRatio() {
		return benefit - cost; 
	}
	
	//Accessors
	public int getBenefit() {
		return benefit;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getName() {
		return name;
	}
}
