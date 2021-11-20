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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author sethm and Justin R. Fox
 */
public class EditAccountController {
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
    
    public void initialize() {
        userNameLabel.setText(DatabaseUtils.loggedInUser.getUsername());
        userEmailLabel.setText(DatabaseUtils.loggedInUser.getEmail());
        userPasswordLabel.setText(DatabaseUtils.loggedInUser.getPassword());
        userRoleLabel.setText(DatabaseUtils.loggedInUser.getRole());
    }
    
    public void updateUserEmail(ActionEvent event) throws IOException{
        //DatabaseUtils.userDatabase.UpdateEmail(DatabaseUtils.loggedInUser.getUsername(), newUserEmail.getText());
        //DatabaseUtils.userDatabase.Save();
        userEmailLabel.setText(newUserEmail.getText());
    }
    
    public void updateUserPassword(ActionEvent event) throws IOException{
        //DatabaseUtils.userDatabase.UpdatePassword(DatabaseUtils.loggedInUser.getUsername(), newUserPassword.getText());
        //DatabaseUtils.userDatabase.Save();
        userPasswordLabel.setText(newUserPassword.getText());
    }
    
    public void changeSceneToMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
