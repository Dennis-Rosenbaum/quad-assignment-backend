package quad.assignmentbackend.api.questions.get;

public class QuestionModel {

    private final int questionId;
    private final QuestionType questionType;
    private final String question;
    private final String[] answers;

    public QuestionModel(int questionId, QuestionType questionType, String question, String[] answers) {
        this.questionType = questionType;
        this.question = question;
        this.answers = answers;
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getAnswers() {
        return answers;
    }
}
