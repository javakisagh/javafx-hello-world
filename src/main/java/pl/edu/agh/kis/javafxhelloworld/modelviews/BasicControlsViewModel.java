package pl.edu.agh.kis.javafxhelloworld.modelviews;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BasicControlsViewModel {
	
	private SimpleListProperty<String> allItemsProperty = new SimpleListProperty<>(FXCollections.observableArrayList (
		    "Single", "Double", "Suite", "Family App"));
	private Property<String> currentTextProperty = new SimpleStringProperty();
	private EventHandler<ActionEvent> addNewItemHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			String value = currentTextProperty.getValue();
			System.out.println("adding: "+value);
			allItemsProperty.add(value);
		}
	};
	
	public Property<String> newItemTextChanged() {
		return currentTextProperty;
	}

	public EventHandler<ActionEvent> addNewItem() {
		return addNewItemHandler;
	}

	public Property<ObservableList<String>> allItems() {
		return allItemsProperty;
	}

}
