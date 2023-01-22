package stu_109504501.A11_109504501;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class MenuController {

    @FXML
    public void onStartPressed() throws IOException{
        HelloApplication.gameScene.getRoot().requestFocus();
        HelloApplication.currentStage.setScene(HelloApplication.gameScene);
    }

    @FXML
    public void onExitPressed() throws IOException{
        HelloApplication.currentStage.close();
    }
}