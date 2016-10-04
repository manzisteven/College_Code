package assignment2.sum;

import edu.cmu.rwanda.correctness.*;

/** A class for computing the sum of elements of an array along with their partial and total correctness **/
public class Sum {
	static Assertions myAssert = new SumAssertion();
	
	/**  @param a array passed as arguments **/
	public static int sum(int[] a) throws AssertionException {
		myAssert.newEnvironment();
		// This variable stores intermidiate results and it will in the end hold the total sum 
		int sum =0;
		myAssert.declare("sum",sum);
		/** The variable b is an identifier for an array declared to be of the same size as the array whose elements are to be summed up. This variable serves as the loop invariant,
		 for each iteration the element at the current index is added to the array. The array b expands as the program computes the sum of array elements and the same array is 
		 passed to the groundTruth function as argument, the groundTruth function returns the sum of the currently computed elements of array**/
		int  [] b = new int [a.length];
		myAssert.declare("b",b);
		for (int i=0; i<a.length;i++)
		{
			sum+=a[i];
			b[i] = a[i];
			myAssert.update("sum",sum);
			myAssert.loopInvariantEquals("sum",( myAssert.groundTruth(b)));
			/** To check progression towards the goal, a is passed to the groundTruth function as arguments and 
			 the groundTruth function returns the total sum of array elements             **/
			myAssert.isProgressIterative("sum",( myAssert.groundTruth(a)));
		}
		// when the loop exits, I checked the result against the groundTruth
		myAssert.assertEquals("sum",( myAssert.groundTruth(a)));
		// we need to indicate to our assertions system that we are about to leave the current environment
		myAssert.leaveEnvironment();
		return sum;
	}
	

	public static int evalSum(int[] a) {
		int result = 0;
		try {	
			result = sum(a);
			myAssert.evaluate();
		} catch (AssertionException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
		Sum.evalSum(new int[] {3,6,3,34,2});
	}
}