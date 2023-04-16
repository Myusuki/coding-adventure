/* Fraction Class with four arithmetic operations
 */

 public class Fraction {
    private int numer;  //numerator
    private int denom;  //denominator
  
    // note NO DEFAULT CONSTRUCTOR
  
    public Fraction(int n, int d) {
      if ( d != 0 ) {
        numer = n;
        denom = d;
      }
      else {
        throw new IllegalArgumentException("Denominator cannot be 0");
      }
    }
  
    //finding greatest common divisor for reducing fraction
    //there are more elegant ways to do this!
    private int gcd(int num1, int num2) {
        if(num2 == 0){
            return num1;
        }
        int remainder = num1 % num2;
        return (gcd(num2,remainder));
    }
  
    private void reduce(Fraction toReduce) {
      int divisor = gcd ( toReduce.numer, toReduce.denom);
      toReduce.numer = toReduce.numer / divisor;
      toReduce.denom = toReduce.denom / divisor;
    }
  
    public Fraction add(Fraction b) {
      int numerator = (this.numer * b.denom) + (b.numer * this.denom);
      int denominator = this.denom * b.denom;
      Fraction f =  new Fraction (numerator, denominator);
      reduce (f);
      return f;
    }
  
    public Fraction subtract(Fraction b){
      int numerator = (this.numer * b.denom) - (b.numer * this.denom);
      int denominator = this.denom * b.denom;
      Fraction f =  new Fraction (numerator, denominator);
      reduce (f);
      return f;
      }
  
    public Fraction multiply(Fraction b){
      int numerator = this.numer * b.numer;
      int denominator = this.denom * b.denom;
      Fraction f =  new Fraction (numerator, denominator);
      reduce (f);
      return f;
    }
  
    public Fraction divide(Fraction b){
      int numerator = this.numer * b.denom;
      int denominator = this.denom * b.numer;
      Fraction f =  new Fraction (numerator, denominator);
      reduce ( f);
      return f;
    }
  
    public String toString()  {
      if (numer == denom) {
        return ("" + numer / denom);
      }
      else if(numer > denom && denom > 1) {
        return (numer + "/" + denom + " = " + (numer/denom) + " " + (numer % denom) + "/" + denom);
      }
      else {
        return(numer + "/" + denom);
      }
    }
   //Many algorithms to do this! n1*d2 == n2 * d1 instead of reducing
    public boolean equals(Object obj) {
      if(obj instanceof Fraction) {
        Fraction f = (Fraction) obj;
        reduce(f);
        reduce(this);
        if ( ( f.numer == this.numer ) && (f.denom == this.denom )) {
          return true;
        }
      }
      return false;
    }
  
    // returns positive if this > f;
    // return negative if this < f;
    // returns 0 if this = f;
    public int compareTo (Fraction f) {
      double me = (double)this.numer/ this.denom;
      double fraction1 = (double)f.numer/ f.denom;
  
      if (me < fraction1) {
        return -1;
       }
        else if (me > fraction1) {
          return 1;
        }
        return 0;
  
        //another algorithm: return (me - fraction1);
        }
  }
  
