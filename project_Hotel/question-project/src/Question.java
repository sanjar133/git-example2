import java.io.*;
import java.util.List;

public class Question {

    private String text;

    private QuestionLevelEnum level;

    private List<Option> options;



    public static void main(String[] args) {

        String filePath = "questions2.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Savol")) {
                    System.out.println("Savol" + line.substring(7));
                }
                if (line.startsWith("Javob")) {
                    System.out.println("Javob" + line.substring(6));
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
