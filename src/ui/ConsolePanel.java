package ui;

import java.awt.Container;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ConsolePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private String consoleContent="";
	private TextArea ta;
	private TextField tf;
	private Container parent;
	
	public ConsolePanel(Container parent) {
		this.setParent(parent);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		final TextArea ta = new TextArea();
		ta.setFocusable(false);
		final TextField tf = new TextField();
		this.add(ta);
		this.add(tf);
		tf.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					ta.append(tf.getText()+"\n");
					tf.setText("");
				}
			}
			@Override
			public void keyPressed(KeyEvent arg0) {
			}
		});
	}

	public String getConsoleContent() {
		return consoleContent;
	}

	public void setConsoleContent(String consoleContent) {
		this.consoleContent = consoleContent;
	}

	public TextArea getTa() {
		return ta;
	}

	public void setTa(TextArea ta) {
		this.ta = ta;
	}

	public TextField getTf() {
		return tf;
	}

	public void setTf(TextField tf) {
		this.tf = tf;
	}

	public Container getParent() {
		return parent;
	}

	public void setParent(Container parent) {
		this.parent = parent;
	}
}
