import java.util.*;
import java.io.*;

class Parser {
	
	static Stack<Character> st = new Stack<Character>();
	static ArrayList<Table> productions = new ArrayList<Table>();
	static boolean found = false;
	
	public static void main(String[] args)
	{
		productions.add(new Table('A', 'i', "CB"));
		productions.add(new Table('B', '+', "+CB"));
		productions.add(new Table('B', '$', "#"));
		productions.add(new Table('C', 'i', "ED"));
		productions.add(new Table('D', '+', "#"));
		productions.add(new Table('D', '*', "*ED"));
		productions.add(new Table('D', '$', "#"));
		productions.add(new Table('E', 'i', "i"));
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input to be checked : ");
		String input = sc.next();
		
		st.push('$');
		st.push('A');
		
		for(int i = 0; i < input.length(); )
		{
			char stTop = st.peek();
			System.out.println("stack top : " + stTop);
			found = false;
			char ch = input.charAt(i);
			System.out.println("input : " + ch);
			
			if(stTop == '$' && ch == '$')
			{
				System.out.println("Input is valid");
				found = true;
				break;
			}
			
			if(stTop == '#')         //if epsilon occurred, pop it
			{
				st.pop();
				continue;
			}
			
			for(int j = 0; j < productions.size(); j++)
			{
				Table t = productions.get(j);
				
				if(t.getRow() == stTop && t.getCol() == ch)
				{
					found = true;
					String prod = t.getProd();
					System.out.println("Popping : " + stTop);
					st.pop();
					
					for(int k = prod.length()-1; k >= 0; k--)
					{
						System.out.println("Pushing : " + prod.charAt(k));
						st.push(prod.charAt(k));
					}	
					
					break;	
				}
			}
			
			System.out.println("Found is now : " + found);
			
			if(stTop == input.charAt(i))
			{
				System.out.println("Popping due to input match : " + stTop);
				found = true;
				st.pop();
				i++;
			}
			
			if(!found)
			{
				System.out.println("Input is not valid");
				break;
			}
		}
	}
}


