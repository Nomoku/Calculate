package com.newer.Calculate;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CalView extends JFrame {

	JButton btn1, btn2;
	JButton[] buttons;
	JLabel label;
	JPanel panel1;
	JPanel panel2;
	String output = "0";
	Callback callback;

	public void setCallback(Callback callback) {
		this.callback = callback;
	}

	protected CalView() throws HeadlessException {
		// TODO Auto-generated constructor stub
		super();
		setTitle("¼ÆËãÆ÷DEMO");
		setSize(800, 600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		initView();
		setVisible(true);

	}

	private void initView() {

		label = new JLabel(output);
		btn1 = new JButton("ce");
		btn2 = new JButton("del");
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(4, 4));
		panel2.setLayout(new GridLayout(1,3));

		buttons = new JButton[16];
		String[] bn ={"1","2","3","/","4","5","6","*","7","8","9","-",".","0","+","="};
		// String [][] bn ={{"ce","c","del","/"},{"1","2","3","*"},{"4","5","6","-"},{"7","8","9","+"},{"+/-","0",".","="}};
		bListener blistener = new bListener();
		for (int i = 0; i < bn.length; i++) {
			buttons[i] = new JButton(bn[i]);
			buttons[i].setPreferredSize(new Dimension(25, 25));
			panel1.add(buttons[i]);
			buttons[i].addActionListener(blistener);
			buttons[i].setActionCommand(buttons[i].getText());
//			System.out.println(buttons[i].getActionCommand());
		}
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i] = new JButton(String.valueOf(i));
//			panel1.add(buttons[i]);
//		}
//
//		int[] numarr = { 0, 1, 2, 4, 5, 6, 8, 9, 10 };
//		for (int i = 0; i < numarr.length; i++) {
//			buttons[numarr[i]].setText(String.valueOf(i + 1));
//		}
//
//		buttons[3].setText("/");
//		buttons[7].setText("*");
//		buttons[13].setText("0");
//		buttons[11].setText("-");
//		buttons[12].setText(".");
//		buttons[14].setText("+");
//		buttons[15].setText("=");
//
//		bListener blistener = new bListener();
//		for (int i = 0; i < buttons.length; i++) {
//			buttons[i].addActionListener(blistener);
//			buttons[i].setActionCommand(buttons[i].getText());
//			// System.out.println(buttons[i].getActionCommand());
//		}

		btn1.addActionListener(blistener);
		btn2.addActionListener(blistener);
		btn1.setActionCommand(btn1.getText());
		btn2.setActionCommand(btn2.getText());

		panel2.add(btn1);		
		panel2.add(label);
		panel2.add(btn2);
		getContentPane().add(panel1, BorderLayout.CENTER);
		getContentPane().add(panel2, BorderLayout.NORTH);

	}

	class bListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "+":
				output = output.concat("+");
				break;
			case "-":
				output = output.concat("-");
				break;
			case "*":
				output = output.concat("*");
				break;
			case "/":
				output = output.concat("/");
				break;
			case ".":
				output = output.concat(".");
				break;
			case "ce":
				output = "0";
				break;
			case "del":
				if(output==null) {
					output="0";
					break;
				}
				output = output.substring(0, output.length() - 1);
				break;
			case "=":
				output = output.concat("=");
				output = output+callback.setString(output);
				break;
			default:
				break;
			}
			switch (e.getActionCommand()) {
			case "0":
				if (output == "0")
					break;
				else {
					output += "0";
					break;
				}
			case "1":
				if (output == "0") {
					output = "1";
					break;
				} else {
					output += "1";
					break;
				}
			case "2":
				if (output == "0") {
					output = "2";
					break;
				} else {
					output += "2";
					break;
				}

			case "3":
				if (output == "0") {
					output = "3";
					break;
				} else {
					output += "3";
					break;
				}
			case "4":
				if (output == "0") {
					output = "4";
					break;
				} else {
					output += "4";
					break;
				}
			case "5":
				if (output == "0") {
					output = "5";
					break;
				} else {
					output += "5";
					break;
				}
			case "6":
				if (output == "0") {
					output = "6";
					break;
				} else {
					output += "6";
					break;
				}
			case "7":
				if (output == "0") {
					output = "7";
					break;
				} else {
					output += "7";
					break;
				}
			case "8":
				if (output == "0") {
					output = "8";
					break;
				} else {
					output += "8";
					break;
				}
			case "9":
				if (output == "0") {
					output = "9";
					break;
				} else {
					output += "9";
					break;
				}
			default:
				break;
			}

			label.setText(output);

		}

	}

	public interface Callback {

		BigDecimal setString(String s);

	}

}
