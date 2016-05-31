package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Administrator on 5/22/2016.
 */
public class CustomerEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static GridPane gridPane;
    private static VBox vboxLabel, vboxText;
    private static Label fName, lName, age, phone_nr, passport_nr, title;
    private static Button okB,cancelB;
    private static TextField fNameT, lNameT, ageT, phone_nrT, passport_nrT;
    private static BorderPane borderPane;
    private static HBox buttons;

    //initialize method
    public static void initialize() {

        //initializing labels
        title = new Label();
        fName = new Label();
        lName = new Label();
        age = new Label();
        phone_nr = new Label();
        passport_nr = new Label();

        //initializing text boxes
        fNameT = new TextField();
        lNameT = new TextField();
        ageT = new TextField();
        phone_nrT = new TextField();
        passport_nrT = new TextField();

        //Title Label
        title.setText("\n\nCustomer Information");
        title.setStyle("-fx-font-size:28pt");

        //Information Label
        fName.setText("First Name");
        lName.setText("Last Name");
        age.setText("Age");
        phone_nr.setText("Phone Number");
        passport_nr.setText("Passport Number");

        //button setup
        okB = new Button("Ok");
        cancelB = new Button("Cancel");

        //layout
        buttons = new HBox();
        buttons.getChildren().addAll(okB,cancelB);
        gridPane = new GridPane();
        borderPane = new BorderPane();
        gridPane.setAlignment(Pos.CENTER);
        vboxLabel = new VBox();
        vboxText = new VBox();
        gridPane.setHgap(10);
        vboxText.setSpacing(25);
        vboxLabel.setSpacing(40);
        vboxLabel.getChildren().addAll(fName,lName,age,phone_nr,passport_nr);
        vboxText.getChildren().addAll(fNameT,lNameT,ageT,phone_nrT, passport_nrT,buttons);
        gridPane.add(vboxLabel, 0, 0);
        gridPane.add(vboxText, 1, 0);
        borderPane.setCenter(gridPane);
        borderPane.setTop(title);
        borderPane.setAlignment(title, Pos.CENTER);

        //scene
        dialogStage = new Stage();
        scene = new Scene(borderPane, 500, 600);
        scene.getStylesheets().addAll("/Presentation/style.css");
        dialogStage.setScene(scene);
        System.out.println("Customer into initialized");
    }

    //GETTERS

    public static Stage getDialogStage(){
        return dialogStage;
    }

    public static Button getOkB() {
        return okB;
    }

    public static Button getCancelB() {
        return cancelB;
    }

    public static TextField getfNameT() {
        return fNameT;
    }

    public static TextField getlNameT() {
        return lNameT;
    }

    public static TextField getAgeT() {
        return ageT;
    }

    public static TextField getPhone_nrT() {
        return phone_nrT;
    }

    public static TextField getPassport_nrT() {
        return passport_nrT;
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        CustomerEditScene.scene = scene;
    }
}
