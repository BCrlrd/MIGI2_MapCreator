package nl.tudelft.coccreator;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.SneakyThrows;
import nl.tudelft.coccreator.model.Room;
import nl.tudelft.coccreator.model.Tile;
import nl.tudelft.coccreator.util.Applier;
import nl.tudelft.coccreator.util.Direction;

public class EditScreen {

	@FXML
	public ColorPicker picker;
	@FXML
	public ComboBox action;
	@FXML
	public ComboBox tile;
	@FXML
	public ComboBox entity;
	@FXML
	public ComboBox direction;
	@FXML
	public TextField height;
	@FXML
	public TextField a_1;
	@FXML
	public TextField a_2;
	@FXML
	public TextField a_3;
	@FXML
	public Button save;
	@FXML
	public Button apply;
	@FXML
	public ScrollPane scrollpane;

	public static Room room;
	private int lastClicked_x;
	private int lastClicked_y;

	public static void start(Stage primaryStage, Room passedRoom) throws Exception {
		room = passedRoom;
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(EditScreen.class.getResource("EditScreen.fxml"));

		try {
			HBox rootLayout = loader.load();
			EditScreen controller = loader.getController();
			Scene scene = new Scene(rootLayout);
			primaryStage.setTitle("CoC Room Creator");
			primaryStage.setScene(scene);
			primaryStage.show();
			controller.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SneakyThrows
	public void init() {
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					room.write();
				} catch (Exception e) {
					System.err.println("Well, this sure broke.");
				}
				refreshMap();
			}
		});

		apply.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int h;
				try {
					h = Integer.valueOf(height.getText());
				} catch (Exception e) {
					h = 0;
				}
				Applier.apply(
						picker.getValue(),
						(String) action.getSelectionModel().getSelectedItem(),
						(Tile) tile.getSelectionModel().getSelectedItem(),
						(String) entity.getSelectionModel().getSelectedItem(),
						(Direction) direction.getSelectionModel().getSelectedItem(),
						h,
						a_1.getText(),
						a_2.getText(),
						a_3.getText(),
						lastClicked_x,
						lastClicked_y
				);
				refreshMap();
			}
		});

		populate();
		refreshMap();
	}

	private void populate() {
		direction.getItems().addAll(
				Direction.NORTH,
				Direction.EAST,
				Direction.SOUTH,
				Direction.WEST
		);

		action.getItems().addAll(
				"Set tile",
				"Set entity",
				"Remove entity",
				"Add light",
				"Remove light"
		);

		tile.getItems().addAll(
				Tile.FLOOR,
				Tile.WALL,
				Tile.ENTRANCE,
				Tile.EXIT,
				Tile.EMPTY
		);

		entity.getItems().addAll(
				"Bomb",
				"Carrot",
				"Crate",
				"DamagedWall",
				"Door",
				"Gate",
				"InvisibleWall",
				"Key",
				"KillerBunny",
				"LandMine",
				"Pitfall",
				"Player",
				"PlayerTrigger",
				"Treasure",
				"VoidPlatform",
				"WallFrame"
		);
	}

	private void refreshMap() {
		GridPane pane = new GridPane();
		for(int y = 0; y < room.getHeight(); y++){
			for(int x = 0; x < room.getWidth(); x++){

				// Create a new TextField in each Iteration
				TextField tf = new TextField();
				tf.setPrefHeight(40);
				tf.setPrefWidth(40);
				tf.setAlignment(Pos.CENTER);
				tf.setEditable(false);
				tf.setText(room.getTiles()[x][y].getRepresentation());
				tf.setStyle(room.getColour(x, y));
				if (room.getLight(x, y) != null) {
					tf.setStyle("-fx-font-weight: bold");
				}
				int cpx = x;
				int cpy = y;
				tf.focusedProperty().addListener(new ChangeListener<Boolean>() {
					@Override
					public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue) {
						if (newPropertyValue) {
							lastClicked_x = cpx;
							lastClicked_y = cpy;
						}
					}
				});

				// Iterate the Index using the loops
				pane.setRowIndex(tf,y);
				pane.setColumnIndex(tf,x);
				pane.getChildren().add(tf);
			}
		}
		scrollpane.setContent(pane);
	}
}
