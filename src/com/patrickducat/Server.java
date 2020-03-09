package com.patrickducat;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Server {

    private static Path buildtoolsDirectory;

    public static Path getBuildtoolsDirectory() {
        return buildtoolsDirectory;
    }

    public static Path createDirectory(String serverDirectory) {

        buildtoolsDirectory = Paths.get(System.getProperty("user.home"), serverDirectory, "buildtools");

        File file = buildtoolsDirectory.toFile();
        file.mkdirs();

        return buildtoolsDirectory.getParent().toAbsolutePath();

    }

}
