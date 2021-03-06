/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package pl.pjatk.s17174.final_project.utils;

import pl.pjatk.s17174.final_project.main.ObjectPlus;
import pl.pjatk.s17174.final_project.main.ObjectPlusPlus;

import java.io.*;

/**
 * Class used to save extent to file and then read it
 *
 * @author Lukasz
 */
public class FileUtils extends ObjectPlusPlus implements Serializable {

    static File extentFile = new File("Final_project_database_file");


    /**
     * method used to read extent from file
     *
     * @throws Exception "
     */
    public static void readExtentFromFile() throws Exception {
        if (extentFile.exists()) {
            try (ObjectInputStream streamInput = new ObjectInputStream(new FileInputStream(extentFile))) {
                ObjectPlus.readExtents(streamInput);
                System.out.print("Size read from file: ");
            } catch (Exception c) {
                System.out.println("Class not found.");
                c.printStackTrace();
                Utils.showAlertDialog(c.getMessage());
            }
        }
    }


    /**
     * method used to save extent to file to extent durability
     *
     * @throws IOException "
     */
    public static void saveExtentToFile() throws IOException {
        try (ObjectOutputStream streamOutput = new ObjectOutputStream(new FileOutputStream(extentFile))) {
            ObjectPlus.writeExtents(streamOutput);
            System.out.print("Size saved to file: ");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
