package sample.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;

public class ViewUtils {

    public static <T> void LoadNewScene(String newScene, ActionEvent event, Class<T> controllerClass) {
        Stage stage;
        Parent root;

        try {
            stage = (Stage) ((Control)event.getSource()).getScene().getWindow();
            root = FXMLLoader.load(controllerClass.getResource(newScene));

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
