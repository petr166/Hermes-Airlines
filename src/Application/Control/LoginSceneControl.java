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
    private static Stage window;
    private static Button loginButton;
    private static TextField usernameField;
    private static TextField passwordField;
    private static ArrayList<Admin> admins;
    private static String username;
    private static String password;

    //initialization of fields
    public static void initialize(){
        //username field
        usernameField = LoginScene.getUsernameField();

        //password field
        passwordField = LoginScene.getPasswordField();

        //admins
        admins = AdminData.getAdmins();

        //stage
        window = MainControl.getWindow();

        //loginButton
        loginButton = LoginScene.getLoginButton();
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
        System.out.println("Login button pressed");
        int ok = 0;
        //inout validation
        if(isInputValid()){
            for(Admin admin: admins){
                if(admin.getAdmin_id() == Integer.parseInt(username) && admin.getPassword().equalsIgnoreCase(password))
                    ok = 1;
            }
            //if input valid
            if(ok == 1){
                MainControl.showMenuScene();
            }
            //if not input valid
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Username or password invalid!");
                alert.setHeaderText("Invalid input!");
                alert.initOwner(window);
                alert.showAndWait();
            }
        }

    }

    public static boolean isInputValid(){
        String error = "";
        if(username==""||username.length()<1)
            error+="Insert username!\n";
        else try{
            Integer.parseInt(username);
        }catch(NumberFormatException e){
            error +="Invalid username!\n";
        }
        if(password==""||password.length()<1)
            error += "Insert password!\n";
        if(error=="")
            return true;
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(error);
            alert.setHeaderText("Invalid input!");
            alert.initOwner(window);
            alert.showAndWait();
            return false;
        }
    }
}
