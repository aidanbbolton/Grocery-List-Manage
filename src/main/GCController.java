package main;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import main.model.GroceryList;
import main.model.SampleData;

public class GCController implements Initializable {

    @FXML
    private ListView<GroceryList> listView;
    @FXML
    private TextField titleTextField;
    @FXML
    private TextField authorTextField;
    @FXML
    private ListView<String> itemsView;

    private GroceryList selectedGL;
    private final BooleanProperty modifiedProperty = new SimpleBooleanProperty(false);
    private ChangeListener<GroceryList> GCChangeListener;
    private final ObservableList<GroceryList> glList = FXCollections.observableArrayList(GroceryList.extractor);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SampleData.fillSampleData(glList);

        ObservableList<String> mainItems = FXCollections.observableArrayList();
        for(int i=0; i<glList.size();i++) {
            for(int j=0; j<glList.get(i).getItems().size();j++) {
                mainItems.add(glList.get(i).getItems().get(j)+ "");
            }
        }
        GroceryList mainList = new GroceryList("System",mainItems,"Main List");
        glList.add(mainList);


        listView.setItems(glList); //set the listView in the scene as the list of items from sample data

        listView.getSelectionModel().selectedItemProperty().addListener(
                GCChangeListener = (observable, oldValue, newValue) -> {
                    System.out.println("Last Selected item: " + newValue);
                    System.out.println("Current Selected:");
                    for(GroceryList gl : listView.getSelectionModel().getSelectedItems()){
                        System.out.println(gl.toString());
                    }
                    selectedGL = newValue;
                    modifiedProperty.set(false);
                    if (newValue != null) {
                        // Populate controls with selected list
                        titleTextField.setText(selectedGL.getTitle());
                        authorTextField.setText(selectedGL.getAuthor());
                        itemsView.setItems(selectedGL.getItems());
                    } else {
                        titleTextField.setText("");
                        authorTextField.setText("");
                    }

                });

        // Pre-select the first item
        listView.getSelectionModel().selectFirst();

    }


    public void CreateButtonAction(ActionEvent actionEvent) {


    }
}
