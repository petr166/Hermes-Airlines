package Presentation;

import Application.DataTypes.Customer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * Created by DragonClau on 19/5/2016.
 */

public class ViewCustomersScene {


        //fields
        private static Pane layout;
        private static Scene scene;
        private static TableView<Customer> table;
        private static TableColumn<Customer, Integer> idColumn, ageColumn;
        private static TableColumn<Customer, String> fnameColumn, lnameColumn, passportColumn, phoneColumn;
        private static TextField search;
        private static HBox buttonLayout;
        private static Button backB, addB, editB;


        //initialize method
        public static void initialize() {

            //table columns
            idColumn = new TableColumn<>("ID");
            idColumn.setMinWidth(116);
            idColumn.setCellValueFactory(cellData -> cellData.getValue().customer_idProperty().asObject());;

            fnameColumn = new TableColumn("First Name");
            fnameColumn.setCellValueFactory(cellData -> cellData.getValue().first_nameProperty());
            fnameColumn.setMinWidth(200);

            lnameColumn = new TableColumn<>("Last Name");
            lnameColumn.setCellValueFactory(cellData -> cellData.getValue().last_nameProperty());
            lnameColumn.setMinWidth(200);

            ageColumn = new TableColumn("Age");
            ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
            ageColumn.setMinWidth(200);

            phoneColumn = new TableColumn("Phone Number");
            phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phone_nrProperty());
            phoneColumn.setMinWidth(200);

            passportColumn = new TableColumn("Passport Number");
            passportColumn.setCellValueFactory(cellData -> cellData.getValue().passport_numberProperty());
            passportColumn.setMinWidth(200);

            //table
            table = new TableView<Customer>();
            table.setMinSize(1116,591);
            table.relocate(42,32);
            table.getColumns().addAll(idColumn, fnameColumn, lnameColumn, ageColumn, phoneColumn, passportColumn);

            //search field
            search = new TextField();
            search.setPromptText("search");
            search.setMinWidth(545);
            search.relocate(42,642);

            //back butt
            backB = new Button("Back");

            //add butt
            addB = new Button("Add");

            //edit butt
            editB = new Button("Edit");

            //button layout
            buttonLayout = new HBox(20);
            buttonLayout.setAlignment(Pos.CENTER);
            buttonLayout.relocate(685,635);
            buttonLayout.getChildren().addAll(backB,addB,editB);

            //layout setup
            layout = new Pane();
            layout.getChildren().addAll(table,search,buttonLayout);

            //scene
            scene = new Scene(layout, 1200, 700);
            scene.getStylesheets().add("/Presentation/style.css");
            System.out.println("customers who are flying scene initialized");
        }



        //getters

    public static TableColumn<Customer, String> getFnameColumn() {
        return fnameColumn;
    }

    public static TableColumn<Customer, String> getLnameColumn() {
        return lnameColumn;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Scene getScene() {
        return scene;
    }

    public static TableView getTable() {
        return table;
    }

    public static TableColumn getIdColumn() {
        return idColumn;
    }

    public static TableColumn getNameColumn() {
        return fnameColumn;
    }

    public static TableColumn getAgeColumn() {
        return ageColumn;
    }

    public static TableColumn getPhoneColumn() {
        return phoneColumn;
    }

    public static TableColumn getPassportColumn() {
        return passportColumn;
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

    public static Button getAddB() {
        return addB;
    }

    public static Button getEditB() {
        return editB;
    }


}
