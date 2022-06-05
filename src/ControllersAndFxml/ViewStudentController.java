package ControllersAndFxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import tmsdbPackage.Student;
import static ControllersAndFxml.Index.db;

public class ViewStudentController implements Initializable {

    @FXML
    private Label studentName;
    @FXML
    private Label PhoneNum;
    @FXML
    private Label ParentPhoneNum;
    @FXML
    private Label GroupName;

    static String chosenStudentName;
    Student student;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        student = db.selectStudent(chosenStudentName);
        studentName.setText(chosenStudentName);
        PhoneNum.setText(student.getStudentNumber());
        ParentPhoneNum.setText(student.getParentNumber());
        GroupName.setText(student.getGrp());
    }    

    @FXML
    private void viewMarksPressed(ActionEvent event) {
        
    }

    @FXML
    private void editMarksPressed(ActionEvent event) {
        
    }
    
}
