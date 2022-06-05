package ControllersAndFxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static ControllersAndFxml.Index.db;
import javafx.scene.Node;
import javafx.stage.Stage;
import tmsdbPackage.Assistant;

public class ViewAssistantController implements Initializable {

    @FXML
    private TextField SalaryText;
    @FXML
    private Button EditButton;
    @FXML
    private Label Name, Number; 
    static String assistantName;
    Assistant assistant;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        assistant = db.selectAssistant(assistantName);
        Name.setText(assistant.getName());
        Number.setText(assistant.getAssistantNumber());
        SalaryText.setText(Double.toString(assistant.getSalary()));
    }    

    @FXML
    private void EditPressed(ActionEvent event) {
        SalaryText.setEditable(true);
    }
    @FXML
    private void DonePressed(ActionEvent event){
        //Save new Salary
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
    
}
