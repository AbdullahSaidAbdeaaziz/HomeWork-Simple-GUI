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
				positionOFMouse.setText(String.valueOf("pos ("+e.getX()) + " X  " + e.getY() + " Y)");
			}
		});
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

					positionOFMouse.setText(String.valueOf("pos ("+e.getX()) + " X  " + e.getY() + " Y)");
				}
			});
			content.setBounds(110, 100, 250, 130);
			content.setBackground(new Color(245, 245, 245));
			content.addMouseMotionListener(new MouseAdapter() {
				@Override
				public void mouseMoved(MouseEvent e) {
					super.mouseMoved(e);
					positionOFMouse.setText(String.valueOf("pos ("+e.getX()) + " X  " + e.getY() + " Y)");
				}
			});
			content.addMouseWheelListener(new MouseWheelListener() {
				@Override
				public void mouseWheelMoved(MouseWheelEvent e) {

				}
			});
		}
}
