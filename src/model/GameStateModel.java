package model;

public interface GameStateModel {
	// TODO Decide if we should make this an abstract class and extend it instead of
	// implement like we do with the view, currently it is inconsistent
	public QuizModel timeUp();
}
