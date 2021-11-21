/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import invproject.User;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
 * A controller for the Create Account JavaFX FXML file.
 * @author sethm
 */
public class CreateAccountController {
    @FXML
    private TextField userName;
    @FXML
    private TextField userEmail;
    @FXML
    private PasswordField userPassword;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    /**
     * Checks to make sure that the username password and email are correct then
     * creates it in the database and swaps to Login window.
     * @param event
     * @throws IOException 
     */
    public void changeSceneToLoginWindow(ActionEvent event) throws IOException{
        Boolean usernameCheck = this.checkUserName();
        Boolean passwordChcek = this.checkPassword();
        Boolean emailCheck = this.checkEmail();
        
        if(usernameCheck && passwordChcek && emailCheck)
        {
            User u = new User(userName.getText(),userPassword.getText(),userEmail.getText(),false);
            DatabaseUtils.userDatabase.Create(u);
            DatabaseUtils.userDatabase.Save();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    /**
     * Changes the active scene to the Login window without creating an account
     * @param event
     * @throws IOException 
     */
    public void changeSceneToLogin(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * This is a utility function that checks to make sure that the Username 
     * meets the criteria for creation
     * @return 
     */
    private Boolean checkUserName()
    {
        //checking the user's created account for a proper username. one that is longer than 9 chars and shorter than 60. and that there is not already a user with that name.
        if(DatabaseUtils.userDatabase.Read(userName.getText()) == null)return false;
        if(userName.getText().toCharArray().length >= 9 && userName.getText().toCharArray().length <= 60)
        {
            Pattern p = Pattern.compile("^(\\d|\\w)+$");
            Matcher m = p.matcher(userName.getText());
            if(m.find())
            {
                return true;
            }
            else
            {
                Alert loginWrong = new Alert(Alert.AlertType.ERROR);
                loginWrong.setHeaderText("Your username can not contain spaces or special characters.");
                loginWrong.showAndWait();
                return false;
            }
            
        }
        else if(userName.getText().toCharArray().length > 60)
        {
            Alert loginWrong = new Alert(Alert.AlertType.ERROR);
            loginWrong.setHeaderText("Okay you can't write a story for a username... ");
            loginWrong.showAndWait();
            return false;
        }
        else
        {
            
            Alert loginWrong = new Alert(AlertType.ERROR);
            loginWrong.setHeaderText("Your username needs to be longer than 9 characters.");
            loginWrong.showAndWait();
            return false;
        }
    }
    
    /**
     * This is a utility function that checks to make sure that the Password 
     * meets the criteria for creation
     * @return 
     * @return 
     */
    private Boolean checkPassword()
    {
        //checking the user's created account for a proper Password. one that is longer than 9 chars and shorter than 60.
        if(userPassword.getText().toCharArray().length >= 9 && userPassword.getText().toCharArray().length <= 60)
        {
            return true;
        }
        else if(userPassword.getText().toCharArray().length > 60)
        {
            Alert loginWrong = new Alert(Alert.AlertType.ERROR);
            loginWrong.setHeaderText("This program is not that important... come on try something a bit shorter maybe password123 ;) ");
            loginWrong.showAndWait();
            return false;
        }
        else
        {
            Alert loginWrong = new Alert(AlertType.ERROR);
            loginWrong.setHeaderText("Your username needs to be longer than 9 characters.");
            loginWrong.showAndWait();
            return false;
        }
    }
    
    /**
     * This is a utility function that checks to make sure that the Email 
     * meets the criteria for creation
     * @return 
     */
    private Boolean checkEmail()
    {
        //checking the user's created account for a proper email. one that contains the @ symbol and . and is followed by non special characters.
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(userEmail.getText());
        return m.find();
    }
}