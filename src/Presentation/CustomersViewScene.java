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
 * Created by DragonClau on 19/5/2016.
 */
public class CustomersViewScene {


        //fields
        private static Pane layout;
        private static Scene scene;
        private static TableView table;
        private static TableColumn idColumn, nameColumn, ageColumn, phoneColumn, passportColumn;
        private static TextField search;
        private static HBox buttonLayout;
        private static Button backB, addB, editB;


        //initialize method
        public static void initialize() {

            //table columns
            idColumn = new TableColumn("ID");
            nameColumn = new TableColumn("Name");
            ageColumn = new TableColumn("Age");
            phoneColumn = new TableColumn("Phone Number");
            passportColumn = new TableColumn("Passport Number");

            //table
            table = new TableView();
            table.setMinSize(1116,591);
            table.relocate(42,32);
            table.getColumns().addAll(idColumn, nameColumn, ageColumn, phoneColumn, passportColumn);

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

            System.out.println("customers who are flying scene initialized");
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

    public static TableColumn getIdColumn() {
        return idColumn;
    }

    public static void setIdColumn(TableColumn idColumn) {
        CustomersViewScene.idColumn = idColumn;
    }

    public static TableColumn getNameColumn() {
        return nameColumn;
    }

    public static void setNameColumn(TableColumn nameColumn) {
        CustomersViewScene.nameColumn = nameColumn;
    }

    public static TableColumn getAgeColumn() {
        return ageColumn;
    }

    public static void setAgeColumn(TableColumn ageColumn) {
        CustomersViewScene.ageColumn = ageColumn;
    }

    public static TableColumn getPhoneColumn() {
        return phoneColumn;
    }

    public static void setPhoneColumn(TableColumn phoneColumn) {
        CustomersViewScene.phoneColumn = phoneColumn;
    }

    public static TableColumn getPassportColumn() {
        return passportColumn;
    }

    public static void setPassportColumn(TableColumn passportColumn) {
        CustomersViewScene.passportColumn = passportColumn;
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
