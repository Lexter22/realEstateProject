/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author johnl
 */
public class signUp extends JFrame {
    private JLabel hdrSignUp;
    private JPanel pnlSignUp;
    private JButton btnBack;
    public signUp() {
        setSize(400,600);
        setTitle("Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        hdrSignUp = new JLabel("Sign Up");
        hdrSignUp.setBounds(140, 50, 150, 30);
        hdrSignUp.setFont(new Font("Arial",Font.BOLD,30));
        add(hdrSignUp);
        
        pnlSignUp = new JPanel();
        pnlSignUp.setBounds(80, 100, 240, 430);
        pnlSignUp.setBackground(Color.red);
        pnlSignUp.setLayout(null);
        add(pnlSignUp);
        
         btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        add(btnBack);
        
        
        setVisible(true);
    }
    
}
