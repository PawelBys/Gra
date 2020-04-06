package game;

import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import main_pack.PopUp2_Controller;
import main_pack.PopUp_Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class MultiGame extends Application {

    private HashMap<KeyCode, Boolean> keys = new HashMap<KeyCode, Boolean>();
    private ArrayList<Node> shot = new ArrayList<Node>();
    Label label = new Label("100");
    Label label2 = new Label("100");
    int hp_hero1 , hp_hero2;



    private Pane appRoot = new Pane();
    private Pane gameRoot;
    private Pane uiRoot = new Pane();


    private Node player;
    private Node player2;
    private Node skills;
    private Node skills2;

    private Point2D playerVelocity = new Point2D(0, 0);
    private Point2D playerVelocity2 = new Point2D(0, 0);

    private boolean canJump = true;
    private boolean canJump2 = true;

    private int levelWidth;

    private boolean dialogEvent = false, running = true;

    private String USER;
    private String HERO;
    private String HERO2;
    private String src;


    int offset_aktualny;
    int offset_poczatkowy = 0;

    int offset_aktualny2;
    int offset_poczatkowy2 = 0;

    int k = 0;

    public Image PLAYER_IMG;
    public Image[] HeroLeft = new Image[3];
    public Image[] HeroRight = new Image[3];
    public Image HeroStay;

    public Image PLAYER_IMG2;
    public Image[] HeroLeft2 = new Image[3];
    public Image[] HeroRight2 = new Image[3];
    public Image HeroStay2;

    public boolean skill_limited = true;
    public boolean skill_enabled = false;
    public boolean skill_limited2 = true;
    public boolean skill_enabled2 = false;
    public boolean monster_moved = true;
    public boolean game_status = true;

    LevelData levelData;
    Image tlo1 = new Image("file:src/asset/Maps/background/game_background_2.png");
    Image skill_left = new Image("file:src/asset/skile/efecto_fuego_00023 _left.png");
    Image skill_right = new Image("file:src/asset/skile/efecto_fuego_00023.png");

    public void setUser(String User){
        this.USER = User;
    }

    public void setHero(String hero, String hero2){
        this.HERO = hero;
        this.HERO2 = hero2;
        switch(hero){
            case "Jenny":
                src = "file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_wide.png";
                HeroLeft[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_hold 2.png");
                break;
            case "Jonny":
                src = "file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_wide.png";
                HeroLeft[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_hold 2.png");
                break;
            case "Bob":
                src = "file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_wide.png";
                HeroLeft[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_hold 2.png");
                break;
            case "Amy":
                src = "file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png";

                HeroLeft[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png");

                break;
            case "Zulu":
                src = "file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_wide.png";
                HeroLeft[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_duck.png");


                break;
            case "Fred":
                src = "file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_wide.png";
                HeroLeft[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run0.png");
                HeroLeft[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run1.png");
                HeroLeft[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run2.png");

                HeroRight[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run0.png");
                HeroRight[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run1.png");
                HeroRight[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run2.png");

                HeroStay = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_hold 2.png");
                break;
        }

        switch(hero2){
            case "Jenny":
                src = "file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_wide.png";
                HeroLeft2[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/left/character_femaleAdventurer_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/need/right/character_femaleAdventurer_run2.png");

                HeroStay2 = new Image("file:src/asset/postacie/Female adventurer 2/PNG/Poses HD/character_femaleAdventurer_hold 2.png");
                break;
            case "Jonny":
                src = "file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_wide.png";
                HeroLeft2[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/left/character_maleAdventurer_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/need/right/character_maleAdventurer_run2.png");

                HeroStay2 = new Image("file:src/asset/postacie/Male adventurer 2/PNG/Poses HD/character_maleAdventurer_hold 2.png");
                break;
            case "Bob":
                src = "file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_wide.png";
                HeroLeft2[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/left/character_malePerson_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/need/right/character_malePerson_run2.png");

                HeroStay2 = new Image("file:src/asset/postacie/Male person 2/PNG/Poses HD/character_malePerson_hold 2.png");
                break;
            case "Amy":
                src = "file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png";

                HeroLeft2[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/left/character_femalePerson_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/need/right/character_femalePerson_run2.png");

                HeroStay2 = new Image("file:src/asset/postacie/Female person 2/PNG/Poses HD/character_femalePerson_hold.png");

                break;
            case "Zulu":
                src = "file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_wide.png";
                HeroLeft2[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/left/character_zombie_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/need/right/character_zombie_run2.png");

                HeroStay2= new Image("file:src/asset/postacie/Zombie 2/PNG/Poses HD/character_zombie_duck.png");


                break;
            case "Fred":
                src = "file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_wide.png";
                HeroLeft2[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run0.png");
                HeroLeft2[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run1.png");
                HeroLeft2[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/left/character_robot_run2.png");

                HeroRight2[0] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run0.png");
                HeroRight2[1] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run1.png");
                HeroRight2[2] = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/need/right/character_robot_run2.png");

                HeroStay2 = new Image("file:src/asset/postacie/Robot 2/PNG/Poses HD/character_robot_hold 2.png");
                break;
        }

        PLAYER_IMG = HeroStay;
        PLAYER_IMG2 = HeroStay2;
    }


    private void initContent(int poziom) {
        System.out.println(USER);
        System.out.println(HERO);

        Rectangle bg = new Rectangle(1280, 720);


        gameRoot = new Pane();

        // dlugosc mapy
        levelWidth = 34 * 60;
        levelData =  new LevelData(gameRoot);
        bg.setFill(new ImagePattern(tlo1));
        levelData.createMulti();


        // tworzenie playera
        player = createEntity(0, 600, 60, 55, PLAYER_IMG);
        player2 = createEntity(600, 600, 60, 55, PLAYER_IMG2);
        hp_hero1 = hp_hero2 = 100;

        // listener na jego aktualny offset
        player.translateXProperty().addListener((obs, old, newValue) -> {
            offset_aktualny = newValue.intValue();
            System.out.print(player.getTranslateX());
            System.out.print(" - " +player.getTranslateY() + "\n");

            // obsluga kamery jezeli sie postac przesuwa to mapa razem z nia
            if (offset_aktualny > 640 && offset_aktualny < levelWidth - 640) {
                gameRoot.setLayoutX(-(offset_aktualny - 640));
            }
        });

        player2.translateXProperty().addListener((obs, old, newValue) -> {
            offset_aktualny2 = newValue.intValue();
            System.out.print(player2.getTranslateX());
            System.out.print(" - " +player2.getTranslateY() + "\n");

            // obsluga kamery jezeli sie postac przesuwa to mapa razem z nia
            if (offset_aktualny > 640 && offset_aktualny < levelWidth - 640) {
                gameRoot.setLayoutX(-(offset_aktualny - 640));
            }
        });

        // dodanie wszystkiego do panelu
        label.setLayoutX(0);
        label2.setLayoutX(600);
        gameRoot.getChildren().add(label2);
        gameRoot.getChildren().add(label);

        appRoot.getChildren().addAll(bg, gameRoot, uiRoot);
    }

    // funkcja do animacji skila postaci
    public void showSkill(Node skill , int value){
        skill_enabled = true;
        Line line = new Line();
        line.setStartX(skill.getTranslateX()+15);
        line.setEndX(skill.getTranslateX()+value);
        line.setStartY(skill.getTranslateY()+15);
        line.setEndY(skill.getTranslateY()+15);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(skill);
        pathTransition.setDuration(Duration.seconds(0.5));
        pathTransition.setPath(line);
        pathTransition.play();

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                skill_enabled = false;
                skill_limited = true;
                gameRoot.getChildren().remove(skill);

            }
        });
    }

    public void showSkill2(Node skill , int value){
        skill_enabled2 = true;
        Line line = new Line();
        line.setStartX(skill.getTranslateX()+15);
        line.setEndX(skill.getTranslateX()+value);
        line.setStartY(skill.getTranslateY()+15);
        line.setEndY(skill.getTranslateY()+15);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setNode(skill);
        pathTransition.setDuration(Duration.seconds(0.5));
        pathTransition.setPath(line);
        pathTransition.play();

        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                skill_enabled2 = false;
                skill_limited2 = true;
                gameRoot.getChildren().remove(skill);

            }
        });
    }



    private void update() throws IOException {
        // obluga klawiszy - W skok
        if (isPressed(KeyCode.W) && player.getTranslateY() >= 5) {
            jumpPlayer();
        }
        // obsluga klawisza Q - funkcyjny - skill
        if (isPressed(KeyCode.Q) && player.getTranslateY() >= 5) {
            Image test = new Image("file:src/asset/skile/efecto_fuego_00032.png");
            // zmienna do nalozenia limitu jednego skilla naraz na ekranie
            if(skill_limited){
                skill_limited = false;
                skills = createEntity((int)player.getTranslateX() - 50 , (int)player.getTranslateY() + 20,40,30,skill_left);
                showSkill(skills,-100);
            }
        }
        // obsluga klawisza Q - funkcyjny - skill
        if (isPressed(KeyCode.E) && player.getTranslateY() >= 5) {
            Image test = new Image("file:src/asset/skile/efecto_fuego_00032.png");
            // zmienna do nalozenia limitu jednego skilla naraz na ekranie
            if(skill_limited){
                skill_limited = false;
                skills = createEntity((int)player.getTranslateX() + 50 , (int)player.getTranslateY() + 20,40,30,skill_right);
                showSkill(skills,100);
            }
        }
        // obsluga klawisza A - idziemy w lewo
        if (isPressed(KeyCode.A) && player.getTranslateX() >= 5) {
            movePlayerX(-5);
            // na podstawie offsetu jest zrobiona animacja
            if(offset_aktualny + 10 < offset_poczatkowy){
                offset_poczatkowy = offset_aktualny;
                // funkcja zmienia zdjecie do wyboru 1-3
                changeImgae((Rectangle) player,HeroLeft[k]);
            }
            // sterowanie zmiana zdjecia
            k++;
            if(k==3){
                k = 0;
            }
        }else if (isPressed(KeyCode.D) && player.getTranslateX() + 40 <= levelWidth - 5) {
            movePlayerX(5);

            if(offset_aktualny > offset_poczatkowy+10){
                offset_poczatkowy = offset_aktualny;
                changeImgae((Rectangle) player,HeroRight[k]);
            }
            k++;
            if(k==3){
                k = 0;
            }
        }else{
            changeImgae((Rectangle) player,HeroStay);
        }


        // PLAYER 2 ###############################################################################################

        // obluga klawiszy - W skok
        if (isPressed(KeyCode.I) && player2.getTranslateY() >= 5) {
            jumpPlayer2();
        }
        // obsluga klawisza Q - funkcyjny - skill
        if (isPressed(KeyCode.U) && player2.getTranslateY() >= 5) {
            Image test = new Image("file:src/asset/skile/efecto_fuego_00032.png");
            // zmienna do nalozenia limitu jednego skilla naraz na ekranie
            if(skill_limited2){
                skill_limited2 = false;
                skills2 = createEntity((int)player2.getTranslateX() - 50 , (int)player2.getTranslateY() + 20,40,30,skill_left);
                showSkill2(skills2,-100);
            }
        }
        // obsluga klawisza Q - funkcyjny - skill
        if (isPressed(KeyCode.O) && player2.getTranslateY() >= 5) {
            Image test = new Image("file:src/asset/skile/efecto_fuego_00032.png");
            // zmienna do nalozenia limitu jednego skilla naraz na ekranie
            if(skill_limited2){
                skill_limited2 = false;
                skills2 = createEntity((int)player2.getTranslateX() + 50 , (int)player2.getTranslateY() + 20,40,30,skill_right);
                showSkill2(skills2,100);
            }
        }
        // obsluga klawisza A - idziemy w lewo
        if (isPressed(KeyCode.J) && player2.getTranslateX() >= 5) {
            movePlayerX2(-5);
            // na podstawie offsetu jest zrobiona animacja
            if(offset_aktualny2 + 10 < offset_poczatkowy2){
                offset_poczatkowy2 = offset_aktualny2;
                // funkcja zmienia zdjecie do wyboru 1-3
                changeImgae((Rectangle) player2,HeroLeft2[k]);
            }
            // sterowanie zmiana zdjecia
            k++;
            if(k==3){
                k = 0;
            }
        }else if (isPressed(KeyCode.L) && player2.getTranslateX() + 40 <= levelWidth - 5) {
            movePlayerX2(5);

            if(offset_aktualny2 > offset_poczatkowy2+10){
                offset_poczatkowy2 = offset_aktualny2;
                changeImgae((Rectangle) player2,HeroRight2[k]);
            }
            k++;
            if(k==3){
                k = 0;
            }
        }else{
            changeImgae((Rectangle) player2,HeroStay2);
        }

        // detekcja kolizji
        if(skill_enabled == true){
            if(skills.getBoundsInParent().intersects(player2.getBoundsInParent())) {
                if ((boolean) player2.getProperties().get("alive")) {
                    if(hp_hero2 <= 0){
                        System.out.println("o kurwa");
                        player2.getProperties().put("alive", false);
                        gameRoot.getChildren().remove(player2);

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/fxml/PopUp2_Layout.fxml"));
                        Parent nextRoot = loader.load();
                        PopUp2_Controller popup = loader.getController();
                        popup.set_hero(HERO,HERO2);
                        popup.user(USER);

                        Scene nextScene = new Scene(nextRoot);
                        Stage window = new Stage();
                        window.setScene(nextScene);
                        window.show();

                        Stage stage = (Stage) appRoot.getScene().getWindow();
                        stage.close();
                    }else{
                        hp_hero2 -= getRandomNumberInRange(1,3);
                        label2.setText(String.valueOf(hp_hero2));
                    }
                }
            }
        }
        // detekcja kolizji
        if(skill_enabled2 == true){
            if(skills2.getBoundsInParent().intersects(player.getBoundsInParent())) {
                if ((boolean) player.getProperties().get("alive")) {
                    if(hp_hero1 <=0 ){
                        System.out.println("o kurwa");
                        player.getProperties().put("alive", false);
                        gameRoot.getChildren().remove(player);

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/fxml/PopUp2_Layout.fxml"));
                        Parent nextRoot = loader.load();
                        PopUp2_Controller popup = loader.getController();
                        popup.set_hero(HERO2,HERO);
                        popup.user(USER);

                        Scene nextScene = new Scene(nextRoot);
                        Stage window = new Stage();
                        window.setScene(nextScene);
                        window.show();

                        Stage stage = (Stage) appRoot.getScene().getWindow();
                        stage.close();
                    }else{
                        hp_hero1 -= getRandomNumberInRange(1,2);
                        label.setText(String.valueOf(hp_hero1));
                    }
                }
            }
        }


        if (playerVelocity.getY() < 10) {
            playerVelocity = playerVelocity.add(0, 1);
        }

        if (playerVelocity2.getY() < 10) {
            playerVelocity2 = playerVelocity2.add(0, 1);
        }


        movePlayerY((int)playerVelocity.getY());
        movePlayerY2((int)playerVelocity2.getY());


        /*if (offset_aktualny > 640 && offset_aktualny < levelWidth - 640) {
            label.setLayoutX(offset_aktualny - 100);
            label2.setLayoutX(offset_aktualny2 - 100);
        }*/

    }



    private void movePlayerX(int value) {
        boolean movingRight = value > 0;

        for (int i = 0; i < Math.abs(value); i+=2) {
            for (Node platform : levelData.getPlatforms()) {
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (player.getTranslateX() + 60 == platform.getTranslateX()) {
                            return;
                        }
                    }
                    else {
                        if (player.getTranslateX() == platform.getTranslateX() + 60) {
                            return;
                        }
                    }
                }
            }
            player.setTranslateX(player.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    private void movePlayerY(int value) {
        boolean movingDown = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : levelData.getPlatforms()) {
                if (player.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (player.getTranslateY() + 55 == platform.getTranslateY()) {
                            player.setTranslateY(player.getTranslateY() - 1);
                            canJump = true;
                            return;
                        }
                    }
                    else {
                        if (player.getTranslateY() == platform.getTranslateY() + 55) {
                            return;
                        }
                    }
                }
            }
            player.setTranslateY(player.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    private void jumpPlayer() {
        if (canJump) {
            playerVelocity = playerVelocity.add(0, -30);
            canJump = false;
        }
    }


    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    // ##################  PLAYER 2 ##############
    private void movePlayerX2(int value) {
        boolean movingRight = value > 0;

        for (int i = 0; i < Math.abs(value); i+=2) {
            for (Node platform : levelData.getPlatforms()) {
                if (player2.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingRight) {
                        if (player2.getTranslateX() + 60 == platform.getTranslateX()) {
                            return;
                        }
                    }
                    else {
                        if (player2.getTranslateX() == platform.getTranslateX() + 60) {
                            return;
                        }
                    }
                }
            }
            player2.setTranslateX(player2.getTranslateX() + (movingRight ? 1 : -1));
        }
    }

    private void movePlayerY2(int value) {
        boolean movingDown = value > 0;

        for (int i = 0; i < Math.abs(value); i++) {
            for (Node platform : levelData.getPlatforms()) {
                if (player2.getBoundsInParent().intersects(platform.getBoundsInParent())) {
                    if (movingDown) {
                        if (player2.getTranslateY() + 55 == platform.getTranslateY()) {
                            player2.setTranslateY(player2.getTranslateY() - 1);
                            canJump2 = true;
                            return;
                        }
                    }
                    else {
                        if (player2.getTranslateY() == platform.getTranslateY() + 55) {
                            return;
                        }
                    }
                }
            }
            player2.setTranslateY(player2.getTranslateY() + (movingDown ? 1 : -1));
        }
    }

    private void jumpPlayer2() {
        if (canJump2) {
            playerVelocity2 = playerVelocity2.add(0, -30);
            canJump2 = false;
        }
    }

    private Node createEntity(int x, int y, int w, int h, Image image) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(new ImagePattern(image));
        entity.getProperties().put("alive", true);

        gameRoot.getChildren().add(entity);
        return entity;
    }

    public void changeImgae(Rectangle player , Image image){
        player.setFill(new ImagePattern(image));
    }

    private boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }




    @Override
    public void start(Stage primaryStage) throws Exception {
        initContent(1);

        Scene scene = new Scene(appRoot);
        scene.setOnKeyPressed(event -> keys.put(event.getCode(), true));
        scene.setOnKeyReleased(event -> keys.put(event.getCode(), false));
        primaryStage.setTitle("Game starts");
        primaryStage.setScene(scene);
        primaryStage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (running) {
                    try {
                        update();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        timer.start();
    }
}
