package com.team5.epl362;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.ClinicalStaff;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class allergies {

	 JFrame frame;
	 private JTable table;
	 private JTextField textField;
	 private ClinicalStaff clinicalstaff;

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
	public allergies(ClinicalStaff clinicalstaff) {
		this.clinicalstaff = clinicalstaff;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Αλλεργίες");
		frame.setBounds(200, 200, 650, 505);
		frame.setDefaultCloseOperation(1);
		ButtonGroup bg =new ButtonGroup();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel = new JLabel("ID Ασθενή:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Φάρμακο1", "Φάρμακο2", "Φάρμακο3", "Φάρμακο4", "Φάρμακο5"}));
		
		JLabel label = new JLabel("Προσθήκη Αλλεργίας");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		
		JLabel label_1 = new JLabel("Φάρμακο:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Καταχώρηση");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clinicalstaff.addAllergy(Integer.parseInt(textField.getText()), comboBox.getSelectedItem().toString());
				 JOptionPane.showMessageDialog (null, "Η αλλεργία προστέθηκε!", "Title", JOptionPane.INFORMATION_MESSAGE);
	                frame.setVisible(false);
					allergies windoww = new allergies(clinicalstaff);
					windoww.frame.setVisible(true);	
			}
		});
		
		JButton button = new JButton("Πίσω");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
				diagnosis windoww = new diagnosis(clinicalstaff);
				windoww.frame.setVisible(true);	
			}
		});
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnNewButton)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(button))))
					.addGap(59))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(30)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		
		
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		String columns[] = null;
		columns = new String[] { "ID", "Allergy"};
		ArrayList<Object[]> Q = new ArrayList<Object[]>();

		clinicalstaff.getAllergies(Q);
		rowData = new Object[Q.size()][2];

		for (int i = 0; i < Q.size(); i++) {
			// System.out.println(Q.get(0).toString());
			rowData[i] = Q.get(i);
		}
		
		table = new JTable();
		table.setModel(new DefaultTableModel(rowData,columns));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
