public class Palindrome{
    public static void main(String[] args){
        int num = Integer.parseInt(args[0]);
        int original = num;
        int rev = 0;
        int dig;
        while(num > 0){
            dig = num % 10;
            rev = rev * 10 + dig; 
            num = num / 10;
        }
        System.out.println(rev);
        if (original == rev){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }
}