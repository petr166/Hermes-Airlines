package Application.Control;

import Application.DataTypes.Admin;
import DataAccess.AdminData;
import Presentation.LoginScene;
import Presentation.Main;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Administrator on 5/19/2016.
 */

public class LoginSceneControl {

    //fields
    private static Button loginButton;
    private static TextField usernameField;
    private static TextField passwordField;
    private static ArrayList<Admin> admins;
    private static String username;
    private static String password;


    //initialize
    public static void initialize(){
        //username field
        usernameField = LoginScene.getUsernameField();

        //password field
        passwordField = LoginScene.getPasswordField();

        //admins list
        admins = AdminData.getAdmins();

        //loginButton
        loginButton = LoginScene.getLoginButton();
        loginButton.setDefaultButton(true);
        loginButton.setOnAction(e->{
            //username
            username = usernameField.getText();

            //password
            password = passwordField.getText();

            handle_loginButton();
        });

    }


    //handle login button
    public static void handle_loginButton(){
        int ok = 0;

        if(isInputValid()) {

            //verify the user credentials in database
            for(Admin admin : AdminData.getAdmins()) {
                if (admin.getAdmin_id() == Integer.parseInt(username) && admin.getPassword().equalsIgnoreCase(password)) {

                    MainControl.showMenuScene(); //valid username and pass
                    ok = 1;
                    break;
                }
            }

            //wrong username or pass
            if(ok == 0) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Login failed");
                alert.setContentText("Invalid username or password");
                alert.initOwner(MainControl.getWindow());
                alert.showAndWait();
            }
        }
    }


    //method to verify the user input
    public static boolean isInputValid(){
        String error = "";

        if(username.isEmpty())
            error+="Insert username!\n";
        else try{
            Integer.parseInt(username);
        }
        catch(NumberFormatException e){
            error +="Invalid username!\n";
        }

        if(password.isEmpty())
            error += "Insert password!\n";

        if(error=="")
            return true;

        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.initOwner(MainControl.getWindow());
            alert.showAndWait();
            return false;
        }
    }

}
