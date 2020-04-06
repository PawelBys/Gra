package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Random;

public class GameDialog extends Stage {

    private Text textQuestion = new Text();
    private TextField fieldAnswer = new TextField();
    private Text textActualAnswer = new Text();

    private boolean correct = false;

    String[] QuestionArray = new String[]{
            "Karta graficzna to GPU, a procesor?",
            "Oprogramowanie to software, a sprzęt?",
            "Pamięć operacyjna komputera to:",
            "Dysk talerzony inaczej nazywamy:",
            "Pamięci półprzewodnikowe z interfejsem SATA",
            "Czy HDMI to złącze komercyjne? tak/nie",
            "1 B= ? b",
            "Częstotliwość zegara podajemy w:",
            "Model barw stosowany w monitorach",
            "Model barw stosowany w drukarkach"
    };
    String[] AnswerArray = new String[]{
            "CPU",
            "hardware",
            "RAM",
            "HDD",
            "SSD",
            "tak",
            "8",
            "MHz",
            "RGB",
            "CMYK"
    };

    public int GenerateNumber(){
        int number;
        Random generator = new Random();
        number = generator.nextInt(10);
        return number;
    }


    public GameDialog() {
        Button btnSubmit = new Button("Submit");
        btnSubmit.setOnAction(event -> {
            fieldAnswer.setEditable(false);
            textActualAnswer.setVisible(true);
            correct = textActualAnswer.getText().equals(fieldAnswer.getText().trim());
        });




        VBox vbox = new VBox(10, textQuestion, fieldAnswer, textActualAnswer, btnSubmit);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);

        setScene(scene);
        initModality(Modality.APPLICATION_MODAL);
    }

    public void open() {
        int number = GenerateNumber();
        textQuestion.setText(QuestionArray[number]);
        fieldAnswer.setText("");
        fieldAnswer.setEditable(true);
        textActualAnswer.setText(AnswerArray[number]);
        textActualAnswer.setVisible(false);

        show();
    }

    public boolean isCorrect() {
        return correct;
    }
}