package ControllersAndFxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import static ControllersAndFxml.Index.db;


public class AddHomeworkScreenController implements Initializable {

    @FXML
    private TextArea hwTextField;
    public static String chosenGroup;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    @FXML
    private void donePressed(ActionEvent event){
        db.newHomework(hwTextField.getText(), chosenGroup);
    }
    
}
