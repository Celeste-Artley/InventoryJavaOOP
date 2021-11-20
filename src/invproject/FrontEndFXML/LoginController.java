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
 *
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
    
    public void changeSceneToCreateAccount(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
