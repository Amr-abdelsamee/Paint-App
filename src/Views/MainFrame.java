package Views;

import Controllers.Controller;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;

public class MainFrame extends javax.swing.JFrame {

	DrawingPanel drawPanel;
	Controller controller;
	private boolean saved = false;
	private boolean newProject = false;
	private int i;

	public MainFrame() {
		setLocation(new Point(250, 80));

		initComponents();
		drawPanel = new DrawingPanel(this.redoButton, this.undoButton, this.clearButton);
		controller = Controller.getInstance(drawPanel, this.redoButton, this.undoButton, this.clearButton);
		tmpPanel.add(drawPanel);
		repaint();
	}

	private void initComponents() {

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/Assets/Images/paint-app-icon.png")));

		buttonGroup1 = new javax.swing.ButtonGroup();
		background = new javax.swing.JPanel();
		tmpPanel = new javax.swing.JPanel();
		topBar = new javax.swing.JToolBar();
		filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		undoButton = new javax.swing.JButton();
		redoButton = new javax.swing.JButton();
		jSeparator2 = new javax.swing.JToolBar.Separator();
		filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		lineStrokeLabel = new javax.swing.JLabel();
		filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		lineStrokeMenu = new javax.swing.JComboBox<>();
		filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		drawFillButton = new javax.swing.JToggleButton();
		filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		colorPickerButton = new javax.swing.JButton();
		filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(5, 5), new java.awt.Dimension(5, 5),
				new java.awt.Dimension(5, 5));
		currentColor = new javax.swing.JPanel();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
				new java.awt.Dimension(32767, 0));
		sideBar = new javax.swing.JToolBar();
		mousePointerButton = new javax.swing.JToggleButton();
		lineButton = new javax.swing.JToggleButton();
		rectangleButton = new javax.swing.JToggleButton();
		squareButton = new javax.swing.JToggleButton();
		circleButton = new javax.swing.JToggleButton();
		triangleButton = new javax.swing.JToggleButton();
		ellispeButton = new javax.swing.JToggleButton();
		jSeparator3 = new javax.swing.JToolBar.Separator();
		moveButton = new javax.swing.JToggleButton();
		fillButton = new javax.swing.JToggleButton();
		copyButton = new javax.swing.JToggleButton();
		resizeButton = new javax.swing.JToggleButton();
		deleteButton = new javax.swing.JToggleButton();
		jSeparator4 = new javax.swing.JToolBar.Separator();
		clearButton = new javax.swing.JButton();
		menuBar = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		newProjectMenuItem = new javax.swing.JMenuItem();
		newProjectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (!saved) {

					int respose = JOptionPane.showConfirmDialog(null, "Save current project?");
					if (respose == JOptionPane.YES_OPTION) {
						save(drawPanel);
						
						clearButtonActionPerformed(evt);
						undoButtonActionPerformed(evt);
						
						clearButtonActionPerformed(evt);
					} else {
						
						clearButtonActionPerformed(evt);
						undoButtonActionPerformed(evt);
						
						clearButtonActionPerformed(evt);
					}
				}
			}
		});
		saveProjectMenuItem = new javax.swing.JMenuItem();
		saveProjectMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				save(drawPanel);
			}
		});
		jMenu2 = new javax.swing.JMenu();
		aboutMenuItem = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Paint App");
		setMinimumSize(new java.awt.Dimension(996, 573));
		setSize(new java.awt.Dimension(947, 537));

		tmpPanel.setForeground(new java.awt.Color(255, 0, 255));
		tmpPanel.setLayout(new java.awt.BorderLayout());

		topBar.setFloatable(false);
		topBar.add(filler9);

		undoButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_undo_black_24dp.png")));
		undoButton.setToolTipText("undo");
		undoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		undoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				undoButtonActionPerformed(evt);
			}
		});
		topBar.add(undoButton);

		redoButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_redo_black_24dp.png")));
		redoButton.setToolTipText("redo");
		redoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		redoButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				redoButtonActionPerformed(evt);
			}
		});
		topBar.add(redoButton);
		topBar.add(jSeparator2);
		topBar.add(filler2);

		lineStrokeLabel.setText("Line Stroke");
		topBar.add(lineStrokeLabel);
		topBar.add(filler3);

		lineStrokeMenu.setEditable(true);
		lineStrokeMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "10", "12", "14", "16", "18", "20", "22", "24" }));
		lineStrokeMenu.setToolTipText("Line Stroke");
		lineStrokeMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		lineStrokeMenu.setMaximumSize(new java.awt.Dimension(100, 25));
		lineStrokeMenu.setMinimumSize(new java.awt.Dimension(100, 25));
		lineStrokeMenu.setPreferredSize(new java.awt.Dimension(100, 25));
		lineStrokeMenu.setEditable(false);
		lineStrokeMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lineStrokeMenuActionPerformed(evt);
			}
		});
		topBar.add(lineStrokeMenu);
		topBar.add(filler4);

		drawFillButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/outline_format_paint_black_24dp.png")));
		drawFillButton.setToolTipText("Draw Filled");
		drawFillButton.setFocusable(false);
		drawFillButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		drawFillButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		drawFillButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				drawFillButtonActionPerformed(evt);
			}
		});
		topBar.add(drawFillButton);
		topBar.add(filler8);

		colorPickerButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_color_lens_black_24dp.png")));
		colorPickerButton.setToolTipText("Change Color");
		colorPickerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		colorPickerButton.setFocusable(false);
		colorPickerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		colorPickerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		colorPickerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				colorPickerButtonActionPerformed(evt);
			}
		});
		topBar.add(colorPickerButton);
		topBar.add(filler10);

		currentColor.setBackground(new java.awt.Color(0, 0, 0));
		currentColor.setMaximumSize(new java.awt.Dimension(24, 24));
		currentColor.setMinimumSize(new java.awt.Dimension(24, 24));
		currentColor.setPreferredSize(new java.awt.Dimension(24, 24));
		currentColor.setLayout(new java.awt.BorderLayout());
		topBar.add(currentColor);
		topBar.add(filler1);

		sideBar.setBackground(Color.LIGHT_GRAY);
		sideBar.setFloatable(false);
		sideBar.setForeground(new java.awt.Color(102, 255, 102));
		sideBar.setOrientation(javax.swing.SwingConstants.VERTICAL);
		sideBar.setRollover(true);

		buttonGroup1.add(mousePointerButton);
		mousePointerButton
				.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/mouse-pointer.png")));
		mousePointerButton.setToolTipText("Normal Mode");
		mousePointerButton.setFocusable(false);
		mousePointerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		mousePointerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		mousePointerButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mousePointerButtonActionPerformed(evt);
			}
		});
		sideBar.add(mousePointerButton);

		buttonGroup1.add(lineButton);
		lineButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/outline_maximize_black_24dp.png.png")));
		lineButton.setToolTipText("Draw Line");
		lineButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		lineButton.setFocusable(false);
		lineButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		lineButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		lineButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				lineButtonActionPerformed(evt);
			}
		});
		sideBar.add(lineButton);

		buttonGroup1.add(rectangleButton);
		rectangleButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_crop_16_9_black_24dp.png")));
		rectangleButton.setToolTipText("Draw Rectangle");
		rectangleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		rectangleButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				rectangleButtonActionPerformed(evt);
			}
		});
		sideBar.add(rectangleButton);

		buttonGroup1.add(squareButton);
		squareButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_crop_square_black_24dp.png")));
		squareButton.setToolTipText("Draw Square");
		squareButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		squareButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				squareButtonActionPerformed(evt);
			}
		});
		sideBar.add(squareButton);

		buttonGroup1.add(circleButton);
		circleButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_circle_black_24dp.png")));
		circleButton.setToolTipText("Draw Circle");
		circleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		circleButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				circleButtonActionPerformed(evt);
			}
		});
		sideBar.add(circleButton);

		buttonGroup1.add(triangleButton);
		triangleButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/outline_change_history_black_24dp.png")));
		triangleButton.setToolTipText("Draw triangle");
		triangleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		triangleButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				triangleButtonActionPerformed(evt);
			}
		});
		sideBar.add(triangleButton);

		buttonGroup1.add(ellispeButton);
		ellispeButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_oval_black_24dp.png")));
		ellispeButton.setToolTipText("Draw oval");
		ellispeButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		ellispeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ellispeButtonActionPerformed(evt);
			}
		});
		sideBar.add(ellispeButton);
		sideBar.add(jSeparator3);

		buttonGroup1.add(moveButton);
		moveButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_open_with_black_24dp.png")));
		moveButton.setToolTipText("Move Shapes");
		moveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		moveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				moveButtonActionPerformed(evt);
			}
		});
		sideBar.add(moveButton);

		buttonGroup1.add(fillButton);
		fillButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/outline_format_color_fill_black_24dp.png")));
		fillButton.setToolTipText("Fill Shape");
		fillButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		fillButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				fillButtonActionPerformed(evt);
			}
		});
		sideBar.add(fillButton);

		buttonGroup1.add(copyButton);
		copyButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/outline_content_paste_black_24dp.png")));
		copyButton.setToolTipText("Copy mode");
		copyButton.setFocusable(false);
		copyButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		copyButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		copyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				copyButtonActionPerformed(evt);
			}
		});
		sideBar.add(copyButton);

		buttonGroup1.add(resizeButton);
		resizeButton.setIcon(new javax.swing.ImageIcon(
				getClass().getResource("/Assets/Images/baseline_aspect_ratio_black_24dp.png")));
		resizeButton.setToolTipText("Resize mode");
		resizeButton.setFocusable(false);
		resizeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		resizeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		resizeButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				resizeButtonActionPerformed(evt);
			}
		});
		sideBar.add(resizeButton);

		buttonGroup1.add(deleteButton);
		deleteButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_delete_black_24dp.png")));
		deleteButton.setToolTipText("Delete mode");
		deleteButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		deleteButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			}
		});
		sideBar.add(deleteButton);
		sideBar.add(jSeparator4);

		clearButton.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_clear_all_black_18dp.png")));
		clearButton.setToolTipText("Clear All");
		clearButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		clearButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				clearButtonActionPerformed(evt);
			}
		});
		sideBar.add(clearButton);

		javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
		background.setLayout(backgroundLayout);
		backgroundLayout
				.setHorizontalGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(backgroundLayout.createSequentialGroup()
								.addComponent(sideBar, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(tmpPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addContainerGap())
						.addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE));
		backgroundLayout.setVerticalGroup(backgroundLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(backgroundLayout.createSequentialGroup()
						.addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, 31,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(backgroundLayout.createSequentialGroup()
										.addComponent(tmpPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addContainerGap())
								.addGroup(backgroundLayout.createSequentialGroup().addGap(8, 8, 8).addComponent(sideBar,
										javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)))));

		getContentPane().add(background, java.awt.BorderLayout.CENTER);

		jMenu1.setText("File");

		newProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		newProjectMenuItem.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_add_black_18dp.png"))); // NOI18N
		newProjectMenuItem.setText("New Project");
		jMenu1.add(newProjectMenuItem);

		saveProjectMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
				java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
		saveProjectMenuItem.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_save_black_18dp.png"))); // NOI18N
		saveProjectMenuItem.setText("Save Project");
		jMenu1.add(saveProjectMenuItem);

		menuBar.add(jMenu1);

		jMenu2.setText("Help");

		aboutMenuItem.setIcon(
				new javax.swing.ImageIcon(getClass().getResource("/Assets/Images/outline_info_black_18dp.png"))); // NOI18N
		aboutMenuItem.setText("About");
		aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutMenuItemActionPerformed(evt);
			}
		});
		jMenu2.add(aboutMenuItem);

		menuBar.add(jMenu2);

		setJMenuBar(menuBar);

		pack();
	}

	private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.clear();
	}

	private void undoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.undo();
	}

	private void redoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.redo();
	}

	private void squareButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (squareButton.isSelected()) {
			controller.drawSquare();
		} else {
			controller.resetMode();
		}
	}

	private void rectangleButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (rectangleButton.isSelected()) {
			controller.drawRect();
		} else {
			controller.resetMode();
		}
	}

	private void circleButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (circleButton.isSelected()) {
			controller.drawCircle();
		}else {
            controller.resetMode();
        }
	}

	private void triangleButtonActionPerformed(java.awt.event.ActionEvent evt) {

		if (triangleButton.isSelected()) {
			controller.drawTriangle();
		} else {
			controller.resetMode();
		}
	}

	private void ellispeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (ellispeButton.isSelected()) {
			controller.drawOval();
		} else {
			controller.resetMode();
		}
	}

	private void moveButtonActionPerformed(java.awt.event.ActionEvent evt) {

		if (moveButton.isSelected()) {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.move();
		} else {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.resetMode();
		}
	}

	private void fillButtonActionPerformed(java.awt.event.ActionEvent evt) {

		if (fillButton.isSelected()) {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.fill();

		} else {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.resetMode();
		}
	}

	private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (deleteButton.isSelected()) {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.delete();
		} else {
			drawFillButton.setSelected(false);
			controller.setFalseDrawFilled();
			controller.resetMode();
		}

	}

	private void lineButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (lineButton.isSelected()) {
			controller.drawLine();
		} else {
			controller.resetMode();
		}
	}

	private void lineStrokeMenuActionPerformed(java.awt.event.ActionEvent evt) {
		int stroke = Integer.valueOf((String) lineStrokeMenu.getSelectedItem());
		controller.setLineStroke(stroke);
	}

	private void colorPickerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.colorPicker(currentColor);
	}

	private void mousePointerButtonActionPerformed(java.awt.event.ActionEvent evt) {
		controller.resetMode();
	}

	private void drawFillButtonActionPerformed(java.awt.event.ActionEvent evt) {
		if (drawFillButton.isSelected())
			controller.drawFill();
		else {
			controller.setFalseDrawFilled();
			mousePointerButton.setSelected(true);
		}
	}

	private void copyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		drawFillButton.setSelected(false);
		controller.setFalseDrawFilled();
		controller.copy();
	}

	private void resizeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		drawFillButton.setSelected(false);
		controller.setFalseDrawFilled();
		controller.resize();
	}

	private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
		drawFillButton.setSelected(false);
		controller.setFalseDrawFilled();
		new About().setVisible(true);
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			new MainFrame().setVisible(true);
		});
	}

	private void save(Component comp) {
		BufferedImage bi = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_RGB);
		comp.paint(bi.getGraphics());

		try {
			ImageIO.write(bi, "png", new File("image" + i + ".png"));
			i++;
			JOptionPane.showMessageDialog(this, "Saved Successfully!!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JMenuItem aboutMenuItem;
	private javax.swing.JPanel background;
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.JToggleButton circleButton;
	public javax.swing.JButton clearButton;
	private javax.swing.JButton colorPickerButton;
	private javax.swing.JToggleButton copyButton;
	javax.swing.JPanel currentColor;
	private javax.swing.JToggleButton deleteButton;
	private javax.swing.JToggleButton drawFillButton;
	private javax.swing.JToggleButton ellispeButton;
	private javax.swing.JToggleButton fillButton;
	private javax.swing.Box.Filler filler1;
	private javax.swing.Box.Filler filler10;
	private javax.swing.Box.Filler filler2;
	private javax.swing.Box.Filler filler3;
	private javax.swing.Box.Filler filler4;
	private javax.swing.Box.Filler filler8;
	private javax.swing.Box.Filler filler9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JToolBar.Separator jSeparator2;
	private javax.swing.JToolBar.Separator jSeparator3;
	private javax.swing.JToolBar.Separator jSeparator4;
	private javax.swing.JToggleButton lineButton;
	private javax.swing.JLabel lineStrokeLabel;
	private javax.swing.JComboBox<String> lineStrokeMenu;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JToggleButton mousePointerButton;
	private javax.swing.JToggleButton moveButton;
	private javax.swing.JMenuItem newProjectMenuItem;
	private javax.swing.JToggleButton rectangleButton;
	public javax.swing.JButton redoButton;
	private javax.swing.JToggleButton resizeButton;
	private javax.swing.JMenuItem saveProjectMenuItem;
	private javax.swing.JToolBar sideBar;
	private javax.swing.JToggleButton squareButton;
	private javax.swing.JPanel tmpPanel;
	private javax.swing.JToolBar topBar;
	private javax.swing.JToggleButton triangleButton;
	public javax.swing.JButton undoButton;
}
