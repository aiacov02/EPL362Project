package com.javaworld.sample.helloworld;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import com.javaworld.sample.helloservice.HelloService;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class searchres {

	 JFrame frame;
	 private JTable table;
	 public HelloService helloservice1;
	 private String pattern;

	/**
	 * Launch the application.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		    
		    JScrollPane scrollPane = new JScrollPane();
		    
		    JButton btnBack = new JButton("Back");
		    btnBack.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		frame.setVisible(false);
		    		PatientsView windoww = new PatientsView(helloservice1);
		    		//windoww.frame.setVisible(true);	
		    	}
		    });
		    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		    groupLayout.setHorizontalGroup(
		    	groupLayout.createParallelGroup(Alignment.TRAILING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGap(75)
		    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 755, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap(54, Short.MAX_VALUE))
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addContainerGap(367, Short.MAX_VALUE)
		    			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
		    			.addGap(359))
		    );
		    groupLayout.setVerticalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGap(42)
		    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
		    			.addGap(51)
		    			.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap(106, Short.MAX_VALUE))
		    );
		    
		    Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
		    String columns[] = null;
		    columns = new String[]{ "ID","Name", "Surname", "DOB", "Sex", "Telephone", "Address", "Suicide"};
		    ArrayList<Object[]> Q = new ArrayList<Object[]>();
		    
		    helloservice1.searchPatient(Q,pattern,pattern);
		    rowData = new Object[Q.size()][8];
		  
		    
		    
			for(int i=0; i<Q.size(); i++){
					//System.out.println(Q.get(0).toString());
				   rowData[i] = Q.get(i);
			}
		    
		    table = new JTable();
		    table.setModel(new DefaultTableModel(rowData,columns));
		    scrollPane.setViewportView(table);
		    frame.getContentPane().setLayout(groupLayout);
		    frame.setSize(900, 400);
		    frame.setVisible(true);

		
	}

	/**
	 * Create the application.
	 */
	public searchres(HelloService helloservice1,String pattern) {
		this.helloservice1 = helloservice1;
		this.pattern = pattern;
		initialize();
	}

}
