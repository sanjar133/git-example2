import forUser.UserService;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static   Scanner scanner = new Scanner(System.in) ;
    public static void main(String[] args) {


        while (true) {
            switch (minimenu()){
                case 0 ->{
                    return;
                }
                case 1->{
                    UserService.SignIN();
                }
                case 2->{
                    UserService.signUp();
                }









            }







        }


    }






    public static int minimenu(){
        System.out.println("""
                0 - exit
                1 - sign in
                2 - sign up
                """);
        System.out.println("may you select one option");
        return scanner.nextInt();

    }
}