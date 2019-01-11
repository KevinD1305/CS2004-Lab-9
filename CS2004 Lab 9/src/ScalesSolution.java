import java.util.ArrayList;
import java.util.Random;

public class ScalesSolution
{
	private String scasol;
	
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)

	public ScalesSolution(String s)
	{
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n;++i)
		{
			char si = s.charAt(i);
			if (si != '0' && si != '1') ok = false;
		}
		if (ok)
		{
			scasol = s;
		}
		else
		{
			scasol = RandomBinaryString(n);
		}
	}
	private static String RandomBinaryString(int n)
	{
		String s = new String();
		
		//Code goes here
		//Create a random binary string of just ones and zeros of length n
		for(int i = 0; i < n; ++i)
		{
	        s = s + String.valueOf(CS2004.UI(0,1));
		}	
		
		System.out.println(s + " This is the random string generated!");

		return s;
	}
	public ScalesSolution(int n) 
	{
		scasol = RandomBinaryString(n);	
	}
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution
	
	public double ScalesFitness(ArrayList<Double> weights)
	//Code goes here
	//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
	//to variables lhs and rhs as appropriate
	{		

		if (scasol.length() > weights.size()) return(-1);
		
		double lhs = 0.0,rhs = 0.0;
		int n = scasol.length();
		for(int i=0;i<n;++i)
		{
			char c = scasol.charAt(i);
			if (c == '0')
			{
				lhs = lhs + weights.get(i);	
			}
			else
			{
				rhs = rhs + weights.get(i);
			}
		}
		return(Math.abs(lhs-rhs));
	}	
	//Display the string without a new line
	public void print()
	{
		System.out.print(scasol);
	}
	//Display the string with a new line
	public void println()
	{
		print();
		System.out.println();
	}
	public void SmallChange(int n)
	{

		Random p = new Random();
		int answer = p.nextInt(10 + (n-1) + 1) + 1;
		ArrayList<String> ar = new ArrayList<String>();
		ar.add(scasol);
		
	}

}