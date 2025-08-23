import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, k;
while (true) {
    try {
        System.out.print("Enter the Value: ");
        x = sc.nextInt();

        while (true) {
            try {
                k = 44 / x;
                System.out.println("The value of k: " + k);
                break;
            } catch (ArithmeticException e) {
                System.out.println("Sorry! The value can't be zero.");
                System.out.print("Please Enter the value again: ");
                x = sc.nextInt();
            }
        }

    } catch (Exception e) {
        System.out.println("Unexpected Input! Only numbers allowed. ");

    } finally {
            System.out.println("Program Closed Successfully.");
            sc.close();
        }
    break;
    }
    }
}
