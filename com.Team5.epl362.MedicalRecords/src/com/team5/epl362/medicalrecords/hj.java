package com.team5.epl362.medicalrecords;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

import com.javaworld.sample.helloservice.MedicalRecords;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class hj {

	 JFrame frame;
	 private MedicalRecords medicalrecords;

	

	/**
	 * Create the application.
	 */
	public hj(MedicalRecords medicalrecords) {
		this.medicalrecords = medicalrecords;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Ενημέρωση Ασθενή");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update x=new update(medicalrecords);
				x.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		JButton btnLog = new JButton("log");
		btnLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logf x=new logf(medicalrecords);
				x.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLog)
						.addComponent(button))
					.addContainerGap(286, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(button)
					.addGap(40)
					.addComponent(btnLog)
					.addContainerGap(152, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
