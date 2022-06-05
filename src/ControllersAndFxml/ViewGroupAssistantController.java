package ControllersAndFxml;

import static ControllersAndFxml.Index.db;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ViewGroupAssistantController implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Button homeworkButton;
    @FXML
    private Button quizzesButton;
    @FXML
    private ListView<String> studentsList;
    public static String chosenGroup;
    private String ChosenStudent; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        studentsList.getItems().addAll(db.queryStudentsNamesInAGroup(chosenGroup));
            studentsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               ChosenStudent = studentsList.getSelectionModel().getSelectedItem();
            }
        });
    }    

    @FXML
    private void Logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ControllersAndFxml/Index2.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void HomeworkPressed(ActionEvent event) {
        System.out.println("Show Homework");
    }

    @FXML
    private void QuizzesPressed(ActionEvent event) {
        System.out.println("Show Quizzes");
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
    
}
