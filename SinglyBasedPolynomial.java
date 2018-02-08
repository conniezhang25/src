import java.util.*;
import java.util.NoSuchElementException;
import java.util.LinkedList;
public class SinglyBasedPolynomial implements Polynomial {

	     private static class ListNode <Term> 
	    {    
	      private Term value;    
	      private ListNode <Term>  next; 
	      public ListNode  (Term  initValue, ListNode <Term> initNext)    
	      { 
	         value = initValue; 
	         next = initNext; 
	      }  
	      public Term getValue()  
	      { 
	         return value; 
	      }    
	   
	      public ListNode <Term> getNext() 
	      { 
	         return next;  
	      } 
	   
	      public void setValue(Term theNewValue)
	      { 
	         value = theNewValue;
	      }
	   
	      public void setNext(ListNode  <Term> theNewNext)
	      { 
	         next = theNewNext; 
	      }
	   
	   }  // end of ListNode
	   
	   private ListNode<Term> coeffList;

	   //construct a singlybasedPolynomial with two arrays: coefficient and exponent
	   public SinglyBasedPolynomial(double[] coefficient, int[] exponent)
	   {
	      for(int i =0; i<coefficient.length; i++)
	      { 
	         Term next = new Term(coefficient[i], exponent[i]);
	         coeffList = new ListNode<Term>(next, coeffList);
	      }
	   }
	   
