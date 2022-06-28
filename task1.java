import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("введите число: ");
        int n = iScanner.nextInt();
        System.out.println(triangle(n));
        }
    static public int triangle(int n) { 
        if(n==1)
            return 1;
        else
            return( n + triangle(n-1));
    
    } 
}