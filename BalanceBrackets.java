//TC: O(n)
//SC: O(n)

import java.util.*;
//([])(){}(())()()
class Program {
  public static boolean balancedBrackets(String str) {
    // Write your code here.
		if(str == null || str.equals("")) return false;
		Stack<Character> stack = new Stack<Character>();
		List<Character> charList = new ArrayList<Character>(){
			
			{
				add('{');
				add('}');
				add('[');
				add(']');
				add('(');
				add(')');
			}
		};
		stack.add(str.charAt(0));
		for(int i = 1; i < str.length(); i++) {
			if(!charList.contains(str.charAt(i))) {
				continue;
			}
			if(stack.isEmpty()) {
				stack.push(str.charAt(i));
			}
			else  {
				char valueOnTopOfStack = stack.peek();
				if((valueOnTopOfStack == '(' && str.charAt(i) == ')')
					|| (valueOnTopOfStack == '[' && str.charAt(i) == ']')
					|| (valueOnTopOfStack == '{' && str.charAt(i) == '}')) {
					stack.pop();
				} else {
					stack.push(str.charAt(i));
				}
			} 
		}
    return stack.isEmpty();
  }
}
