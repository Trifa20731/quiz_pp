package udacity.projectpractice1.quizeapp.ViewAndController;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import udacity.projectpractice1.quizeapp.QuestionModel.SingleChoiceQuestion;
import udacity.projectpractice1.quizeapp.R;

/**
 * The class defines a controller of a single choice question. In the controller, it
 * will connect with a single choice question data model and defines the UI component of
 * a single choice question.
 */

public class SingleChoiceQuestionViewController extends QuestionController implements View.OnClickListener {

    private static final String TAG = "single choice question";

    // The data model of single choice question.
    private SingleChoiceQuestion singleChoiceQuestion;

    // The unique data component of the single choice question.
    private LinearLayout singleQuestionLayout;
    private RadioGroup singleQuestionRG;

    // The final choice index of users' choice.
    private int choiceIndex;

    /**
     * This constructor to set up a single choice question UI and data.
     *
     * @param singleChoiceQuestion the data model of multiple choice question.
     * @param singleQuestionLayout the layout of multiple choice question.
     */
    public SingleChoiceQuestionViewController(SingleChoiceQuestion singleChoiceQuestion, LinearLayout singleQuestionLayout) {
        this.singleChoiceQuestion = singleChoiceQuestion;
        this.singleQuestionLayout = singleQuestionLayout;

        questionTextView = this.singleQuestionLayout.findViewById(R.id.single_choice_question_text_view);
        singleQuestionRG = this.singleQuestionLayout.findViewById(R.id.question_radio_group);

        questionTextView.setText(singleChoiceQuestion.getQuestion());
        for (int i = 0; i < 4; i++) {
            ((RadioButton) singleQuestionRG.getChildAt(i)).setText(singleChoiceQuestion.getChoice(i));
            ((RadioButton) singleQuestionRG.getChildAt(i)).setOnClickListener(this);
        }
    }

    /**
     * The method to check whether the user answered correct or not and send the final mark to main activity.
     *
     * @return the integer of final question mark.
     */
    public int giveMark() {
        singleChoiceQuestion.isAnswerCorrect(choiceIndex);
        singleQuestionRG.clearCheck();
        return singleChoiceQuestion.getQuestionMark();
    }

    /**
     * The onclick function to listen which radio button has been choosen and change the answer index.
     *
     * @param v the View that received the click event.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.question_radio_btn_1:
                choiceIndex = 0;
                break;
            case R.id.question_radio_btn_2:
                choiceIndex = 1;
                break;
            case R.id.question_radio_btn_3:
                choiceIndex = 2;
                break;
            case R.id.question_radio_btn_4:
                choiceIndex = 3;
                break;
        }
    }
}
