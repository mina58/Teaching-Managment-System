package ControllersAndFxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tmsdbPackage.TmsDb;

import java.io.IOException;

public class Index extends Application {
    public static TmsDb db;
    @Override
    public void start(Stage primaryStage) {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Index2.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Login");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setOnCloseRequest(e -> db.close());

        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
            db = new TmsDb();
            db.open();
            db.create();
            launch(args);
    }
    
}
