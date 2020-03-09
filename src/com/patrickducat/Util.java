package com.patrickducat;

import java.io.*;

public class Util {

    public static void signEULA(String filePath, String oldString, String newString) {

        File fileToBeModified = new File(filePath);

        StringBuilder oldContent = new StringBuilder();

        BufferedReader reader = null;

        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));

            //Reading all the lines of input text file into oldContent

            String line = reader.readLine();

            while (line != null) {
                oldContent.append(line).append(System.lineSeparator());

                line = reader.readLine();
            }

            //Replacing oldString with newString in the oldContent

            String newContent = oldContent.toString().replaceAll(oldString, newString);

            //Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);

            writer.write(newContent);

            System.out.println("Signed EULA.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources

                assert reader != null;
                reader.close();

                assert writer != null;
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
