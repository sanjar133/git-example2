
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tub(n);
    }
    public static int tub(int n) {
        int a = 0, b = 0;
        if (isTubA(a) && isTubB(b) && (a + b == n)) {
            System.out.println(a + b);
        }
        return a + b;

    }
    public static boolean isTubA(int a) {
        int cntA = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                cntA ++;
            }
        }
        if (cntA == 2) {
            return true;
        }
        return false;
    }
    public static boolean isTubB(int b) {
        int cntB = 0;
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) {
                cntB ++;
            }
        }
        if (cntB == 2) {
            return true;
        }
        return false;
    }

}