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
 * A controller for the Edit Account JavaFX FXML file.
 * @author sethm
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
    
    /**
     * Updates the active users email
     * @param event
     * @throws IOException 
     */
    public void updateUserEmail(ActionEvent event) throws IOException{
        // Use newUserEmail.getText() and change the database file to match.
        // Just updates email label, no connection to backend
        userEmailLabel.setText(newUserEmail.getText());
    }
    /**
     * Updates the active users password
     * @param event
     * @throws IOException 
     */
    public void updateUserPassword(ActionEvent event) throws IOException{
        // Use newUserPassword.getText() and change the database file to match.
        // Just updates password label, no connection to backend
        userPasswordLabel.setText(newUserPassword.getText());
    }
    /**
     * changes the active scene back to the main window.
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
