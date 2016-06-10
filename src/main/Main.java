package main;

import javax.swing.JFrame;

import ui.GamePanel;
import bean.Game;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Grow Your Kingdom");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setContentPane(new GamePanel(new Game()));
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
	
}
