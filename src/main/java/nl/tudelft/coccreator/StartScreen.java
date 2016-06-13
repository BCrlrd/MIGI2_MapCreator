package nl.tudelft.coccreator;

import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import nl.tudelft.coccreator.model.Room;
import nl.tudelft.coccreator.model.Tile;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartScreen extends Application {

	@Override
	public void start(Stage primaryStage) {
		TextField inputName = new TextField();
		inputName.setPromptText("Name");

		TextField inputWidth = new TextField();
		inputWidth.setPromptText("Width");

		TextField inputHeight = new TextField();
		inputHeight.setPromptText("Height");

		final ComboBox fillerCombobox = new ComboBox();
		fillerCombobox.getItems().addAll(
				Tile.EMPTY,
				Tile.FLOOR,
				Tile.WALL
		);
		fillerCombobox.setPromptText("Filler");


		Button btn = new Button();
		btn.setText("Generate");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					String name = inputName.getText();
					int width = Integer.parseInt(inputWidth.getText());
					int height = Integer.parseInt(inputHeight.getText());
					Tile filler = (Tile) fillerCombobox.getSelectionModel().getSelectedItem();
					Room room = new Room(height, width, filler, name);
					EditScreen.start(primaryStage, room);
				} catch (Exception e) {
					System.err.println("Width and/or height is not a number.");
				}
			}
		});

		btn.localToScene(350, 200);

		FlowPane root = new FlowPane();
		root.getChildren().addAll(inputName, inputWidth, inputHeight, fillerCombobox, btn);

		Scene scene = new Scene(root, 800, 800);
		root.setAlignment(Pos.CENTER);

		primaryStage.setTitle("CoC Room Creator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
