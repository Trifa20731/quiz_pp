package udacity.projectpractice1.quizeapp.ViewAndController;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import udacity.projectpractice1.quizeapp.QuestionModel.MultipleChoiceQuestion;
import udacity.projectpractice1.quizeapp.R;

/**
 * The class defines a controller of a multiple choice question. In the controller,
 * it will connect with a multiple choice question data model and defines the UI component of
 * a multiple choice question.
 */

public class MultipleChoiceQuestionViewController extends QuestionController implements View.OnClickListener {

    private static final String TAG = "multipleChoiceQuestion";

    // The data model of multiple choice question.
    private MultipleChoiceQuestion multipleChoiceQuestion;

    // The linear layout of multiple choice question.
    private LinearLayout multipleChoiceQuestionLayout;

    // The final answer index of users' choice.
    private int choiceIndex;

    /**
     * This constructor to set up a multiple choice question UI and data.
     *
     * @param multipleChoiceQuestion the data model of multiple choice question.
     * @param multipleQuestionLayout the layout of multiple choice question.
     */
    public MultipleChoiceQuestionViewController(MultipleChoiceQuestion multipleChoiceQuestion, LinearLayout multipleQuestionLayout) {
        this.multipleChoiceQuestion = multipleChoiceQuestion;
        this.multipleChoiceQuestionLayout = multipleQuestionLayout;

        questionTextView = this.multipleChoiceQuestionLayout.findViewById(R.id.multiple_choice_question_text_view);

        questionTextView.setText(multipleChoiceQuestion.getQuestion());
        for (int i = 0; i < 4; i++) {
            ((CheckBox) this.multipleChoiceQuestionLayout.getChildAt(i + 1)).setText(multipleChoiceQuestion.getChoice(i));
            ((CheckBox) this.multipleChoiceQuestionLayout.getChildAt(i + 1)).setOnClickListener(this);
        }
    }

    /**
     * The method to check whether the user answered correct or not and send the final mark to main activity.
     *
     * @return the integer of final question mark.
     */
    public int giveMark() {
        multipleChoiceQuestion.isAnswerCorrect(choiceIndex);
        for (int i = 0; i < 4; i++) {
            ((CheckBox) this.multipleChoiceQuestionLayout.getChildAt(i + 1)).setChecked(false);
        }
        return multipleChoiceQuestion.getQuestionMark();
    }

    /**
     * The onclick function to listen which checkboxs has been choosen and change the answer index.
     *
     * @param v the View that received the click event.
     */
    @Override
    public void onClick(View v) {
        boolean isChecked = ((CheckBox) v).isChecked();

        switch (v.getId()) {
            case R.id.checkbox_1:
                if (isChecked) {
                    Log.i(TAG, "Checkbox 1 has been checked");
                    choiceIndex += 3;
                } else {
                    Log.i(TAG, "Checkbox 1 unchecked");
                    choiceIndex -= 3;
                }
                break;
            case R.id.checkbox_2:
                if (isChecked) {
                    Log.i(TAG, "Checkbox 2 has been checked");
                    choiceIndex += 5;
                } else {
                    Log.i(TAG, "Checkbox 2 unchecked");
                    choiceIndex -= 5;
                }
                break;
            case R.id.checkbox_3:
                if (isChecked) {
                    Log.i(TAG, "Checkbox 3 has been checked");
                    choiceIndex += 7;
                } else {
                    Log.i(TAG, "Checkbox 3 unchecked");
                    choiceIndex -= 7;
                }
                break;
            case R.id.checkbox_4:
                if (isChecked) {
                    Log.i(TAG, "Checkbox 4 has been checked");
                    choiceIndex += 11;
                } else {
                    Log.i(TAG, "Checkbox 4 unchecked");
                    choiceIndex -= 11;
                }
                break;
        }
    }
}
