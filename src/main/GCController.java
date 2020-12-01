package main;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.model.GroceryList;
import main.model.SampleData;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class GCController implements Initializable {


    //This is the list of editable text components of the grocery list. Each list has its own listview. I made 5
    //lists and a main, so 6 total.
    // ***NOTE*** if you use scenebuilder to edit or add anything you will need to go
    //back through the FXML file and re-add the FX:ID to the tabs, labels, and listView because scenebuilder wipes them
    @FXML
    private Label tab1Name;
    @FXML
    private ListView<String> tab1List;
    @FXML
    private Tab tab1;
    @FXML
    private VBox tab1Vbox;

    @FXML
    private Label tab2Name;
    @FXML
    private ListView<String> tab2List;
    @FXML
    private Tab tab2;
    @FXML
    private VBox tab2Vbox;

    @FXML
    private Label tab3Name;
    @FXML
    private ListView<String> tab3List;
    @FXML
    private Tab tab3;
    @FXML
    private VBox tab3Vbox;

    @FXML
    private Label tab4Name;
    @FXML
    private ListView<String> tab4List;
    @FXML
    private Tab tab4;
    @FXML
    private VBox tab4Vbox;

    @FXML
    private Label tab5Name;
    @FXML
    private ListView<String> tab5List;
    @FXML
    private Tab tab5;
    @FXML
    private VBox tab5Vbox;

    @FXML
    private Label tabMainName;
    @FXML
    private ListView<String> tabMainList;
    @FXML
    private Tab tabMain;
    @FXML
    private VBox tabMainVbox;

    @FXML
    private TabPane tabPane;

    @FXML
    private Button addButton1;
    @FXML
    private Button addButton2;
    @FXML
    private Button addButton3;
    @FXML
    private Button addButton4;
    @FXML
    private Button addButton5;
    @FXML
    private Button addButton6;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private TextField textField3;
    @FXML
    private TextField textField4;
    @FXML
    private TextField textField5;
    @FXML
    private TextField textField6;

    @FXML
    private Button deleteButton1;
    @FXML
    private Button deleteButton2;
    @FXML
    private Button deleteButton3;
    @FXML
    private Button deleteButton4;
    @FXML
    private Button deleteButton5;
    @FXML
    private Button deleteButton6;


    private TextField currentTextField;

    private String selectedItem;

    private ListView<String> currentList;

    private Label selectedLabel;



    private Tab currentTab;


//    private GroceryList selectedGL;
//    private final BooleanProperty modifiedProperty = new SimpleBooleanProperty(false);
//    private ChangeListener<GroceryList> GCChangeListener;
//    private final ObservableList<GroceryList> glList = FXCollections.observableArrayList(GroceryList.extractor);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
        On startup an array of data is created using populate lists and a method from Sampledata. It is just a
        random assortment of grocery items from a premade list of possibilities. I did it this way so each run would
        be slightly different and to ensure the main was updating correctly.
         */

        //data has 5 grocery lists premade to put use as sample data for the lists
        ArrayList<GroceryList> data = populateLists();

        //Set the name, list and tabname. The tabname is just the first letter of the author's name. We can change that
        //its just what I put for the time being.
        tab1Name.setText(data.get(0).getAuthor());
        tab1List.setItems( data.get(0).getItems());
        tab1.setText(String.valueOf(data.get(0).getAuthor().charAt(0)));
        tab1.setStyle("-fx-background-color:#DF00FF73");
        tab1Vbox.setBackground(new Background(new BackgroundFill(Color.rgb(223,0,255,.45), CornerRadii.EMPTY, Insets.EMPTY)));

        tab2Name.setText(data.get(1).getAuthor());
        tab2List.setItems( data.get(1).getItems());
        tab2.setText(String.valueOf(data.get(1).getAuthor().charAt(0)));
        tab2.setStyle("-fx-background-color:#ED7D3173");
        tab2Vbox.setBackground(new Background(new BackgroundFill(Color.rgb(237,125,49,.45), CornerRadii.EMPTY, Insets.EMPTY)));


        tab3Name.setText(data.get(2).getAuthor());
        tab3List.setItems( data.get(2).getItems());
        tab3.setText(String.valueOf(data.get(2).getAuthor().charAt(0)));
        tab3.setStyle("-fx-background-color:#64ABE373");
        tab3Vbox.setBackground(new Background(new BackgroundFill(Color.rgb(100,171,227,.45), CornerRadii.EMPTY, Insets.EMPTY)));


        tab4Name.setText(data.get(3).getAuthor());
        tab4List.setItems( data.get(3).getItems());
        tab4.setText(String.valueOf(data.get(3).getAuthor().charAt(0)));
        tab4.setStyle("-fx-background-color:#9FE2BF73");
        tab4Vbox.setBackground(new Background(new BackgroundFill(Color.rgb(159,226,191,.45), CornerRadii.EMPTY, Insets.EMPTY)));


        tab5Name.setText(data.get(4).getAuthor());
        tab5List.setItems( data.get(4).getItems());
        tab5.setText(String.valueOf(data.get(4).getAuthor().charAt(0)));
        tab5.setStyle("-fx-background-color:#FFDB5373");
        tab5Vbox.setBackground(new Background(new BackgroundFill(Color.rgb(255,219,88,.45), CornerRadii.EMPTY, Insets.EMPTY)));


        tabMainName.setText("Main");
        tabMain.setText("Main");

        //I made a method to update the Main list so it will be easy to update it when we make changes to lists
        updateMainList();

        setCurrentList(tab1List); //currentList will start on the first tab
        setCurrentTab(tab1);

        tabPane.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("Current Selected Tab: ");
                    String printTab = getCurrentTab().getId();
//                    System.out.println(printTab);
                    setCurrentTab(newValue);
                    if(printTab.contains("M")){ //sets current list to main and current selection to first
                        setCurrentList(tabMainList);
                        getCurrentList().getSelectionModel().select(tabMainList.getItems().get(0));
                        setCurrentTextField(textField6);
                        setSelectedLabel(tabMainName);
                    } else if (printTab.contains("1")){//sets current list to 1 and current selection to first
                        setCurrentList(tab1List);
                        getCurrentList().getSelectionModel().select(tab1List.getItems().get(0));
                        setCurrentTextField(textField1);
                        setSelectedLabel(tab1Name);
                    } else if (printTab.contains("2")){//sets current list to 2 and current selection to first
                        setCurrentList(tab2List);
                        getCurrentList().getSelectionModel().select(tab2List.getItems().get(0));
                        setCurrentTextField(textField2);
                        setSelectedLabel(tab2Name);
                    }else if (printTab.contains("3")){//sets current list to 3 and current selection to first
                        setCurrentList(tab3List);
                        getCurrentList().getSelectionModel().select(tab3List.getItems().get(0));
                        setCurrentTextField(textField3);
                        setSelectedLabel(tab3Name);
                    }else if (printTab.contains("4")){//sets current list to 4 and current selection to first
                        setCurrentList(tab4List);
                        getCurrentList().getSelectionModel().select(tab4List.getItems().get(0));
                        setCurrentTextField(textField4);
                        setSelectedLabel(tab4Name);
                    }else if (printTab.contains(("5"))){//sets current list to 5 and current selection to first
                        setCurrentList(tab5List);
                        getCurrentList().getSelectionModel().select(tab5List.getItems().get(0));
                        setCurrentTextField(textField5);
                        setSelectedLabel(tab5Name);
                    }
                    System.out.println(getCurrentList().getId());
                    System.out.println(getCurrentList().getSelectionModel().getSelectedItems().toString());
                    getCurrentList().getSelectionModel().selectedItemProperty().addListener(
                            (obs, ov, nv) -> {

                                System.out.println("Current Selected Item: ");
                                System.out.println(getCurrentList().getSelectionModel().getSelectedItems().toString());


                                setSelectedItem(nv);
                                getCurrentList().getSelectionModel().select(nv);
                            });
                    getCurrentList().getSelectionModel().selectFirst();
                });
        tabPane.getSelectionModel().select(tab2);
        tabPane.getSelectionModel().select(tab1);




    }

    //adds a new item to the list from the text in the text field
    @FXML
    private void addButtonAction(ActionEvent actionEvent){
        //find out what list, tab, and text field is currently being viewed by the user
        Tab addTab = getCurrentTab();
        if(!getCurrentTextField().getText().isBlank()){
            String userText = getCurrentTextField().getText();
            System.out.println("Add " + userText);
            getCurrentList().getItems().add(userText);
        }
        updateMainList();
    }

    //deletes an item from the current list
    @FXML
    private void deleteButtonAction(ActionEvent actionEvent){
        //find out what list the user is viewing
        String delItem = getCurrentList().getSelectionModel().getSelectedItem();
        getCurrentList().getItems().remove(delItem);
        System.out.println("Deleted " + delItem);
        if(!getCurrentTab().equals(tabMain)){
            updateMainList();
        }
    }

    @FXML
    private void onLabelClicked(MouseEvent mouseEvent) {

        if(!getCurrentTextField().getText().isBlank()){
            String newName = getCurrentTextField().getText();
            System.out.println("Name Changed to" + newName);
            getSelectedLabel().setText(newName);
            getCurrentTab().setText(String.valueOf(newName.charAt(0)));
        }
    }

    @FXML
    private void printButtonAction(ActionEvent actionEvent) {

        Document document = new Document();
        String list = "Grocery List\n-----------\n";
        for(int i=0;i<getCurrentList().getItems().size();i++) {

            list += "- " + getCurrentList().getItems().get(i) + "\n";
        }

        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Grocery List.pdf"));
            document.open();
            document.add(new Paragraph(list));
            document.close();
            writer.close();
        } catch (DocumentException e)
        {
            e.printStackTrace();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }



    //gets the current tab
    private Tab getCurrentTab(){
        Tab tab = new Tab();
        tab = tabPane.getSelectionModel().getSelectedItem();
        return tab;

    }

    //Create the array of premade data to use for examples. The names are just placeholders
    //See SampleData to see how the lists are made.
    private ArrayList<GroceryList> populateLists() {
       ArrayList<GroceryList> rtnList = new ArrayList<GroceryList>();
       String[] names = {"Alpha", "Bravo", "Charlie", "Delta", "Echo"};

        for(int i=0;i<5;i++) {
            rtnList.add(SampleData.fillSampleData(names[i]));
        }
        return rtnList;
    }

    //updateMainList uses a method called combinelists to check all lists and copy unique entries into the main. The
    //main list will have duplicates in the fringe case that the first list contains duplicates, but that can be fixed
    //in the future.
    private void updateMainList() {

        //I had to make the starting ObservableList this way because otherwise it would change other lists along the
        //way.
        ObservableList<String> currentList = FXCollections.observableArrayList();

        //These calls just add in unique data to the running list.
        combineLists(currentList,tab1List.getItems());
        combineLists(currentList,tab2List.getItems());
        combineLists(currentList,tab3List.getItems());
        combineLists(currentList,tab4List.getItems());
        combineLists(currentList,tab5List.getItems());

        tabMainList.setItems(currentList);
    }

    //combineLists takes in two lists and modifies the first one by adding the elements from the second that are not
    //already contained within it. It uses a nested for loop to check each new entry by all entries already within the
    //list.
    private void combineLists(ObservableList<String> currentList, ObservableList<String> compareList) {
        for(int i=0;i<compareList.size();i++) {

            boolean repeatItem = false;
            for(int j=0;j<currentList.size();j++) {

                if(compareList.get(i).equalsIgnoreCase(currentList.get(j))) {
                    repeatItem = true;
                }
            }
            if(repeatItem==false) {
                currentList.add(compareList.get(i));
                System.out.println(compareList.get(i));
            }
        }

    }

    public ListView<String> getCurrentList() {
        return currentList;
    }

    public void setCurrentList(ListView<String> currentList) {
        this.currentList = currentList;
    }

    public void setCurrentTab(Tab currentTab) {
        this.currentTab = currentTab;
    }

    public TextField getCurrentTextField() {
        return currentTextField;
    }

    public void setCurrentTextField(TextField currentTextField) {
        this.currentTextField = currentTextField;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Label getSelectedLabel() {
        return selectedLabel;
    }

    public void setSelectedLabel(Label selectedLabel) {
        this.selectedLabel = selectedLabel;
    }

}
