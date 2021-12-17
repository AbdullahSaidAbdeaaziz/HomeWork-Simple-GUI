package com.Abdullah;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Sheet7 extends JFrame  {

	private JLabel x = new JLabel("Enter X");
	private JLabel y = new JLabel("Enter Y");
	private JLabel Result = new JLabel("Result");
	private JTextField forX = new JTextField();
	private JTextField forY = new JTextField();
	private JTextField forResult = new JTextField();
	private JButton[] operations = new JButton[4];
	private JLabel ex1 = new JLabel("Exercise 1");

	private JLabel x2 = new JLabel("Enter X");
	private JLabel y2 = new JLabel("Enter Y");
	private JTextField forX2 = new JTextField();
	private JTextField forY2 = new JTextField();
	private JRadioButton[] operations2 = new JRadioButton[4];
	private JButton calculate = new JButton("Calculate");
	private JLabel Result2 = new JLabel("Result");
	private JTextField forResult2 = new JTextField();
	private JLabel ex2 = new JLabel("Exercise 2");

	private JLabel name = new JLabel("Name");
	private JLabel age = new JLabel("Age");
	private JTextField forName = new JTextField();
	private JTextField forAge = new JTextField();
	private JButton save = new JButton("Save");
	private JButton del = new JButton("Delete");
	private JButton search = new JButton("Search");
	private JButton show = new JButton("Show");
	private JTextArea datas = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(datas);
	private ArrayList<Student> students = new ArrayList<>();
	private JLabel ex3AndHomework = new JLabel("Exercise 3 And HomeWork");
	private JButton back = new JButton("Back");

	Sheet7() {
		Design1();
		Design2();
		Design3();
		this.add(back);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 1000);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		this.setResizable(false);
		this.setVisible(true);
		this.setLayout(null);
		back.setBounds(350, 5, 70, 20);
		back.addActionListener( e ->{
			this.dispose();
			new MainContain();
		});
		this.add(ex1);
		this.add(x);
		this.add(y);
		this.add(Result);
		this.add(forX);
		this.add(forY);
		this.add(forResult);
		for (JButton op : operations) {
			this.add(op);
		}

		this.add(ex2);
		this.add(x2);
		this.add(y2);
		this.add(forX2);
		this.add(forY2);
		for (JRadioButton rb : operations2) {
			this.add(rb);
		}
		this.add(calculate);
		this.add(Result2);
		this.add(forResult2);

		this.add(ex3AndHomework);
		this.add(name);
		this.add(age);
		this.add(forName);
		this.add(forAge);
		this.add(save);
		this.add(del);
		this.add(search);
		this.add(show);
		this.add(datas);
		this.add(scrollPane);
		this.setTitle("Sheet 7");

	}

	private void Design3() {
		ex3AndHomework.setBounds(10, 430, 240, 50);
//		ex3AndHomework.setLocation(10,430);
		ex3AndHomework.setForeground(Color.BLUE);
		ex3AndHomework.setFont(new Font("Comic Sans", Font.HANGING_BASELINE, 16));

		name.setBounds(30, 450, 50, 100);
		age.setBounds(30, 490, 50, 100);
		forName.setBounds(270, 490, 140, 20);
		forAge.setBounds(270, 530, 140, 20);
		save.setBounds(440, 490, 70, 20);
		save.setFont(new Font("Comic Sans", Font.BOLD, 10));
		save.addActionListener(e -> {
			if (forName.getText().equals("") & forAge.getText().equals("")) {
//				forName.setText("Enter Name!");
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Name and Age" , "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else if (!isAge(forAge.getText())) {
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Age (Number plz)!" , "title", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (forName.getText().equals("")) {
//				forName.setText("Enter Name!");
				JOptionPane.showMessageDialog(null, "Enter Name!" , "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			Student student = new Student();
			student.setName(forName.getText());
			student.setAge(forAge.getText());
			students.add(student);
			forAge.setText("");
			forName.setText("");
		});

		del.setBounds(440, 520, 70, 20);
		del.setFont(new Font("Comic Sans", Font.BOLD, 10));
		del.addActionListener(e -> {
			boolean check = false;
			if (forName.getText().equals("") & forAge.getText().equals("")) {
//				forName.setText("Enter Name!");
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Name and Age" , "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else if (!isAge(forAge.getText())) {
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Age (Number plz)!" , "title", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (forName.getText().equals("")) {
//				forName.setText("Enter Name!");
				JOptionPane.showMessageDialog(null, "Enter Name!", "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			for (Student s: students) {
				if (s.getAge().equals(forAge.getText()) &
				    s.getName().equals(forName.getText())) {
					students.remove(s);
//					datas.setText("deleted!");
					JOptionPane.showMessageDialog(null,"Deleted", "title",JOptionPane.INFORMATION_MESSAGE);
					check = true;
					break;
				}
			}
			if (!check) { //datas.setText("not Exist!");
				JOptionPane.showMessageDialog(null,"Not Exist", "title",JOptionPane.INFORMATION_MESSAGE);
				 }
			forAge.setText("");
			forName.setText("");
		});

		search.setBounds(440, 550, 70, 20);
		search.setFont(new Font("Comic Sans", Font.BOLD, 10));
		search.addActionListener(e ->{
			boolean check = false;
			if (forName.getText().equals("") & forAge.getText().equals("")) {
//				forName.setText("Enter Name!");
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Name and Age" , "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			else if (!isAge(forAge.getText())) {
//				forAge.setText("Enter Age!");
				JOptionPane.showMessageDialog(null, "Enter Age (Number plz)!" , "title", JOptionPane.ERROR_MESSAGE);
				return;
			}
			else if (forName.getText().equals("")) {
//				forName.setText("Enter Name!");
				JOptionPane.showMessageDialog(null, "Enter Name!" , "title", JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			for (Student s: students) {
				if (s.getAge().equals(forAge.getText()) &
				    s.getName().equals(forName.getText())) {
					JOptionPane.showMessageDialog(null, "Founded" , "title", JOptionPane.PLAIN_MESSAGE);
					datas.setText(String.format("Name %10s      Age %10s\n",s.getName(), s.getAge()));
					check = true;
					break;
				}
			}
			if (!check) {
//				datas.setText("Not Found");
				JOptionPane.showMessageDialog(null, "Not Found", "title", JOptionPane.INFORMATION_MESSAGE);
			}
			forAge.setText("");
			forName.setText("");
		});

		show.setBounds(20, 600, 70, 20);
		show.setFont(new Font("Comic Sans", Font.BOLD, 10));
		show.addActionListener(e -> {
			datas.setText("");
			for (Student s : students) {
				datas.append(String.format("Name %10s      Age %10s\n",s.getName(), s.getAge()));
			}
		});

		datas.setBounds(200, 600, 350, 300);
		datas.setFont(new Font("Comic Sans", Font.BOLD, 13));
		datas.setBackground(new Color(70, 195, 219));

	}

	public void Design1() {
		ex1.setBounds(10, 10, 120, 50);
		ex1.setFont(new Font("Comic Sans", Font.HANGING_BASELINE, 16));
		x.setBounds(30, 30, 50, 100);
		y.setBounds(30, 70, 50, 100);
		forX.setBounds(270, 70, 140, 20);
		forY.setBounds(270, 110, 140, 20);

		operations[0] = new JButton(" + ");
		operations[0].addActionListener(e -> {
			if (!isInteger(forX.getText(), forY.getText())) {
				JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
				return;
			}
			forResult.setText(new StringBuilder().append( Double.parseDouble(forX.getText()) + Double.parseDouble(forY.getText())).append("").toString());
		});

		operations[1] = new JButton("-");
		operations[1].addActionListener(e -> {
			if (!isInteger(forX.getText(), forY.getText())) {
				JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
				return;
			}
			forResult.setText(new StringBuilder().append( Double.parseDouble(forX.getText()) - Double.parseDouble(forY.getText())).append("").toString());
		});
		operations[2] = new JButton("*");
		operations[2].addActionListener(e -> {
			if (!isInteger(forX.getText(), forY.getText())) {
				JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
				return;
			}
			forResult.setText(new StringBuilder().append( Double.parseDouble(forX.getText()) * Double.parseDouble(forY.getText())).append("").toString());
		});
		operations[3] = new JButton("/");
		operations[3].addActionListener(e -> {
			if (!isInteger(forX.getText(), forY.getText())) {
				JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
				return;
			} else if (forY.getText().equals("0")) {
//				forResult.setText("divide by zero!");
				JOptionPane.showMessageDialog(null, "Divide by Zero", "title", JOptionPane.WARNING_MESSAGE);
				return;
			}
			forResult.setText(new StringBuilder().append(Double.parseDouble(forX.getText()) / Double.parseDouble(forY.getText())).append("").toString());
		});
		for (int i = 0; i < 4; i++) {
			operations[i].setBackground(Color.WHITE);
			operations[i].setBorder(BorderFactory.createEtchedBorder());
			operations[i].setFont(new Font("Comic Sans", Font.BOLD, 10));
			operations[i].setBounds(70 + 100 * i, 150, 30, 20);
		}
		Result.setBounds(30, 190, 100, 20);
		forResult.setBounds(270, 190, 140, 20);

	}
	private boolean isAge(String age) {
		if (age.equals("") | !age.matches("[1-9]*")) {
			return false;
		}
		return true;
	}
	private boolean isInteger(String x, String y) {
		if (x.equals("") | y.equals("") | !x.matches("^[0-9]*(.)?[0-9]*") | !y.matches("^[0-9]*(.)?[0-9]*")) { // range (0 to 9)........and if there . or not and if there . range(0 to 9).......
			return false;
		}
		return true;
	}

	public void Design2() {
		AtomicReference<Character> op = new AtomicReference<>('N');
		ex2.setBounds(10, 200, 120, 50);
		ex2.setForeground(Color.red);
		ex2.setFont(new Font("Comic Sans", Font.HANGING_BASELINE, 16));
		x2.setBounds(30, 220, 50, 100);
		y2.setBounds(30, 260, 50, 100);
		forX2.setBounds(270, 260, 140, 20);
		forY2.setBounds(270, 300, 140, 20);
		operations2[0] = new JRadioButton("+");
		operations2[0].addActionListener(e -> {
			op.set('+');
		});
		operations2[1] = new JRadioButton("-");
		operations2[1].addActionListener(e -> {
			op.set('-');
		});
		operations2[2] = new JRadioButton("*");
		operations2[2].addActionListener(e ->{
			op.set('*');
		});
		operations2[3] = new JRadioButton("/");
		operations2[3].addActionListener(e->{
			op.set('/');
		});

		for (int i = 0; i < 4; i++) {
			operations2[i].setBackground(Color.LIGHT_GRAY);
			operations2[i].setFont(new Font("Comic Sans", Font.BOLD, 11));
			operations2[i].setBounds(70 + 100 * i, 350, 40, 20);
		}
		ButtonGroup group = new ButtonGroup();
		for(JRadioButton rb : operations2) {
			group.add(rb);
		}

		calculate.setBounds(170, 380, 90, 30);
		calculate.setBorder(BorderFactory.createEtchedBorder());
		calculate.setBackground(Color.LIGHT_GRAY);
		calculate.addActionListener(e -> {
			switch (op.get()) {
				case '+' -> {
					if (!isInteger(forX2.getText(), forY2.getText())) {
						JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
						return;
					}
					forResult2.setText(new StringBuilder().append( Double.parseDouble(forX2.getText()) + Double.parseDouble(forY2.getText())).append("").toString());
				}
				case '-' -> {
					if (!isInteger(forX2.getText(), forY2.getText())) {
						JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
						return;
					}
					forResult2.setText(new StringBuilder().append( Double.parseDouble(forX2.getText()) - Double.parseDouble(forY2.getText())).append("").toString());
				}
				case '*' -> {
					if (!isInteger(forX2.getText(), forY2.getText())) {
						JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
						return;
					}
					forResult2.setText(new StringBuilder().append( Double.parseDouble(forX2.getText()) * Double.parseDouble(forY2.getText())).append("").toString());
				}
				case '/' -> {
					if (!isInteger(forX2.getText(), forY2.getText())) {
						JOptionPane.showMessageDialog(null, "Plz Enter Number!", "title",JOptionPane.ERROR_MESSAGE);
						return;
					} else if (forY2.getText().equals("0")) {
//						forResult2.setText("divide by zero!");
						JOptionPane.showMessageDialog(null, "Divide by Zero!", "title", JOptionPane.WARNING_MESSAGE);
						return;
					}
					forResult2.setText(new StringBuilder().append( Double.parseDouble(forX2.getText()) / Double.parseDouble(forY2.getText())).append("").toString());
				}
				default -> {JOptionPane.showMessageDialog(null, "Invalid Operation " + op.get(), "title", JOptionPane.ERROR_MESSAGE);}
			}
		});
		Result2.setBounds(30, 420, 100, 20);
		forResult2.setBounds(270, 420, 140, 20);
	}

}
