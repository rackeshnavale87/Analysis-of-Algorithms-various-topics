package pkg;

public class RadixSort {
	public static void main(String[] args) {
		String[] strArray = {"CAT","DOG","SEA","RUG","ROW","MOB","BOX","TAB","BAR","EAR","TAR","DIG","BIG","TEA","NOW","FOX"};
		int d = 3;
		String[] B = new String[strArray.length];
		myradixSort(strArray, d, B);
		for(int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
	}

	private static void myradixSort(String[] strArray, int d, String[] B) {
		for(int i = d-1; i >=0; i--)
			insertionSort(strArray, i);
	}

	private static void insertionSort(String[] strArray, int pos) {  // d time called and performs O(n2) WORST CASE PERFORMANCE NO USE!!!!!
		for(int i = 1; i < strArray.length; i++) {
			for(int j = i; j > 0; j--) {
				if(strArray[j].charAt(pos) < strArray[j-1].charAt(pos)) {
					String temp = strArray[j];
					strArray[j] = strArray[j-1];
					strArray[j-1] = temp;
				}
			}
		}
	}
		
	private static void countingSort(String[] strArray, int length, int k, int pos, String[] B) // EXTRA SPACE but its LIENEAR COMPLEXITY!!!
	{
		int[] counts = new int[26];
		for(int i = 0; i<k; i++) {	
			counts[i] = 0;
		}
		for(int j = 0; j < length; j++) {
			B[j] = "";
			counts[(int)strArray[j].charAt(pos)%65]++;
		}
		for(int j = 1; j < counts.length; j++) {
			counts[j] = counts[j] + counts[j-1]; 
		}		
		for(int j = length-1; j >=0; j--) {
			int check = counts[((int)strArray[j].charAt(pos))%65];
			
			B[counts[(int)strArray[j].charAt(pos)%65]-1] = strArray[j];
			counts[(int)strArray[j].charAt(pos)%65]--;
		}
		for(int j = 0; j < length; j++)
		strArray[j] = B[j];
	}	
}
