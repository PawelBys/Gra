package game;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LevelData {

    private ArrayList<Node> platforms = new ArrayList<Node>();
    private ArrayList<Node> coins = new ArrayList<Node>();
    private ArrayList<Node> water = new ArrayList<Node>();
    private ArrayList<Node> doors = new ArrayList<Node>();
    Node next_lever_door;
    private ArrayList<Node> chests = new ArrayList<Node>();
    private ArrayList<Node> monster = new ArrayList<Node>();

    private Pane gameRoot;

    // problemy gita
    //sa pojebane

    Image Tile_1 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/1.png");
    Image Tile_2 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/2.png");
    Image Tile_3 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/3.png");
    Image Tile_4 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/4.png");
    Image Tile_5 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/5.png");
    Image Tile_6 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/6.png");
    Image Tile_7 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/7.png");
    Image Tile_8 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/8.png");
    Image Tile_9 = new Image("file:src/asset/Maps/Zestaw_1/Tiles/9.png");
    Image Tile_a = new Image("file:src/asset/Maps/Zestaw_1/Tiles/a.png");
    Image Tile_b = new Image("file:src/asset/Maps/Zestaw_1/Tiles/b.png");
    Image Tile_c = new Image("file:src/asset/Maps/Zestaw_1/Tiles/c.png");
    Image Tile_d = new Image("file:src/asset/Maps/Zestaw_1/Tiles/d.png");
    Image Tile_e = new Image("file:src/asset/Maps/Zestaw_1/Tiles/e.png");
    Image Tile_z = new Image("file:src/asset/rozne/door.png");
    Image Tile_y = new Image("file:src/asset/rozne/chest.png");
    Image Tile_x = new Image("file:src/asset/rozne/coin.png");
    Image Tile_m = new Image("file:src/asset/Golem_02_Jump Start_000.png");

    Image Tile_2_1 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/1.png");
    Image Tile_2_2 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/2.png");
    Image Tile_2_3 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/3.png");
    Image Tile_2_4 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/4.png");
    Image Tile_2_5 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/5.png");
    Image Tile_2_6 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/6.png");
    Image Tile_2_7 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/7.png");
    Image Tile_2_8 = new Image("file:src/asset/Maps/Zestaw_3/Tiles_rock/8.png");

    Image Tile_3_1 = new Image("file:src/asset/Maps/Zestaw_4/1.png");
    Image Tile_3_2 = new Image("file:src/asset/Maps/Zestaw_4/2.png");
    Image Tile_3_3 = new Image("file:src/asset/Maps/Zestaw_4/3.png");
    Image Tile_3_4 = new Image("file:src/asset/Maps/Zestaw_4/4.png");
    Image Tile_3_5 = new Image("file:src/asset/Maps/Zestaw_4/5.png");
    Image Tile_3_6 = new Image("file:src/asset/Maps/Zestaw_4/6.png");


    public LevelData(Pane gameRoot) {
        this.gameRoot = gameRoot;
    }

    public static final String[] LEVEL1 = new String[]{
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000y00000000000000",
            "0000000abc000abc00abc0000000000000",
            "00000000000000000000000000000000y0",
            "0000000000000000000000000000000abc",
            "0000abc00m000000000000000000000000",
            "000000000abc000000000000000abc0000",
            "00000000000000x0000000000000000000",
            "000m000000000abc0000x0000130000000",
            "0001222300000000000123000460m0000u",
            "12785556991223999178569978de222222"
    };
    public static final String[] LEVEL2 = new String[]{
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000m00y000000000x0000000",
            "0000522226000122230000000040000000",
            "0000000000000000000000000000000000",
            "00m000000000000x000012230000000000",
            "00123000x00008522600000000m0000000",
            "0000052226000700000000000052222600",
            "0000000000000700000000040000000000",
            "0000000000000700z00000400000000000",
            "1230440052600701222223000000000000"
    };
    public static final String[] LEVEL3 = new String[]{
            "0000000000000000000000000000000000",
            "0000000000000000000000000mx0000000",
            "00y00000000000000000000002222000000",
            "0022000000000000000000000000000000",
            "0000x0000000000000000000000000000z",
            "00022200000000000000000x0000012222",
            "0000000000002200000000222000155555",
            "00000mx000000000000200000000455555",
            "0000012223000000200000000000455555",
            "0000155555300000000000000000455555",
            "00015555555222300y000m000y00455555",
            "1225555555555552222222222222555555"
    };

    public static final String[] LEVEL_MULTI = new String[]{
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000000000000000000000000",
            "0000000000000011111000000000000000",
            "0000000000111000000011100000000000",
            "0000111100000000000000000111100000",
            "0000000000000000000000000000000000",
            "1111111111111111111111111111111111"
    };


    public Node createEntity2(int x, int y, int w, int h, Image image) {
        Rectangle entity = new Rectangle(w, h);
        entity.setTranslateX(x);
        entity.setTranslateY(y);
        entity.setFill(new ImagePattern(image));
        entity.getProperties().put("alive", true);
        gameRoot.getChildren().add(entity);

        return entity;
    }

    public void createMulti(){

        for (int i = 0; i < LEVEL_MULTI.length; i++) {
            String line = LevelData.LEVEL_MULTI[i];
            for (int j = 0; j < line.length(); j++) {

                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createEntity2(j * 60, i * 60, 60, 60, Tile_2);
                        platforms.add(platform1);
                        break;
                }
            }
        }
    }

    public void createLevel1()
    {

        for (int i = 0; i < LEVEL1.length; i++) {
            String line = LevelData.LEVEL1[i];
            for (int j = 0; j < line.length(); j++) {

                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createEntity2(j * 60, i * 60, 60, 60, Tile_1);
                        platforms.add(platform1);
                        break;
                    case '2':
                        Node platform2 = createEntity2(j * 60, i * 60, 60, 60, Tile_2);
                        platforms.add(platform2);
                        break;
                    case '3':
                        Node platform3 = createEntity2(j * 60, i * 60, 60, 60, Tile_3);
                        platforms.add(platform3);
                        break;
                    case '4':
                        Node platform4 = createEntity2(j * 60, i * 60, 60, 60, Tile_4);
                        platforms.add(platform4);
                        break;
                    case '5':
                        Node platform5 = createEntity2(j * 60, i * 60, 60, 60, Tile_5);
                        platforms.add(platform5);
                        break;
                    case '6':
                        Node platform6 = createEntity2(j * 60, i * 60, 60, 60, Tile_6);
                        platforms.add(platform6);
                        break;
                    case '7':
                        Node platform7 = createEntity2(j * 60, i * 60, 60, 60, Tile_7);
                        platforms.add(platform7);
                        break;
                    case '8':
                        Node platform8 = createEntity2(j * 60, i * 60, 60, 60, Tile_8);
                        platforms.add(platform8);
                        break;
                    case '9':
                        Node platform9 = createEntity2(j * 60, i * 60, 60, 60, Tile_9);
                        water.add(platform9);
                        break;
                    case 'a':
                        Node platforma = createEntity2(j * 60, i * 60, 60, 60, Tile_a);
                        platforms.add(platforma);
                        break;
                    case 'b':
                        Node platformb = createEntity2(j * 60, i * 60, 60, 60, Tile_b);
                        platforms.add(platformb);
                        break;
                    case 'c':
                        Node platformc = createEntity2(j * 60, i * 60, 60, 60, Tile_c);
                        platforms.add(platformc);
                        break;
                    case 'd':
                        Node platformd = createEntity2(j * 60, i * 60, 60, 60, Tile_d);
                        platforms.add(platformd);
                        break;
                    case 'e':
                        Node platforme = createEntity2(j * 60, i * 60, 60, 60, Tile_e);
                        platforms.add(platforme);
                        break;
                    case 'y':
                        Node chest = createEntity2(j * 60, i * 60, 60, 60, Tile_y);
                        coins.add(chest);
                        break;
                    case 'x':
                        Node coin = createEntity2(j * 60, i * 60, 60, 60, Tile_x);
                        chests.add(coin);
                        break;
                    case 'm':
                        Node monsterek = createEntity2(j * 60, i * 60, 60, 60, Tile_m);
                        monster.add(monsterek);
                        break;
                    case 'u':
                        Node door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        doors.add(door);
                        next_lever_door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        break;
                }
            }
        }
    }
    public void createLevel2(){
        for (int i = 0; i < LEVEL2.length; i++) {
            String line = LevelData.LEVEL2[i];
            for (int j = 0; j < line.length(); j++) {

                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_1);
                        platforms.add(platform1);
                        break;
                    case '2':
                        Node platform2 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_2);
                        platforms.add(platform2);
                        break;
                    case '3':
                        Node platform3 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_3);
                        platforms.add(platform3);
                        break;
                    case '4':
                        Node platform4 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_4);
                        platforms.add(platform4);
                        break;
                    case '5':
                        Node platform5 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_5);
                        platforms.add(platform5);
                        break;
                    case '6':
                        Node platform6 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_6);
                        platforms.add(platform6);
                        break;
                    case '7':
                        Node platform7 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_7);
                        platforms.add(platform7);
                        break;
                    case '8':
                        Node platform8 = createEntity2(j * 60, i * 60, 60, 60, Tile_2_8);
                        platforms.add(platform8);
                        break;

                    case 'y':
                        Node platformy = createEntity2(j * 60, i * 60, 60, 60, Tile_y);
                        coins.add(platformy);
                        break;
                    case 'x':
                        Node coin = createEntity2(j * 60, i * 60, 60, 60, Tile_x);
                        chests.add(coin);
                        break;
                    case 'z':
                        Node door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        doors.add(door);
                        next_lever_door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        break;
                    case 'm':
                        Node monsterek = createEntity2(j * 60, i * 60, 60, 60, Tile_m);
                        monster.add(monsterek);
                        break;
                }
            }
        }
    }

    public void createLevel3(){
        for (int i = 0; i < LEVEL3.length; i++) {
            String line = LevelData.LEVEL3[i];
            for (int j = 0; j < line.length(); j++) {

                switch (line.charAt(j)) {
                    case '0':
                        break;
                    case '1':
                        Node platform1 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_1);
                        platforms.add(platform1);
                        break;
                    case '2':
                        Node platform2 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_2);
                        platforms.add(platform2);
                        break;
                    case '3':
                        Node platform3 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_3);
                        platforms.add(platform3);
                        break;
                    case '4':
                        Node platform4 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_4);
                        platforms.add(platform4);
                        break;
                    case '5':
                        Node platform5 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_5);
                        platforms.add(platform5);
                        break;
                    case '6':
                        Node platform6 = createEntity2(j * 60, i * 60, 60, 60, Tile_3_6);
                        platforms.add(platform6);
                        break;

                    case 'y':
                        Node platformy = createEntity2(j * 60, i * 60, 60, 60, Tile_y);
                        coins.add(platformy);
                        break;
                    case 'x':
                        Node coin = createEntity2(j * 60, i * 60, 60, 60, Tile_x);
                        chests.add(coin);
                        break;
                    case 'z':
                        Node door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        doors.add(door);
                        next_lever_door = createEntity2(j * 60, i * 60, 60, 60, Tile_z);
                        break;
                    case 'm':
                        Node monsterek = createEntity2(j * 60, i * 60, 60, 60, Tile_m);
                        monster.add(monsterek);
                        break;
                }
            }
        }
    }

    public ArrayList<Node> getPlatforms() {
        return platforms;
    }

    public ArrayList<Node> getCoins() {
        return coins;
    }
    public ArrayList<Node> getChests() {
        return chests;
    }

    public ArrayList<Node> getMonster() {
        return monster;
    }

    public ArrayList<Node> getDoors() {
        return doors;
    }

    public ArrayList<Node> getWater() {
        return water;
    }

    public void deleteAll(){
        for(int i = 0 ; i < platforms.size() ; i++){
            platforms.remove(i);
        }
        for(int i = 0 ; i < coins.size() ; i++){
            coins.remove(i);
        }
        for(int i = 0 ; i < chests.size() ; i++){
            chests.remove(i);
        }
        for(int i = 0 ; i < monster.size(); i++){
            monster.remove(i);
        }
        for(int i = 0 ; i < water.size() ; i++){
            water.remove(i);
        }
        doors.remove(0);

    }

    public Node getNext_lever_door() {
        return next_lever_door;
    }
}