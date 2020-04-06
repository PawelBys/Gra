package main_pack;

import database.DbConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main_pack.menu_Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public PasswordField getUserPassword;
    public TextField getUserName;
    public Label registerLabel;
    public Label infoAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void loginToGame(ActionEvent actionEvent) throws IOException {
        String username = getUserName.textProperty().get();
        String password = getUserPassword.textProperty().get();

        DbConnector db = new DbConnector();
        DbConnector.polaczenie_z_baza();
        try {
            if(db.logInToGame(username,password)){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/menu_layout.fxml"));
                Parent nextRoot = loader.load();
                menu_Controller menu = loader.getController();
                menu.hello_user(getUserName.getText());

                Scene nextScene = new Scene(nextRoot);
                Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
                window.setScene(nextScene);
                window.show();
            }else{
                infoAccount.setText("Nie ma takiego konta.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        /*FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu_layout.fxml"));
        Parent nextRoot = loader.load();
        menu_Controller menu = loader.getController();
        menu.hello_user(getUserName.getText());

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();*/

    }

    public void goRegister(MouseEvent mouseEvent) throws IOException {
        Parent nextRoot = FXMLLoader.load(getClass().getResource("/fxml/register_layout.fxml"));
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }


}
