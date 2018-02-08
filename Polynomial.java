
public interface Polynomial {
	int returnDegree();
	   double returnCoefficient(int exponent);
	   double evaluate(int x);
	   Polynomial plus(Polynomial a);
	   Polynomial minus(Polynomial a);
	   Polynomial differenciate();
	   Polynomial multiply(Polynomial a);
	   boolean equals(Polynomial a);

}
