import java.util.ArrayList;
import java.io.*; 
import java.util.*; 

public class Lab9 

{
	public static void main(String args[])
	{
		/*ScalesSolution s = new ScalesSolution("00000");
		s.println();
		s.SmallChange();
		s.println();*/
		/*ScalesSolution s1 = new ScalesSolution(10);
		s1.println();
		ScalesSolution s2 = new ScalesSolution(s1.GetSol());
		s2.println();
		*/
		ArrayList<Double> array = new ArrayList<Double>(); 
		array.add(1.0);// 1st parameter, weights in array
		array.add(2.0);
		array.add(3.0);
		array.add(4.0);
		array.add(10.0);
		RMHC(array, 50);// 2nd parameter number of iterations to run for.

	}
	public static ScalesSolution RMHC(ArrayList<Double> weights,int iter)
	{
		ScalesSolution bestSol = null;
		ScalesSolution mutatedsol = new ScalesSolution(weights.size());//Creates initial random solution //MODIFIED
		if (weights.isEmpty()) 
		{
			return null;//Returning null if the array is empty
		}
		else 
		{
			for (int i = 0; i < iter; i++) //specified iterations iter
			{
				System.out.print("Iteration " + (i+1) + ": ");// +1 to correct iterations as iter always starts at 0
				bestSol = new ScalesSolution(mutatedsol.GetSol());	  //Save previous iter
				bestSol.println();
	    	
				mutatedsol.SmallChange();//Mutation
				System.out.print("Mutated Solution: ");
				mutatedsol.println();
				if (mutatedsol.ScalesFitness(weights) < bestSol.ScalesFitness(weights)) //If the mutated change is better than the current best fitness 
				{
					double NewFitness = mutatedsol.ScalesFitness(weights);
					System.out.print("MUTATED SOLUTION IS BETTER: ");
					mutatedsol.println();
					System.out.println("Fitness is: " + NewFitness);
					bestSol = new ScalesSolution(mutatedsol.GetSol());//Makes mutated Solution the best solution so can loop.
				}
				else
				{
					double OldFitness = bestSol.ScalesFitness(weights);
					System.out.print("THE OLD SOLUTION IS BETTER: ");
					bestSol.println();//Returns the Current Solution if the new fitness is worse than old.
					System.out.println("Fitness is: " + OldFitness);
					mutatedsol =  new ScalesSolution(bestSol.GetSol());//Takes the Current/Best solution and makes it mutated. So in the for loop mutated becomes best.
				}	
			}	
			return (bestSol);//Returns new fitness if better than the old.
		}
	}

}
