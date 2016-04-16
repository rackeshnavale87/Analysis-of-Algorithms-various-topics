#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int kmp(char *Tstring, int TstrSize,char *Substring, int SubSize)
{
	int k = 0,i = 0;
//-----------------------------------------------------------------------
	int *PmatchT = malloc(sizeof(int)*SubSize);
	if (!PmatchT)
		return (-1);
	else
	{
		PmatchT[0] = -1;
		PmatchT[1] = 0;
		for (i = 1; i < SubSize-1; i++) 
		{
			while (k > 0 && Substring[i] != Substring[k])
				k = PmatchT[k];
			if (Substring[i] == Substring[k])
				k++;
			PmatchT[i+1] = k;
		}
	}
		for (i = 0; i < SubSize; i++) 
		{
			printf(" %c",Substring[i]);
		}
		printf("\n");
		for (i = 0; i < SubSize; i++) 
		{
			printf("%d ",PmatchT[i]);
		}
		printf("\n");

//-----------------------------------------------------------------------
	k = 0;
	for (i = 0; i < TstrSize; i++) 
	{
		while (k > 0 && Substring[k] != Tstring[i])
			k = PmatchT[k];
		if (Tstring[i] == Substring[k])
			k++;
		if (k == SubSize) 
		{
			free(PmatchT);
			return (i-(k-1));
		}
	}
	free(PmatchT);
return -1;
}
//-----------------------------------------------------------------------
//-----------------------------------------------------------------------
int main(int argc, const char *argv[])
{
	char Tstring[] = "abcdabcdabcdabcdxyxz";
	char *ch = Tstring;
	char Substring[] = "abcdx";
	int index;
	index = kmp(Tstring, strlen(Tstring), Substring, strlen(Substring));
	if (index >= 0)
	{
		printf("Substring matched at index \"[%d]\" of given string as : '%s'%s\n",index,Substring, ch + (index+strlen(Substring)));
		return 0;
	}	
	else
	{
		printf("Substring NOT found\n");
		return 1;
	}
}
