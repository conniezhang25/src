
public class Term {
	   private double coefficient;
	   private int degree;
	   
	   //default constructor
	   public Term()
	   {
	      coefficient = 0;
	      degree = 0;
	   }
	   
	   //constructor given coeff and degree
	   public Term(double coefficient, int degree)
	   {
	      this.coefficient = coefficient;
	      this.degree = degree;
	   }
	   
	   //Precondition:none
	   //Postcondition:returns coefficient
	   public double getCoefficient()
	   {
	      return coefficient;
	   }
	   
	   //Precondition:none
	   //Postcondition:returns degree
	   public int getDegree()
	   {
	      return degree;
	   }
	   
	  //Precondition:none
	   //Postcondition: returns term in string form
	   public String toString()
	   {       
	      String s = "";
	      s = s+ coefficient + "x^" + degree;
	      return s;
	   }

}
