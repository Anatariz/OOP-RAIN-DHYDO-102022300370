import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Button button;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
public void handleLoginButtonAction() {
    String user = username.getText();
    String pass = password.getText();
    // Implement your login logic here
    if (user.equals("Dhydo") && pass.equals("102022300370")) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("inventory.fxml"));
            Stage stage = (Stage) button.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}