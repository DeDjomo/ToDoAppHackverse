package cm.polytechnique;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

import static javafx.scene.Cursor.*;



public class App extends Application {
    static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"),1920,1080);
        scene.getStylesheets().add(getClass().getResource("Styles.css").toExternalForm());
        stage.setScene(scene);
        // pour afficher le stage (1920x1080)
        stage.show();
    }

    // deux fonctions statique pour pouvoir switcher entre les différentes vues
    public static void setRout(String fxml) throws IOException {
        App.scene.setRoot(loadFXML(fxml));
    }
    public static Parent loadFXML(String fxml) throws  IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Vues" + "/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }
}
