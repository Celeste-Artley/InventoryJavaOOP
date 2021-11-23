/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import invproject.*;
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
 * @authors sethm and Justin R. Fox
 */
public class ManageUsersController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public static User currentlySelectedUser;
    
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
     * Adds lines for the role drop down and sets the initial screen.
     */
    public void initialize() {
        newUserRole.getItems().addAll("Read","Edit","Accounting","Update","Manage","Administrator");
        currentlySelectedUser = DatabaseUtils.loggedInUser;
        refreshScreen();
    }
    
    /**
     * Populates user info and user list labels.
     */
    public void refreshScreen() {
        userNameLabel.setText(currentlySelectedUser.getUsername());
        userEmailLabel.setText(currentlySelectedUser.getEmail());
        userPasswordLabel.setText(currentlySelectedUser.getPassword());
        // The following if-else statement should be replaced when the User's Role attribute is corrected to reflect a specific role.
        if (currentlySelectedUser.getRole()) {
            userRoleLabel.setText("Administrator");
        } else {
            userRoleLabel.setText("NON-Administrator");
        }
        // Also update the displayed User List in the Left panel.
    }
    
    /**
     * Selecting another user.
     * @param event
     * @throws IOException 
     */
    public void selectSomeoneElse(ActionEvent event) throws IOException{
        // currentlySelectedUser = whatever user was selected from the list - No selectable list available in fxml yet.
        refreshScreen();
    }
    
    /**
     * Updating the selected user email.
     * @param event
     * @throws IOException 
     */
    public void updateUserEmail(ActionEvent event) throws IOException{
        userEmailLabel.setText(newUserEmail.getText());
        DatabaseUtils.userDatabase.UpdateEmail(currentlySelectedUser.getUsername(), newUserEmail.getText());
        DatabaseUtils.userDatabase.Save();
        newUserEmail.setText("");
    }
    
    /**
     * Updates the selected user password
     * @param event
     * @throws IOException 
     */
    public void updateUserPassword(ActionEvent event) throws IOException{
        userPasswordLabel.setText(newUserPassword.getText());
        DatabaseUtils.userDatabase.UpdatePassword(currentlySelectedUser.getUsername(), newUserPassword.getText());
        DatabaseUtils.userDatabase.Save();
        newUserPassword.setText("");
    }
    
    /**
     * Updates the selected user's role
     * @param event
     * @throws IOException 
     */
    public void updateUserRole(ActionEvent event) throws IOException{
        userRoleLabel.setText(newUserRole.getValue().toString());
        // Just updates role label, no connection to backend.
        // No UpdateRole function available in UserDatabase yet.
    }
    
    /**
     * Creates a new user.
     */
    public void addUser(){
        Boolean alreadyExists = false;
        if (newUser.getText() != "") {
            for (invproject.User u : DatabaseUtils.userDatabase.getUsers())
            {
                if(u.getUsername().equals(newUser.getText()))
                {
                    alreadyExists = true;
                    // Error Message Pop-Up Perhaps?
                }
            }
            if (!alreadyExists)
            {
                invproject.User user;
                user = new invproject.User(newUser.getText(), "password", "email");
                DatabaseUtils.userDatabase.Create(user);
                DatabaseUtils.userDatabase.Save();
                currentlySelectedUser = user;
                refreshScreen();
            }
            newUser.setText("");        
        }
    }
    
    /**
     * deletes a selected user from the database.
     */
    public void removeUser(){
        if (currentlySelectedUser != DatabaseUtils.loggedInUser) {
            // Without the above if statement, but with line 154 below active, this function allowed you to delete yourself.
            // Since that did work, and addUser seems totally to work, I (Justin R. Fox) do not understand why this doesn't work for the most recently added user.
            // Makes no sense to me, but that's why the next line is commented out now.
            // DatabaseUtils.userDatabase.Delete(currentlySelectedUser.getUsername()); 
            DatabaseUtils.userDatabase.Save();
            userNameLabel.setText("User Removed");
            userEmailLabel.setText("");
            userPasswordLabel.setText("");
            userRoleLabel.setText("");
            // Also, this user should be removed from the list of users in the left panel.
        }
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
