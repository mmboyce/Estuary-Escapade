package controller;

public interface CodeListener {
	// Right not the only codelistner is the controller but it made sense to have an
	// interface in case something else needs to receive codes
	public void codeEmitted(Code c);
}