	   public SinglyBasedPolynomial(Polynomial a)//copy constructor
	   {
		   int size=0;
		   for(int i=0; i<=a.returnDegree();i++)
		   {
			   size++;
		   }
		  double[] copyCoeff = new double[size];
		  int[] copyDegree = new int[size];
		  copyCoeff[0] = a.returnCoefficient(0);
		  copyDegree[0] =0;
		  Term first = new Term(copyCoeff[0], copyDegree[0]);
		  coeffList = new ListNode(first, null);
		  int index=1;
		  for(int i=1; i<size;i++)
		  {
			  copyCoeff[index] = a.returnCoefficient(i);//sets value to new arrays
			  copyDegree[index] =i;		  
			  Term next = new Term(copyCoeff[index], copyDegree[index]);//adds these values to a new term
			 coeffList= (new ListNode(next, coeffList));
			  index++;
		  }
	   }
	   //Precondition:coeffList is in order
	   //Postcondition:returns the size of coeffList
	   public static int size(ListNode <Term> coeffList)
	   {
	      int count =0; 
	      for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext())
	      {
	         count++;
	      }
	      return count;
	   }
	   //Precondition:coeffList is in order
	   //Postcondition:returns the highestDegree of coeffList
	   public int returnDegree()
	   {  
		   	int degree= 0;
	        for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext()) 
	        {
	        	degree = temp.getValue().getDegree();
	        }
		   	return degree;
	   }
	   //Precondition:coeffList is in order
	   //Postcondition: returns coefficient given an exponent
	   public double returnCoefficient(int exponent)
	   {
		  for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext())
		  {
			  if(temp.getValue().getDegree()==exponent)
			  {
				  return (temp.getValue().getCoefficient());
			  }
			  else if(temp.getValue().getDegree()>exponent)
			  {
				  return 0;
			  }
		  }
		  return 0;
	   }
	   //Precondition:coeffList is in order
	   //Postcondition:evaluates the polynomial, given x
	   public double evaluate(int x)
	   {
	      double result=0;
	      for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext())
	      {
	    	  result += temp.getValue().getCoefficient()* Math.pow(x, temp.getValue().getDegree());
	      }
	      return result;
	      
	   }
	   //Precondition:coeffList and a are in order
	   //Postcondition:adds two polynomials 
	   public Polynomial plus(Polynomial a)
	   {
	   
		  int highestDegree = 0;
		  if(returnDegree()>a.returnDegree())
		  {
			  highestDegree =returnDegree();//finds the highest degree
		  }
		  else
		  {
			 highestDegree= a.returnDegree() ;
		  }
		  int sizePlus = 0;
		  for(int i=0; i<=highestDegree; i++)
		  {
			  if(returnCoefficient(i) !=0 || a.returnCoefficient(i) !=0)//finds the size of the polynomial
			  {
				  sizePlus++;											//some values may be zero, so you dont want to allocate space for zero as coefficients
			  }
		  }
		  double[] newCoeff = new double[sizePlus];
		  int[] newDegree = new int[sizePlus];
		  int index=highestDegree;//index for polynomial
		  for(int i=0; i<highestDegree+1; i++)
		  {
			  if(returnCoefficient(i)!=0 || a.returnCoefficient(i)!=0)
			  {
				  newCoeff[index]=returnCoefficient(i)+a.returnCoefficient(i);//at the same degree, add the values
				  newDegree[index]= i;
				  index--;
			  }
			  
		  }
		  return new SinglyBasedPolynomial(newCoeff, newDegree);
	   }
		//Precondition: other is in order 
	   //Postcondition: negates the value of the polynomial being subtracted
	   private Polynomial negateCoeffList(Polynomial other)
	   {
		   int sizeA=0;
		   for(int i=0; i<=other.returnDegree(); i++)
		   {
			   if(other.returnCoefficient(i)!=0)
			   {
				   sizeA++;
			   }
		   }
			  double[] negCoeff = new double[sizeA];
			   int[] degree = new int[sizeA];
			   int index=0;
			   for(int exponent=0; exponent<=other.returnDegree(); exponent++)
			   {
				   if(other.returnCoefficient(exponent)!=0)
				   {
					   negCoeff[index]=other.returnCoefficient(exponent) *-1;//negates coefficient
					   degree[index] = exponent;
				   }
			   }
		   	      
	      return new SinglyBasedPolynomial(negCoeff, degree);
	   }
	   
	   //Precondition:coeffList and a are in order
	   //Postcondition: subtracts a from coeffList
	   public Polynomial minus(Polynomial a)
	   {     
	      return plus(negateCoeffList(a));//uses plus method
	   }
	    
	   //Precondition:coeffList and a are in order
	   //Postcondition: multiply a and coeffList
	   public Polynomial multiply(Polynomial a)
	   {
		   double[] initCoeff = {0};
		   int[] initDegree = {0};
		   int exponent = 0;
		   Polynomial p= new SinglyBasedPolynomial(initCoeff, initDegree);//individual monomials
		   Polynomial multiplied =  new SinglyBasedPolynomial(initCoeff, initDegree);//final Polynomial
	      for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext())//loops through each term
	      {
	    	  double listCoeff = temp.getValue().getCoefficient();//keep term of coeffList the same 
	    	  for(int i=0; i<a.returnDegree()+1; i++)//loops through terms of a
	    	  {
		    	  double multCoeff =  listCoeff * a.returnCoefficient(i);
		    	  int multDegree = temp.getValue().getDegree()+exponent;
		    	  double[] multCoeffList = {multCoeff};
		    	  int[] multDegreeList = {multDegree};	    		  
		    	 
		    	  p = new SinglyBasedPolynomial(multCoeffList, multDegreeList);
		    	  multiplied = multiplied.plus(p);//add new multiplied terms
		    	  exponent++;
	    	  }
	    	  exponent = 0;
	    	  
	      }	      
	      return multiplied;
	      	      
	   }
	   
	   //Precondition:coeffList is in order
	   //Postcondition: find the derivative of coeffList
	   public Polynomial differenciate()
	   { 
		   
		   double[] initderivCoeff = {0};
		   int[] initderivDegree = {0};	
		   Polynomial deriv = new SinglyBasedPolynomial(initderivCoeff, initderivDegree);
		   for(ListNode<Term> temp = coeffList; temp!=null; temp = temp.getNext())
		   {		   
			   int initDeg = temp.getValue().getDegree();
			   double deriveCoeff = temp.getValue().getCoefficient() * initDeg;//derive new coeff
			   int deriveDeg = initDeg -1;//subtract 1 from degree
			   if(deriveDeg>=0)//if derivative is 0, ignore it
			   {
					   double[] derivCoeff = {deriveCoeff};
					   int[] derivDegree= {deriveDeg};
					  deriv=  deriv.plus(new SinglyBasedPolynomial(derivCoeff, derivDegree));//add each new deriv term
			   }	   
			   
		   }
		   
		   return deriv;
	   }
	   //Precondition:coeffList and a are in order
	   //Postcondition: checks if coeffList and a are equal
	   public boolean equals(Polynomial a)
	   {
		   boolean flag = true;
		   for(ListNode<Term> temp = coeffList; temp!=null; temp= temp.getNext())
		   {
			   for(int i=0; i<a.returnDegree(); i++)
			   {
				   if(temp.getValue().getCoefficient()!=a.returnCoefficient(i))//if not equals value, false
				   {
					   flag = false;
				   }
			   }
			   
		   }
		   return flag;
	   }
	   
	   //Precondition:none
	   //Postcondition: returns polynomial in string form 
	   public String toString() 
	   {
	      String s = "";   
	      ListNode<Term> temp;      
	      for (temp=coeffList; temp!=null; temp=temp.getNext())
	       {
	           double coeff = temp.getValue().getCoefficient();
	            
				if (coeff!=0.0)            
				{
				         if (coeff>0)                  
				         {
					          if (s.length()!=0)
					           {
					                 s+="+";
					           }
				          }
				     s+=temp.getValue().toString();				              
				}
				         
			}
			return s;
	  }

}
