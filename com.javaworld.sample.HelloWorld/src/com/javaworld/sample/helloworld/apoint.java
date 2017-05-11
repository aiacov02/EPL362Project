package com.javaworld.sample.helloworld;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.HelloService;
import com.team5.epl362.writetofileservice.ReceptionistFile;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class apoint {

	 JFrame frame;
	 private JTable table;
	 private JTextField textField;
	 private JTextField textField_1;
	 
	 private HelloService helloservice1;
	 private ReceptionistFile receptionistFile;

	/**
	 * Launch the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 438);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		    
		    JScrollPane scrollPane = new JScrollPane();
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		frame.setVisible(false);
		    		number1 n = new number1(helloservice1, receptionistFile);
		    		n.frame.setVisible(true);
		    	}
		    });
		    
		    JLabel lblNewLabel = new JLabel("ID");
		    
		    textField = new JTextField();
		    textField.setColumns(10);
		    
		    JLabel lblNewLabel_1 = new JLabel("YES/NO");
		    
		    textField_1 = new JTextField();
		    textField_1.setColumns(10);
		    
		    JButton button = new JButton("Καταχώρηση");
		    button.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		helloservice1.checkIfPatientWent(Integer.parseInt(textField.getText()), textField_1.getText());
		    		frame.setVisible(false);
		    		apoint ap = new apoint(helloservice1, receptionistFile);
		    	}
		    });
		    
		    JLabel lblNewLabel_2 = new JLabel("Ραντεβού");
			
			
		    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		    groupLayout.setHorizontalGroup(
		    	groupLayout.createParallelGroup(Alignment.TRAILING)
		    		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
		    			.addGap(49)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    				.addComponent(lblNewLabel_2)
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addComponent(lblNewLabel)
		    					.addGap(77)
		    					.addComponent(lblNewLabel_1))
		    				.addComponent(button)
		    				.addComponent(btnBack)
		    				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		    					.addGroup(groupLayout.createSequentialGroup()
		    						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
		    						.addGap(18)
		    						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		    						.addGap(147))
		    					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 325, GroupLayout.PREFERRED_SIZE)))
		    			.addContainerGap(54, Short.MAX_VALUE))
		    );
		    groupLayout.setVerticalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGap(6)
		    			.addComponent(lblNewLabel_2)
		    			.addPreferredGap(ComponentPlacement.UNRELATED)
		    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		    			.addGap(31)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel)
		    				.addComponent(lblNewLabel_1))
		    			.addGap(18)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		    			.addPreferredGap(ComponentPlacement.UNRELATED)
		    			.addComponent(button)
		    			.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
		    			.addComponent(btnBack)
		    			.addContainerGap())
		    );
		    
		    
		    Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    String columns[] = null;
		    columns = new String[]{ "AID","PatientID", "DateCreated", "ADate", "DoctorID", "Clinic", "PatientWent"};
		    ArrayList<Object[]> Q = new ArrayList<Object[]>();
		    
		    helloservice1.getAppointments(Q);
		    rowData = new Object[Q.size()][7];
		  
		    
		    
			for(int i=0; i<Q.size(); i++){
					//System.out.println(Q.get(0).toString());
				   rowData[i] = Q.get(i);
			}
		    
		    table = new JTable();
		    table.setModel(new DefaultTableModel(rowData,columns));
		    scrollPane.setViewportView(table);
		    frame.getContentPane().setLayout(groupLayout);
		    frame.setVisible(true);

		
	}

	/**
	 * Create the application.
	 * @param receptionistFile 
	 */
	public apoint(HelloService helloservice1, ReceptionistFile receptionistFile) {
		this.receptionistFile = receptionistFile;
		this.helloservice1 = helloservice1;
		initialize();
	}
}