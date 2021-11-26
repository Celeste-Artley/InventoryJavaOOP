/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import invproject.*;
import java.io.IOException;
import java.util.Collections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static javafx.scene.control.SelectionMode.SINGLE;
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
    
    private User currentlySelectedUser;
    private ObservableList<String> userObservableList;
    
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
    private ListView userList;    
    @FXML 
    private ChoiceBox newUserRole;
    
    
    /**
     * Adds lines for the role drop down and sets the initial screen.
     */
    public void initialize() {
        newUserRole.getItems().addAll("Read","Edit","Accounting","Update","Manage","Administrator");
        currentlySelectedUser = DatabaseUtils.loggedInUser;
        userObservableList = FXCollections.observableArrayList();
        for (invproject.User u : DatabaseUtils.userDatabase.getUsers()) {
            userObservableList.add(u.getUsername());
        }
        userList.setItems(userObservableList);
        Collections.sort(userObservableList);
        userList.getSelectionModel().setSelectionMode(SINGLE);
        userList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() { 
            public void changed(ObservableValue<? extends String> changed, String oldVal, String newVal) {
                currentlySelectedUser = DatabaseUtils.userDatabase.Read(newVal);
                refreshScreen();
            }
        });
        userList.getSelectionModel().select(currentlySelectedUser.getUsername());
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
    }
    
    /**
     * Updates the selected user's email.
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
     * Updates the selected user's password.
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
        // No proper Role attribute in User yet.
    }
    
    /**
     * Creates a new user.
     */
    public void addUser(){
        boolean alreadyExists = false;
        if (newUser.getText().equals("")) {
            Alert noName = new Alert(Alert.AlertType.ERROR);
            noName.setHeaderText("No new username was entered.  Please try again.");
            noName.showAndWait();
        } else {
            for (invproject.User u : DatabaseUtils.userDatabase.getUsers())
            {
                if(u.getUsername().equals(newUser.getText())) {
                    alreadyExists = true;
                }
            }
            if (alreadyExists) {
                Alert existsAlready = new Alert(Alert.AlertType.ERROR);
                existsAlready.setHeaderText("That user already exists.  Please try again.");
                existsAlready.showAndWait();
            } else {
                invproject.User user;
                user = new invproject.User(newUser.getText(), "password", newUser.getText() + "@dev.com");
                DatabaseUtils.userDatabase.Create(user);
                DatabaseUtils.userDatabase.Save();
                currentlySelectedUser = user;
                userObservableList.add(newUser.getText());
                Collections.sort(userObservableList);
                userList.getSelectionModel().select(user.getUsername());
                refreshScreen();
            }
            newUser.setText("");        
        }
    }
    
    /**
     * Deletes a selected user from the database.
     */
    public void removeUser(){
        if (currentlySelectedUser.equals(DatabaseUtils.loggedInUser)) {
            Alert neverGiveUpNeverSurrender = new Alert(Alert.AlertType.ERROR);
            neverGiveUpNeverSurrender.setHeaderText("You don't really want to delete yourself; do you?  No, of course you don't.  Stop that.");
            neverGiveUpNeverSurrender.showAndWait();
        } else {
            DatabaseUtils.userDatabase.Delete(currentlySelectedUser.getUsername());
            DatabaseUtils.userDatabase.Save();
            userObservableList.remove(currentlySelectedUser.getUsername());
            userList.getSelectionModel().clearSelection();
            Collections.sort(userObservableList);
            userNameLabel.setText("User Removed");
            userEmailLabel.setText("");
            userPasswordLabel.setText("");
            userRoleLabel.setText("");
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
