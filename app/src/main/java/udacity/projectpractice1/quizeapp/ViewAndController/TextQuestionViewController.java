package udacity.projectpractice1.quizeapp.ViewAndController;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import udacity.projectpractice1.quizeapp.QuestionModel.TextQuestion;
import udacity.projectpractice1.quizeapp.R;

/**
 * The class defines a controller of a text question. In the controller, it
 * will connect with a text question data model and defines the UI component of
 * a text question.
 * */

public class TextQuestionViewController extends QuestionController {

    private static final String TAG = "text question";

    // The data model of a text question.
    private TextQuestion textQuestion;

    // The UI component which are unique on the Text Question.
    private LinearLayout textQuestionLayout;
    private EditText textQuestionInput;

    /**
     * The constructor to build a text question.
     *
     * @param textQuestion the data model of a text question.
     * @param textQuestionLayout the layout of a text question.
     * */
    public TextQuestionViewController(TextQuestion textQuestion, LinearLayout textQuestionLayout) {
        this.textQuestion = textQuestion;
        this.textQuestionLayout = textQuestionLayout;

        questionTextView = this.textQuestionLayout.findViewById(R.id.text_question_text_view);
        textQuestionInput = this.textQuestionLayout.findViewById(R.id.question_input);

        questionTextView.setText(textQuestion.getQuestion());
    }

    /**
     * The method to check whether the user answered correct or not and send the final mark to main activity.
     *
     * @return the integer of final question mark.
     * */
    public int giveMark() {
        String tmpAnswer = textQuestionInput.getText().toString();
        textQuestion.isAnswerCorrect(tmpAnswer);
        textQuestionInput.setText("");
        return textQuestion.getQuestionMark();
    }
}
