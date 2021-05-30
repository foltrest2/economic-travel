package ui;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.BorderPane;
import model.TravelGuide;

public class economictravelGUI {


	private TravelGuide tg;
	@FXML
	private BorderPane basePane;
	@FXML
	private ScrollPane map;

	public economictravelGUI(TravelGuide t) {

		t=tg;

	}

	public void loadMainMenu() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Map.fxml"));
		fxmlLoader.setController(this);
		Parent mape = fxmlLoader.load();
		basePane.setCenter(mape);
		map.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		map.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		map.pannableProperty().set(true);
		zoom(map);

	}

	public void zoom( ScrollPane pane) {
		pane.setOnScroll(
				new EventHandler<ScrollEvent>() {
					@Override
					public void handle(ScrollEvent event) {
						double zoomFactor = 1.05;
						double deltaY = event.getDeltaY();

						if (deltaY < 0){
							zoomFactor = 0.95;
						}
						pane.setScaleX(pane.getScaleX() * zoomFactor);
						pane.setScaleY(pane.getScaleY() * zoomFactor);
						event.consume();

					}

				});
	}


}
