package com.Abdullah;

import javax.swing.*;
import java.awt.*;
final class MainContain extends JFrame{
	private final int screenHeight = 600;
	private final int screenWidth = 600;
	private final JButton sheet7 = new JButton("Sheet 7");
	private final JButton sheet8 = new JButton("Sheet 8");

	public MainContain() {
		sheet7.addActionListener(e -> {
			this.dispose();
			new Sheet7();
		});
		sheet8.addActionListener(e -> {
			this.dispose();
			new Sheet8();
		});
		this.setTitle("SHEETS");
		JLabel information = new JLabel(String.format("%10s %50s","Department : CS","Name : Abdullah Said Abdeaaziz"));
		information.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		JLabel h = new JLabel("WELCOME");
		h.setFont(new Font("", Font.BOLD, 20));
		h.setForeground(Color.BLACK);
		JPanel hi = new JPanel();
		hi.setBackground(Color.ORANGE);
		hi.add(h);
		this.setLayout(new BorderLayout(20,450 / 2));
		this.add(information,BorderLayout.SOUTH);
		this.add(sheet7, BorderLayout.WEST);
		this.add(sheet8, BorderLayout.EAST);
		this.add(hi, BorderLayout.NORTH);
		this.getContentPane().setBackground(Color.ORANGE);
		this.setSize(screenHeight,screenWidth);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
