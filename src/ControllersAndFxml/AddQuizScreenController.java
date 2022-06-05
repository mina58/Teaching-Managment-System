package ControllersAndFxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import quizPackage.Question;
import quizPackage.Quiz;
import quizPackage.QuizPrinter;

import java.io.IOException;

public class AddQuizScreenController {
    @FXML
    private TextField QuestionText, Ans1Text, Ans2Text, Ans3Text, Ans4Text;
    static Quiz quiz;
    public static void makeQuiz(){
        quiz = new Quiz();
    }

    @FXML
    private void donePressed(ActionEvent event){
        Question q = new Question(QuestionText.getText(), Ans1Text.getText(), Ans2Text.getText(), Ans3Text.getText(), Ans4Text.getText());
        //save object
        quiz.addQuestion(q);
        QuizPrinter.printQuiz(quiz);
        Stage stage =  (Stage)(((Node)event.getSource()).getScene().getWindow());
        stage.close();
    }
    @FXML
    private void newQuestionPressed(ActionEvent event) throws IOException {
        Question q = new Question(QuestionText.getText(), Ans1Text.getText(), Ans2Text.getText(), Ans3Text.getText(), Ans4Text.getText());
        quiz.addQuestion(q);
        clear();
    }
    @FXML
    private void clear(){
        QuestionText.clear();
        Ans1Text.clear();
        Ans2Text.clear();
        Ans3Text.clear();
        Ans4Text.clear();
    }
}
