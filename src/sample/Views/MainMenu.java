package sample.Views;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.View;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class MainMenu {

    @FXML
    private Button btnJava;

    @FXML
    private Button btnCSharp;

    @FXML
    private Button btnPython;

    @FXML
    private Button btnExit;

    @FXML
    void buttonJavaScreen(ActionEvent event) {
        ViewUtils.LoadNewScene("JavaTests.fxml",event, getClass());
    }

    @FXML
    void buttonCSharpScreen(ActionEvent event) {
        ViewUtils.LoadNewScene("CSharpTests.fxml",event, getClass());
    }

    @FXML
    void buttonPythonScreen(ActionEvent event) {
        ViewUtils.LoadNewScene("PythonTests.fxml",event, getClass());
    }

    @FXML
    void buttonCloseApplication(ActionEvent event) {
        System.exit(0);
    }

}

