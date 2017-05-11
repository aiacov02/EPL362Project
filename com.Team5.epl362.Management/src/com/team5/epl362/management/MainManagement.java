package com.team5.epl362.management;



import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;


import com.javaworld.sample.helloservice.Management;

public class MainManagement {

	public JFrame frame;
	public Management management;

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
	 */
	public MainManagement(Management management) {
		this.management = management;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Προβολή λιστών management");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				gui windoww = new gui(management,1);
				windoww.frame.setVisible(true);	
					

				}
		});
		
		JButton button = new JButton("Προβολή Ασθενών");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				patientlist windoww = new patientlist(management);
				windoww.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(94)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(122)
							.addComponent(button)))
					.addContainerGap(163, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton)
					.addGap(40)
					.addComponent(button)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}

