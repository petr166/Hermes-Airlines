package Application.Control;

import Application.DataTypes.Customer;
import Presentation.CustomerEditScene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Administrator on 5/22/2016.
 */
public class CustomerEditSceneControl {

    //fields
    private static Button okB,cancelB;
    private static TextField fNameT, lNameT, ageT, phone_nrT, passport_nrT;
    private static Customer customer = new Customer();
    private static boolean okPressed = false;

    //initialization of fields
    public static void initialize(){

        //ok Button
        okB = CustomerEditScene.getOkB();
        okB.setOnAction(e-> handle_okB());

        //cancelB
        cancelB = CustomerEditScene.getCancelB();
        cancelB.setOnAction(e -> handle_cancelB());

        //textFields
        fNameT = CustomerEditScene.getfNameT();
        lNameT = CustomerEditScene.getlNameT();
        ageT = CustomerEditScene.getAgeT();
        phone_nrT = CustomerEditScene.getPhone_nrT();
        passport_nrT = CustomerEditScene.getPassport_nrT();

    }

    public static void setCustomer(Customer c){
        customer = c;
        fNameT.setText(customer.getFirst_name());
        lNameT.setText(customer.getLast_name());
        ageT.setText(Integer.toString(customer.getAge()));
        passport_nrT.setText(customer.getPassport_number());
        phone_nrT.setText(customer.getPhone_nr());

    }

    public static boolean isOkPressed(){ return okPressed; }

    public static void handle_okB(){
        if(isInputValid()){
            customer.setFirst_name(fNameT.getText());
            customer.setLast_name(lNameT.getText());
            customer.setPassport_number(passport_nrT.getText());
            customer.setPhone_nr(phone_nrT.getText());
            customer.setAge(Integer.parseInt(ageT.getText()));
            okPressed = true;
            CustomerEditScene.getDialogStage().close();
        }

    }

    public static void handle_cancelB(){
        okPressed = false;
        CustomerEditScene.getDialogStage().close();

    }


    public static boolean isInputValid(){
        String error = "";
        if(fNameT.getText() ==""||fNameT.getText().length()<1)
            error += "Invalid first name!\n";
        if(lNameT.getText() == "" || lNameT.getText().length()<1)
            error += "Invalid last name!\n";
        if(ageT.getText() == "" || ageT.getText().length()<1)
            error += "Invalid age!\n";
        else
            try{
                Integer.parseInt(ageT.getText());
            } catch(NumberFormatException e){
                error += "Invalid age!\n";
            }
        if(phone_nrT.getText() == "" || phone_nrT.getText().length() < 1)
            error +="Invalid phone nr!\n";

        if(passport_nrT.getText() == "" || passport_nrT.getText().length() < 1)
            error += "Invalid passport number!\n";

        if(error == "")
            return true;
        else{
            Alert alert = new Alert((Alert.AlertType.WARNING));
            alert.initOwner(MainControl.getWindow());
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.showAndWait();
            return false;
        }
    }

    public static Customer getCustomer(){ return customer; }


}
