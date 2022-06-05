package ControllersAndFxml;

import static ControllersAndFxml.Index.db;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class GroupsViewController implements Initializable{
    @FXML
    private ListView<String> list;
    String chosenGroup;
   
   public void AssistantsSelected(ActionEvent event) throws IOException{
         Parent GroupsViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/assistantView.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(GroupsViewRoot);
        stage.setScene(scene);
        stage.show();
    }
   
   public void AddSelected(ActionEvent event) throws IOException {
        Parent AddScreenRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/AddScreen.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(AddScreenRoot);
        stage.setScene(scene);
        stage.show();
    }
   
  
   public void Logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/Index2.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
   }
   
   public void addGroupPressed(ActionEvent event) throws IOException{    
       Parent addGroupRoot = FXMLLoader.load(getClass().getResource("AddGroup.fxml"));
       Scene scene = new Scene(addGroupRoot);
       Stage stage = new Stage();
       stage.setScene(scene);
       stage.setResizable(false);
       stage.show();
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
            list.getItems().addAll(db.queryAllGroupsNames());
            list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                chosenGroup = list.getSelectionModel().getSelectedItem();
            }
        });
    }


   public void viewGroupPressed(ActionEvent event) throws IOException{
        ViewGroupController.ChosenGroup = chosenGroup;
        Parent root = FXMLLoader.load(getClass().getResource("ViewGroup.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
   }
}