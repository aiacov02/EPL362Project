package com.team5.epl362.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.Management;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class patientlist {

	JFrame frame;
	private JTable table;
	public Management management;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					patientlist window = new patientlist();
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
	public patientlist(Management management) {
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
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u03A0\u03AF\u03C3\u03C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				MainManagement windoww = new MainManagement(management);
				windoww.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(34, 215, 89, 23);

		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 62, 373, 121);
		frame.getContentPane().add(scrollPane);
		
		
		 Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    String columns[] = null;
		    columns = new String[]{ "ID","Name", "Surname", "Diagnosis", "Prescription"};
		    ArrayList<Object[]> Q = new ArrayList<Object[]>();
		    
		    management.getPatient(Q);
		    rowData = new Object[Q.size()][5];
		  
		    
		    
			for(int i=0; i<Q.size(); i++){
					//System.out.println(Q.get(0).toString());
				   rowData[i] = Q.get(i);
			}
		management.getPatient(Q);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(rowData,columns));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u039B\u03AF\u03C3\u03C4\u03B1 \u0391\u03C3\u03B8\u03B5\u03BD\u03CE\u03BD");
		lblNewLabel.setBounds(167, 22, 105, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
