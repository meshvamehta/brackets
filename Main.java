import java.util.Stack;

/*
	This program checks whether a string of brackets are correctly nested or not
*/
/* 
   Some Simple Test Cases
   So given S = "[{()}]" the method should return true
   But given for example S = "[{)}]" should return false
   Also S = "[{(})]" should return false
   
   Task Approach
   the simple way to do this task would be to iterate over the string
   and put each "opening" bracket into a queue, once you encounter a 
   "closing" bracket you need to check if it is the same as the last 
   open bracket on the queue, if it is then you continue, if not the 
   the string does not properly nested. Also you must continue till you
   reach the end of the string, and also make sure that the open bracket
   queue is also empty, that is, no open brackets were left unclosed.
*/
public class Main {
	
	public static void main(String[] args) {
		System.out.println(solution("([)()]"));
	}
	
	public static int solution(String S) {
		/*
			We use a stack to keep track of our 'open' brackets, once we find a closing bracket
			and it is the correct closing bracket corresponding to the last open bracket on the stack
			then we pop the last open bracket from the stack, if the close bracket is incorrect then 
			we know the string is not correctly nested.
		*/
		
		Stack<Character> open = new Stack<Character>();
		
		char bracket = '(';
		char brace = '{';
		char square = '[';
		
		char[] string = S.toCharArray();
		
		for (int n = 0; n < string.length; n++) {
			if (string[n] == bracket || string[n] == brace || string[n] == square) {
				open.push(string[n]);
			} else {
				char last = (char) open.peek();

				if (last == '(' && string[n] == ')') {
					open.pop();
				} else if (last == '{' && string[n] == '}') {
					open.pop();
				} else if (last == '[' && string[n] == ']') {
					open.pop();
				} else {
					return 0;
				}
				
			}
		}
		
		return 1;
	}
}
