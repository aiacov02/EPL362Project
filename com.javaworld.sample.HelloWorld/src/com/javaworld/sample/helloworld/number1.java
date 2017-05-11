package com.javaworld.sample.helloworld;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

import com.javaworld.sample.helloservice.HelloService;
import com.team5.epl362.writetofileservice.ReceptionistFile;

public class number1 {

	public JFrame frame;
	public HelloService helloservice1;
	private ReceptionistFile receptionistFile;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					number1 window = new number1();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 * @param receptionistFile 
	 */
	public number1(HelloService helloservice1, ReceptionistFile receptionistFile) {
		this.receptionistFile = receptionistFile;
		this.helloservice1 = helloservice1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Προσθήκη Ασθενή");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				number2 windoww = new number2(helloservice1, receptionistFile);
				windoww.frame.setVisible(true);	
					

				}
		});
		
		JButton button = new JButton("Προσθήκη Ραντεβού");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				Createappointment windoww = new Createappointment(helloservice1, receptionistFile);
				windoww.frame.setVisible(true);	
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Ασθενείς");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PatientsView p = new PatientsView(helloservice1, receptionistFile);
				frame.setVisible(false);
				//p.frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Ραντεβού");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				apoint appointments = new apoint(helloservice1, receptionistFile);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(94)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_1)
						.addComponent(button))
					.addContainerGap(209, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(button)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addContainerGap(90, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
