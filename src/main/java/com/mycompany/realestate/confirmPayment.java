/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jcasu
 */
public class confirmPayment extends JFrame implements ActionListener{
private JLabel hdrConPay, hdrPass, hdrRetype1, hdrRetype2;
private JPasswordField passWord, retypePass;
private JButton btnBack, btnContinue;


    confirmPayment(){
        setTitle("QRSE");
        setSize(400, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        hdrConPay = new JLabel("Confirm Payment");
        hdrConPay.setBounds(105, 10, 180, 100);
        hdrConPay.setHorizontalAlignment(SwingConstants.CENTER);
        hdrConPay.setFont(new Font("Arial", Font.BOLD, 20));
        add(hdrConPay);
        
        hdrPass = new JLabel("Password:");
        hdrPass.setBounds(20, 180, 80, 30);
        add(hdrPass);
        
        passWord = new JPasswordField();
        passWord.setBounds(90, 180, 260, 30);
        add(passWord);
        
        hdrRetype1 = new JLabel("Retype");
        hdrRetype2 = new JLabel("Password:");
        hdrRetype1.setBounds(20, 240, 120, 30);
        hdrRetype2.setBounds(20, 260, 120, 30);
        add(hdrRetype1);
        add(hdrRetype2);
        
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
            String pass = passWord.getText();
            String retypePassword = new String(retypePass.getPassword());
            
            if (pass.isEmpty()){
                JOptionPane.showMessageDialog(this, "Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (retypePassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Password is required. Please re-type your password", "Error", JOptionPane.ERROR_MESSAGE);
            }else if (!pass.equals(retypePassword)){
                 JOptionPane.showMessageDialog(this, "Password does not match", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Purchase Successful!\n\nClick OK to continue ", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
}
