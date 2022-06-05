package ControllersAndFxml;

import JavaFXApplication6.Verification;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    @FXML
    private TextField LoginUsername;
    @FXML   
    private PasswordField LoginPassword;
    @FXML
    private Label label1,label2;
    
    
   public void LogInButtonPressed(ActionEvent event) throws IOException{
       String Password = LoginPassword.getText();
       String m = Verification.verifyInfo(LoginUsername.getText(), Password);
       if(m.equals("teacher")){
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/login.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Stylesheet1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        }
       else if(m.equals("assistant")) {
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/AssistantIndex.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/StyleSheets/Stylesheet1.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
       else if (m.equals("not a user")){ 
           label1.setVisible(true);
           label2.setVisible(true);
       }
   }
   
}
