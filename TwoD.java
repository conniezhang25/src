public class TwoD
{
   public static void PrintArray(int [] a)
   {
      for(int r=0; r<a.length; r++)
      {
         for( int c=0; c<a[0].length; c++)
         {
            System.out.print(a[r][c]);
         }
         System.out.println();
      }
   }
   public static void mirror(int [] a)
   {
      for(int r= r-1; r<=r+1; r++)
      {
         for(int c= c-1; c<=c+1; c++)
         {
            int temp = a[a.length-r-1][c];
            a[a.length-r-1][c] = a[r][c];
            a[r][c]=temp;
         }
      }
   }
   public static void main(String[] args)
   {
      int [] [] minesfield = new int [] [size];
   }
}