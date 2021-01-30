/**
 * A happy number is defined by the following process: Starting with any positive integer, 
 * replace the number by the sum of the squares of its digits in base-ten, and repeat the 
 * process until the number either equals 1 (where it will stay), or it loops endlessly in 
 * a cycle that does not include 1. Those numbers for which this process ends in 1 are happy 
 * numbers, while those that do not end in 1 are unhappy numbers (or sad numbers).
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      System.out.println(isHappyNumber(Integer.parseInt(line)));
    }
  }
  
  /**
   * Function to determine if a number is a happy number
   */
  public static boolean isHappyNumber(int num){  
    HashSet<Integer> sequence = new HashSet<Integer>();
      while (!sequence.contains(num)) {
        sequence.add(num);
        num = sumSquaresDigits(Integer.toString(num));
        if (num == 1) return true;
      }
      return false;
  }

  // Helper function to get squares of digits
  public static int sumSquaresDigits(String digits){
	  int sum = 0;
    for(int i = 0;i < digits.length();i++){
      sum += Character.getNumericValue(digits.charAt(i)) * Character.getNumericValue(digits.charAt(i));
    } 
    return sum;
  }

  

  
}
