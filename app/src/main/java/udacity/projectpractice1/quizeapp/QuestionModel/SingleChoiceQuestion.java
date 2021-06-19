package udacity.projectpractice1.quizeapp.QuestionModel;

import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class define the data model of Single Choice Question.
 * <p>
 * Note: The index of answer are
 * A -> 0, B -> 1, C -> 2, D -> 3.
 */

public class SingleChoiceQuestion {
    private final static String TAG = "SingleChoiceQuestion";

    // The necessary attributes for a single choice question.
    private String question;
    private int questionMark;
    private String[] questionChoices;
    private int answerIndex;

    /**
     * The default constructor for the single choice question.
     */
    public SingleChoiceQuestion() {
    }

    /**
     * The constructor to setup the question answer, the choices of question and the index of answer.
     *
     * @param question       the String of question text.
     * @param questionChoice the String Array of question choices.
     * @param answerIndex    the index of correct answer.
     */
    public SingleChoiceQuestion(String question, String[] questionChoice, int answerIndex) {
        this.question = question;
        this.questionChoices = questionChoice;
        this.answerIndex = answerIndex;
        questionMark = 0;
    }


//-----------------------------------------------------------------------------Judgement Function--------------------------------------------------------------

    /**
     * This method use the answer index to check whether the user answered correct or not.
     *
     * @param tmpAnswerIndex the index of users' choices.
     */
    public void isAnswerCorrect(int tmpAnswerIndex) {
        questionMark = 0;
        if (tmpAnswerIndex == answerIndex) {
            questionMark = 1;
        }
    }


//-----------------------------------------------------------------------------Get and Set Function-------------------------------------------------------------

    /**
     * This method get the question text.
     *
     * @return The String of question text.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * This method get the question mark.
     *
     * @return The final mark of a multiple question.
     */
    public int getQuestionMark() {
        return questionMark;
    }

    /**
     * This method get the question choice text.
     *
     * @return The String of a question choice.
     */
    public String getChoice(int index) {
        return this.questionChoices[index];
    }


}
