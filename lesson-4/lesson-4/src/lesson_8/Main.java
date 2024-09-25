package lesson_8;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {

        // Splitting a random text into a set of words
        String text = "Hello g43 group!";

        String[] words = text.split("\\W+");
        System.out.println(Arrays.toString(words));


        Scanner scanner =new Scanner(System.in);
        String patter="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        while (true) {
            System.out.println("enter password");
            String password = scanner.nextLine();
            System.out.println(Pattern.matches(patter,password));
//        }
//
//        Pattern a = Pattern.compile("(\\+998)(9[7-9]|33|78|77)(\\d{7})");
//
//        Matcher test = a.matcher("+998331112233");
//        System.out.println(test.matches());
//        String phoneNumber ="+998331112233";
//        boolean matches = phoneNumber.matches("(\\+998)(9[7-9]|33|78|77)(\\d{7})");

//        String[] split = a.split("hello world a hi jon a hi everyone");
//
//
//        for (String s : split) {
//            System.out.println(s);
//        }

        


    }

}
