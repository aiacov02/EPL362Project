package com.team5.epl362.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.Management;

import java.awt.BorderLayout;
import java.awt.List;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui {

	JFrame frame;
	private JTable table;
	public Management management;
	
	int myClinic=0;
	
	public gui(Management management, int MyClinic) {
		this.management = management;
		this.myClinic = MyClinic;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 703, 435);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Clinic 1", "Clinic 2", "Clinic 3", "Clinic 4"}));
		comboBox.setBounds(32, 32, 69, 20);
		frame.getContentPane().add(comboBox);
		
		
		
		JLabel lblE = new JLabel("E\u03B2\u03B4\u03BF\u03BC\u03B1\u03B4\u03B9\u03B1\u03AF\u03B1 \u0391\u03BD\u03B1\u03C6\u03BF\u03C1\u03AC");
		lblE.setBounds(32, 11, 127, 23);
		frame.getContentPane().add(lblE);
		
		JLabel label = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03BF2");
		label.setBounds(321, 277, 69, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03BF3");
		label_1.setBounds(321, 302, 69, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03BF4");
		label_2.setBounds(321, 327, 69, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03BF1");
		label_3.setBounds(321, 252, 69, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u03A6\u03AC\u03C1\u03BC\u03B1\u03BA\u03BF5");
		label_4.setBounds(321, 361, 69, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u0394\u03B9\u03C0\u03BF\u03BB\u03B9\u03BA\u03AE \u0394\u03B9\u03B1\u03C4\u03B1\u03C1\u03B1\u03C7\u03AE");
		label_5.setBounds(32, 252, 69, 14);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u03A3\u03C7\u03B9\u03B6\u03BF\u03C6\u03C1\u03AD\u03BD\u03B5\u03B9\u03B1");
		label_6.setBounds(32, 277, 69, 14);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u0391\u03B3\u03C7\u03CE\u03B4\u03B7\u03C2 \u0394\u03B9\u03B1\u03C4\u03B1\u03C1\u03B1\u03C7\u03AE");
		label_7.setBounds(32, 302, 69, 14);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u0391\u03CB\u03C0\u03BD\u03AF\u03B1");
		label_8.setBounds(32, 331, 69, 14);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u039A\u03B1\u03C4\u03AC\u03B8\u03BB\u03B9\u03C8\u03B7");
		label_9.setBounds(32, 361, 69, 14);
		frame.getContentPane().add(label_9);
		
		
		int patientsPerDay[] = new int[5];
		int conditions[] = new int[5];
		int Drugs[] = new int[5];
		int Allpatients[] = new int[1];
		
		management.CalculateStatistics(patientsPerDay, conditions, Drugs, Allpatients, myClinic);
		
		
		System.out.println(Drugs[3]);
		
		Object[][] patients = new Object[1][5];
		
		for(int i=0; i<5; i++){
			patients[0][i] = patientsPerDay[i];
		}
		
		String[] columns = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday"};
		
//		table = new JTable();
//		table.setModel(new DefaultTableModel(patients,columns));
		
		JButton btnNewButton = new JButton("\u0395\u03BD\u03B7\u03BC\u03AD\u03C1\u03C9\u03C3\u03B7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int clinic=0;
				String myString = comboBox.getSelectedItem().toString();
				if(myString.equals("Clinic 1")){
					
					clinic=1;
				}
				else if(myString.equals("Clinic 2")) clinic=2;
				else if(myString.equals("Clinic 3")) clinic=3;
				else if(myString.equals("Clinic 4")) clinic =4;
				
				frame.setVisible(false);
				gui g = new gui(management, clinic);
				g.frame.setVisible(true);
			}
			
		});
		btnNewButton.setBounds(116, 31, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 65, 562, 63);
		frame.getContentPane().add(scrollPane);
		table = new JTable(patients,columns);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(134, 252, 81, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setBounds(134, 277, 81, 14);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setBounds(134, 302, 71, 14);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setBounds(134, 331, 71, 14);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setBounds(134, 361, 71, 14);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("New label");
		label_14.setBounds(427, 252, 66, 14);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("New label");
		label_15.setBounds(427, 277, 66, 14);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("New label");
		label_16.setBounds(427, 302, 66, 14);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel("New label");
		label_17.setBounds(427, 331, 66, 14);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("New label");
		label_18.setBounds(427, 361, 66, 14);
		frame.getContentPane().add(label_18);
		
		JLabel lblNewLabel_1 = new JLabel("\u0391\u03C3\u03B8\u03B5\u03BD\u03B5\u03AF\u03C2");
		lblNewLabel_1.setBounds(17, 88, 67, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u03A3\u03C5\u03BD\u03BF\u03BB\u03B9\u03BA\u03CC\u03C2 \u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD");
		lblNewLabel_2.setBounds(321, 32, 172, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(517, 35, 89, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_3.setText(Allpatients[0]+"");
		
		lblNewLabel.setText(conditions[0]+"");
		label_10.setText(conditions[1]+"");
		label_11.setText(conditions[2]+"");
		label_12.setText(conditions[3]+"");
		label_13.setText(conditions[4]+"");
		
		label_14.setText(Drugs[0]+"");
		label_15.setText(Drugs[1]+"");
		label_16.setText(Drugs[2]+"");
		label_17.setText(Drugs[3]+"");
		label_18.setText(Drugs[4]+"");

		
		


		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainManagement m = new MainManagement(management);
				m.frame.setVisible(true);
			}
		});
		btnBack.setBounds(559, 327, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
