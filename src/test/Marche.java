package test;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.SwingUtilities;

public class Marche extends JPanel {

	private static final long serialVersionUID = 1L;
	private Dimension preferredSize = new Dimension(400, 400);
	private BufferedImage sourceImage;
	private Image scaledImage;
	public JPanel jp = this;

	public static void main(String[] args) {
		JFrame jf = new JFrame("tes1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.add(new JScrollPane(new Marche()));
		jf.setVisible(true);
	}

	public Marche() {
		// generate rectangles with pseudo-random coords
		try {
			sourceImage = ImageIO.read(new File("resources/batiments/lvl3_house.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		scaledImage = sourceImage.getScaledInstance(400, 400,
				Image.SCALE_SMOOTH);

		// mouse listener to detect scrollwheel events
		addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				updatePreferredSize(e.getWheelRotation(), e.getPoint());
			}
		});

		MouseAdapter ma = new MouseAdapter() {

			private Point origin;

			@Override
			public void mousePressed(MouseEvent e) {
				origin = new Point(e.getPoint());
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				if (origin != null) {
					JViewport viewPort = (JViewport) SwingUtilities
							.getAncestorOfClass(JViewport.class, jp);
					if (viewPort != null) {
						int deltaX = origin.x - e.getX();
						int deltaY = origin.y - e.getY();

						Rectangle view = viewPort.getViewRect();
						view.x += deltaX;
						view.y += deltaY;

						jp.scrollRectToVisible(view);
					}
				}
			}

		};
		this.addMouseListener(ma);
        this.addMouseMotionListener(ma);
		
	}

	private void updatePreferredSize(int n, Point p) {
		double d = (double) n * 1.08;
		d = (n > 0) ? 1 / d : -d;

		int w = (int) (getWidth() * d);
		int h = (int) (getHeight() * d);
		preferredSize.setSize(w, h);
		scaledImage = sourceImage.getScaledInstance(this.getWidth(),
				this.getHeight(), Image.SCALE_SMOOTH);

		int offX = (int) (p.x * d) - p.x;
		int offY = (int) (p.y * d) - p.y;
		setLocation(getLocation().x - offX, getLocation().y - offY);

		getParent().doLayout();
	}

	public Dimension getPreferredSize() {
		return preferredSize;
	}

	public void paint(Graphics g) {
		super.paint(g);
		((Graphics2D) g).drawImage(scaledImage, 0, 0, null);
	}
}