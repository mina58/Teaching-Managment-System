
package ControllersAndFxml;

import JavaFXApplication6.Verification;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class PinVerficationScreenController implements Initializable {

    @FXML
    private TextField pinField;
    @FXML
    private Button OkButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void OkButtonPressed(ActionEvent event) throws IOException {
       boolean bool = Verification.checkPin(Integer.parseInt(pinField.getText()));
       if(bool){
           System.out.println("pin correct");
           Stage stageOriginal =(Stage)((Node)event.getSource()).getScene().getWindow();
           stageOriginal.close();
           Parent root = FXMLLoader.load(getClass().getResource("ViewGroupAssistant.fxml"));
           Scene scene = new Scene(root);
           Stage stage = new Stage();
           stage.setScene(scene);
           stage.setResizable(false);
           stage.show();
           
       }
       else{
           Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
           stage.close();
       }
    }
    
}
