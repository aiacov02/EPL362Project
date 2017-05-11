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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.ClinicalStaff;

public class drugsinfo {

	 JFrame frame;
	 private JTable table;
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
	public drugsinfo(ClinicalStaff clinicalstaff) {
		this.clinicalstaff = clinicalstaff;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Παρενέργιες Φαρμάκων");
		frame.setBounds(200, 200, 650, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonGroup bg =new ButtonGroup();
		
		JButton button_1 = new JButton("Πίσω");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frame.setVisible(false);
//					diagnosis windoww = new diagnosis();
//					windoww.frame.setVisible(true);	     
//				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(button_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(110)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(75)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
			String columns[] = null;
			columns = new String[] { "Drug Name", "Side Effect"};
			ArrayList<Object[]> Q = new ArrayList<Object[]>();

			clinicalstaff.viewDrugs(Q);
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
