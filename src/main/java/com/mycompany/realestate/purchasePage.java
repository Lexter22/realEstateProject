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
public class purchasePage extends JFrame implements ActionListener{
    private JLabel hdrTitle, hdrPurchasingForm, hdrId, hdrLocation, hdrDate;
    private JButton btnBack, btnContinue;
    private JPanel  logoPanel;
        
    purchasePage(){
        setTitle("Purchase Form");
        setSize(400, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
 
        hdrTitle = new JLabel("QRSE");
        hdrTitle.setBounds(150, 10, 100, 80);
        hdrTitle.setHorizontalAlignment(SwingConstants.CENTER);
        hdrTitle.setFont(new Font("Arial", Font.PLAIN, 34));
        add(hdrTitle);
        
        logoPanel = new JPanel();
        logoPanel.setBounds(140, 80, 110, 110);
        logoPanel.setBackground(Color.red);
        add(logoPanel);
        
        hdrPurchasingForm = new JLabel("PURCHASE FORM");
        hdrPurchasingForm.setHorizontalAlignment(SwingConstants.CENTER);
        hdrPurchasingForm.setBounds(140, 150, 95, 120);
        hdrPurchasingForm.setFont(new Font("Arial", Font.BOLD, 10));
        add(hdrPurchasingForm);

        hdrId = new JLabel("ID:");
        hdrId.setBounds(30, 260, 70, 40);
        add(hdrId);
        
        hdrLocation = new JLabel("Location:");
        hdrLocation.setBounds(30, 320, 70, 40);
        add(hdrLocation);
        
        hdrDate = new JLabel("Date:");
        hdrDate.setBounds(30, 390, 70, 40);
        add(hdrDate);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(110, 480, 110, 30);
        add(btnBack);
        
        btnContinue = new JButton("Continue");
        btnContinue.setBounds(240, 480, 110, 30);
        add(btnContinue);
        
        btnBack.addActionListener(this);
        btnContinue.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnContinue){
            
            confirmPayment payment = new confirmPayment();
            payment.setVisible(true);
            dispose();
        } else if(e.getSource()==btnBack){
            new moreInfo();
            dispose();
        }
    }
}
