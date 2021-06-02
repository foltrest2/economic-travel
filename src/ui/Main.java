package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private economictravelGUI guiItem;

	public Main() {
		
		guiItem = new economictravelGUI();
	}

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("basePane.fxml"));
		fxmlLoader.setController(guiItem);
		Parent root = fxmlLoader.load();
		guiItem.loadMainMenu();
		Scene scene = new Scene(root);
		primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Economic Travel");
		primaryStage.show();
	}
}

