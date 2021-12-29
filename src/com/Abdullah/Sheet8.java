package com.Abdullah;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Sheet8 extends JFrame  {
	private JButton show = new JButton("Click Me");
	private JTextArea content = new JTextArea();
	private JLabel positionOFMouse = new JLabel("position on Screen 0 X 0 Y");
	private int countClick = 0;
	private JLabel ex1 = new JLabel("Exercise 1, 2");
	protected JRadioButton [] colors = new JRadioButton[5];
	protected JComboBox shapes = new JComboBox(new String[] {"None","Line", "Square", "Circle"});
	protected int count = 0;
	private  mPanel shapesPanel = new mPanel();
//	protected  Color selectedColor = new Color(244, 244, 244);

	Sheet8() {
		Task12();

		this.setTitle("Sheet 8");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setResizable(true);
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(224, 222, 222));
		this.setVisible(true);
		this.add(ex1);
		this.add(show);
		this.add(content);
		this.add(positionOFMouse);
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				positionOFMouse.setBounds(e.getX()+10, e.getY()-60, 200, 100);
				positionOFMouse.setText("pos (" + e.getX() + " X  " + e.getY() + " Y)");
			}
		});
		this.add(shapes);
		shapes.addActionListener(e -> {
			if (shapes.getSelectedItem().equals("Line")) {
				shapesPanel.setShapes(mPanel.Drawshapes.LINE);
				shapesPanel.repaint();
			}
			else if (shapes.getSelectedItem().equals("Square")) {
				shapesPanel.setShapes(mPanel.Drawshapes.SQUARE);
				shapesPanel.repaint();
			}
			else if (shapes.getSelectedItem().equals("Circle")) {
				shapesPanel.setShapes(mPanel.Drawshapes.CIRCLE);
				shapesPanel.repaint();
			}
		});

		colors[0] = new JRadioButton("Red");
		colors[0].addActionListener(e ->  {
			shapesPanel.setSelectedColor(Color.RED);
			shapesPanel.repaint();
		});
		colors[1] = new JRadioButton("Green");
		colors[1].addActionListener(e -> {shapesPanel.setSelectedColor(Color.GREEN);
			shapesPanel.repaint();
		});
		colors[2] = new JRadioButton("Blue");
		colors[2].addActionListener(e -> shapesPanel.setSelectedColor(Color.BLUE));
		colors[3] = new JRadioButton("Black");
		colors[3].addActionListener(e ->  shapesPanel.setSelectedColor(Color.BLACK));
		colors[4] = new JRadioButton("Yellow");
		colors[4].addActionListener(e -> shapesPanel.setSelectedColor(Color.YELLOW));
		ButtonGroup collect = new ButtonGroup();
		JLabel ex3 = new JLabel("Exercise 3");
		this.add(ex3);
		ex3.setBounds(30, 300, 80, 20);
		ex3.setFont(new Font("Comic Sans", Font.ITALIC, 16));
		for (var c : colors) {
			collect.add(c);
			c.setBounds(270 + count * 100,350, 70, 20);
			c.setBackground(new Color(224, 222, 222));
			this.add(c);
			++count;
		}
		shapes.setBounds(400, 400, 70, 20);
		this.add(shapesPanel);
	}

	private void Task12() {
			positionOFMouse.setBounds(10, 10, 200, 100);
			positionOFMouse.setForeground(Color.blue);
			ex1.setBounds(30, 30, 120, 20);
			ex1.setFont(new Font("Comic Sans", Font.ITALIC, 16));
			show.setBounds(200, 50, 90, 20);
			show.setFont(new Font("Comic Sans", Font.BOLD, 12));
			show.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					super.mouseClicked(e);
					countClick++;
					content.setText("");
					content.append("Number of Clicks " + countClick + "\n");
					switch (e.getButton()) {
						case 1 -> content.append("You clicked Left Click on mouse.\n");
						case 3 -> content.append("You clicked Right Click on mouse.\n");
					}
	              }
            });

			show.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					super.keyPressed(e);
					content.setText("");
					content.append("key pressed " + e.getKeyChar());
				}
			});
			show.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					super.mouseMoved(e);

					positionOFMouse.setText("pos (" + e.getX() + " X  " + e.getY() + " Y)");
				}
			});
			content.setBounds(110, 100, 250, 130);
			content.setBackground(new Color(245, 245, 245));
			content.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					super.mouseMoved(e);
					positionOFMouse.setText("pos ("+e.getX() + " X  " + e.getY() + " Y)");
				}
			});
			
		}
}
