package sample.Views;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.stage.Stage;
import sample.Interfaces.SceneInitialize;

import java.net.URL;

public class ViewUtils {



    public static <T> void LoadNewScene(String newScene, ActionEvent event, Class<T> controllerClass, Object data) {
        Stage stage;
        Parent root;

        try {
            stage = (Stage) ((Control)event.getSource()).getScene().getWindow();
            stage.setUserData(data);

            FXMLLoader loader = new FXMLLoader(controllerClass.getResource(newScene));
            root = (Parent) loader.load();
            SceneInitialize initialize = (SceneInitialize)loader.getController();
            initialize.initialize(stage);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
