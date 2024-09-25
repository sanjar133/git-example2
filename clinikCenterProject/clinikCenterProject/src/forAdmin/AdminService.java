package forAdmin;

import doctor.Doctor;
import prof.Prof;
import enums.Category;
import enums.Category;
import enums.Role;

import java.util.HashMap;
import java.util.Scanner;

public class AdminService {
    static HashMap<Integer , Prof> profHashMap = new HashMap<>() ;
    static int count = 0 ;
    static Scanner scanner = new Scanner(System.in) ;
    public static void addprof() {
        System.out.println("you selected add prof");
        System.out.println("enter name ");
        String profname= scanner.nextLine();
        System.out.println("enter salary");
        String salary= scanner.nextLine();
        Prof prof = new Prof(profname , salary) ;
        profHashMap.put(count,prof) ;


    }

    public static void showprof(){
        System.out.println("you selected Show prof");
        System.out.println(profHashMap);





    }
    public static void removeDoctor(){
        System.out.println("you selected remove Doctor");
        System.out.println(Category.getuserhashmap());
        System.out.println("enter number");
        int removeNumber = scanner.nextInt();
        Doctor.doctorArray.remove(removeNumber) ;
        System.out.println("removed successfuly");
        System.out.println(Category.getuserhashmap());

    }

//public static void addDoctor(){
//    System.out.println("you selected add doctor");
//    System.out.println("if you wanna add doctor just then enter number");
//    System.out.println(Kategoriya.getuserhashmap());
//    int addoctor=scanner.nextInt() ;
////        Kategoriya.getuserhashmap().get(addoctor).setRole.Doctor ;
//        Kategoriya.getuserhashmap().get(1)
//}



}
