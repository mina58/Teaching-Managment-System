package ControllersAndFxml;

import JavaFXApplication6.Verification;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ControllersAndFxml.Index.db;

public class AssistantIndexController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Button addGroupButton;
    @FXML
    private Button viewGroup;
    @FXML
    private ListView<String> list;
    String chosenGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         list.getItems().addAll(db.queryAllGroupsNames());
            list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                chosenGroup = list.getSelectionModel().getSelectedItem();
            }
        });

    }    

    @FXML
    public void Logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/Index2.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
   }
   
    @FXML
    private void viewGroupPressed(ActionEvent event) throws IOException {
        Verification.chosenGroup = chosenGroup;
        ViewGroupAssistantController.chosenGroup = chosenGroup;
        Parent root = FXMLLoader.load(getClass().getResource("PinVerficationScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
