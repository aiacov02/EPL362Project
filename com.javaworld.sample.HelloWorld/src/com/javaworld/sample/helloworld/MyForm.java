package com.javaworld.sample.helloworld;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.DropMode;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.Dimension;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyForm {

	public JFrame frmHotlinePlatform;
	public JPasswordField passwordField;
	public JTextField textField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MyForm() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {
		frmHotlinePlatform = new JFrame();
		frmHotlinePlatform.setTitle("Hotline Platform");
		frmHotlinePlatform.setBounds(500, 200, 469, 200);
		frmHotlinePlatform.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Please Log In");
		lblNewLabel.setBounds(185, 6, 86, 14);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(185, 62, 86, 20);
		passwordField.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				if (new String(passwordField.getPassword()).equals("1234")) {
						
					System.out.println("You have logged in");
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(185, 31, 86, 20);
		textField.setColumns(10);
		
		passwordField.setText("");
		frmHotlinePlatform.getContentPane().setLayout(null);
		frmHotlinePlatform.getContentPane().add(lblNewLabel);
		frmHotlinePlatform.getContentPane().add(textField);
		frmHotlinePlatform.getContentPane().add(passwordField);
		
		
//		Connection1 newConnection = new Connection1();
		
		
		
		JLabel lblUsername = new JLabel("username:");
		lblUsername.setBounds(74, 34, 75, 14);
		frmHotlinePlatform.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(74, 65, 71, 14);
		frmHotlinePlatform.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
//			public void actionPerformed(ActionEvent e) {
//				//String userN = textField.getText();
//				try {
//				boolean loggedin = newConnection.LogIn(textField.getText(),new String(passwordField.getPassword()));
//				if(!loggedin){
//					
//					JOptionPane.showMessageDialog(new JFrame(), "Please try again","Wrong username or password",JOptionPane.WARNING_MESSAGE);
//					passwordField.setText("");
//					textField.setText("");
//				}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
		});
		
		btnNewButton.setBounds(185, 93, 86, 23);
		frmHotlinePlatform.getContentPane().add(btnNewButton);
		
		JButton CloseButton = new JButton("Cancel");
		CloseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		CloseButton.setBounds(185, 127, 86, 23);
		frmHotlinePlatform.getContentPane().add(CloseButton);
	}
}
