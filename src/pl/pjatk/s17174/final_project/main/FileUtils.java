/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.main;

import java.io.*;

/**
 * Class used to save extent to file and then read it
 *
 * @author Lukasz
 */
public class FileUtils extends ObjectPlusPlus {

    static File extentFile = new File("Final_project_database_file");


    /**
     * method used to read extent from file
     *
     * @throws Exception "
     */
    public static void readExtentFromFile() throws Exception {
        if (extentFile.exists()) {
            ObjectInputStream streamInput = null;
            try {
                streamInput = new ObjectInputStream(new FileInputStream(extentFile));
                getExtent(streamInput);
                System.out.print("Size read from file: ");
            } catch (Exception c) {
                System.out.println("Class not found.");
                c.printStackTrace();
            } finally {
                if (streamInput != null)
                    streamInput.close();
            }
        }
    }


    /**
     * method used to save extent to file to extent durability
     *
     * @throws IOException "
     */
    public static void saveExtentToFile() throws IOException {
        ObjectOutputStream streamOutput = null;
        try {
            streamOutput = new ObjectOutputStream(new FileOutputStream(extentFile));
            saveExtent(streamOutput);
            System.out.print("Size saved to file: ");
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            if (streamOutput != null) {
                streamOutput.close();
            }
        }
    }
}
