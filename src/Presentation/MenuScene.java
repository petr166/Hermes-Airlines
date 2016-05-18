package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by Petru on 18-May-16.
 */

public class MenuScene {

    //fields
    private static Scene scene;
    private static Pane layout;
    private static VBox vbox;
    private static Label quoteLabel, welcomeLabel;
    private static ImageView img;
    private static Button bookingsB, customersB, flightsB, planesB, exitB;


    //initialize method
    public static void initialize() {

        //quoteLabel
        quoteLabel = new Label("quote inserted");
        quoteLabel.relocate(105,430);

        //welcomeLabel
        welcomeLabel = new Label("Welcome\n to\n Hermes Airlines");
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.relocate(750,210);

        //img
        img = new ImageView();
        img.relocate(30,25);

        //bookingsB
        bookingsB = new Button("Bookings");
        bookingsB.setAlignment(Pos.CENTER);
        bookingsB.setDefaultButton(true);

        //customersB
        customersB = new Button("Customers");
        customersB.setAlignment(Pos.CENTER);

        //flightsB
        flightsB = new Button("Flights");
        flightsB.setAlignment(Pos.CENTER);

        //planesB
        planesB = new Button("Planes");
        planesB.setAlignment(Pos.CENTER);

        //EXITB
        exitB = new Button("Exit");
        exitB.setAlignment(Pos.CENTER);

        //VBox
        vbox = new VBox(10);
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.relocate(800,310);
        vbox.getChildren().addAll(bookingsB,customersB,flightsB,planesB,exitB);

        //layout
        layout = new Pane();
        layout.getChildren().addAll(quoteLabel, img, welcomeLabel, vbox);

        //scene
        scene = new Scene(layout, 1200, 700);

        System.out.println("menu scene initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static VBox getVbox() {
        return vbox;
    }

    public static Label getQuoteLabel() {
        return quoteLabel;
    }

    public static Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public static ImageView getImg() {
        return img;
    }

    public static Button getBookingsB() {
        return bookingsB;
    }

    public static Button getCustomersB() {
        return customersB;
    }

    public static Button getFlightsB() {
        return flightsB;
    }

    public static Button getPlanesB() {
        return planesB;
    }

    public static Button getExitB() {
        return exitB;
    }

}
