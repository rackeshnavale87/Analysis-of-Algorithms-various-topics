package pkg;

/* package whatever; // don't place package name! */

class Median_Of_Two_Sorted_Arrays 
{
	public static void main(String[] args) 
	{
		// Note: These are sorted arrays and are of equal length.
		int[] array1 = {1, 3, 5, 7, 9, 11}; // median is 6
		int[] array2 = {2, 4, 6, 8, 10, 12};

		int median = getMedianOfTwoArrays(array1, array2);
		System.out.println("Median is: " + median);
	}

	static int getMedianOfTwoArrays(int[] array1, int[] array2) 
	{
		int index1 = array1.length/2;
		int index2 = array2.length/2;

		int m1 = array1[index1];
		int m2 = array2[index2];

		if(m1 == m2) 
		{
			return m1;
		} 
		else 
		{
			return findMedian(array1, array2, 0, array1.length - 1, 0, array2.length - 1);
		}
	}

	static int findMedian(int[] array1, int[] array2,int low1, int high1,int low2, int high2) 
	{
		// termination condition
		// System.out.println("low1: " + low1 + "\thigh1: " + high1 + "\tlow2: " + low2 + "\thigh2: " + high2);

		int length = high1 - low1 + 1;
		
		if(length==1)
		{
			return ((array1[0]+array2[0])/2);
		}
		
		if(2 == (high1 - low1 + 1) && 2 == (high2 - low2 + 1)) 
		{
			return (Math.max(array1[low1], array2[low2]) + Math.min(array1[high1], array2[high2]))/2;
		}

		int m1 = median(array1, low1, high1);
		int m2 = median(array2, low2, high2);
		// System.out.println("Median-1: " + m1 + "\t Median-2: " + m2 + "\n");

		int low11 = 0;
		int high11 = 0;
		int low12 = 0;
		int high12 = 0;

		if(m1 == m2) 
		{
			return m1;
		} 
		else if(m1 > m2) 
		{
			if(length % 2 == 0) 
			{
				low11 = low1;
				high11 = high1 - length/2 + 1;
				low12 = low2 + length/2 - 1;
				high12 = high2;	
			} 
			else 
			{
				low11 = low1;
				high11 = high1 - length/2;
				low12 = low2 + length/2;
				high12 = high2;
			}
			return findMedian(array1, array2, low11, high11, low12, high12);
		} 
		else 
		{
			if(length % 2 == 0) 
			{
				low11 = low1 + length/2 - 1;
				high11 = high1;
				low12 = low2;
				high12 = high2 - length/2 + 1;
			} 
			else 
			{
				low11 = low1 + length/2;
				high11 = high1;
				low12 = low2;
				high12 = high2 - length/2;
			}
			return findMedian(array1, array2, low11, high11, low12, high12);
		}
	} // method

	static int median(int[] array, int low, int high) 
	{
		if((low + high) % 2 == 0) 
		{
			return array[(low + high) / 2];
		} 
		else 
		{
			int mid = (low + high)/2;
			return (array[mid] + array[mid - 1])/2;
		}
	}

}
