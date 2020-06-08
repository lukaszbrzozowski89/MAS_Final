import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            FileUtils.readExtentFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            FileUtils.saveExtentToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
