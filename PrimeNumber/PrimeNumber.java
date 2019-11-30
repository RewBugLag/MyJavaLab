import java.util.Scanner;

/**
 * PrimeNumber
 */
public class PrimeNumber {
    // public boolean prime() {
    //     for (int i = 2; i < num; i++) {
    //         if (num % i == 0) {
    //             System.out.println(num + " isn't a prime number");
    //             return false;
    //         }
    //         System.out.println(num + " is a prime number");
    //         return true;
    //     }
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Max number: ");
        int num = sc.nextInt();
        for (int i = 2; i <= num; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    if (i != j) {
                        System.out.println(i + " isn't a prime number");
                        break;
                    }
                    System.out.println(i + " is a prime number");
                }
            }
        }

        // for (int i = 2; i < num; i++) {
        //     if (num % i == 0) {
        //         System.out.println(num + " isn't a prime number");
        //         break;
        //     } else {
        //         System.out.println(num + " is a prime number");
        //     }
        // }
    }
}