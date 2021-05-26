package sample.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.Window;
import sample.Controllers.CSharpCompileRequest;
import sample.Interfaces.SceneInitialize;
import sample.Models.CompilationType;
import sample.Models.TestModel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class TestWindow implements SceneInitialize {

    TestModel currentModel;

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

    Font font = new Font("Courier New", 14);

    @Override
    public void initialize(Stage stage) {
        currentModel = (TestModel) stage.getUserData();
        // Step 3

        fillElements(currentModel);
    }

    private void fillElements(TestModel model) {

        Label text1 = new Label(model.codeSplit[0]);
        text1.setStyle("-fx-text-fill: white;");
        text1.setFont(font);
        txtTopCode.getChildren().add(text1);

        Label text2 = new Label(model.codeSplit[2]);
        text2.setStyle("-fx-text-fill: white;");
        text2.setFont(font);
        txtBottomCode.getChildren().add(text2);

        Label text3 = new Label("Instructions: " + model.codeSplit[1]);
        text3.setStyle("-fx-text-fill: white;");
        text3.setFont(font);
        txtOutput.getChildren().add(text3);
    }

    private void setButtonsDisable(boolean active){
        btnSubmit.setDisable(active);
        btnExit.setDisable(active);
    }

    @FXML
    void buttonSubmit(ActionEvent event) {
        setButtonsDisable(true);
        String result = verifyTest();
        setButtonsDisable(false);

        Label text3 = new Label(result);
        text3.setStyle("-fx-text-fill: white;");
        text3.setFont(font);
        txtOutput.getChildren().add(0,text3);
    }



    private String verifyTest() {
        String userCode = inpUserCode.getText();
        String returnString = "";
        switch (currentModel.type) {
            case CSHARP:
                returnString = CSharpCompileRequest.returnTestResults(currentModel.testName, userCode);
                break;
            case JAVA:
                returnString = "Unimplemented";
                break;
            case PYTHON:
                returnString = "Unimplemented";
                break;
        }

        returnString = returnString.replaceAll("\\\\n", "\n");

        return returnString;
    }

    @FXML
    void buttonToMainMenu(ActionEvent event) {
        ViewUtils.LoadNewScene("MainMenu.fxml",event, getClass(), null);
    }


}

