package ui;

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
	
	
	public ConsolePanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		TextArea ta = new TextArea();
		ta.setFocusable(false);
		TextField tf = new TextField();
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
}