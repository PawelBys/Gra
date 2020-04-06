package main_pack;

import database.DbConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class register_Controller implements Initializable {
    public PasswordField getUserPassword;
    public TextField getUserName;
    public PasswordField getUserConfirmPassword;
    public Button signIn;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void registerAccount(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String username, password , password1;
        username = getUserName.textProperty().get();
        password = getUserPassword.textProperty().get();
        password1 = getUserConfirmPassword.textProperty().get();

        if(password.equals(password1)){
            DbConnector db = new DbConnector();
            db.add_user(username,password);

            Parent nextRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
            Scene nextScene = new Scene(nextRoot);
            Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();

        }else{
            System.out.println("Hasla sie nie zgadzaja");
        }
    }
}
