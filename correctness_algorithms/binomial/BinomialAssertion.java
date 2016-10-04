package assignment2.binomial;

import edu.cmu.rwanda.correctness.*;

/** Please write documentation. **/
public class BinomialAssertion extends Assertions {
	/** Please write documentation. **/
	public void initComparator() {
		setComparator(new NumberComparator());
	}
	/** The groundTruth function takes two arguments. To implement this function we used the formula for calculating 
	 binomial coefficients discussed in the binomial.java file **/
	public Object groundTruth (Object obj) {
		int[] a = ((int[]) obj).clone();
		 
		int i = (a[0] - a[1])+1;
		int j =1;
		int result =1;
		while (j<=a[1])
		{
			result = (result*i)/j;
			i++;
			j++;
		}
		return result;
		
		
	}
	}
