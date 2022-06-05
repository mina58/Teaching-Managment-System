package ControllersAndFxml;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import static ControllersAndFxml.Index.db;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

public class AssistantViewController implements Initializable {
    @FXML
    private ListView<String> list;
    String chosenAssistant;

    public void GroupsSelected(ActionEvent event) throws IOException{
        Parent GroupsViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/groupsView.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(db.queryAllAssistantsNames().size() == 0){
            list.getItems().add("*  There are no assistants saved  *");
        }
        else{
             list.getItems().addAll(db.queryAllAssistantsNames());
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                chosenAssistant = list.getSelectionModel().getSelectedItem();
            }
        });
        }
       
    }
    
    @FXML
     private void viewButtonPressed(ActionEvent event) throws IOException{
       try{ 
        ViewAssistantController.assistantName = chosenAssistant;
        Parent root = FXMLLoader.load(getClass().getResource("viewAssistant.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
       }
       catch(Exception e){
           System.out.println(e);
       }
    }
    @FXML 
    private void AssignAssistantPressed(ActionEvent event) throws IOException{
        AssignAssistantController.chosenAssistant = chosenAssistant;
        Parent root = FXMLLoader.load(getClass().getResource("assignAssistant.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }//4875
    
}

