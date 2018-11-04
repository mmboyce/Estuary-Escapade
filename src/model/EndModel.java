package model;

public class EndModel extends Model {

	private int score;
	private boolean quizCorrect;
	
	public EndModel(int frameWidth, int frameHeight, Model nextModel) {
		super(frameWidth, frameHeight, nextModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Model nextModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
