import java.util.Scanner;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("1.Menu 2.Choose Table 0.Exit");
        int stepCode = scannerInt.nextInt();
        switch (stepCode) {
            case 1 -> {
                System.out.println("1.Osh\n2.Mastava\n3.Sho'rva\n4.Moshkichri\n" +
                        "5.Shashlik\n6.Ichimlik\n7.Salat");
                stepCode = scannerInt.nextInt();
                switch (stepCode) {
                    case 1 -> {

                    }
                }
            }
            case 2 -> {
                System.out.println("1.First table\n 2.Second table\n 3.Third table\n " +
                        "4.Fourth table\n 5.Fifth table");
                stepCode = scannerInt.nextInt();
                switch (stepCode) {
                    case 1 -> {

                    }
                }
            }
        }

    }


}