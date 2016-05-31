package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Petru on 5/26/2016.
 */

public class BookingEditScene {

    //fields
    private static Stage dialogStage;
    private static Scene scene;
    private static Pane layout;
    private static Label customerLabel, addCustomerLabel;
    private static Label bookingLabel;
    private static Label routeLabel;
    private static Label departure_dateLabel;
    private static Label categoryLabel;
    private static Label priceLabel;
    private static VBox labelsLayout;
    private static VBox detailsLayout;

    private static ComboBox<String> customerBox;
    private static ComboBox<String> routeBox;
    private static DatePicker departure_datePicker;

    private static RadioButton firstC;
    private static RadioButton coachC;
    private static RadioButton economyC;
    private static ToggleGroup g;
    private static HBox toggleBox;

    private static Button addCustomer;
    private static Button okButton;
    private static Button cancelButton;
    private static Label priceLabelObs;

    private static HBox buttons;


    //initialization of objects
    public static void initialize(){

        //bookingLabel
        bookingLabel = new Label("Booking details");
        bookingLabel.relocate(190,51);
        bookingLabel.setStyle("-fx-font-size:20pt");


        //customer label
        customerLabel = new Label("Select customer");

        //add customer label
        addCustomerLabel = new Label("OR");

        //routeLabel
        routeLabel = new Label("Route");

        //departureLabel
        departure_dateLabel = new Label("Departure date");

        //categoryLabel
        categoryLabel = new Label("Category");

        //priceLabel
        priceLabel = new Label("Price");

        //labelsLayout
        labelsLayout = new VBox();
        labelsLayout.getChildren().addAll(customerLabel,addCustomerLabel, routeLabel,departure_dateLabel,categoryLabel,priceLabel);
        labelsLayout.setSpacing(34);
        labelsLayout.relocate(41,138);


        //customer box
        customerBox = new ComboBox<>();
        customerBox.setMinWidth(270);

        //add customer button
        addCustomer = new Button("New customer");
        addCustomer.setMinWidth(270);

        //route
        routeBox = new ComboBox<>();
        routeBox.setMaxWidth(270);

        //departure date
        departure_datePicker = new DatePicker();
        departure_datePicker.setMinWidth(270);

        //fare_class radio buttons
        firstC = new RadioButton("First class");
        coachC = new RadioButton("Coach");
        economyC = new RadioButton("Economy");

        //toggle group
        g = new ToggleGroup();
        firstC.setToggleGroup(g);
        coachC.setToggleGroup(g);
        economyC.setToggleGroup(g);

        //toggle group layout
        toggleBox = new HBox();
        toggleBox.getChildren().addAll(firstC,coachC,economyC);
        toggleBox.setSpacing(10);

        //price label obs
        priceLabelObs = new Label("");
        //cancel button
        cancelButton = new Button("Cancel");

        //ok button
        okButton = new Button("OK");
        okButton.setDefaultButton(true);

        buttons = new HBox(10);
        buttons.getChildren().addAll(okButton, cancelButton);
        buttons.setAlignment(Pos.CENTER);

        //details layout
        detailsLayout = new VBox();
        detailsLayout.getChildren().addAll(customerBox,addCustomer, routeBox,departure_datePicker,toggleBox,priceLabelObs,buttons);
        detailsLayout.setSpacing(24);
        detailsLayout.relocate(210,139);
        toggleBox.setPadding(new Insets(10,0,0,0));
        priceLabelObs.setPadding(new Insets(10,0,0,0));




        //layout
        layout = new Pane();
        layout.getChildren().addAll(bookingLabel,labelsLayout,detailsLayout);

        //Scene
        scene = new Scene(layout,500,600);
        scene.getStylesheets().addAll("/Presentation/style.css");

        //Stage
        dialogStage = new Stage();
        dialogStage.getIcons().add(new Image("/Presentation/icon.png"));
        dialogStage.setScene(scene);

        System.out.println("booking edit dialog initialized");
    }


    //getters
    public static Stage getDialogStage() {
        return dialogStage;
    }

    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getCustomerLabel() {
        return customerLabel;
    }

    public static Label getAddCustomerLabel() {
        return addCustomerLabel;
    }

    public static Label getBookingLabel() {
        return bookingLabel;
    }

    public static Label getRouteLabel() {
        return routeLabel;
    }

    public static Label getDeparture_dateLabel() {
        return departure_dateLabel;
    }

    public static Label getCategoryLabel() {
        return categoryLabel;
    }

    public static Label getPriceLabel() {
        return priceLabel;
    }

    public static VBox getLabelsLayout() {
        return labelsLayout;
    }

    public static VBox getDetailsLayout() {
        return detailsLayout;
    }

    public static ComboBox<String> getCustomerBox() {
        return customerBox;
    }

    public static ComboBox<String> getRouteBox() {
        return routeBox;
    }

    public static DatePicker getDeparture_datePicker() {
        return departure_datePicker;
    }

    public static RadioButton getFirstC() {
        return firstC;
    }

    public static RadioButton getCoachC() {
        return coachC;
    }

    public static RadioButton getEconomyC() {
        return economyC;
    }

    public static ToggleGroup getG() {
        return g;
    }

    public static HBox getToggleBox() {
        return toggleBox;
    }

    public static Button getAddCustomer() {
        return addCustomer;
    }

    public static Button getOkButton() {
        return okButton;
    }

    public static Button getCancelButton() {
        return cancelButton;
    }

    public static Label getPriceLabelObs() {
        return priceLabelObs;
    }

}
