import java.util.*;
import java.io.*;

class LeftRecursion {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n, i=0, j=0, k=0;
		boolean flag = true;
		String left, right;
		System.out.println("Enter the number of productions : ");
		n = sc.nextInt();
		String productions[] = new String[n];
		String alpha = new String();
		System.out.println("Enter the productions : ");
		for(i = 0; i < n; i++)
		{
			productions[i] = sc.next();
		}
		
		for(i = 0; i < n; i++)
		{
			k = 0;
			flag = false;
			String split1[] = productions[i].split("->");
			left = split1[0];
			right = split1[1];
			String split2[] = right.split("\\|");
			String beta[] = new String[split2.length];
			
			for(String s : split2)
			{
				if(s.startsWith(left))
				{
					alpha = s.substring(1, s.length());
					flag = true;
				}
				else
				{
					beta[k++] = s;
					
				}
			}
			
			System.out.println("After removal of left recursion : ");
			if(flag)   //left recursion is present
			{
				System.out.print(left + "->");
				for(j = 0; j < k; j++)
				{
					System.out.print(beta[j] + left + "'|");
				}
				System.out.println();
				System.out.println(left + "'->" + alpha + left + "'" + "|e");
			}
			else    //left recursion not present
			{
				System.out.println(productions[i]);
			}
			
		}
	}
}
