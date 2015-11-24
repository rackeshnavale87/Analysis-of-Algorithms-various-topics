package pkg;

import java.util.Scanner;

class heap_t
{
	int count =0;
	int a[];
}

public class Median_Dynamic_Input 
{

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		heap_t min_heap = new heap_t();
		heap_t max_heap = new heap_t();
		min_heap.count = 0;
		max_heap.count = 0;
		min_heap.a = new int[100];
		max_heap.a = new int[100];
		
	    int choice,n,i;

	    do {
	        print_menu();
	        choice = scan.nextInt();

	        switch(choice)
	        {
	            case 1 :
	                System.out.println("Enter integer : ");
	                n = scan.nextInt();
	                add_integer(min_heap,max_heap,n);
	                break;

	            case 2 :
	            	System.out.print("Max heap  : ");
	                for(int i1 = 1; i1<=max_heap.count;i1++)
	                	System.out.print((max_heap.a[i1])+" ");
	                System.out.print("\nMin heap  : ");
	                for(int i1 = 1; i1<=min_heap.count;i1++)
	                	System.out.print((min_heap.a[i1])+" ");
	                print_median(min_heap, max_heap);
	                break;
	            case 3:
	            	System.out.println("Exiting...\n");
	                break;
	        }
	    }while(choice != 3);

	}

	private static void print_menu() 
	{
		System.out.println("\n\n1. Add integer");
		System.out.println("2. Median");
		System.out.println("3. Exit");
	}
	
	private static void print_median(heap_t min_heap, heap_t max_heap) 
	{
		if(min_heap.count == max_heap.count)
			System.out.println("\nMedian : "+((double)min_heap.a[1]+max_heap.a[1])/2);
		else{
	        if(max_heap.count > min_heap.count){
	        	System.out.println("\nMedian : "+max_heap.a[1]);
	        }
	        else{
	        	System.out.println("\nMedian : "+ min_heap.a[1]);
	        }
	    }
		
	}

	private static void add_integer(heap_t min_heap, heap_t max_heap, int value) 
	{
		insert_max(max_heap, value);
		int top=0;
		if(max_heap.count - min_heap.count >1 || (min_heap.count !=0 && max_heap.a[1] > min_heap.a[1] ) )
		{
			top = max_heap.a[1];
			delete_max(max_heap);
			insert_min(min_heap,top);
		}
		if(min_heap.count - max_heap.count >1 && min_heap.count !=0  )
		{
			top = min_heap.a[1];
			delete_min(min_heap);
			insert_max(max_heap,value);
		}
		
		
	}

	private static void delete_min(heap_t min_heap) 
	{
		if(min_heap.count ==0)
		{	
			System.out.println("Min_Heap is empty");
			return;
		}
		
		min_heap.a[1] = min_heap.a[min_heap.count--];
		min_heapify(min_heap.a, 1, min_heap.count);
		
	}

	private static void min_heapify(int[] a, int i, int len) 
	{
		int left, right, smallest = i;
		left = i*2;
		right = left+1;
		
		if(left <= len && a[smallest] > a[left])
			smallest = left;
		if(right <= len && a[smallest] > a[right])
			smallest = right;
		
		if(smallest != i)
		{
			swap(a, i, smallest);
			min_heapify(a, smallest, len);
		}		
	}

	private static void insert_min(heap_t min_heap, int value) 
	{
		if(min_heap.count > 100)
			System.out.println("Can not Insert into Min_Heap, Underlying data structure size.");
		else
		{
			min_heap.count++;
			min_heap.a[min_heap.count] = value;
			shift_up_min(min_heap, min_heap.count);
		}
	}

	private static void shift_up_min(heap_t min_heap, int i) 
	{
		int parent = i/2;
		if(i>1)
		{
			if(min_heap.a[parent] > min_heap.a[i])
			{
				swap(min_heap.a, parent, i);
				shift_up_min(min_heap, parent);
			}
		}
		
	}

	private static void delete_max(heap_t max_heap) 
	{
		if(max_heap.count ==0)
		{	
			System.out.println("Max_Heap is empty");
			return;
		}
		
		max_heap.a[1] = max_heap.a[max_heap.count--];
		max_heapify(max_heap.a, 1, max_heap.count);
	}

	private static void max_heapify(int[] a, int i, int len)
	{
		int largest = i;
		int left, right;
		
		left = i*2;
		right = left+1;
		
		if(left <=len && a[left] > a[i])
			largest = left;
		
		if(right <=len && a[right] > a[largest])
			largest = right;
		
		if(largest != i)
			swap(a, i, largest);
		
	}

	private static void insert_max(heap_t max_heap, int value) 
	{
		if(max_heap.count > 100)
			System.out.println("Can not insert into Maxx_Heap. Underlying data structure size");
		
		max_heap.count++;
		max_heap.a[max_heap.count] = value;
		shift_up_max(max_heap,max_heap.count);
		
	}

	private static void shift_up_max(heap_t max_heap, int i) 
	{
		int parent = i/2;
		if(i>1)
		{
			if(max_heap.a[parent] < max_heap.a[i])
				swap(max_heap.a,parent,max_heap.count);
			shift_up_max(max_heap,parent);
		}
	}

	private static void swap(int[] a, int i, int j) 
	{
		 int temp = a[i];
	        a[i] = a[j];
	        a[j] = temp;
	}

}
