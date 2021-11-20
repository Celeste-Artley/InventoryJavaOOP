/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author sethm
 */
public class ManageUsersController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label userNameLabel;
    @FXML
    private Label userEmailLabel;
    @FXML
    private Label userPasswordLabel;
    @FXML
    private Label userRoleLabel;
    @FXML
    private TextField newUserEmail;
    @FXML
    private TextField newUserPassword;
    @FXML
    private TextField newUser;

    
    @FXML 
    private ChoiceBox newUserRole;
    
    public void initialize() {
        newUserRole.getItems().addAll("Read","Edit","Accounting","Update","Manage","Administrator");
    }
    
    public void updateUserEmail(ActionEvent event) throws IOException{
        // Use newUserEmail.getText() and change the database file to match.
        // Just updates email label, no connection to backend
        userEmailLabel.setText(newUserEmail.getText());
    }
    
    public void updateUserPassword(ActionEvent event) throws IOException{
        // Use newUserPassword.getText() and change the database file to match.
        // Just updates password label, no connection to backend
        userPasswordLabel.setText(newUserPassword.getText());
    }
    
    public void updateUserRole(ActionEvent event) throws IOException{
        // Just updates role label, no connection to backend
        userRoleLabel.setText(newUserRole.getValue().toString());
    }
    
    public void addUser(){
    
    }
    
    public void removeUser(){
        
    }
    
    public void changeSceneToMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
