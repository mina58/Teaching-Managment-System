package ControllersAndFxml;

import static ControllersAndFxml.arraylistss.StudentNames;
import static ControllersAndFxml.Index.db;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddGroupController implements Initializable {
   
    static ArrayList<String> GroupStudentNames = new ArrayList<>();
    String ChosenStudent, ChosenToRemoveStudent, GrpName, maxNum;
    @FXML
    private TextField groupNameText;
    @FXML
    private TextField maxStudentsText;
    @FXML
    private ListView<String> allStudentsListView;
    @FXML
    private Button AddButton;
    @FXML
    private ListView<String> studentsListView;
    @FXML
    private Button RemoveButton;
    @FXML
    private Label labelError; 
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(db.queryAllStudentsNames().size() == 0){
            allStudentsListView.getItems().add("Please Add Students First");
        }
        else{
            allStudentsListView.getItems().addAll(db.queryAllStudentsNames());
            allStudentsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    ChosenStudent = allStudentsListView.getSelectionModel().getSelectedItem();
                }
            });
            studentsListView.getItems().addAll(GroupStudentNames);
            studentsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    ChosenToRemoveStudent = studentsListView.getSelectionModel().getSelectedItem();
                }
            });
        }
    }    

    @FXML
    private void DonePressed(ActionEvent event) {
        try{
        int maxNumber = Integer.parseInt(maxStudentsText.getText());
        int pin = db.newGrp(groupNameText.getText(), maxNumber);
        AlertBox.display("Pin for " + groupNameText.getText() + " is " + pin, "Please make sure to save the "
                + "pin before exiting");
        db.assignStudentsToGroup(GroupStudentNames, groupNameText.getText());
        studentsListView.getItems().clear();
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        }
        catch(NumberFormatException e){
            labelError.setText("Please Only enter a number");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void AddButtonPressed(ActionEvent event) {
       // allStudentsListView.getItems().remove(ChosenStudent);
        studentsListView.getItems().add(ChosenStudent);
        GroupStudentNames.add(ChosenStudent);
        
    }

    @FXML
    private void RemoveButtonPressed(ActionEvent event) {
        //allStudentsListView.getItems().add(ChosenToRemoveStudent);
        studentsListView.getItems().remove(ChosenToRemoveStudent);
        GroupStudentNames.remove(ChosenToRemoveStudent);
    }
            
    
}
