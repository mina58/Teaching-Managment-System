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

public class AddStudentFormController {

    @FXML
    private TextField NameField;
    @FXML
    private TextField NumberField;
    @FXML
    private TextField ParentField;
    @FXML
    private Label phoneNumError;
    @FXML
    private Label parentError;
    @FXML
    private Button DoneButton;

   

    @FXML
    private void DoneButtonPressed(ActionEvent event) {
        try{
            Integer.parseInt(NumberField.getText());
            Integer.parseInt(ParentField.getText());
            db.newStudent(NameField.getText(), NumberField.getText(), ParentField.getText());
            Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
            stage.close();
        }
        catch(NumberFormatException e){
            parentError.setText("Please make sure Phone numbers only consist of numbers between 0-9");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
