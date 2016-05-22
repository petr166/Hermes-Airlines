package Application.Control;

import Application.DataTypes.Customer;
import DataAccess.CustomerData;
import Presentation.CustomerScene;
import Presentation.ViewCustomersScene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import javax.swing.text.View;

/**
 * Created by Administrator on 5/22/2016.
 */
public class ViewCustomerSceneControl {

    //fields
    private static TableView<Customer> table;
  //  private static TableColumn<Customer, Integer> idColumn, ageColumn;
    //private static TableColumn<Customer, String> fnameColumn, lnameColumn, passportColumn, phoneColumn;
    private static TextField search;

    private static Button backB, addB, editB;


    //initialize fields

    public static void initialize(){
        table = ViewCustomersScene.getTable();
        table.setItems(CustomerData.getCustomers());

        // search field
        search = ViewCustomersScene.getSearch();

        //backB
        backB = ViewCustomersScene.getBackB();
        backB.setOnAction(e -> handle_backB());
        //addB
        addB = ViewCustomersScene.getAddB();
       // addB.setOnAction(e -> handle_addB());
        //editB
        editB = ViewCustomersScene.getEditB();
        editB.setOnAction(e -> handle_editB());



    }

    //handle_editB
    public static void handle_editB(){
        Customer customer = table.getSelectionModel().getSelectedItem();
        if(customer != null){
            boolean okPressed = MainControl.showCustomerEditScene(customer);
            CustomerData.updateCustomer(customer);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initOwner(MainControl.getWindow());
            alert.setContentText("Customer edited!");
            alert.showAndWait();

        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(MainControl.getWindow());
            alert.setHeaderText("Select customer!");
            alert.setContentText("No customer selected!");
            alert.showAndWait();

        }
    }

    public static void handle_backB(){ MainControl.showMenuScene(); }

}
