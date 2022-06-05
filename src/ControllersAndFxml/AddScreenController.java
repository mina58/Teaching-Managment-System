package ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import static ControllersAndFxml.Index.db;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class AddScreenController {
    
    @FXML
    private ListView<String> StudentsList;
    private ListView<String> AssistantsList;
    
    public void GroupsSelected(ActionEvent event) throws IOException{
        Parent GroupsViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/groupsView.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(GroupsViewRoot);
        stage.setScene(scene);
        stage.show();
    }
    public void AssistantsSelected(ActionEvent event) throws IOException{
           Parent GroupsViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/assistantView.fxml"));
           Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
           Scene scene = new Scene(GroupsViewRoot);
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

    public void addStudentButtonPressed(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/AddStudentForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        Stage stageOriginal = (Stage)(((Node)event.getSource()).getScene().getWindow());
        stageOriginal.show();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    public void addAssistantButtonPressed (ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/AddAssistantForm.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        Stage stageOriginal = (Stage)(((Node)event.getSource()).getScene().getWindow());
        stageOriginal.show();
        stage.setScene(scene);
        stage.showAndWait();
    }
    
    
     
}
