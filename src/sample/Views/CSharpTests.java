package sample.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import sample.Controllers.CSharpCompileRequest;
import sample.Interfaces.SceneInitialize;
import sample.Models.CompilationType;
import sample.Models.TestModel;

public class CSharpTests implements SceneInitialize {


    @FXML
    private Button btnTest1;

    @FXML
    private Button btnTest2;

    @FXML
    private Button btnTest3;

    @FXML
    private Button btnTest4;

    @FXML
    private Button btnTest5;

    @FXML
    private Button btnExit;

    private void setButtons(boolean active){
        btnTest1.setDisable(active);
        btnTest2.setDisable(active);
        btnTest3.setDisable(active);
        btnTest4.setDisable(active);
        btnTest5.setDisable(active);
        btnExit.setDisable(active);
    }

    @FXML
    void buttonTest1(ActionEvent event) {
        setButtons(true);

        int testNum = 0;

        String codeBase = CSharpCompileRequest.returnCodeBase(testNum);
        codeBase = codeBase.replaceAll("\\\\r\\\\n", "\n");

        //Remove quotations
        codeBase.replaceAll("\"", "");

        String[] codeSplit = codeBase.split("//");

        String testName = CSharpCompileRequest.getTestName(testNum);
        TestModel model = new TestModel(CompilationType.CSHARP, testName, codeSplit);

        ViewUtils.LoadNewScene("TestWindow.fxml",event, getClass(), model);
    }

    @FXML
    void buttonTest2(ActionEvent event) {

    }

    @FXML
    void buttonTest3(ActionEvent event) {

    }

    @FXML
    void buttonTest4(ActionEvent event) {

    }

    @FXML
    void buttonTest5(ActionEvent event) {

    }

    @FXML
    void buttonToMainMenu(ActionEvent event) {
        ViewUtils.LoadNewScene("MainMenu.fxml",event, getClass(), null);
    }

    @Override
    public void initialize(Stage stage) {

    }
}


