//Name:   
//Date:
// What I learned:
// How I feel about this lab:
// I am wondering:
public class Connie_Zhang_Pd5_HeapSortLab
{
   public static final int SIZE = 9;
	
   public static void main(String[] args)
   {
   //Part 1: Given a heap, sort it. Do this part first.   
      double heap[] = {-1,99,80,85,17,30,84,2,16,1};
      display(heap);
      sort(heap);
      display(heap);
      
   //Part 2:  Generate 100 random numbers, make a heap, sort it.
      // double[] heap = new double[SIZE + 1];
      // createRandom(heap);
      // display(heap);
      // makeHeap(heap, SIZE);
      // display(heap); 
      // sort(heap);
      // display(heap);
   }
   
	//******* Part 1 ******************************************
   public static void display(double[] array)
   {
      for(int k = 1; k < array.length; k++)
         System.out.print(array[k] + "    ");
      System.out.println("\n");	
   }
   public static void sort(double[] array)
   {
		swap(array,1, array.length-1);
		display(array);
		heapDown(array, 1, array.length-1);
		//double[] temp = new double[array.length-1]; 
		
	    /*for(int i=1; i<array.length-1;i++)
	    {
	    	temp[i] = array[i];
	    }
	    System.out.println("temp");
	    display(temp);
	    double[] end = new double[array.length-temp.length];
	    System.out.println("size end:  " + (array.length-temp.length));
	    for(int i=0;i<array.length-temp.length;i++)
	    {
	    	end[i] = array[temp.length];
	    }
	    display(end);
	    sort(temp);*/
	    
		

   }
   public static void swap(double[] array, int a, int b)
   {
	   double temp = array[a];
		array[a] = array[b];
		array[b] = temp;
   }
   public static void heapDown(double[] array, int index, int size)
   {
	   if(index >= size){
			return;
	   }
	   if(index*2<size&&index*2+1<size)
	   {
		   if(array[index]<array[index*2] || array[index]<array[index*2+1])
			{
				if((index*2<size)&&(index*2+1<size))
				{
					
					if(array[index*2]>array[index*2+1])
					{
						swap(array, index, index*2);
						display(array);
						heapDown(array, index*2, size);
					}
					else if(array[index*2]<array[index*2+1])
					{
						swap(array, index, index*2+1);
						display(array);
						heapDown(array, index*2+1, size);
					}
				}

		}
			else if(index*2<size&&index*2+1>size)
			{
				swap(array, index, index*2);
				display(array);
				heapDown(array, index*2, size);
			}
			else if(index*2+1<size&&index*2>size)
			{
				swap(array, index, index*2+1);
				display(array);
				heapDown(array, index*2+1, size);
			}
		}
	   else 
	   {		   
		  	 double[] temp = new double[size];
		  	 size--;
		  	 for(int i=1;i<size;i++)
		  	 {
		  		 temp[i] = array[i];
		  	 }	
		  	 sort(temp);
		  	
		  	 
	   }
	   
   }
   
   // ****** Part 2 *******************************************
   public static void makeHeap(double[] array, int size)
   {
   
   }
   //Generate 100 random numbers (between 1 and 100, formatted to 2 decimal places) 
   public static void createRandom(double[] array)
   {  
   
   }
}


