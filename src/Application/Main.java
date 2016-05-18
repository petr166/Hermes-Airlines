package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * MAIN CLASS - HERMES AIRLINES ---
 */


public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    //start method
    public void start(Stage primaryStage) {

        Pane pane = new Pane();

        primaryStage.setTitle("Hermes Airlines");

        Scene scene = new Scene(pane, 600, 400);


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}