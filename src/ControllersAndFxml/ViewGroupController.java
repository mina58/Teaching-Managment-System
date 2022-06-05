package ControllersAndFxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import static ControllersAndFxml.Index.db;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tmsdbPackage.Assistant;
import tmsdbPackage.Group;

public class ViewGroupController implements Initializable {

    @FXML
    private ListView<String> StudentsList;
    @FXML
    private Button ViewButton;
    @FXML
    private Button HomeworkButton;
    @FXML
    private Button AddQuizButton;
    @FXML
    private TextField AssistantNameField;
    
    static String ChosenGroup;
    Assistant assistantObj;
    String ChosenStudent;
    Group group;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(db.getGroupAssistant(ChosenGroup).equals(null)) {
            group = db.selectGroup(ChosenGroup);
            AssistantNameField.setText(group.getAssistant());
            StudentsList.getItems().addAll(db.queryStudentsNamesInAGroup(ChosenGroup));

            StudentsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    ChosenStudent = StudentsList.getSelectionModel().getSelectedItem();
                }
            });
        }
        else{
            AssistantNameField.setText("*There is no assistant assigned to this group*");
            StudentsList.getItems().addAll(db.queryStudentsNamesInAGroup(ChosenGroup));

            StudentsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    ChosenStudent = StudentsList.getSelectionModel().getSelectedItem();
                }
            });
        }

    }    

    @FXML
    private void ViewStudentPressed(ActionEvent event) throws IOException {
        ViewStudentController.chosenStudentName = ChosenStudent;
        Parent root = FXMLLoader.load(getClass().getResource("viewStudent.fxml"));
        Stage stage = (Stage)(((Node)event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AddHomeworkPressed(ActionEvent event) throws IOException {
        AddHomeworkScreenController.chosenGroup = ChosenGroup;
        Parent root = FXMLLoader.load(getClass().getResource("addHomeworkScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AddQuizButtonPressed(ActionEvent event) throws IOException {
        AddQuizScreenController.makeQuiz();
        Parent root = FXMLLoader.load(getClass().getResource("AddQuizScreen.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
