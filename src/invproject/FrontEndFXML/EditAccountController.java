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
import javafx.stage.Stage;

/**
 *
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
    
    public void updateUserEmail(ActionEvent event) throws IOException{
        // Use newUserEmail.getText() and change the database file to match.
    }
    
    public void updateUserPassword(ActionEvent event) throws IOException{
        // Use newUserPassword.getText() and change the database file to match.
    }
    
    public void changeSceneToMainWindow(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
