package ControllersAndFxml;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void display(String message, String secondMessage) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(message);
		window.setWidth(300);
		window.setHeight(200);
		
		Label label = new Label();
		label.setText(message);
                label.setFont(Font.font("System", 14));
		Label label2 = new Label(secondMessage);
                label2.setTextFill(Color.RED);
		Button closebutton = new Button("Ok");
		closebutton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, label2, closebutton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setResizable(false);
		window.setScene(scene);
		window.showAndWait();
	}
	
}
