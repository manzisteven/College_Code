package assignment2.sum;

import edu.cmu.rwanda.correctness.*;


public class SumAssertion extends Assertions {

	
	class SumComparator extends InternalComparator {
		public int compare(Object o1, Object o2) {
			return 0;
		}
	}
	

	public void initComparator() {
		setComparator(new NumberComparator ());
	}
	
	/** The groundTruth function takes an array as argument and computes the sum of its elements                **/
	public Object groundTruth (Object obj) {
		int[] a = ((int[]) obj).clone(); 
		int  sum = 0;
	      for (Integer i=0; i< a.length;i++)
	      {
	    	  sum+= a[i];
	      }
	      return sum;
	}
	}
