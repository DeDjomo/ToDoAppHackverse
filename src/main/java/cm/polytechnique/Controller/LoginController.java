package cm.polytechnique.Controller;

import cm.polytechnique.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button Login_button;
    @FXML
    private Label Login_label;
    @FXML
    private AnchorPane already_pane;
    @FXML
    private Button create_button;
    @FXML
    private AnchorPane create_pane;
    @FXML
    private TextField email1;
    @FXML
    private TextField mail2;
    @FXML
    private PasswordField password1;
    @FXML
    private PasswordField password2;
    @FXML
    private TextField username1;
    @FXML
    private ImageView fond;




    @FXML
    void on_action_create(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    @FXML
    void on_action_login(ActionEvent event) throws IOException {
        App.setRout("MainView");
    }

    @FXML
    void on_clicked_forgot_password(MouseEvent event) {

    }

    @FXML
    void on_clicked_login(MouseEvent event) {
        create_pane.setVisible(false);
        already_pane.setVisible(true);
    }

    @FXML
    void on_clicked_signUp(MouseEvent event) {
        create_pane.setVisible(true);
        already_pane.setVisible(false);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        create_pane.setVisible(false);
        already_pane.setVisible(true);
        fond.setImage(new Image("fond3.jpg"));
    }
}
