/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author johnl
 */
public class loginPage extends JFrame{
    private JLabel hdrLogin,lblUserName,lblPassword,lblProfile;
    private JPanel pnlLogin;
    private JTextField txtUsername,txtPassword;
    private JButton btnLogin,btnBack;
    public loginPage() {
        setSize(400, 600);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        hdrLogin = new JLabel("Login");
        hdrLogin.setBounds(150, 50, 150, 30);
        hdrLogin.setFont(new Font("Arial",Font.BOLD,30));
        add(hdrLogin);
        
        lblProfile = new JLabel("Profile Pic");
        lblProfile.setBounds(150, 150, 150, 30);
        add(lblProfile);
        
        pnlLogin = new JPanel();
        pnlLogin.setBounds(70, 300, 250, 180);
        pnlLogin.setBackground(Color.red);
        pnlLogin.setLayout(null);
        add(pnlLogin);
        
        lblUserName = new JLabel("Username:");
        lblUserName.setBounds(10, 30, 150, 30);
        lblUserName.setFont(new Font("Arial",Font.BOLD,15));
        pnlLogin.add(lblUserName);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(100, 30, 130, 30);
        pnlLogin.add(txtUsername);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 80, 150, 30);
        lblPassword.setFont(new Font("Arial",Font.BOLD,15));
        pnlLogin.add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(100, 80, 130, 30);
        pnlLogin.add(txtPassword);
               
        btnLogin = new JButton("Login");
        btnLogin.setBounds(110, 120, 110, 30);
        pnlLogin.add(btnLogin);
        setVisible(true);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        add(btnBack);
        
        
        
    }
   
}
