package pl.edu.agh.kis.javafxhelloworld.views;

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
import pl.edu.agh.kis.javafxhelloworld.modelviews.BasicControlsViewModel;

public class BasicControls {
	
	private Label cbLabel;
	private ComboBox<String> itemsAvailable;
	private Label textLabel;
	private TextField newItemField;
	private Button addItemToAvailable;
	private GridPane layout;
	
	private void init() {
		cbLabel = new Label("Available items:");
		itemsAvailable = new ComboBox<>();
		textLabel = new Label("New item field:");
		newItemField = new TextField();
		addItemToAvailable = new Button("Add that item");
	}
	
	private void bind(BasicControlsViewModel modelView) {
		itemsAvailable.itemsProperty().bindBidirectional(modelView.allItems());
		newItemField.textProperty().bindBidirectional(modelView.newItemTextChanged());
		addItemToAvailable.setOnAction(modelView.addNewItem());
	}
	
	private GridPane insertControlsIntoLayout() {
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(addItemToAvailable);
		
		
		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		layout.setHgap(10);
		layout.setVgap(10);
		layout.setPadding(new Insets(25, 25, 25, 25));
		
		layout.add(cbLabel,0,0);
		layout.add(itemsAvailable,1,0);
		layout.add(textLabel,0,1);
		layout.add(newItemField,1,1);
		layout.add(hbBtn,1,3);
		return layout;
	}
	
	public BasicControls(BasicControlsViewModel viewModel) {
		init();
		bind(viewModel);
		layout = insertControlsIntoLayout();
	}
	
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("MyApp Hello!");	
		primaryStage.setScene(new Scene(layout,400,300));
		primaryStage.show();
	}
}
