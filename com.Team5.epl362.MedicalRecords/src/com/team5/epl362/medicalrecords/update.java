package com.team5.epl362.medicalrecords;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javaworld.sample.helloservice.MedicalRecords;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class update {

	 JFrame frame;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JLabel lblNewLabel_7;
	 private JTextField textField_2;
	 
	 private MedicalRecords medicalrecords;
	 private JTextField textField_5;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					number2 window = new number2();
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
	public update(MedicalRecords medicalrecords) {
		this.medicalrecords = medicalrecords;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 650, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1");
		
		JLabel lblNewLabel_1 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		
		JLabel lblNewLabel_2 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0393\u03AD\u03BD\u03BD\u03B7\u03C3\u03B7\u03C2");
		
		JLabel lblNewLabel_3 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7");
		
		JLabel lblNewLabel_4 = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblNewLabel_7 = new JLabel("\u03A6\u03CD\u03BB\u03BF");
		
		JButton button = new JButton("Ενημέρωση");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Άρρεν");		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Θύλη");
		ButtonGroup bg =new ButtonGroup();	
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(textField.getText());
				System.out.println(textField_1.getText());
				System.out.println(textField_2.getText());
				System.out.println(textField_3.getText());
				System.out.println(textField_4.getText());
				rdbtnNewRadioButton.setActionCommand("m");
				rdbtnNewRadioButton_1.setActionCommand("f");
				
				try{
                System.out.println(bg.getSelection().getActionCommand());
				}
				 catch (Exception e){
					 JOptionPane.showMessageDialog (null, "Δώστε φύλο", "Title", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				//Code for record change here
				boolean isAlive = medicalrecords.updateRecord(Integer.parseInt(textField_5.getText()), textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), textField_4.getText(), bg.getSelection().getActionCommand());
				if(!isAlive){
					JOptionPane.showMessageDialog (null, "Ο ασθενής είναι νεκρός", "Title", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
	                JOptionPane.showMessageDialog (null, "Ο ασθενής Ενημερώθηκε", "Title", JOptionPane.INFORMATION_MESSAGE);
	                frame.setVisible(false);
					hj windoww = new hj(medicalrecords);
					windoww.frame.setVisible(true);	
						
				}
				
                
			
			}
		});
		
		
		
		JButton button_1 = new JButton("Πίσω");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frame.setVisible(false);
					hj windoww = new hj(medicalrecords);
					windoww.frame.setVisible(true);	
				
				
			}
		});
		
		
		
		JLabel lblId = new JLabel("ID Ασθενή");
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_7)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel)
										.addComponent(lblId))))
							.addGap(90))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)
							.addGap(51)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(button)
						.addComponent(rdbtnNewRadioButton))
					.addContainerGap(342, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(lblNewLabel_7))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rdbtnNewRadioButton_1)
					.addGap(103)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
