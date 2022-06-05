
package ControllersAndFxml;

import static ControllersAndFxml.Index.db;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AssignAssistantController implements Initializable {

    @FXML
    private ListView<String> list;
    private String chosenGroup;
    public static String chosenAssistant;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          list.getItems().addAll(db.queryAllGroupsNames());
            list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                chosenGroup = list.getSelectionModel().getSelectedItem();
            }
        });
    }    

    @FXML
    private void DonePressed(ActionEvent event) {
        db.assignAssistantToGroup(chosenAssistant, chosenGroup);
        Stage stageOriginal = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageOriginal.close();
    }
    
}
