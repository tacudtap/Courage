package com.patrickducat;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

class BuildTools {

    private static final String URL = "https://hub.spigotmc.org/jenkins/job/BuildTools/lastSuccessfulBuild/artifact/target/BuildTools.jar";
    private static final String JAR_NAME = "buildtools.jar";
    private static Path path;
    private final File LOG_FILE = new File(String.valueOf(path), "BuildTools.log.txt");

    public static Path getPath() {
        return path;
    }

    static void download() throws IOException {

        InputStream source = new URL(URL).openStream();
        Path target = Paths.get(String.valueOf(Server.getBuildtoolsDirectory()), JAR_NAME);

        Files.copy(source, target, REPLACE_EXISTING);

    }

    public String getJAR_NAME() {
        return JAR_NAME;
    }

    public File getLOG_FILE() {
        return LOG_FILE;
    }

    boolean createDirectories(String serverDirectory) {

        path = Paths.get(System.getProperty("user.home"), serverDirectory, "buildtools");

        File file = new File(path.toString());

        return file.mkdirs();

    }

}
