
public class TestRecur {
	private int[] v;
	public TestRecur(int[] v)
	{
		 v = new int[3];
	}
	public static void main (String[] args)
	{
		int[]v = {2,4,8};
		//System.out.println(powerof3(81));
		//System.out.println(powerof3(6));
		//System.out.println(reverse(1234567));
		//base5(5);
		//correctPermutateOdd("", 3);
		//permutateOdd(3);
		//System.out.print(found(v,7));
		//System.out.print(found(v,3));
		//head(5);
		//System.out.println();
		//tail(5);
		System.out.println(groupSum(0, v, 10));
	}
	public static void triangle(int count)
	{
		if( count <= 0 ) 
			return;
		else
		{
			triangle(count-1);
			for(int i=0; i<count; i++)
			{
				System.out.print("*");
			}
			System.out.println();
			
			
	    }		
	}
	 public static boolean powerof3(int x)
	   {		 
			  	
			  if(x==1)
			  {
				   return true;
			  }
			  else if(x%3!=0)
			  {
				  return false;
			  }
			  else
			  {
				  return powerof3(x/3);			  
			  }
			  
	   }
	 public static String reverse(int x)
	 {
		 if(x/10==0)
		 {
			 return ""+x;
		 }
		 else
		 {
			 String p = "" + x%10;
			 p = p+reverse(x/10);
			 return p;
		 }
		 
	 }
	 public static void reverseString(int x)
	 {
		 if(x/10==0)
		 {
			 System.out.print(x);
		 }
		 else
		 {
			 System.out.print(x%10);
			 reverseString(x/10);
		 }
	 }
	 public static void base5(int x)
	   { 
		   if(x<5)
		   {
			   System.out.print(x);
		   }
		   else
		   {
			   base5(x/5);
			   System.out.print(x%5);
		   }
	   }
	 public static void permutateOdd(int x)//SIMILAR PROBLEM ON TEST!!!
	 {
		 String s="";
		 if(x<0)
		 {
			 System.out.println(s);
	     }
		 else{
			 for(int i=1; i<x; i= i+2)//start from 1!!
			 {
				  s+=i;
				 //permutateOdd(x+2);
				 permutateOdd(x-1);
				 
			 }
		 }
		 
	 }
	 public static void correctPermutateOdd(String p, int length)
	 {
		 if(length==0)
		 {
			 System.out.println(p);
			 return;
		 }
		 else{
			 for(int i=1; i<9; i = i+2)
			 {
				 correctPermutateOdd(p+i, length-1);// cannot do length-- bc it changes the value of length!!
			 } 
				 
		 }
	 }
	 public static boolean found (int[] v, int target){
		 return foundHelper(v, v.length-1, target);
	 }
	 public static boolean foundHelper(int[]v, int n, int target)
	 {
		 if(n<0)
		 {
			 return false;
		 }
		 else{
			 if(v[n] ==target)
			 {
				 return true;
			 }
			 else{
				 return foundHelper(v, n-1, target);
			 }
		 }	
	 }
	 public static int log(int n)//base 2
	 {
		 if(n<=2)
		 {
			 return 1;
		 }
		 else{
			 return log(n/2)+1;
		 }
	 }
	 public static void tail(int n)
	 {
		 if(n==1)
		 {
			 return;
		 }
		 else{
			 System.out.print(n);
		 }
		 tail(n-1);
	 }
	 public static void head(int n)
	 {
		 if(n==1)
		 {
			 return;
		 }
		 else{
			 head(n-1);
			
		 }
		 System.out.print(n);
		 
	 }
	 public static boolean groupSum(int start, int[] nums, int target) {
		  if(start>=nums.length)
		  {
		    return (target==0);
		  }
		  if(groupSum(start+1, nums, target-nums[start]))
		  {
		    return true;
		  }
		  if(groupSum(start+1, nums, target))
		  {
		    return true;
		  }
		  return false;
		}

}	   

