/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import invproject.User;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * A controller for the Login JavaFX FXML file.
 * @author sethm
 */
public class LoginController {
    @FXML
    private TextField userName;
    @FXML
    private PasswordField userPassword;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    /**
     * function for the login button to check that there is currently no active 
     * user, then pulls the info from the username and password fields. Checks 
     * those against the database. verifies correctness, logs in and changes 
     * the window to the min window.
     * @param event
     * @throws IOException 
     */
    public void changeSceneToMainWindow(ActionEvent event) throws IOException{
        User loginUser = DatabaseUtils.userDatabase.Read(userName.getText());
        if(loginUser != null)
        {
            DatabaseUtils.loggedInUser = loginUser;
        }
        
        if (DatabaseUtils.loggedInUser != null && DatabaseUtils.loggedInUser.getUsername().equals(userName.getText()) && DatabaseUtils.loggedInUser.getPassword().equals(userPassword.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            DatabaseUtils.loggedInUser = loginUser;
            stage.show();
        }
        else
        {
            Alert loginWrong = new Alert(AlertType.ERROR);
            loginWrong.setHeaderText("Username or Password incorrect");
            loginWrong.showAndWait();
        }
        
    }
    
    /**
     * Swaps the current Active Window to Create Account
     * @param event
     * @throws IOException 
     */
    public void changeSceneToCreateAccount(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
