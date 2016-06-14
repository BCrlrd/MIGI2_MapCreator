package nl.tudelft.coccreator;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nl.tudelft.coccreator.model.Room;
import nl.tudelft.coccreator.model.Tile;
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

	public static Room room;

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

	public void init() {
		save.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					room.write();
					Platform.exit();
				} catch (Exception e) {
					System.err.println("Well, this sure broke.");
				}
			}
		});

		direction.getItems().addAll(
				Direction.NORTH,
				Direction.EAST,
				Direction.SOUTH,
				Direction.WEST
		);

		action.getItems().addAll(
				"Set tile",
				"Set entity",
				"Remove entity"
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
				"WallFrame",
				"PointLight"
		);
	}
}
