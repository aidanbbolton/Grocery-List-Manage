package main.model;

import java.util.ArrayList;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Callback;
import java.util.Objects;

public class GroceryList {


    private StringProperty author = new SimpleStringProperty(this, "author", "");
    private StringProperty title = new SimpleStringProperty(this, "title", "");
    private ObservableList<String> items = FXCollections.observableArrayList();

    public GroceryList(String author, ObservableList<String> items, String title) {
        this.author.set(author);
        this.items.setAll(items);
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public ObservableList getItems() {
        return items;
    }

    public void setItems(ObservableList items) {
        this.items = items;
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String toString() {
        return title.get() + " by " + author.get();
    }


    public static Callback<GroceryList, Observable[]> extractor = p -> new Observable[]
            {p.titleProperty(), p.authorProperty()};

}
