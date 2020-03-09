package com.patrickducat;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.nio.file.Path;

public class Controller {

    public Label statusLabel;
    public TextField serverDirectoryField;
    public Button createServerDirectoryButton;

    public void onCreateServerDirectoryButtonPress() {

        Path directory = Server.createDirectory(serverDirectoryField.getText());
        statusLabel.setText("Directory created at: " + directory);

    }

    public void onDownloadBuildtoolsButtonPress() throws IOException {

        try {
            BuildTools.download();
        } catch (Exception e) {
            statusLabel.setText("Download failed");
            return;
        }
        statusLabel.setText("Downloaded BuildTools jar");

    }
}
