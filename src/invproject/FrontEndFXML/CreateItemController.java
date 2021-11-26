package invproject.FrontEndFXML;


import invproject.Category;
import invproject.Item;
import invproject.POrder;
import invproject.Tag;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CreateItemController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelButton;

     @FXML
    private ChoiceBox categoryChoiceBox;

    @FXML
    private Button createItemButton;

    @FXML
    private Pane createItemWindow;

    @FXML
    private TextArea lDescTextArea;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField sDescTextField;

    @FXML
    private TextField tagsTextField;

    @FXML
    void initialize() {
        onLoadAllCategories();
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert categoryChoiceBox != null : "fx:id=\"categoryComboBox\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert createItemButton != null : "fx:id=\"createItemButton\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert createItemWindow != null : "fx:id=\"createItemWindow\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert lDescTextArea != null : "fx:id=\"lDescTextArea\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert quantityTextField != null : "fx:id=\"quantityTextField\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert sDescTextField != null : "fx:id=\"sDescTextField\" was not injected: check your FXML file 'CreateItem.fxml'.";
        assert tagsTextField != null : "fx:id=\"tagsComboBox\" was not injected: check your FXML file 'CreateItem.fxml'.";
        
        // force the field to be numeric only
        quantityTextField.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, 
        String newValue) {
        if (!newValue.matches("\\d*")) {
            quantityTextField.setText(newValue.replaceAll("[^\\d]", ""));
        }
        
    }
});
    }
    public void onCreateItem() throws IOException
    {
        String name = nameTextField.getText();
        Integer quantity = 0;
        if(quantityTextField.getText().length() != 0)
        {
            quantity = Integer.parseInt(quantityTextField.getText());
        }
        String Category;
        if(categoryChoiceBox.getSelectionModel().getSelectedItem() != null)
        {
            Category = categoryChoiceBox.getSelectionModel().getSelectedItem().toString();
        }
        else
        {
            Category = null;
        }
        String tagText = tagsTextField.getText();
        List<Tag> tags = new ArrayList<>();
        String[] tagsArray = tagText.split(" ");
        for (String s : tagsArray)
        {
            if(s.contains(";") || s.contains(","))
            {
                System.out.println("Your tags can't contain ; or , characters.");
            }
            else
            {
                Tag t = new Tag(s);
                tags.add(t);
            }
            
        }
        String lDesc = lDescTextArea.getText();
        String sDesc = sDescTextField.getText();
        POrder order = new POrder();
        if(Category == null || name.length() ==  0 || lDesc.length() == 0 || sDesc.length() == 0)
        {
            System.out.println("you need to enter all boxes, put an error here.");
        }
        else
        {
            Item i = new Item(name,Category,quantity,lDesc,sDesc,order,tags);
            DatabaseUtils.itemDatabase.Create(i);
            DatabaseUtils.itemDatabase.Save();
            onCancel();
        }
        
    }
    public void onCancel() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        stage = (Stage)createItemWindow.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onLoadAllCategories()
    {
        List<Category> categories = DatabaseUtils.categoryDatabase.getCategories();
        
        for(Category c : categories)
        {
            categoryChoiceBox.getItems().add(c.getName());
        }
    }
    public void checkThenAddToTags()
    {
        //this method should parse the list of tags that were given by the user
        //and add them to the database.
    }
}







