package com.patrickducat;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class temp {

    public static void main(String[] args) throws IOException {

        BuildTools buildTools = new BuildTools();
        buildTools.createDirectories("local-server");
        BuildTools.download();
        Jar.run(BuildTools.getPath(), buildTools.getJAR_NAME());

        File logFile = buildTools.getLOG_FILE();
        Spigot spigot = new Spigot(logFile);

        Path spigotJar = spigot.move();

        Path path = Paths.get(spigotJar.getRoot().toString(), spigotJar.subpath(0, 3).toString());
        Jar.run(path, spigotJar.getFileName().toString());

        Path eulaPath = Paths.get(path.toString(), "eula.txt");
        Util.signEULA(eulaPath.toString(), "false", "true");

        Jar.run(path, spigotJar.getFileName().toString());

    }

}