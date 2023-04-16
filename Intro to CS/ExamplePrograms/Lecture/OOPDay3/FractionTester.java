public class FractionTester {
    public static void main(String[] args){
        Fraction f1 = new Fraction( 2, 3);
        Fraction f2 = new Fraction (4, 5);
        Fraction f3 = new Fraction (2, 3);
        Fraction f4 = new Fraction (4, 6);
        System.out.println(f1.compareTo(f2)); //expected  -1
        System.out.println(f2.compareTo(f1)); //expected  1
        System.out.println(f1.compareTo(f3)); //expected  0

        System.out.println(f1.equals(f3)); //expected true
        System.out.println(f1.equals(f4)); //expected true
        System.out.println(f1.equals(f2)); //expected false

        System.out.println(f1.compareTo(f2));

        Fraction product = f1.multiply(f2); // expect 8/15
        System.out.println(product);
        Fraction quotient = f1.divide(f2);
        System.out.println(quotient);
        Fraction sum  = f1.add(f2);
        System.out.println(sum);
    }
}
