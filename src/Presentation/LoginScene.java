package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * Created by Administrator on 5/18/2016.
 */

public class LoginScene {


    //fields
    private static Scene scene;
    private static Pane layout;
    private static Label loginLabel;
    private static Label hermesLabel;
    private static TextField usernameField;
    private static PasswordField passwordField;
    private static Button loginButton;


    //initialize method
    public static  void initialize(){
        //loginLabel
        loginLabel = new Label("Login");
        loginLabel.relocate(182,176);

        //hermesLabel
        hermesLabel=new Label("Hermes Airlines");
        hermesLabel.relocate(182,140);

        //usernameField
        usernameField=new TextField();
        usernameField.setPromptText("username");
        usernameField.relocate(125,238);
        usernameField.setAlignment(Pos.CENTER);

        //passwordField
        passwordField=new PasswordField();
        passwordField.setAlignment(Pos.CENTER);
        passwordField.relocate(125,278);
        passwordField.setPromptText("password");

        //buttonField
        loginButton=new Button("Login");
        loginButton.relocate(174,332);

        //layout
        layout=new Pane();
        layout.getChildren().addAll(loginLabel,hermesLabel,usernameField,passwordField,loginButton);

        //scene
        scene = new Scene(layout,400,500);


        System.out.println("login screen initialized");
    }


    //getters
    public static Scene getScene() {
        return scene;
    }

    public static Pane getLayout() {
        return layout;
    }

    public static Label getLoginLabel() {
        return loginLabel;
    }

    public static Label getHermesLabel() {
        return hermesLabel;
    }

    public static TextField getUsernameField() {
        return usernameField;
    }

    public static PasswordField getPasswordField() {
        return passwordField;
    }

    public static Button getLoginButton() {
        return loginButton;
    }

}
