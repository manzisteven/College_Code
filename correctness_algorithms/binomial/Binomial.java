package assignment2.binomial;

import edu.cmu.rwanda.correctness.*;

/** A class for computing bionomial coefficients using iterative and recursive algorithms 
along with their partial and total correctness **/
public class Binomial {
	static Assertions myAssert = new BinomialAssertion();
	
	/** The iterative version of binomial coefficients computation 
	 @param n the upper binomial index 
	 @param k the lower binomial index **/
	public static int binomialIterative (int n, int k) throws AssertionException {
		myAssert.newEnvironment();
		myAssert.declare("n",n);
		myAssert.declare("k",k);
		//Check that n and k >0
		myAssert.assertCompare(1,"n",0);
		myAssert.assertCompare(1,"k",0);
		// This variable will store intermidiate results inside the while loop below 
		int result = 1;
		myAssert.declare("result",result);
		/** J and i are key variables of this iterative version of binomial coefficients computation. The initial values
		 of these variables were determined after investigating the pattern in calculating binomial coefficients. During my investigation I found out that for 
		  any given binomial indices (n,k), n will vary from n to (n-k)+1 and k will vary from k to 1. Let's use an example to clarify this, assume we are given to 
		  compute binomial coefficients whose upper and lower indices are n and k respectively. According to the identified pattern, we can confidently say that the binomial 
		  coefficient will be 6*5*4*3/4*3*2*1. So as a general rule of thumb regarding the identified pattern, for any given n and k the corresponding binomial coefficient 
		  can be computed as follows n*n-1*....*(n-k)+1/k*k-1*.....k. To compute the binomial coefficient in this program we set j to 1 and it will vary from one to k, then i was set to (n-k)+1 and it will vary up to n. My decision to use these initial values for i and j was dictated by the 
		  discussed formula for calculating binomial coefficients using the identified pattern. in math, we know that multiplication is commutative that is to say a*b = b*a. So in the program we implemented our formula from right to the left in this form 
		  (n-k)+1/1..........n/k. This was done inside a while loop and for each iteration I stored the results in an intermidiate variable which will hold the desired binomial coefficient when the loop exits. The rationale behind this reasoning is to show partial and total correctness. for each iteration in the while loop we are 
		  are moving closer to the desired binomial coefficient. Fortunately, in this case we are moving in ascending order towards the goal. This formula is much better than the usual way of calculating binomial coefficients using factorial, since it can work for any given binomial indices.                   **/
		int j = 1;
		int i = n-k+1;
		myAssert.declare("i",i);
		myAssert.declare("j",j);
		// An array to hold n and k
		int  [] b= new int []{n,k};
		while (j<=k)
		{
			/**My loop invariant uses the groundTruth method to calculate the  binomial coefficient using the formula discussed above. for each iteration i and j are passed to 
			 * the groundTruth method as arguments. so the loop invariant is result = result*i/j                **/
			result = result*i/j;
			myAssert.update("result",result);
			// an array to hold i and j
			int  [] a= new int []{i,j};
			myAssert.loopInvariantEquals("result",( myAssert.groundTruth(a)));
			
			/** To check the progression towards the goal, I passed n and k to groundTruth as arguments and in this case the groundTruth 
			  method will return the desired binomial coefficient **/
			
			myAssert.isProgressIterative("result",( myAssert.groundTruth(b)));
            /** For each iteration, i is incremented by one and the loop will exit when it is equal to n. j is the loop guard, 
              it is incremented by one up to the value of k            **/
			j++;
			i++;
			myAssert.update("i",i);
			myAssert.update("j",j);
		}
		// After exiting the loop, I checked the computed binomial coefficient against the groundTruth
		myAssert.assertEquals("result",( myAssert.groundTruth(b)));
		// we need to indicate to our assertions system that we are about to leave the current environment
		myAssert.leaveEnvironment();

		return result;
	}	
	
	/** The recursive version of binomial coefficients computation 
	 @param n the upper binomial index
	 @param k the lower binomial index **/
	public static int binomialRecursive (int n, int k) throws AssertionException {
		myAssert.newEnvironment();
		myAssert.declare("n",n);
		myAssert.declare("k",k);
		// This variable stores intermidiate results and will in the end hold the desired binomial coefficient
		int result2 =0;
		/** The recursive version uses the formula discussed above, I took advantage of the fact that n varies up 
		  to (n-k)+1 and is actually incremented by one up to this bound. k has the same variation pattern, it varies from k to one and is decremented by one up 
		  to this bound. with this variation, it's easy to do a recursive-based implementation of our formula. All I did is to implement the formula in this form
		  n/k*binomialRecursive(n-1, k-1) and the binomialRecursive function will return when k=0
		                             **/
      if (k==0)
	  {
		  return 1;
	  }
      else
      {
	   result2 = (n*binomialRecursive(n-1, k-1))/k;
	  myAssert.declare("result2",result2);
	  // An array to hold n and k
	  int  [] c= new int []{n,k};
	  
	  /**for the recursive version, the loop invariant is the same as that of the iterative version (result = result*i/j )
	   but in this case I passed n and k to the groundTruth function as arguments.                                **/
	  myAssert.loopInvariantEquals("result2",( myAssert.groundTruth(c)));
	  if (k>1)
	  {
		// To check progression towards the goal, I passed n and k to the groundTruth function as arguments
	  myAssert.isProgressRecursive("result2",myAssert.get("goal"));
	  }
	  myAssert.leaveEnvironment();
	 return result2;
      }
	}

	public static int binomial(int n, int k) {
		int result = -1;
		int d [] = new int [] {n,k};
		try {
			result = binomialIterative(n,k);
			myAssert.declareGlobal("goal",( myAssert.groundTruth(d)));
			result = binomialRecursive(n,k);
			myAssert.evaluate();
		} catch (AssertionException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		Binomial.binomial(7,6);
	}
}