package utils;

import java.util.Scanner;

public class ScannerUtil {

    private static final Scanner intScanner = new Scanner(System.in);
    private static final Scanner stringScanner = new Scanner(System.in);

    public static int inputInt(String text) {
        System.out.print(text);
        return intScanner.nextInt();
    }

    public static String inputString(String text) {
        System.out.print(text);
        return stringScanner.nextLine();
    }

}
