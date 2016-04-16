package pkg;

public class KMP_Substring_Algorithm
{

	public static void main(String[] args) 
	{
		String T = "ababa";
		String P = "aba";
		
		System.out.println("Text    : "+T);
		System.out.println("Pattern : "+P);
		
		KMP(T,P);
		
	}

	private static void KMP(String T, String P) 
	{
		int n = T.length();
		int m = P.length();
		
		int[] prefix = computPrefix(P);
		int k = 0;
		
		for(int i=0; i<n; i++)
		{
			while(k>0 && P.charAt(k)!=T.charAt(i))
			{
				k = prefix[k];
			}
			
			if(P.charAt(k) == T.charAt(i))
			{
				k++;
			}
			if(k == m)
			{
				System.out.println("Pattern occures with shift s: "+(i-m+1));
				k = prefix[k-1];
			}
		}
	}

	private static int[] computPrefix(String P) 
	{
		int m = P.length();
		int[] prefix = new int[m];
		prefix[0]=0;
		prefix[1]=0;
		int k = 0;

		for(int i = 1; i<m; i++)
		{
			while(k>0 && P.charAt(k) != P.charAt(i))
			{
				k = prefix[k];
			}

			if(P.charAt(k)==P.charAt(i))
			{
				k++;
			}
			prefix[i] = k;
		}
		return prefix;
	}
}
