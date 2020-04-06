package main_pack;

import game.PlatformGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class single_Controller implements Initializable {
    public Label hello_user;
    String USER;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void hello_user(String unsername){
        hello_user.setText("Login as: "+unsername);
        USER = unsername;
    }

    public void JennySelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Jenny");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Jenny");
        platformGame.start(window);


    }

    public void AmySelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Ammy");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Amy");
        platformGame.start(window);
    }

    public void JonnySelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Jonny");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Jonny");
        platformGame.start(window);

    }

    public void BobSelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Bob");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Bob");
        platformGame.start(window);
    }

    public void ZuluSelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Zulu");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Zulu");
        platformGame.start(window);
    }

    public void FredSelected(MouseEvent mouseEvent) throws Exception {
        System.out.println("User = "+USER);
        System.out.println("Wybrano postać Fred");

        Stage window = (Stage) ((Node)mouseEvent.getSource()).getScene().getWindow();
        PlatformGame platformGame = new PlatformGame();
        platformGame.setUser(USER);
        platformGame.setHero("Fred");
        platformGame.getStage(window);
        platformGame.start(window);
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
}
