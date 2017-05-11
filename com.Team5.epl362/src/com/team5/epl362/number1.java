package com.team5.epl362;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.javaworld.sample.helloservice.ClinicalStaff;

public class number1 {

	public JFrame frame;
	private ClinicalStaff clinicalstaff;

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
	public number1(ClinicalStaff clinicalstaff){
		this.clinicalstaff = clinicalstaff;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Clinical Staff");
		frame.setBounds(100, 100, 450, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Διαγνώσεις");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				diagnosis windoww = new diagnosis(clinicalstaff);
				windoww.frame.setVisible(true);	
					

				}
		});
		
		JButton button = new JButton("Προειδοποιητικο Μύνημα");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				 Object rowData[][] = null;			
				ArrayList<Object[]> Q = new ArrayList<Object[]>();
				clinicalstaff.getSuicidal(Q);
				rowData = new Object[Q.size()][6];

				for (int i = 0; i < Q.size(); i++) {
					// System.out.println(Q.get(0).toString());
					rowData[i] = Q.get(i);
				}
				
				
				

			    
//				for(int i=0; i<Q.size(); i++){
//						//System.out.println(Q.get(0).toString());
//					   rowData[i] = Q.get(i);
//				}
				
				
				
				try{
				    PrintWriter writer = new PrintWriter("C:\\Users\\andreas\\Documents\\JavaNew\\com.Team5.epl362\\warningletters.txt", "UTF-8");
				    writer.println("Το Προειδοποιητικο Μύνημα εχει σταλεί με επιτυχία στους πιο κάτω:");
				   
					for(int i=0; i<3; i++){
						writer.println(rowData[i][1] + " " + rowData[i][2] );
					}
				    
				    writer.close();
				} catch (IOException vil) {
				   // do something
				}
//				
//				frame.setVisible(false);
//				Createappointment windoww = new Createappointment();
//				windoww.frame.setVisible(true);	
				
                JOptionPane.showMessageDialog (null, "Τα μηνύματα εχουν σταλεί με επιτυχία!", "Title", JOptionPane.INFORMATION_MESSAGE);
                
				

			}
		});
		
		JButton btnNewButton_1 = new JButton("Περιστατικά");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	    		frame.setVisible(false);
	    		incident windoww = new incident(clinicalstaff);
	    		windoww.frame.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(273, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(btnNewButton)
					.addGap(38)
					.addComponent(button)
					.addGap(46)
					.addComponent(btnNewButton_1)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
