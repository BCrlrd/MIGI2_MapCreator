package nl.tudelft.coccreator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import nl.tudelft.coccreator.model.Room;

public class EditScreen {

	public static void start(Stage primaryStage, Room room) throws Exception {
		System.out.println(room.toString());
		primaryStage.setTitle("CoC Room Creator");
		Button btn = new Button();
		btn.setText("Lol not implemented.");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 800, 800));
		primaryStage.show();
	}
}
