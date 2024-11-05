/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Lenovo Ideapad
 */
public class SignUp extends JFrame implements ActionListener{
    private JTextField txtName, txtUsername, txtContact;
    private JPasswordField passwordField, retypePasswordField;
    private JButton signUpButton, backButton;
    private JLabel lblMessage, lblQuahogSpringField, lblRealEstates, lblCrtAccount, lblName, lblUsername, lblContact, lblPassword, lblretypePass;

    public SignUp() {
        setTitle("Sign Up");
        setSize(400, 600);
        setLayout(null); 
        
        lblQuahogSpringField = new JLabel("Quahog Springfield");
        lblQuahogSpringField.setBounds(20, 35, 360, 40);
        lblQuahogSpringField.setHorizontalAlignment(JLabel.CENTER);
        lblQuahogSpringField.setFont(new Font("Arial", Font.PLAIN, 35));
        add(lblQuahogSpringField);
        
        lblRealEstates = new JLabel("Real Estates");
        lblRealEstates.setBounds(20, 75, 360, 30);
        lblRealEstates.setHorizontalAlignment(JLabel.CENTER);
        lblRealEstates.setFont(new Font("Arial", Font.PLAIN, 20));
        add(lblRealEstates);
        
        lblCrtAccount = new JLabel("Create Account");
        lblCrtAccount.setBounds(20, 270, 360, 30);
        lblCrtAccount.setHorizontalAlignment(JLabel.CENTER);
        lblCrtAccount.setFont(new Font("Arial", Font.PLAIN, 30));
        add(lblCrtAccount);
        
        JPanel jpLogo = new JPanel();
        jpLogo.setBounds(150,140,100,100);
        jpLogo.setBackground(Color.red);
        add(jpLogo);
        
        
        lblName = new JLabel("Name:");
        lblName.setBounds(20, 330, 360, 30);
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(120, 335, 240, 20);
        add(txtName);

        lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 360, 100, 30);
        lblUsername.setHorizontalAlignment(JLabel.LEFT);
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 365, 240, 20);
        add(txtUsername);
        
        lblContact = new JLabel("Contact:");
        lblContact.setBounds(20, 390, 100, 30);
        lblContact.setHorizontalAlignment(JLabel.LEFT);
        lblContact.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblContact);
        
        txtContact = new JTextField();
        txtContact.setBounds(120, 395, 240, 20);
        add(txtContact);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 420, 360, 30);
        lblPassword.setHorizontalAlignment(JLabel.LEFT);
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(120, 425, 240, 20);
        add(passwordField);

        lblretypePass = new JLabel("Retype Password:");
        lblretypePass.setBounds(20, 450, 360, 30);
        lblretypePass.setHorizontalAlignment(JLabel.LEFT);
        lblretypePass.setFont(new Font("Arial", Font.PLAIN, 12));
        add(lblretypePass);

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

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = passwordField.getText();
        String name = txtName.getText();
        String username = txtUsername.getText();
        String contact = txtContact.getText();
        String retypePassword = new String(retypePasswordField.getPassword());
        if (!name.isEmpty() && !username.isEmpty() && !contact.isEmpty() && !password.isEmpty() && !retypePassword.isEmpty()) {
  
         if (!password.equals(retypePassword)) {
         JOptionPane.showMessageDialog(this, "Password do not match!","Error",JOptionPane.ERROR_MESSAGE);
            
        }else {
               Icon checkIcon = new ImageIcon("C:\\Users\\Lenovo Ideapad\\Downloads\\check.png");
         JOptionPane.showMessageDialog(this, "Sign up successful","Success",JOptionPane.INFORMATION_MESSAGE,checkIcon);   
         new welcomePage();
        }
         
        }else{
         JOptionPane.showMessageDialog(this, "Can't Sign Up please complete all details!","Error",JOptionPane.ERROR_MESSAGE);
        }

    }
    
}
