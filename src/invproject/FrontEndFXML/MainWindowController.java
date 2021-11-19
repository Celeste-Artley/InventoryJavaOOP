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
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import invproject.FrontEndFXML.DatabaseUtils;
import javafx.application.Platform;


/**
 *
 * @author sethm
 */
public class MainWindowController {
    @FXML
    private Label categoryName;

    @FXML
    private Font x1;

    @FXML
    private Font x11;

    @FXML
    private Color x2;

    @FXML
    private Color x21;

    @FXML
    private Font x3;

    @FXML
    private Color x4;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    DatabaseUtils dbUtils = new DatabaseUtils();
    
    public void changeSceneToEditAccount(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void changeSceneToManageUsers(ActionEvent event) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("ManageUsers.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onExit(){
        dbUtils.DatabaseTest("greggIsTheBest");
    }
}