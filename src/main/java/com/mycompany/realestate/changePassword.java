/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author johnl
 */
public class changePassword extends JFrame implements  ActionListener{
    private JLabel hdrChangePassword,lblEnterPassword,lblNewPassword;
    private JTextField txtTypePassword,txtTypeNewPassword;
    private JButton btnChangePassword,btnBack;
    public changePassword()  {
        setSize(600,400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        hdrChangePassword = new JLabel("Change Password");
        hdrChangePassword.setBounds(210, 50, 200, 30);
        hdrChangePassword.setFont(new Font("Arial",Font.BOLD,20));
        add(hdrChangePassword);
        
        lblEnterPassword = new JLabel("Enter Password:");
        lblEnterPassword.setBounds(150, 100, 150, 30);
        add(lblEnterPassword);
        
        txtTypePassword = new JTextField();
        txtTypePassword.setBounds(250, 100, 150, 30);
        add(txtTypePassword);
        
        lblNewPassword = new JLabel("New Password:");
        lblNewPassword.setBounds(150, 150, 150, 30);
        add(lblNewPassword);
        
        txtTypeNewPassword = new JTextField();
        txtTypeNewPassword.setBounds(250, 150, 150, 30);
        add(txtTypeNewPassword);
        
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(250, 200, 150, 30);
        add(btnChangePassword);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        add(btnBack);
        
        btnChangePassword.addActionListener(this);
        btnBack.addActionListener(this);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // aayusin koi pa dito para macheck sa sql kung tama yung input
        if(e.getSource()==btnChangePassword) {
        String enterPassword;
        String enterNewPassword = txtTypeNewPassword.getText();
              try {
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/realestate",  "root", "admin123");
                
                 PreparedStatement st = (PreparedStatement) con.prepareStatement("Update admindetails set password=? where username=?");
                 st.setString(1, enterNewPassword);
                 st.setString(2, "admin");
                 st.executeUpdate();
                 JOptionPane.showMessageDialog(this, "Password changed successfully");
                
              } catch (SQLException ex) {
                            Logger.getLogger(changePassword.class.getName()).log(Level.SEVERE, null, ex);
              }
        }else if(e.getSource()==btnBack){
            new adminPage();
            dispose();
        }else {
         //   new adminPage();
            dispose();
        }
    }
    
}
