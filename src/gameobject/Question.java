package gameobject;

/**
 * This class stores the question, fun-fact, and answers to the question. These
 * are passed to the {@link view.QuizView QuizView} and {@link model.QuizModel QuizModel}
 * to populate the quiz. Each animal in the game will have its own question.
 * 
 * @author Miguel Fuentes
 * @author W Mathieu Mimms-Boyce
 */
public class Question {

	private String question;
	private String funFact;
	private String correctAnswer;
	private String[] distractionAnswers;

	/**
	 * The constructor for Question.
	 * 
	 * @param funFact The Funfact about the fish
	 * @param question The question asked during the quiz
	 * @param correct The correct answer to the quiz
	 * @param a Distraction Answer A
	 * @param b Distraction Answer B
	 * @param c Distraction Answer C
	 */
	public Question(String funFact, String question, String correct, String a, String b, String c) {
		setQuestion(question);
		setCorrectAnswer(correct);
		distractionAnswers = new String[3];
		distractionAnswers[0] = a;
		distractionAnswers[1] = b;
		distractionAnswers[2] = c;
		this.funFact = funFact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("Fun Fact: " + funFact + "/nQuestion: " + question + "/nCorrect Answer: " + correctAnswer
				+ "/nDisctraction Answer 1: " + distractionAnswers[0]);
	}

	/**
	 * @return The String representing the Question to be asked during the quiz.
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question The String to change the quiz question to.
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return The String representing the answer to the quiz.
	 */
	public String getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * @param correctAnswer Thhe String to change the correct answer to.
	 */
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	/**
	 * @return An array of all the answers to the quiz.
	 */
	public String[] getAllAnswers() {
		// Returns all answers correct and distraction
		String[] answerArr = new String[4];
		answerArr[0] = correctAnswer;
		for (int i = 1; i < 4; i++) {
			answerArr[i] = distractionAnswers[i - 1];
		}
		return answerArr;
	}

	/**
	 * @return The funFact filled out in the notebook.
	 */
	public String getFunFact() {
		return funFact;
	}

	/**
	 * @param funFact The funFact to be put into the notebook.
	 */
	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}

}
