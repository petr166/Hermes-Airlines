package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by Petru on 18-May-16.
 */

public class FlightsScene {

    //fields
    private static Pane layout;
    private static Scene scene;
    private static TableView table;
    private static TableColumn dateColumn, routeColumn, priceColumn, bookingsColumn;
    private static TextField search;
    private static HBox buttonLayout;
    private static Button backB, viewCustomB, addB, editB;


    //initialize method
    public static void initialize() {

        //table columns
        dateColumn = new TableColumn("Date");
        routeColumn = new TableColumn("Route");
        priceColumn = new TableColumn("Price");
        bookingsColumn = new TableColumn("Bookings");

        //table
        table = new TableView();
        table.setMinSize(1116,591);
        table.relocate(42,32);
        table.getColumns().addAll(dateColumn,routeColumn,priceColumn,bookingsColumn);

        //search field
        search = new TextField();
        search.setPromptText("search");
        search.setMinWidth(545);
        search.relocate(42,642);

        //back butt
        backB = new Button("Back");

        //view customers butt
        viewCustomB = new Button("View customers");

        //add butt
        addB = new Button("Add");

        //edit butt
        editB = new Button("Edit");

        //button layout
        buttonLayout = new HBox(20);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.relocate(685,635);
        buttonLayout.getChildren().addAll(backB,viewCustomB,addB,editB);

        //layout setup
        layout = new Pane();
        layout.getChildren().addAll(table,search,buttonLayout);

        //scene
        scene = new Scene(layout, 1200, 700);

        System.out.println("flights scene initialized");
    }


    //getters
    public static Pane getLayout() {
        return layout;
    }

    public static Scene getScene() {
        return scene;
    }

    public static TableView getTable() {
        return table;
    }

    public static TableColumn getDateColumn() {
        return dateColumn;
    }

    public static TableColumn getRouteColumn() {
        return routeColumn;
    }

    public static TableColumn getPriceColumn() {
        return priceColumn;
    }

    public static TableColumn getBookingsColumn() {
        return bookingsColumn;
    }

    public static TextField getSearch() {
        return search;
    }

    public static HBox getButtonLayout() {
        return buttonLayout;
    }

    public static Button getBackB() {
        return backB;
    }

    public static Button getViewCustomB() {
        return viewCustomB;
    }

    public static Button getAddB() {
        return addB;
    }

    public static Button getEditB() {
        return editB;
    }

}
