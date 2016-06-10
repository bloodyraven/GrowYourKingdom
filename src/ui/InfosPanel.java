package ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import bean.Game;

public class InfosPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Game g;
	private Label populationLabel, happinessLabel, goldLabel, criminalityLabel, defenseLabel;
	private Container parent;
	
	public InfosPanel(Game g, Container parent) {
		this.setG(g);
		this.setParent(parent);
		this.populationLabel=new Label("Population : "+g.getPopulation());
		this.happinessLabel=new Label("Happiness : "+g.getHappiness());
		this.goldLabel=new Label("Gold : "+g.getGold());
		this.criminalityLabel=new Label("Criminality : "+g.getCriminality());
		this.defenseLabel=new Label("Defense : "+g.getDefense());
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(populationLabel);
		this.add(happinessLabel);
		this.add(goldLabel);
		this.add(criminalityLabel);
		this.add(defenseLabel);
		this.setPreferredSize(new Dimension(100, 150));
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public Label getPopulationLabel() {
		return populationLabel;
	}

	public void setPopulationLabel(Label populationLabel) {
		this.populationLabel = populationLabel;
	}

	public Label getHappinessLabel() {
		return happinessLabel;
	}

	public void setHappinessLabel(Label happinessLabel) {
		this.happinessLabel = happinessLabel;
	}

	public Label getGoldLabel() {
		return goldLabel;
	}

	public void setGoldLabel(Label goldLabel) {
		this.goldLabel = goldLabel;
	}

	public Label getCriminalityLabel() {
		return criminalityLabel;
	}

	public void setCriminalityLabel(Label criminalityLabel) {
		this.criminalityLabel = criminalityLabel;
	}

	public Label getDefenseLabel() {
		return defenseLabel;
	}

	public void setDefenseLabel(Label defenseLabel) {
		this.defenseLabel = defenseLabel;
	}

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}
	
}
