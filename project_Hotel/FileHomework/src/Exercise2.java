import java.io.*;
import java.util.Objects;

public class Exercise2 {


    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\sanja\\Downloads\\text.txt");
        System.out.println(file);


        try (FileInputStream inputStream = new FileInputStream(file)) {

            byte[] bytes = inputStream.readAllBytes();
            String str = new String(bytes);

            System.out.println("str = " + str);
        }


    }




}
