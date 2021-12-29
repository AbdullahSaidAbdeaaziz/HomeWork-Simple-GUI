package com.Abdullah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class mPanel  extends JPanel {
	enum Drawshapes {
		NONE,
		LINE,
		SQUARE,
		CIRCLE
	}

	public void setSelectedColor(Color selectedColor) {
		this.selectedColor = selectedColor;
	}

	public void setShapes(Drawshapes shapes) {
		this.shapes = shapes;
	}

	Color selectedColor  = new Color(244, 244, 244);
	Drawshapes shapes = Drawshapes.NONE;
	Point begin = new Point(0, 0);
	Point end = new Point(0, 0);
	mPanel() {
		this.setBackground(Color.WHITE);
		this.setBounds(250, 500, 500 , 250);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				begin = new Point(e.getX(), e.getY());

			}
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mousePressed(e);
				end = new Point(e.getX(), e.getY());
				repaint();
			}
		});
	}
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		Graphics2D shape = (Graphics2D) g;
		switch (shapes) {
			case LINE -> {
				shape.setColor(selectedColor);
				shape.setStroke(new BasicStroke(5));
				shape.drawLine(begin.x, begin.y, end.x, end.y);
			}
			case SQUARE -> {
				shape.setColor(selectedColor);
				shape.setStroke(new BasicStroke(5));
				shape.drawRect(begin.x, begin.y, 80, 80);
			}
			case CIRCLE -> {
				shape.setColor(selectedColor);
				shape.setStroke(new BasicStroke(5));
				shape.drawOval(begin.x, begin.y, 80, 80);
			}
		}
	}
}
