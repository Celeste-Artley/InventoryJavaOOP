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
 * A controller for the Manage Users JavaFX FXML file.
 * @author sethm and Justin R. Fox
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
    /**
     * adds lines for the role drop down
     */
    public void initialize() {
        newUserRole.getItems().addAll("Read","Edit","Accounting","Update","Manage","Administrator");
        userNameLabel.setText(DatabaseUtils.loggedInUser.getUsername());
        userEmailLabel.setText(DatabaseUtils.loggedInUser.getEmail());
        userPasswordLabel.setText(DatabaseUtils.loggedInUser.getPassword());
        if (DatabaseUtils.loggedInUser.getRole()) {
            userRoleLabel.setText("Administrator");
        } else {
            userRoleLabel.setText("NON-Administrator");
        }
    }
    
    /**
     * Updating the selected user email.
     * @param event
     * @throws IOException 
     */
    public void updateUserEmail(ActionEvent event) throws IOException{
        DatabaseUtils.userDatabase.UpdateEmail(userNameLabel.getText(), newUserEmail.getText());
        DatabaseUtils.userDatabase.Save();
        userEmailLabel.setText(newUserEmail.getText());
    }
    
    /**
     * Updates the selected user password
     * @param event
     * @throws IOException 
     */
    public void updateUserPassword(ActionEvent event) throws IOException{
        DatabaseUtils.userDatabase.UpdatePassword(userNameLabel.getText(), newUserPassword.getText());
        DatabaseUtils.userDatabase.Save();
        userPasswordLabel.setText(newUserPassword.getText());
    }
    
    /**
     * Updates the selected user's role
     * @param event
     * @throws IOException 
     */
    public void updateUserRole(ActionEvent event) throws IOException{
        // No UpdateRole function available in UserDatabase
        // Just updates role label, no connection to backend
        userRoleLabel.setText(newUserRole.getValue().toString());
    }
    
    /**
     * Creates a new user.
     */
    public void addUser(){
        invproject.User user;
        user = new invproject.User(newUser.getText(), "password", "email");
        DatabaseUtils.userDatabase.Create(user);
        DatabaseUtils.userDatabase.Save();
    }
    
    /**
     * deletes a selected user from the database.
     */
    public void removeUser(){
        DatabaseUtils.userDatabase.Delete(userNameLabel.getText());
        DatabaseUtils.userDatabase.Save();
    }
    
    /**
     * Changes the current scene to the main window.
     * @param event
     * @throws IOException 
     */
    public void changeSceneToMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
