/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import com.mycompany.realestate.loginPage;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author johnl
 */
public class loginPage extends JFrame implements ActionListener{
    
    
    private JLabel lblQuahogSpringField1, lblQuahogSpringField2, lblUserName, lblPassword, lblLogIn;
    private JTextField txtLoginField;
    private JPasswordField psfPassword;
    private JButton btnBack, btnLogIn;
    private JPanel jpLogo;
    
    
    public loginPage() {
        
        
        setSize(400, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        lblQuahogSpringField1 = new JLabel("Quahog Springfield");
        lblQuahogSpringField1.setBounds(20, 35, 360, 40);
        lblQuahogSpringField1.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField1.setFont(new Font("Arial", Font.PLAIN, 35));
        add(lblQuahogSpringField1);
        
        
        lblQuahogSpringField2 = new JLabel("Real Estates");
        lblQuahogSpringField2.setBounds(20, 75, 360, 30);
        lblQuahogSpringField2.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField2.setFont(new Font("Arial", Font.PLAIN, 25));
        add(lblQuahogSpringField2);
        
        
        lblLogIn = new JLabel("Log In");
        lblLogIn.setBounds(20, 350, 360, 35);
        lblLogIn.setHorizontalAlignment(JLabel.CENTER);
        lblLogIn.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lblLogIn);
        
        
        jpLogo = new JPanel();
        jpLogo.setBounds(100,130,200,200);
        jpLogo.setBackground(Color.red);
        add(jpLogo);
        
        
        lblUserName = new JLabel("Username :");
        lblUserName.setBounds(20, 425, 360, 30);
        lblUserName.setHorizontalAlignment(JLabel.LEFT);
        lblUserName.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblUserName);
        
        
        lblPassword = new JLabel("Password :");
        lblPassword.setBounds(20, 455, 360, 30);
        lblPassword.setHorizontalAlignment(JLabel.LEFT);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblPassword);
        
        
        txtLoginField = new JTextField();
        txtLoginField.setBounds(120, 430, 240, 20);
        //txtLoginField.setFont(new Font("Arial", Font.PLAIN,20));
        add(txtLoginField);
        
        
        psfPassword = new JPasswordField();
        psfPassword.setBounds(120, 460, 240, 20);
        psfPassword.setFont(new Font("Arial", Font.PLAIN,20));
        add(psfPassword);
        
        
        btnBack = new JButton("Back");
        btnBack.setBounds(175, 505, 80, 25);
        add(btnBack);
        
        
        btnLogIn = new JButton("Log In");
        btnLogIn.setBounds(275, 505, 80, 25);
        add(btnLogIn);
        
        
        btnBack.addActionListener(this);
        btnLogIn.addActionListener(this);
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==btnBack){
            
//            welcomePage frame = new welcomePage();
//            frame.setVisible(true);
//            dispose();
            
        }
        
        
}  
}
