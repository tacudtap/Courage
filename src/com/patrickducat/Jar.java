package com.patrickducat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Jar {

    public static void run(Path path, String jarName) throws IOException {

        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + path + " && java -jar " + jarName);

        builder.redirectErrorStream(true);

        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        while (true) {

            String line = reader.readLine();

            if (line == null) {

                break;

            }

            System.out.println(line);

        }

    }


}
