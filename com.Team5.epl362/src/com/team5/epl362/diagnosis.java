package com.team5.epl362;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.ClinicalStaff;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class diagnosis {

	JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private ClinicalStaff clinicalstaff;

	
	/**
	 * Create the application.
	 */
	public diagnosis(ClinicalStaff clinicalstaff){
		this.clinicalstaff = clinicalstaff;
		initialize();
	}
	
	/**
	 * Launch the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Διάγνωσεις");
		frame.setBounds(100, 100, 1048, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox comboBox = new JComboBox();
		comboBox.setSelectedItem("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Υγιής", "Διπολική Διαταραχή", "Σχιζοφρένια",
				"Αγχώδεις Διαταραχή", "Αϋπνία", "Κατάθλιψη" }));

		JLabel label = new JLabel("ID Γιατρού");

		JLabel label_1 = new JLabel("ID Ασθενή");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Κανένα", "Φάρμακο1", "Φάρμακο2", "Φάρμακο3", "Φάρμακο4", "Φάρμακο5"}));

		JButton btnBack = new JButton("Πίσω");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				number1 windoww = new number1(clinicalstaff);
				windoww.frame.setVisible(true);
			}
		});

		JButton button_2 = new JButton("Ανανέωση Λίστας");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				diagnosis windoww = new diagnosis(clinicalstaff);
				windoww.frame.setVisible(true);
			}
		});

		JButton btnNewButton = new JButton("Ανανέωση Διάγνωσης");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean dia = clinicalstaff.isDiagnosisTheSame(comboBox.getSelectedItem().toString(),Integer.parseInt(textField_1.getText()));

				if (dia == true) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Η διάγνωση είναι η ίδια!συνέχεια?","Warning",dialogButton);
					if(dialogResult == JOptionPane.NO_OPTION){
					  return;
					}
				}
				clinicalstaff.changeDiagnosis(comboBox.getSelectedItem().toString(),Integer.parseInt(textField_1.getText()));
			}
		});

		JButton btnNewButton_1 = new JButton("Ανανέωση Συνταγής");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				boolean allergia = clinicalstaff.isAllergic(Integer.parseInt(textField_1.getText()), comboBox_1.getSelectedItem().toString());
				
				if (allergia == true) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Ο Ασθενής είναι αλλεργικός σε αυτό το φάρμακο!συνέχεια?","Warning",dialogButton);
					if(dialogResult == JOptionPane.NO_OPTION){
					  return;
					}
					
					
					
					
				}
				
				boolean sint = clinicalstaff.isPrescriptionTheSame(comboBox_1.getSelectedItem().toString(),Integer.parseInt(textField_1.getText()));
				
				if (sint == true) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "Η συνταγή είναι η ίδια!συνέχεια?","Warning",dialogButton);
					if(dialogResult == JOptionPane.NO_OPTION){
					  return;
					}
				}
				
				clinicalstaff.changePrescription(comboBox_1.getSelectedItem().toString(),Integer.parseInt(textField_1.getText()));
			}
		});

		

		JButton btnNewButton_2 = new JButton("Ανανέωση Αγρότερα");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clinicalstaff.updateLater(Integer.parseInt(textField_1.getText()));
			}
		});

		JButton btnNewButton_3 = new JButton("Παρενέργιες Φαρμάκων");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				drugsinfo windoww = new drugsinfo(clinicalstaff);
				windoww.frame.setVisible(true);

			}
		});
		
		JButton btnNewButton_4 = new JButton("Αλλεργίες");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
	                frame.setVisible(false);
					allergies windoww = new allergies(clinicalstaff);
					windoww.frame.setVisible(true);	
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 859, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 171, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(comboBox_1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(395))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnBack)
										.addGap(18)
										.addComponent(btnNewButton_2)
										.addGap(18)
										.addComponent(btnNewButton_3)
										.addGap(18)
										.addComponent(btnNewButton_4)
										.addGap(135)))
								.addGap(344)))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(button_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnBack)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGap(45))
		);

		
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Name", "Surname", "DOB", "Sex", "Suicidal", "Diagnosis", "Prescription", "Needs Update","Last DropIn" };
		ArrayList<Object[]> Q = new ArrayList<Object[]>();

		clinicalstaff.getPatient(Q);
		rowData = new Object[Q.size()][10];

		for (int i = 0; i < Q.size(); i++) {
			// System.out.println(Q.get(0).toString());
			rowData[i] = Q.get(i);
		}
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(rowData,columns));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);

	}

	
}
