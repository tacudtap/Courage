package com.patrickducat;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

class Spigot {

    final File logFile;

    Spigot(File buildToolsLogFile) {

        logFile = buildToolsLogFile;

    }

    String getJarName() throws IOException {

        String fileAsString = "";

        try {

            fileAsString = FileUtils.readFileToString(logFile);

        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());

        }

        int lastIndex = fileAsString.lastIndexOf("spigot");
        int stringLength = fileAsString.length();

        return fileAsString.substring(lastIndex, stringLength).trim();

    }

    Path move() throws IOException {

        String root = BuildTools.getPath().getRoot().toString();
        String buildtoolsFolder = BuildTools.getPath().toString();
        String serverFolder = BuildTools.getPath().subpath(0, 3).toString();
        Path source = Paths.get(buildtoolsFolder, getJarName());
        Path target = Paths.get(root, serverFolder, getJarName());

        return Files.move(source, target, REPLACE_EXISTING);
    }

}
