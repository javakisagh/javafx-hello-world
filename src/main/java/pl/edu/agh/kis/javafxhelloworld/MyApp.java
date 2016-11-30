package pl.edu.agh.kis.javafxhelloworld;


import javafx.application.Application;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyApp extends Application {

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



	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyApp Hello!");
		
		Label cbLabel = new Label("Available items:");
		ComboBox<String> cb = new ComboBox<>();
		cb.itemsProperty().bindBidirectional(this.allItems());
		Label textLabel = new Label("New item field:");
		TextField text = new TextField();
		text.textProperty().bindBidirectional(this.newItemTextChanged());
		Button btn = new Button("Add that item");
		btn.setOnAction(this.addNewItem());
		
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		
		
		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPadding(new Insets(25, 25, 25, 25));
		
		layout.add(cbLabel,0,0);
		layout.add(cb,1,0);
		layout.add(textLabel,0,1);
		layout.add(text,1,1);
		layout.add(hbBtn,1,3);
		
		primaryStage.setScene(new Scene(layout,400,300));
		primaryStage.show();
	}

	private Property<String> newItemTextChanged() {
		return currentTextProperty ;
	}



	private EventHandler<ActionEvent> addNewItem() {
		return addNewItemHandler ;
	}



	private Property<ObservableList<String>> allItems() {
		return allItemsProperty;
	}

}
