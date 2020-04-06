package main_pack;

import game.MultiGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class multi_3_Controller implements Initializable {

    public Label hello_user;
    public Label player_1_hero;
    public Label player_2_hero;
    public ImageView player1_img;
    public ImageView player2_img;
    public Image test;
    String USER;
    String HERO_1,HERO_2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }

    public void players_hero(String hero_1 , String hero_2){
        HERO_1 = hero_1;
        HERO_2 = hero_2;
        player_1_hero.setText(HERO_1);
        player_2_hero.setText(HERO_2);
        
    }

    public void single(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/single_layout.fxml"));
        Parent nextRoot = loader.load();
        single_Controller single_controller = loader.getController();
        single_controller.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void multi(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/multi_1_layout.fxml"));
        Parent nextRoot = loader.load();
        multi_1_Controller multi = loader.getController();
        multi.hello_user(USER);

        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void show_score(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/ShowScore_layout.fxml"));
        Parent nextRoot = loader.load();
        ShowScore_Controller temp = loader.getController();
        temp.hello_user(USER);
        temp.set_10_top_players();
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void show_hero(ActionEvent actionEvent) {
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        USER = null;
        Parent nextRoot = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        Scene nextScene = new Scene(nextRoot);
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    public void lets_play_multi(ActionEvent actionEvent) throws Exception {
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        MultiGame multiGame = new MultiGame();
        multiGame.setHero(HERO_1,HERO_2);
        multiGame.setUser(USER);
        multiGame.start(window);
    }
}
