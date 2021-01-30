/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Stack;

public class Main {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      // 'true' and 'false' were being labelled incorrect.
      if(isWellFormed(line)) System.out.print("True");
      else System.out.print("False");
    }
  }
  
  public static boolean isWellFormed(String str){
      // Storing delimiters for easy reference
      HashMap<Character, Character> delimiters = new HashMap<Character, Character>();
      delimiters.put('(', ')');
      delimiters.put('[', ']');
      delimiters.put('{', '}');
      
      // Stack to track delimiters and check if they are matching
      Stack<Character> stack = new Stack<Character>();
      
      for(int i = 0;i < str.length();i++){
        if(delimiters.keySet().contains(str.charAt(i))) stack.push(str.charAt(i));
        else if(delimiters.values().contains(str.charAt(i))){
          if(!stack.empty() && delimiters.get(stack.peek()) == str.charAt(i)) stack.pop();
          else return false;
        }
      }
      
      return stack.empty();
    }
}