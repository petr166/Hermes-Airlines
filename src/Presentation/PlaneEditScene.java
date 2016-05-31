package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Administrator on 5/21/2016.
 */

public class PlaneEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static GridPane gridPane;
    private static VBox vboxLabel, vboxText;
    private static Label plane_nameLabel, firstClassLabel, coachLabel, economyLabel, titleLabell;
    private static Button okB;
    private static Button cancelB;
    private static TextField plane_nameT, firstClassT, coachT, economyT;
    private static BorderPane borderPane;
    private static HBox buttons;


    //initialization of objects
    public static void initialize(){

        //initializing labels
        plane_nameLabel = new Label("Plane name");
        firstClassLabel = new Label("First class");
        coachLabel = new Label("Coach class");
        economyLabel = new Label("Economy class");

        //initializing text boxes
        plane_nameT = new TextField();
        firstClassT = new TextField();
        coachT = new TextField();
        economyT = new TextField();

        //title Label
        titleLabell = new Label();
        titleLabell.setText("\n\n\n\nPlane details");

        //button setup
        okB = new Button("Ok");
        okB.setDefaultButton(true);
        cancelB = new Button("Cancel");

        //layout
        gridPane = new GridPane();
        borderPane = new BorderPane();
        gridPane.setAlignment(Pos.CENTER);

        vboxLabel = new VBox();
        vboxText = new VBox();
        buttons = new HBox();

        buttons.setSpacing(10);
        buttons.getChildren().addAll(okB,cancelB);

        gridPane.setHgap(10);
        vboxText.setSpacing(25);
        vboxLabel.setSpacing(34);

        vboxLabel.getChildren().addAll(plane_nameLabel,firstClassLabel,coachLabel,economyLabel);
        vboxText.getChildren().addAll(plane_nameT,firstClassT,coachT,economyT, buttons);
        gridPane.add(vboxLabel, 0, 0);
        gridPane.add(vboxText, 1, 0);
        borderPane.setCenter(gridPane);
        borderPane.setTop(titleLabell);
        borderPane.setAlignment(titleLabell, Pos.CENTER);


        //stage setup
        scene = new Scene(borderPane, 500, 600);

        dialogStage = new Stage();
        dialogStage.getIcons().add(new Image("/Presentation/icon.png"));
        dialogStage.setScene(scene);

        System.out.println("plane edit dialog initialized");
    }


    //getters
    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static Button getOkB() {
        return okB;
    }

    public static Button getCancelB() {
        return cancelB;
    }

    public static TextField getPlane_nameT() {
        return plane_nameT;
    }

    public static TextField getFirstClassT() {
        return firstClassT;
    }

    public static TextField getCoachT() {
        return coachT;
    }

    public static TextField getEconomyT() {
        return economyT;
    }

    public static BorderPane getBorderPane() {
        return borderPane;
    }

    public static HBox getButtons() {
        return buttons;
    }

    public static Scene getScene() {
        return scene;
    }
}
