package forUser;

import java.util.Scanner;

import enums.Category;


public class UserService {

    static Scanner scanner = new Scanner(System.in) ;
    static Integer count;
    public static void signUp(){
        System.out.println("Enter Name :");
        String name =scanner.nextLine() ;
        System.out.println("Enter Surname :");
        String surname =scanner.nextLine() ;
        System.out.println("Enter Phone Number :");
        String phone =scanner.nextLine() ;
        System.out.println("Enter id :");
        String id  =scanner.nextLine() ;
        User user1 = new User(name , surname , phone , id) ;

        Category.arrayuser(count , user1);
        count++ ;

    }
    public static void SignIN(){
        System.out.println("Enter Name :");
        String namee=  scanner.nextLine()  ;
        System.out.println("Enter SurName :");
        String Surnamee=  scanner.nextLine() ;

        for (int i = 0; i < Category.ReturnHashmapforUser().size(); i++) {
            if (Category.ReturnHashmapforUser().get(i).getName().equals(namee)&&Category.ReturnHashmapforUser().get(i).getSurname().equals(Surnamee)){
                System.out.println("Habibi welcome to clinic");

                UserMenu() ;


            } else if (namee.equals("admin") && Surnamee.equals("admin")) {
                AdminMenu() ;



            } else {
                System.out.println("Error");
            }
        }
    }
    public static void adminMenuSwitch(){
        switch (AdminMenu()) {
            case 0 ->{return;}
            case 1 ->{}
            case 2 ->{}
            case 3 ->{}
            case 4 ->{}
            case 5 ->{}





        }








    }

    private static int AdminMenu() {
        System.out.println("""
                0 - exit
                1 - show professions
                2 - add professions
                3 - edit prof disable/enable
                4 - add doctor
                5 - show users
                """);return scanner.nextInt();
    }

    public static int UserMenu(){
        System.out.println("""
                0 - exit
                1 - show professions
                2 - consultatation
                3 - show upcoming consultation
                4 - cansel consultation
                5 - history
                """);
        System.out.println("may you select");

        return scanner.nextInt();
    }




}
