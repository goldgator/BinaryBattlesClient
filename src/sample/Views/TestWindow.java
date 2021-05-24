package sample.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;

public class TestWindow {

    @FXML
    private TextFlow txtTopCode;

    @FXML
    private TextArea inpUserCode;

    @FXML
    private TextFlow txtBottomCode;

    @FXML
    private TextFlow txtOutput;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnExit;

    @FXML
    void buttonSubmit(ActionEvent event) {

    }

    @FXML
    void buttonToMainMenu(ActionEvent event) {
        ViewUtils.LoadNewScene("MainMenu.fxml",event, getClass());
    }

}

