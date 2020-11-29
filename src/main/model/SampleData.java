package main.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Random;

public class SampleData {

    public static String[] items = {"bread", "juice", "bananas", "mints", "beans", "cheese", "watermelon", "apples", "tortillas"};

    //fill sample data uses a given name and random to fill in a new grocery list with a random amount of data
    public static GroceryList fillSampleData(String name) {
        Random rand = new Random();
        ObservableList list1 = FXCollections.observableArrayList();
        for(int i=0; i<rand.nextInt(3)+1;i++) {
            list1.add(items[rand.nextInt(9)]);
        }

        return new GroceryList(name,list1);
    }

}
