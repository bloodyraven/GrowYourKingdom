package main;

import javax.swing.JFrame;

import bean.Game;
import ui.InfosPanel;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Grow Your Kingdom");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new InfosPanel(new Game()));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
