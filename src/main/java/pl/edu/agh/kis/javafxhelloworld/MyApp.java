package pl.edu.agh.kis.javafxhelloworld;


import javafx.application.Application;
import javafx.stage.Stage;
import pl.edu.agh.kis.javafxhelloworld.modelviews.BasicControlsViewModel;
import pl.edu.agh.kis.javafxhelloworld.views.BasicControls;

public class MyApp extends Application {

	BasicControls view;
	BasicControlsViewModel viewModel;
	
	public static void main(String[] args) {
		launch(args);
	}	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		viewModel = new BasicControlsViewModel();
		view = new BasicControls(viewModel);
		view.start(primaryStage);
	}

}
