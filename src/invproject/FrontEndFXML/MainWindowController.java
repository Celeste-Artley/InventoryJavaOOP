/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invproject.FrontEndFXML;

import invproject.Category;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import invproject.Item;
import java.util.List;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


/**
 * A controller for the Main Window JavaFX FXML file.
 * @author sethm
 */
public class MainWindowController {
    @FXML
    private Label categoryName;
    @FXML
    private TreeView categoriesTree;
    

    //Table properties
    @FXML
    private TableView ItemTable;
    @FXML
    private TableColumn ItemCol;
    @FXML
    private TableColumn TagCol;
    @FXML
    private TableColumn CreatedCol;
    @FXML
    private TableColumn LastModCol;
    @FXML
    private TableColumn SDecCol;
    @FXML
    private TableColumn LDecCol;
    @FXML
    private TableColumn CurrentCol;
    @FXML
    private TableColumn ReorderCol;
    @FXML
    private TableColumn PendingCol;
     //end of Table properties
    
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
    
    @FXML
    private MenuItem manageUsers;
    @FXML
    private SeparatorMenuItem manageUsersSeparator;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    /**
     * Disables ManageMenu option if not an Admin
     */
    public void initialize() {
        loadItemsIntoMainWindow(DatabaseUtils.itemDatabase.getObsItems());
        loadListOfCategories();
        
        // This will need to be edited once roles are added
        if(DatabaseUtils.loggedInUser.getRole()){
            manageUsers.setVisible(true);
            manageUsersSeparator.setVisible(true);
        } else {
          manageUsers.setVisible(false);
          manageUsersSeparator.setVisible(false);
        }
    }
    
    /**
     * Changes the active window to the Edit Account page.
     * @param event
     * @throws IOException 
     */
    public void changeSceneToEditAccount(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("EditAccount.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        // DatabaseUtils.loggedInUser = null;
        stage.show();
    }
    
    /**
     * Changes the active window to the Manage Users page
     * @param event
     * @throws IOException 
     */
    public void changeSceneToManageUsers(ActionEvent event) throws IOException{    
        Parent root = FXMLLoader.load(getClass().getResource("ManageUsers.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    /**
     * Adds a Category to the database of categories and reloads the categories 
     * list
     * @param event
     * @throws IOException 
     */
    public void addCategory(ActionEvent event) throws IOException{
        String s = newCategory.getText();
        Category c = DatabaseUtils.categoryDatabase.Read(s);
        if(!s.equals("") && c == null)
        {
            DatabaseUtils.categoryDatabase.Create(new Category(s));
            DatabaseUtils.categoryDatabase.Save();
            loadListOfCategories();
        }
        else if(s.equals(""))
        {
            System.out.println("Please Type in a category.");
        }
        else if(c != null)
        {
            System.out.println("That Category already exist.");
        }
        
    }
    /**
     * Returns to the login page as well as setting the active user to null
     * @param event
     * @throws IOException 
     */
    public void logOut(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        DatabaseUtils.loggedInUser = null;
        stage.show();
    }
    
    /**
     * Exits the application and saves all the databases.
     */
    public void onExit(){
        DatabaseUtils.userDatabase.Save();
        DatabaseUtils.itemDatabase.Save();
        DatabaseUtils.tagDatabase.Save();
        DatabaseUtils.categoryDatabase.Save();
        Platform.exit();
    }
    
    /**
     * Displays the items at the start loading into the main window.
     */
    private void loadItemsIntoMainWindow(ObservableList<Item> items) {
        ItemCol.setCellValueFactory(new PropertyValueFactory<Item,String>("name"));
        TagCol.setCellValueFactory(new PropertyValueFactory<Item,String>("stringOfTags"));
        CreatedCol.setCellValueFactory(new PropertyValueFactory<Item,String>("dateCreated"));
        LastModCol.setCellValueFactory(new PropertyValueFactory<Item,String>("dateUpdated"));
        SDecCol.setCellValueFactory(new PropertyValueFactory<Item,String>("sDescription"));
        LDecCol.setCellValueFactory(new PropertyValueFactory<Item,String>("lDescription"));
        CurrentCol.setCellValueFactory(new PropertyValueFactory<Item,Integer>("quantity"));
        ReorderCol.setCellValueFactory(new PropertyValueFactory<Item,Integer>("ammountOrdered"));
        PendingCol.setCellValueFactory(new PropertyValueFactory<Item,String>("isOnOrder"));
        
        ItemTable.setItems(items);
    }
    
    /**
     * Loads all the categories from the database.
     */
    public void loadListOfCategories(){
        TreeItem treeRoot = new TreeItem("Categories");
        treeRoot.setExpanded(true);
        List<Category> categories = DatabaseUtils.categoryDatabase.getCategories();
        for(Category c : categories)
        {
            TreeItem i = new TreeItem(c.getName());
            i.setExpanded(true);
            treeRoot.getChildren().add(i);
            
        }
        EventHandler<MouseEvent> eventHandler = (MouseEvent t) -> {
            TreeItem treeItem = (TreeItem)categoriesTree.getSelectionModel().getSelectedItem();
            ObservableList<Item> items = DatabaseUtils.itemDatabase.getObsItems();
            ObservableList<Item> listToShow = FXCollections.observableArrayList();
            if(treeItem != null)
                {
                for(Item i : items)
                {
                        if(i.getCategoryName().equals(treeItem.getValue()))
                        {
                            listToShow.add(i);
                        }


                }
                if(treeItem.getValue().equals("Categories"))
                    {
                        this.loadItemsIntoMainWindow(items);
                    }
                else
                    {
                        this.loadItemsIntoMainWindow(listToShow);
                    }
                }
        };
        categoriesTree.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
        categoriesTree.setRoot(treeRoot);
    }
    public void onAddItem()throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CreateItem.fxml"));
        stage = (Stage)categoryName.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onDeleteSelected()throws IOException
    {
        if((Item)ItemTable.getSelectionModel().getSelectedItem() != null)
        {
        Item i = (Item)ItemTable.getSelectionModel().getSelectedItem();
        DatabaseUtils.itemDatabase.Delete(i.getName());
        DatabaseUtils.itemDatabase.Save();
        loadItemsIntoMainWindow(DatabaseUtils.itemDatabase.getObsItems());
        }
    }
}