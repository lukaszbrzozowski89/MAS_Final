/*
 * Copyright (c) 2020. Lukasz Brzozowski @ PJATK (s17174)
 */

package data;

import java.io.IOException;

/**
 * Main class
 */
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
