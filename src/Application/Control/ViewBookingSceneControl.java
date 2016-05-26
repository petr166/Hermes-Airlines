package Application.Control;

import Presentation.ViewBookingScene;
import javafx.scene.Scene;
import javafx.scene.control.*;

/**
 * Created by Petru on 26-May-16.
 */

public class ViewBookingSceneControl {

    //fields
    private static TableView table;
    private static Label departure_dateObs;
    private static Label arrival_dateObs;
    private static Label categoryObs;
    private static Label priceObs;

    private static Label first_nameObs;
    private static Label last_nameObs;
    private static Label ageObs;
    private static Label passportObs;
    private static Label phone_numberObs;

    private static TextField searchField;
    private static Button add_bookingButton;
    private static Button cancelButton;
    private static Button backButton;
    private static Button editButton;


    //initialize method
    public static void initialize() {

        table = ViewBookingScene.getTable();

        departure_dateObs = ViewBookingScene.getDeparture_dateObs();
        arrival_dateObs = ViewBookingScene.getArrival_dateObs();
        categoryObs = ViewBookingScene.getCategoryObs();
        priceObs = ViewBookingScene.getPriceObs();

        first_nameObs = ViewBookingScene.getFirst_nameObs();
        last_nameObs = ViewBookingScene.getLast_nameObs();
        ageObs = ViewBookingScene.getAgeObs();
        passportObs = ViewBookingScene.getPassportObs();
        phone_numberObs = ViewBookingScene.getPhone_numberObs();

        add_bookingButton = ViewBookingScene.getAdd_bookingButton();


        cancelButton = ViewBookingScene.getCancelButton();


        backButton = ViewBookingScene.getBackButton();
        backButton.setOnAction(e -> handle_backButton());


        editButton = ViewBookingScene.getBackButton();


        searchField = ViewBookingScene.getSearchField();
    }


    public static void handle_backButton() {
        MainControl.showMenuScene();
    }
}
