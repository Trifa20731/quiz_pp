package udacity.projectpractice1.quizeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import udacity.projectpractice1.quizeapp.QuestionModel.MultipleChoiceQuestion;
import udacity.projectpractice1.quizeapp.QuestionModel.SingleChoiceQuestion;
import udacity.projectpractice1.quizeapp.QuestionModel.TextQuestion;
import udacity.projectpractice1.quizeapp.ViewAndController.MultipleChoiceQuestionViewController;
import udacity.projectpractice1.quizeapp.ViewAndController.QuestionController;
import udacity.projectpractice1.quizeapp.ViewAndController.SingleChoiceQuestionViewController;
import udacity.projectpractice1.quizeapp.ViewAndController.TextQuestionViewController;


/**
 * This class defines a quiz app.
 * */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // The final mark of users' answer.
    int totalMark;

    // Data Model for different questions.
    private SingleChoiceQuestion singleChoiceQues1;
    private SingleChoiceQuestion singleChoiceQues2;
    private MultipleChoiceQuestion multipleChoiceQues1;
    private MultipleChoiceQuestion multipleChoiceQues2;
    private TextQuestion textQuestion1;
    private TextQuestion textQuestion2;

    // View Controller for different questions.
    private SingleChoiceQuestionViewController singleChoiceQuestionViewController1;
    private SingleChoiceQuestionViewController singleChoiceQuestionViewController2;
    private MultipleChoiceQuestionViewController multipleChoiceQuestionViewController1;
    private MultipleChoiceQuestionViewController multipleChoiceQuestionViewController2;
    private TextQuestionViewController textQuestionViewController1;
    private TextQuestionViewController textQuestionViewController2;

    // The QuestionController ArrayList to contain all Questions.
    private ArrayList<QuestionController> questionControllerArrayList = new ArrayList<QuestionController>();

    // The submit button.
    private Button submitButton;

    /**
     * The method to create the Quiz App UI.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create and initialize the question models.
        singleChoiceQues1 = new SingleChoiceQuestion(
                getResources().getString(R.string.single_question_1),
                getResources().getStringArray(R.array.single_question_1_choice),
                0);
        singleChoiceQues2 = new SingleChoiceQuestion(
                getResources().getString(R.string.single_question_2),
                getResources().getStringArray(R.array.single_question_2_choice),
                1);
        multipleChoiceQues1 = new MultipleChoiceQuestion(
                getResources().getString(R.string.multiple_question_1),
                getResources().getStringArray(R.array.multiple_question_1_choice),
                23);
        multipleChoiceQues2 = new MultipleChoiceQuestion(
                getResources().getString(R.string.multiple_question_2),
                getResources().getStringArray(R.array.multiple_question_2_choice),
                8);
        textQuestion1 = new TextQuestion(
                getResources().getString(R.string.text_question_1),
                getResources().getString(R.string.text_question_1_answer));
        textQuestion2 = new TextQuestion(
                getResources().getString(R.string.text_question_2),
                getResources().getString(R.string.text_question_2_answer));

        // Assigning the IDs to object.
        LinearLayout singleQuestion1Layout = findViewById(R.id.single_choice_question_1);
        LinearLayout singleQuestion2Layout = findViewById(R.id.single_choice_question_2);
        LinearLayout multipleQuestion1Layout = findViewById(R.id.multiple_choice_question_1);
        LinearLayout multipleQuestion2Layout = findViewById(R.id.multiple_choice_question_2);
        LinearLayout textQuestion1Layout = findViewById(R.id.text_question_1);
        LinearLayout textQuestion2Layout = findViewById(R.id.text_question_2);
        submitButton = findViewById(R.id.finish_button);

        // create new question view controller.
        singleChoiceQuestionViewController1 = new SingleChoiceQuestionViewController(singleChoiceQues1, singleQuestion1Layout);
        singleChoiceQuestionViewController2 = new SingleChoiceQuestionViewController(singleChoiceQues2, singleQuestion2Layout);
        multipleChoiceQuestionViewController1 = new MultipleChoiceQuestionViewController(multipleChoiceQues1, multipleQuestion1Layout);
        multipleChoiceQuestionViewController2 = new MultipleChoiceQuestionViewController(multipleChoiceQues2, multipleQuestion2Layout);
        textQuestionViewController1 = new TextQuestionViewController(textQuestion1, textQuestion1Layout);
        textQuestionViewController2 = new TextQuestionViewController(textQuestion2, textQuestion2Layout);

        // Store all question controller into array list.
        questionControllerArrayList.add(singleChoiceQuestionViewController1);
        questionControllerArrayList.add(singleChoiceQuestionViewController2);
        questionControllerArrayList.add(multipleChoiceQuestionViewController1);
        questionControllerArrayList.add(multipleChoiceQuestionViewController2);
        questionControllerArrayList.add(textQuestionViewController1);
        questionControllerArrayList.add(textQuestionViewController2);

        // set the button click listener.
        submitButton.setOnClickListener(this);
    }

    /**
     * The method to set the perform action after clicking button.
     *
     * @param v the View that received the click event.
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish_button:
                totalMark = 0;
                String infoToast;
                for (int i = 0; i < questionControllerArrayList.size(); i++) {
                    totalMark += questionControllerArrayList.get(i).giveMark();
                }
                if (totalMark != questionControllerArrayList.size()) {
                    infoToast = "Please try again. You Marks is " + totalMark + " / " + questionControllerArrayList.size() ;
                } else {
                    infoToast = "Congratulation. You Marks is " + totalMark + " / " + questionControllerArrayList.size() ;
                }
                Toast.makeText(getApplicationContext() ,infoToast, Toast.LENGTH_LONG).show();
                break;
        }
    }
}