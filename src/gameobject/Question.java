package gameobject;

public class Question {

	private String question;
	private String funFact;
	private String correctAnswer;
	private String[] distractionAnswers;

	public Question(String funFact, String question, String correct, String a, String b, String c) {
		setQuestion(question);
		setCorrectAnswer(correct);
		distractionAnswers = new String[3];
		distractionAnswers[0] = a;
		distractionAnswers[1] = b;
		distractionAnswers[2] = c;
		this.funFact = funFact;
	}

	public String toString() {
		return ("Fun Fact: " + funFact + "/nQuestion: " + question + "/nCorrect Answer: " + correctAnswer
				+ "/nDisctraction Answer 1: " + distractionAnswers[0]);
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String[] getAllAnswers() {
		String[] answerArr = new String[4];
		answerArr[0] = correctAnswer;
		for (int i = 1; i < 4; i++) {
			answerArr[i] = distractionAnswers[i - 1];
		}
		return answerArr;
	}

	public String getFunFact() {
		return funFact;
	}

	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}

}
