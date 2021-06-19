package udacity.projectpractice1.quizeapp.QuestionModel;

import java.util.Arrays;

/**
 * This is the text question data model.
 */

public class TextQuestion {

    // The necessary attributes of a text question.
    private String question;
    private int questionMark;
    private String answer;

    /**
     * The default text question constructor.
     */
    public TextQuestion() {
    }

    /**
     * The constructor to setup the question, answer and mark of question.
     *
     * @param question The question string.
     * @param answer   The answer of question.
     */
    public TextQuestion(String question, String answer) {
        this.question = question;
        this.answer = answer;
        questionMark = 0;
    }


//-----------------------------------------------------------------------------Judgement Function--------------------------------------------------------------

    /**
     * The method to check the user's answer is same as the model answer or not.
     *
     * @param tmpAnswer the answer submit by user.
     */
    public void isAnswerCorrect(String tmpAnswer) {
        questionMark = 0;
        if (tmpAnswer.equals(this.answer)) {
            questionMark = 1;
        }
    }


//-----------------------------------------------------------------------------Get and Set Function-------------------------------------------------------------

    /**
     * This method gets the question text.
     *
     * @return The string of question.
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * This method gets the final mark of question.
     *
     * @return The integer of question mark.
     */
    public int getQuestionMark() {
        return this.questionMark;
    }

}
