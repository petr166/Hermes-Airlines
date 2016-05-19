package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by DragonClau on 19/5/2016.
 */
public class CustomerScene {

    //fields
    private static Scene scene;
    private static GridPane gridPane;
    private static VBox vboxLabel, vboxText;
    private static Label fName, lName, age, phone_nr, passport_nr, title;
    private static Button completeB;
    private static TextField fNameT, lNameT, ageT, phone_nrT, passport_nrT;
    private static BorderPane borderPane;

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

        //Information Label
        fName.setText("First Name");
        lName.setText("Last Name");
        age.setText("Age");
        phone_nr.setText("Phone Number");
        passport_nr.setText("Passport Number");

        //button setup
        completeB = new Button();
        completeB.setText("Complete Booking");

        //layout
        gridPane = new GridPane();
        borderPane = new BorderPane();
        gridPane.setAlignment(Pos.CENTER);
        vboxLabel = new VBox();
        vboxText = new VBox();
        gridPane.setHgap(10);
        vboxText.setSpacing(25);
        vboxLabel.setSpacing(34);
        vboxLabel.getChildren().addAll(fName,lName,age,phone_nr,passport_nr);
        vboxText.getChildren().addAll(fNameT,lNameT,ageT,phone_nrT, passport_nrT, completeB);
        gridPane.add(vboxLabel, 0, 0);
        gridPane.add(vboxText, 1, 0);
        borderPane.setCenter(gridPane);
        borderPane.setTop(title);
        borderPane.setAlignment(title, Pos.CENTER);

        //scene
        scene = new Scene(borderPane, 500, 600);
        System.out.println("Customer into initialized");
    }

    public static Scene getScene() {
        return scene;
    }

    public static void setScene(Scene scene) {
        CustomerScene.scene = scene;
    }
}
