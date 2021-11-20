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
import invproject.User;
import javafx.application.Platform;
import javafx.scene.control.TextField;


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
    
    @FXML
    private TextField newCategory;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void changeSceneToEditAccount(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        DatabaseUtils.loggedInUser = null;
        stage.show();
    }
    
    public void changeSceneToManageUsers(ActionEvent event) throws IOException{    
        if(DatabaseUtils.loggedInUser.getAdminStatus())
        {
            Parent root = FXMLLoader.load(getClass().getResource("ManageUsers.fxml"));
            stage = (Stage)categoryName.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            System.out.println("You are not an admin.  Please log into an admin account.");
        }
    }
    
    public void addCategory(ActionEvent event) throws IOException{
        
    }
    
    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onExit(){
        DatabaseUtils.userDatabase.Save();
        DatabaseUtils.itemDatabase.Save();
        DatabaseUtils.tagDatabase.Save();
        DatabaseUtils.categoryDatabase.Save();
        Platform.exit();
    }
}