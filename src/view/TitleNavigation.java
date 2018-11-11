package view;

import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Code;
import controller.CodeListener;

public class TitleNavigation extends JPanel implements ActionListener {
	
	JButton start;
	JButton exit;
	JButton timeup;
	CodeListener CodeListener;

	public TitleNavigation(CodeListener cl) {
		CodeListener = cl;
		
		start = new JButton("Start");
		start.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.addActionListener(this);

		timeup = new JButton("timeup");
		timeup.addActionListener(this);
		
		setLayout(new FlowLayout());
		add(start);
		add(exit);
		add(timeup);
	}

	@Override
	public void actionPerformed(ActionEvent buttonPress) {
		JButton pressed = (JButton) buttonPress.getSource();
		if(pressed == start) {
			CodeListener.codeEmmitted(Code.NEXT);
		}
		else if(pressed == exit) {
			CodeListener.codeEmmitted(Code.EXIT);
		}
		else if(pressed==timeup){
			CodeListener.codeEmmitted(Code.TIMEUP);
		}
	}

}
