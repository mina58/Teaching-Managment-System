package ControllersAndFxml;

import static ControllersAndFxml.arraylistss.names;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import static ControllersAndFxml.arraylistss.names;

public class indexController {

    
    
    public void GroupsSelected(ActionEvent event) throws IOException {
        Parent GroupsViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/groupsView.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(GroupsViewRoot);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
     public void assistantsSelected(ActionEvent event) throws IOException {
        //Parent AssistantViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/assistantView.fxml"));
        try{
            Parent AssistantViewRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/assistantView.fxml"));
            
            Scene scene = new Scene(AssistantViewRoot);
            Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            stage.setResizable(false);
            stage.setScene(scene);

            stage.show();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        
    }
     
   
   public void AddSelected(ActionEvent event) throws IOException {
        Parent AddScreenRoot = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/AddScreen.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(AddScreenRoot);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
  
   public void Logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/Index2.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setResizable(false);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
   }
    
}
