import java.util.*;
import java.io.*;

class Quadruple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String postfix;
		System.out.println("Enter the postfix expression : ");
		postfix = sc.next();
		Stack<String> st = new Stack<String>();
		int i = 0;
		String result;
		int result_count = 0;
		System.out.println("Quadruple table for given postfix expression is : ");
		System.out.println();
		System.out.println("op\t" + "op1\t" + "op2\t" + "result");
		while(i < postfix.length())
		{
			char ch = postfix.charAt(i);
			if(Character.isLetterOrDigit(ch))
			{
				st.push(Character.toString(ch));
			
			}
			else if(ch == '*' || ch == '/' || ch == '+' || ch == '-')
			{
				String operand2 = st.pop();
				String operand1 = st.pop();
				result_count++;
				result = "t" + result_count;
				st.push(result);
				System.out.println(ch + "\t" + operand1 + "\t" + operand2 + "\t" + result);
			}
			i++;
		}
		
		
	}
}
