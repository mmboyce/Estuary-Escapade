package controller;

import gameobject.Animal;

public interface CodeListener {
	// Right not the only codelistner is the controller but it made sense to have an
	// interface in case something else needs to receive codes
	public void codeEmitted(Code c);

	public void estuaryPopup(Animal a);

	public void researchPopup(Animal a);
	
	public void tutorialPopup1();
	public void tutorialPopup2();
}
