package enums ;
import forUser.User;

import java.util.HashMap;

public class Category {
    static HashMap<Integer , User> userHashMap = new HashMap<>() ;
    public static void arrayuser(Integer a , User user){

        userHashMap.put(a , user) ;




    }
    public static HashMap getuserhashmap() {
        return userHashMap;
    }




    public static HashMap<Integer , User> ReturnHashmapforUser(){
        return userHashMap ;
    }

    public static HashMap<Integer , User> ReturnHashmapforAdmin(){
        return doctorHashMap ;
    }

    static HashMap<Integer , User> doctorHashMap = new HashMap<>() ;


}
