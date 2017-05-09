package com.javaworld.sample.helloworld;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javaworld.sample.helloservice.HelloService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class number2 {

	 JFrame frame;
	 private JTextField textField;
	 private JTextField textField_1;
	 private JTextField textField_3;
	 private JTextField textField_4;
	 private JTextField textField_5;
	 private JTextField textField_6;
	 private JLabel lblNewLabel_7;
	 private JTextField textField_2;

	 public HelloService helloservice1;
	 
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
	public number2(HelloService helloservice1) {
		this.helloservice1 = helloservice1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 650, 400);
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
		
		JLabel lblNewLabel_5 = new JLabel("\u03A4\u03B7\u03BB\u03AD\u03C6\u03C9\u03BD\u03BF \u03A3\u03C5\u03B3\u03B3\u03B5\u03BD\u03AE");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\u0394\u03B9\u03B5\u03CD\u03B8\u03C5\u03BD\u03C3\u03B7 \u03A3\u03C5\u03B3\u03B3\u03B5\u03BD\u03AE");
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		
		lblNewLabel_7 = new JLabel("\u03A6\u03CD\u03BB\u03BF");
		
		JButton button = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		
		
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
//				System.out.println(textField_5.getText());
//				System.out.println(textField_6.getText());
				rdbtnNewRadioButton.setActionCommand("m");
				rdbtnNewRadioButton_1.setActionCommand("f");
				
				try{
                System.out.println(bg.getSelection().getActionCommand());
				}
				 catch (Exception e){
					 JOptionPane.showMessageDialog (null, "Î’Î±Ï�Ï„Îµ Ï†Ï�Î»Î¿", "Title", JOptionPane.ERROR_MESSAGE);
					return;
				}
				//helloservice1.insertPatient(Name, Surname, DOB, Sex, Telephone, Address, Suicide)
				helloservice1.insertPatient(textField.getText(),textField_1.getText(),textField_2.getText(), bg.getSelection().getActionCommand(), textField_3.getText(), textField_4.getText(), true);
                
				JOptionPane.showMessageDialog (null, "Η προσθήκη έγινε με επιτυχία", "Title", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
				number1 windoww = new number1(helloservice1);
				windoww.frame.setVisible(true);	
                //PatientsView p = new PatientsView(helloservice1);
                //p.frame.setVisible(true);
					
			
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("Ακύρωση");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frame.setVisible(false);
					number1 windoww = new number1(helloservice1);
					windoww.frame.setVisible(true);	
				
				
			}
		});
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_1)
											.addComponent(lblNewLabel)
											.addComponent(lblNewLabel_5)
											.addComponent(lblNewLabel_7)
											.addComponent(lblNewLabel_6))
										.addGap(31))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblNewLabel_2)
										.addGap(21)))
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4))
							.addGap(42))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_1)
							.addGap(18)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(button)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton))
					.addContainerGap(361, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(lblNewLabel_5)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_7)
						.addComponent(rdbtnNewRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
					.addComponent(rdbtnNewRadioButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
