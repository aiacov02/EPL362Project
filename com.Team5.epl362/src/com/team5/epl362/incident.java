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

public class incident {

	 JFrame frame;
	 private JTable table;
	 private JTable table_1;
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
	public incident(ClinicalStaff clinicalstaff) {
		this.clinicalstaff = clinicalstaff;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Περιστατικά");
		frame.setBounds(200, 200, 650, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Περιστατικά");
		
		JLabel lblNewLabel_1 = new JLabel("Ατυχή Περιστατικά");
		
		JButton button = new JButton("Προσθήκη Περιστατικού");
		ButtonGroup bg =new ButtonGroup();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
                 
                frame.setVisible(false);
				addincident windoww = new addincident(clinicalstaff);
				windoww.frame.setVisible(true);	
					
			
			}
		});
		
		JButton button_1 = new JButton("Πίσω");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frame.setVisible(false);
					number1 windoww = new number1(clinicalstaff);
					windoww.frame.setVisible(true);	
				
				
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JButton button_2 = new JButton("Προσθήκη Ατυχούς Περιστατικού");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				addaccincident windoww = new addaccincident(clinicalstaff);
				windoww.frame.setVisible(true);	
			}
		});
		
		
		
		

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(button_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_2))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addComponent(button_1)
					.addContainerGap())
		);
		
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		String columns[] = null;
		String columns1[] = null;
		columns = new String[] { "IncidentID", "PatientID", "IncidentDate", "Description","DrugName" };
		ArrayList<Object[]> Q = new ArrayList<Object[]>();

		clinicalstaff.getAccidents(Q);
		rowData = new Object[Q.size()][5];

		for (int i = 0; i < Q.size(); i++) {
			// System.out.println(Q.get(0).toString());
			rowData[i] = Q.get(i);
		}
		
		
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(rowData,columns));
		scrollPane_1.setViewportView(table_1);
		
		Object rowData1[][] = null; //{{1,1,1,1,1,1,1}};
		columns1 = new String[] { "IncidentID", "PatientID", "IncidentDate", "Description"};
		ArrayList<Object[]> Queue = new ArrayList<Object[]>();

		clinicalstaff.getIncidents(Queue);
		rowData1 = new Object[Queue.size()][5];

		for (int i = 0; i < Queue.size(); i++) {
			// System.out.println(Q.get(0).toString());
			rowData1[i] = Queue.get(i);
		}
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(rowData1,columns1));//rowData1,columns1));
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
	}
}
