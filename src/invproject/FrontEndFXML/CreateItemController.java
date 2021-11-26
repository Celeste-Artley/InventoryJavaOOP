package invproject.FrontEndFXML;


import invproject.Category;
import invproject.Item;
import java.io.IOException;
import java.net.URL;
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
    private ComboBox<?> tagsComboBox;

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
        assert tagsComboBox != null : "fx:id=\"tagsComboBox\" was not injected: check your FXML file 'CreateItem.fxml'.";
        
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
        Item i;
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
            System.out.println(c.getName());
            categoryChoiceBox.getItems().add(c.getName());
        }
    }
}







