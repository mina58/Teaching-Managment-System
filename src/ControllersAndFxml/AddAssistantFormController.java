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

public class AddAssistantFormController implements Initializable {

    @FXML
    private TextField NumberField;
    @FXML
    private TextField SalaryField;
    @FXML
    private TextField NameField;
    @FXML
    private Label phoneNumError;
    @FXML
    private Label SalaryError;
    @FXML
    private Button DoneButton;
    @FXML
    private TextField ParentField;
    int salary;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void DoneButtonPressed(ActionEvent event) {
        try{
            salary = Integer.parseInt(SalaryField.getText());
            db.newAssistant(NameField.getText(), NumberField.getText(), salary);
            Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            stage.close();
        }
        catch(NumberFormatException e){
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
