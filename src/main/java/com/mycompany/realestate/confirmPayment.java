/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author jcasu
 */
public class confirmPayment extends JFrame implements ActionListener{
private JLabel lblConfirPayment, lblPassword, lblRetypePass1, lblRetypePass2;
private JPasswordField inputPassword, retypePass;
private JButton btnBack, btnContinue;


    confirmPayment(){
        setTitle("Property Transaction");
        setSize(400, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        lblConfirPayment = new JLabel("Confirm Payment");
        lblConfirPayment.setBounds(105, 10, 180, 100);
        lblConfirPayment.setHorizontalAlignment(SwingConstants.CENTER);
        lblConfirPayment.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblConfirPayment);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 180, 80, 30);
        add(lblPassword);
        
        inputPassword = new JPasswordField();
        inputPassword.setBounds(90, 180, 260, 30);
        add(inputPassword);
        
        lblRetypePass1 = new JLabel("Retype");
        lblRetypePass2 = new JLabel("Password:");
        lblRetypePass1.setBounds(20, 240, 120, 30);
        lblRetypePass2.setBounds(20, 260, 120, 30);
        add(lblRetypePass1);
        add(lblRetypePass2);
        
        retypePass = new JPasswordField();
        retypePass.setBounds(90, 250, 260, 30);
        add(retypePass);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(110, 480, 110, 30);
        add(btnBack);
        
        btnContinue = new JButton("Continue");
        btnContinue.setBounds(240, 480, 100, 30);
        add(btnContinue);
        
        btnBack.addActionListener(this);
        btnContinue.addActionListener(this);
        
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnBack){
            
            purchasePage purchase = new purchasePage();
            purchase.setVisible(true);
            dispose(); 
            
        } else if (e.getSource() == btnContinue){
            String passWord = inputPassword.getText();
            String retypePassword = new String(retypePass.getPassword());
            
            
            if (passWord.isEmpty() || retypePassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);               
            } else if (!passWord.equals(retypePassword)){
                JOptionPane.showMessageDialog(this, "Password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!passWord.equals("User123") && retypePassword.equals("User123")){
                JOptionPane.showMessageDialog(this, "Incorrect Password! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Puchase Successful!\nClick OK to continue.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                
                new receiptPage().setVisible(true);
                dispose();
            } 
            
        }
        
    }
}
