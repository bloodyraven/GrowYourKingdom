package ui;

import java.awt.BorderLayout;
<<<<<<< HEAD
=======
import java.awt.Container;
>>>>>>> origin/master

import javax.swing.JPanel;

import bean.Game;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Game g;
<<<<<<< HEAD
	private ConsolePanel cslp;
	private ControlPanel ctrlp;
	private InfosPanel infop;
	private MapPanel mapp;
	
	public GamePanel(Game g) {
		this.setG(g);
		infop = new InfosPanel(g);
		cslp = new ConsolePanel();
		ctrlp = new ControlPanel(infop, cslp);
		mapp = new MapPanel();
		this.setLayout(new BorderLayout());
		this.add(mapp, BorderLayout.CENTER);
		this.add(ctrlp, BorderLayout.SOUTH);
=======
	private Container[] childs;
	
	public GamePanel(Game g) {
		this.setG(g);
		this.setLayout(new BorderLayout());
		MapPanel mp = new MapPanel();
		ControlPanel cp = new ControlPanel(new InfosPanel(g, this), new ConsolePanel(this));
		childs = new Container[2];
		childs[0] = mp;
		childs[1] = cp;
		this.add(mp, BorderLayout.CENTER);
		this.add(cp, BorderLayout.SOUTH);
>>>>>>> origin/master
	}

	public Game getG() {
		return g;
	}

	public void setG(Game g) {
		this.g = g;
	}

	public ConsolePanel getCslp() {
		return cslp;
	}

	public void setCslp(ConsolePanel cslp) {
		this.cslp = cslp;
	}

	public ControlPanel getCtrlp() {
		return ctrlp;
	}

	public void setCtrlp(ControlPanel ctrlp) {
		this.ctrlp = ctrlp;
	}

	public InfosPanel getInfop() {
		return infop;
	}

	public void setInfop(InfosPanel infop) {
		this.infop = infop;
	}

	public MapPanel getMapp() {
		return mapp;
	}

	public void setMapp(MapPanel mapp) {
		this.mapp = mapp;
	}
	
}
