package Views;

import Controllers.Controller;
import Models.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class DrawingPanel extends javax.swing.JPanel {

	Controller controller;

	public DrawingPanel(JButton r, JButton u, JButton c) {
		initComponents();
		controller = Controller.getInstance(this, r, u, c);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2D.setColor(Color.BLACK);
		super.paintComponent(g);

		for (Shape shape : controller.getShapes()) {
			if (controller.isMoveChecked() || controller.isFillChecked()) {
				shape.edit(g, "");
			} else {
				if (controller.resizedChecked()) {
					if (shape.isIsEdited())
						shape.edit(g, "");
					else
						shape.draw(g);
				} else if (shape.isIsEdited()) {
					shape.edit(g, "");
				} else {
					shape.draw(g);
				}

			}
		}
	}

	private void initComponents() {

		setBackground(new java.awt.Color(255, 255, 255));
		setForeground(new java.awt.Color(255, 255, 255));
		addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
			public void mouseMoved(java.awt.event.MouseEvent evt) {
				formMouseMoved(evt);
			}

			public void mouseDragged(java.awt.event.MouseEvent evt) {
				DrawingPanel.this.mouseDragged(evt);
			}
		});
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				DrawingPanel.this.mousePressed(evt);
			}

			public void mouseReleased(java.awt.event.MouseEvent evt) {
				DrawingPanel.this.mouseReleased(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 767, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 593, Short.MAX_VALUE));
	}

	private void mousePressed(java.awt.event.MouseEvent evt) {
		controller.mousePressed(evt);
	}

	private void mouseReleased(java.awt.event.MouseEvent evt) {
		controller.mouseReleased(evt);
	}

	private void mouseDragged(java.awt.event.MouseEvent evt) {
		controller.mouseDragged(evt);
	}

	private void formMouseMoved(java.awt.event.MouseEvent evt) {

	}

}
