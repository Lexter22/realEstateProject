/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginpage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenovo Ideapad
 */
public class SignUp extends JFrame implements ActionListener{
    private JTextField nameField, usernameField, contactField;
    private JPasswordField passwordField, retypePasswordField;
    private JButton signUpButton, backButton;
    private JLabel messageLabel;

    public SignUp() {
        setTitle("Sign Up");
        setSize(400, 600);
        setLayout(null); 
        
        JLabel lblQuahogSpringField1 = new JLabel("Quahog Springfield");
        lblQuahogSpringField1.setBounds(20, 35, 360, 40);
        lblQuahogSpringField1.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField1.setFont(new Font("Arial", Font.PLAIN, 35));
        add(lblQuahogSpringField1);
        
        JLabel lblQuahogSpringField2 = new JLabel("Real Estates");
        lblQuahogSpringField2.setBounds(20, 75, 360, 30);
        lblQuahogSpringField2.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField2.setFont(new Font("Arial", Font.PLAIN, 20));
        add(lblQuahogSpringField2);
        
        JLabel lblQuahogSpringField3 = new JLabel("Create Account");
        lblQuahogSpringField3.setBounds(20, 270, 360, 30);
        lblQuahogSpringField3.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField3.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lblQuahogSpringField3);
        
        JPanel jpLogo = new JPanel();
        jpLogo.setBounds(150,140,100,100);
        jpLogo.setBackground(Color.red);
        add(jpLogo);
        
        
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 330, 360, 30);
        nameLabel.setHorizontalAlignment(JLabel.LEFT);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 335, 240, 20);
        add(nameField);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 360, 100, 30);
        usernameLabel.setHorizontalAlignment(JLabel.LEFT);
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(120, 365, 240, 20);
        add(usernameField);
        
        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(20, 390, 100, 30);
        contactLabel.setHorizontalAlignment(JLabel.LEFT);
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(contactLabel);
        
        contactField = new JTextField();
        contactField.setBounds(120, 395, 240, 20);
        add(contactField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 420, 360, 30);
        passwordLabel.setHorizontalAlignment(JLabel.LEFT);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 425, 240, 20);
        add(passwordField);

        JLabel retypeLabel = new JLabel("Retype Password:");
        retypeLabel.setBounds(20, 450, 360, 30);
        retypeLabel.setHorizontalAlignment(JLabel.LEFT);
        retypeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        add(retypeLabel);

        retypePasswordField = new JPasswordField();
        retypePasswordField.setBounds(120, 455, 240, 20);
        add(retypePasswordField);

        signUpButton = new JButton("Back");
        signUpButton.setBounds(175, 505, 80, 25);
        signUpButton.addActionListener(this);
        add(signUpButton);
        
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(275, 505, 80, 25);
        signUpButton.addActionListener(this);
        add(signUpButton);

        messageLabel = new JLabel();
        messageLabel.setBounds(260, 530, 300, 25);
        add(messageLabel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(passwordField.getPassword());
        String retypePassword = new String(retypePasswordField.getPassword());

        if (!password.equals(retypePassword)) {
            messageLabel.setText("Passwords do not match!");
            
        } else {
            messageLabel.setText(" Sign up successful!");
        }
    }
    
}
