package main_pack;

import database.DbConnector;
import game.MultiGame;
import game.PlatformGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PopUp2_Controller implements Initializable {
    public Label hello_user;
    String USER;
    String HERO;
    String HERO2;
    int SCORE;


    public void set_hero(String herosik , String herosik2){
        HERO = herosik;
        HERO2 = herosik2;
        hello_user.setText(HERO);
    }



    public void user(String user){
        USER = user;
    }



    public void go_to_menu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/menu_layout.fxml"));
        Parent nextRoot = loader.load();
        menu_Controller menu = loader.getController();
        menu.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void try_again(ActionEvent actionEvent) throws Exception {
        //Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        MultiGame multiGame = new MultiGame();
        multiGame.setHero(HERO,HERO2);
        multiGame.setUser(USER);
        multiGame.start(window);

        /*Stage window2 = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window2.close();*/

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
