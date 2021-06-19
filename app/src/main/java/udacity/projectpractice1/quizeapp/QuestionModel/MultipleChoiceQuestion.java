package udacity.projectpractice1.quizeapp.QuestionModel;

import java.util.Arrays;

/**
 * This class is the data model of multiple choice question.
 * <p>
 * Note: The index of answer are
 * A -> 3, B -> 5, C -> 7, D -> 11.
 * Therefor, if the final answer is A and B, the answer index is the sum of A and B which is 8.
 * A,B,C,D. The answer index is 26.
 */

public class MultipleChoiceQuestion {

    // The necessary attributes for a multiple choice question.
    private String question;
    private int questionMark;
    private String[] questionChoices;
    private int answerIndex;

    /**
     * The default constructor for the multiple choice question.
     */
    public MultipleChoiceQuestion() {
    }

    /**
     * The constructor to setup the question answer, the choices of question and the index of answer.
     *
     * @param question       the String of question text.
     * @param questionChoice the String Array of question choices.
     * @param answerIndex    the index of correct answer.
     */
    public MultipleChoiceQuestion(String question, String[] questionChoice, int answerIndex) {
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
        return question;
    }

    ;

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
