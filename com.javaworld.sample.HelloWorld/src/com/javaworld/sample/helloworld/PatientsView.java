package com.javaworld.sample.helloworld;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.javaworld.sample.helloservice.HelloService;
import com.team5.epl362.writetofileservice.ReceptionistFile;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;

public class PatientsView {
	
	 
	
	//JFrame frame;
	
	public HelloService helloservice1;
	private JTextField textField_1;
	private ReceptionistFile receptionistFile;

	public PatientsView(HelloService helloservice1, ReceptionistFile receptionistFile){
		this.receptionistFile = receptionistFile;
		this.helloservice1 = helloservice1;
		initialize();
	}
	
  private void initialize() {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Object rowData[][] = null; //{{1,1,1,1,1,1,1}};
    String columns[] = null;
    columns = new String[]{ "ID","Name", "Surname", "DOB", "Sex", "Telephone", "Address", "Last DropIn"};
    ArrayList<Object[]> Q = new ArrayList<Object[]>();
    
    helloservice1.getPatient(Q);
    rowData = new Object[Q.size()][8];
  
    
    
	for(int i=0; i<Q.size(); i++){
			//System.out.println(Q.get(0).toString());
		   rowData[i] = Q.get(i);
	}
	
	JTextField textField = new JTextField();
    textField.setColumns(10);
    
	JButton btnNewButton = new JButton("Search");
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.setVisible(false);
    		
    		searchres windoww = new searchres(helloservice1,textField.getText(), receptionistFile);
//    		windoww.frame.setVisible(true);	
    		
    		
    	}
    });
    
    
    
    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		frame.setVisible(false);
    		number1 windoww = new number1(helloservice1, receptionistFile);
    		windoww.frame.setVisible(true);	
    	}
    });
    
    JScrollPane scrollPane = new JScrollPane();
    
    textField_1 = new JTextField();
    textField_1.setColumns(10);
    
    JLabel lblNewLabel = new JLabel("Απρόσμενη Επίσκεψη");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
    
   
    
    JButton btnNewButton_2 = new JButton("Καταχώρηση");
    btnNewButton_2.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent arg0) {
    		
    		helloservice1.insertDropIN(Integer.parseInt(textField_1.getText()));
    	}
    });
    
    JLabel lblId = new JLabel("ID Ασθενή:");
    GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
    groupLayout.setHorizontalGroup(
    	groupLayout.createParallelGroup(Alignment.LEADING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    				.addGroup(groupLayout.createSequentialGroup()
    					.addGap(24)
    					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 799, GroupLayout.PREFERRED_SIZE))
    				.addGroup(groupLayout.createSequentialGroup()
    					.addGap(66)
    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
    						.addComponent(btnBack)
    						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    					.addGap(28)
    					.addComponent(btnNewButton)
    					.addGap(193)
    					.addComponent(lblId)
    					.addGap(26)
    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    						.addComponent(btnNewButton_2)
    						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblNewLabel)
    						)))
    			.addContainerGap(61, Short.MAX_VALUE))
    );
    groupLayout.setVerticalGroup(
    	groupLayout.createParallelGroup(Alignment.TRAILING)
    		.addGroup(groupLayout.createSequentialGroup()
    			.addContainerGap()
    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    				.addGroup(groupLayout.createSequentialGroup()
    					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(btnNewButton))
    					.addPreferredGap(ComponentPlacement.RELATED)
    					.addComponent(btnBack)
    					.addGap(20))
    				.addGroup(groupLayout.createSequentialGroup()
    					.addGap(6)
    					.addComponent(lblNewLabel)
    					.addPreferredGap(ComponentPlacement.RELATED)
    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    						.addComponent(lblId))
    					.addPreferredGap(ComponentPlacement.RELATED)
    					.addComponent(btnNewButton_2)
    					.addGap(13)))
    			.addPreferredGap(ComponentPlacement.RELATED)
    			)
    );
    
    JTable table = new JTable();
    table.setModel(new DefaultTableModel(rowData,columns));
    //table.setSize(600, 600);
    scrollPane.setViewportView(table);
    frame.getContentPane().setLayout(groupLayout);
    frame.setSize(900, 400);
    frame.setVisible(true);
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//    JTable table = new JTable(rowData, columns);
//    table.setBorder(UIManager.getBorder("Button.border"));
//    
//    JButton button = new JButton("HELLO");
//    button.setVisible(true);
//
//    JScrollPane scrollPane = new JScrollPane(table);
//    frame.getContentPane().add(scrollPane, BorderLayout.EAST);
//    
//    JScrollPane scrollPane_1 = new JScrollPane();
//    scrollPane.setRowHeaderView(scrollPane_1);
//    frame.setSize(400, 300);
//    frame.setVisible(true);

  }
}
