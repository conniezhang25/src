public class SelectionSort
{
   public static int[] sort(int[] a)
   {
      for(int i=0; i<a.length; i++)
      {
         for(int j=i+1; j<a.length; j++)
         {
            if(a[j]<a[i])
            {
               int temp=a[i];
               a[i]=a[j];
               a[j]=temp;
            }
         }
      }
      return a; 
   }
   public static void main (String args[])
   {
      int[] list = {2, 34, 15, 17, 23};
      int[] sorted_list=sort(list);
      for(int i: sorted_list)
      {
         System.out.print(i+",");
      }
      
   }
   
}