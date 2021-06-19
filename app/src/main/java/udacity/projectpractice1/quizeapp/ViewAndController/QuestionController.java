package udacity.projectpractice1.quizeapp.ViewAndController;

import android.widget.TextView;

/**
 * This is the super class of all question controller.
 */

public class QuestionController {

    // The text view of every question controller to display the question.
    protected TextView questionTextView;

    /**
     * The method to return the final mark of question.
     * return 0 mark for default.
     *
     * @return the integer of question mark.
     */
    public int giveMark() {
        return 0;
    }


}
