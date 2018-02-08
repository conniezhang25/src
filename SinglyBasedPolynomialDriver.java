/*
* Name:Connie Zhang                       
* Period:5 
* Name of the Lab: SinglyBasePolynomial
* Purpose of the Program:Learn how to manipulate linked lists to create a polynomial. 
* Learn the key differences between Arrays and LinkedList
* Due Date: 10/1/17
* Date Submitted: 10/1/17
* What I learned: 
1. I learned that Linked lists are similar to Arrays in many ways and how to convert LinkedNodes to arrays, 
which was helpful when trying to visualize how to complete each method
2. I learned how to manipulate the base class for ListNode. I learned that you could either change
the listNode class, or make a new object as the type
* How I feel about this lab: I feel like I learned a lot from this lab. At first, it was frustrating because
* I found it difficult to access the values from the listNodes and be able to manipulate them the same way
* as an array. However, once I understood the logic and process behind using this method, I feel like it has 
* strengthened my abilities to use ListNodes
* What I wonder: I wonder if using LinkedList is more efficient than
 using an ArrayList in some methods because I feel like ArrayList and
  Arrays are easier to manipulate.
* Credits: Angie Zhou- Angie helped me with the toString method,helped me visualize the plus method, and helped me understand
* that the copy constructor was a deep copy 
* Angie's Dad- helped me debug my add method
* Students whom I helped (to what extent):
 purpose of using multiple pointers in different methods
*/
public class SinglyBasedPolynomialDriver {
	public static void main(String[] args) { 
	      
	      double[]coeff = {4, 3, 1};
	      int[] degree = {3,2,0};
	      Polynomial p1 = new SinglyBasedPolynomial(coeff, degree);  // 4x^3 + 3x^2 + 1
	      System.out.println("p1(x) =     " + p1);
	      
	      double[] coeff2 = {-5, -2};
	      int[] degree2 = {1, 0};
	      Polynomial p2 = new SinglyBasedPolynomial(coeff2, degree2);   // - 5x – 2
	      System.out.println("p2(x) =     " + p2);                 // p2(x) = - 5x^1 – 2
	   
	      double[] coeff3 = {-4};
	      int[] degree3={1};
	      Polynomial p3   = new SinglyBasedPolynomial (coeff3, degree3);  // coeff, exp = -4x
	      System.out.println("p3(x) =     " + p3);
	   
	      Polynomial p    = p1.plus(p2).plus(p2);   // 4x^3 + 3x^2 - 10x – 3
	      System.out.println("p(x) =     " + p);       // p(x) = 4x^3 + 3x^2 - 10x^1 – 3
	   
	      Polynomial p4   = p.minus(p3);   // 4x^3 + 3x^2 - 6x^1 – 3   <====
	      System.out.println("p4(x) =     " + p4);
	   
	      Polynomial p5   = p4.differenciate();   // 12x^2 + 6x^1 - 6   <====
	      System.out.println("p5(x) =     " + p5);
	      
	      Polynomial product = p1.multiply(p2);
	      System.out.println("product of p1(x) and p2(x) is     " + product);
	      
	      
	      Polynomial clone = new SinglyBasedPolynomial (p5);
	      System.out.println("clone(x) =     " + clone);
	      
	      System.out.println ("p5(0) = " + p5.evaluate(0));
	      System.out.println ("p5(1) = " + p5.evaluate(1));
	      System.out.println("clone equals p5: " + p5.equals(clone));
	   }

}
/*
 * Program OutPut:
 * p1(x) =     1.0x^0+3.0x^2+4.0x^3
p2(x) =     -2.0x^0-5.0x^1
p3(x) =     -4.0x^1
p(x) =     -3.0x^0-10.0x^1+3.0x^2+4.0x^3
p4(x) =     -3.0x^0-6.0x^1+3.0x^2+4.0x^3
p5(x) =     -6.0x^0+6.0x^1+12.0x^2
product of p1(x) and p2(x) is     -2.0x^0-5.0x^1-6.0x^2-23.0x^3-20.0x^4
clone(x) =     12.0x^2+6.0x^1-6.0x^0
p5(0) = -6.0
p5(1) = 12.0
clone equals p5: true
*/
