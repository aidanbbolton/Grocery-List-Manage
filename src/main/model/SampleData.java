package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class SampleData {

    public static void fillSampleData(ObservableList<GroceryList> backingList) {
        ObservableList list1 = FXCollections.observableArrayList();
        list1.add("bread");
        list1.add("avocado");

        ObservableList list2 = FXCollections.observableArrayList();
        list2.add("Beans");
        list2.add("Soup");
        list2.add("Poptarts");

        backingList.add(new GroceryList("Waldo", list1,"food needed")); //both drawing from the same list
        backingList.add(new GroceryList("Dan", list2,"food I want")); //you can add more if you want

    }

}
