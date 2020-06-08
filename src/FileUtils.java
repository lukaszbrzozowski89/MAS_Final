import java.io.*;

public class FileUtils extends ObjectPlusPlus{

    static File extentFile = new File("Final_project_database_file");

    public static void readExtentFromFile() throws Exception {
        if (extentFile.exists()) {
            ObjectInputStream streamInput = null;
            try {
                streamInput = new ObjectInputStream(new FileInputStream(extentFile));
                getExtent(streamInput);
                System.out.print("Size read from file: ");
//                Pilot.setPilotCount(extentSize(Pilot.class));

            } catch (Exception c) {
                System.out.println("Class not found.");
                c.printStackTrace();
            } finally {
                if (streamInput != null)
                    streamInput.close();
            }
            showExtent(Pilot.class);
        }
    }

    public static void saveExtentToFile() throws IOException {
        ObjectOutputStream streamOutput = null;
        try {
            streamOutput = new ObjectOutputStream(new FileOutputStream(extentFile));
            saveExtent(streamOutput);
            System.out.print("Size saved to file: ");
//            Pilot.setPilotCount(extentSize(Pilot.class));
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            if (streamOutput != null) {
                streamOutput.close();
            }
        }
    }
}
