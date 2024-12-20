/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author jcasu
 */
public class purchasePage extends JFrame implements ActionListener{
    private JLabel lblRichField, lbPurchaseForm, lblId, lblLocation, lblDate, lblLogo;
    private JButton btnBack, btnContinue;
    private JPanel  logoPanel;
    private ImageIcon logoIc, finalLogoIc;
    private String username, fname, lname, userNum, userEmail;
    private int userId;
    private Connection con;
        
    purchasePage(){
        
        setTitle("Purchase Form");
        setSize(400, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
 
        lblRichField = new JLabel("RichField Real Estates");
        lblRichField.setBounds(110, 5, 170, 80);
        lblRichField.setHorizontalAlignment(SwingConstants.CENTER);
        lblRichField.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblRichField);
        
        logoIc = new ImageIcon("logoRealEstates.png");
        finalLogoIc = new ImageIcon(logoIc.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(finalLogoIc);
        lblLogo.setBounds(10, 10, 110, 110);
        add(lblLogo);
        
        
        lbPurchaseForm = new JLabel("PURCHASE FORM");
        lbPurchaseForm.setHorizontalAlignment(SwingConstants.CENTER);
        lbPurchaseForm.setBounds(120, 150, 150, 120);
        lbPurchaseForm.setFont(new Font("Arial", Font.BOLD, 15));
        add(lbPurchaseForm);

        lblId = new JLabel("ID:");
        lblId.setBounds(30, 260, 200, 40);
        add(lblId);
        
        lblLocation = new JLabel("Location:");
        lblLocation.setBounds(30, 320, 200, 40);
        add(lblLocation);
        
        lblDate = new JLabel("Date:");
        lblDate.setBounds(30, 390, 200, 40);
        add(lblDate);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(110, 480, 110, 30);
        add(btnBack);
        
        btnContinue = new JButton("Continue");
        btnContinue.setBounds(240, 480, 110, 30);
        add(btnContinue);
        
        btnBack.addActionListener(this);
        btnContinue.addActionListener(this);
        databaseGetInfo();
        
    }

    private void databaseGetInfo() {
        
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        
         String getInfoForConfirm = "SELECT id, location FROM residentialrealestates";

         
        try (Connection connection = DriverManager.getConnection(url, username, password);
         PreparedStatement ps = connection.prepareStatement(getInfoForConfirm);
         ResultSet rs = ps.executeQuery()) {
        

        if (rs.next()) { 
            
            
            if (rs.next()) { 
 
                
                lblId.setText("ID:     " + rs.getString("id"));
                lblLocation.setText("Location:   " + rs.getString("location"));
            } 
            
            else {
                
                
                lblId.setText("ID:     Not Found");
                lblLocation.setText("Location:   Not Found");
                
                
            }
            
            
        }

        
    } 
        
        catch (Exception e) {
            
        Logger.getLogger(purchasePage.class.getName()).log(Level.SEVERE, null, e);
    }
}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnContinue){
            
            confirmPayment payment = new confirmPayment();
            payment.setVisible(true);
            dispose();
        } else if(e.getSource()==btnBack){
               String location = null, status = null, name=null,price = "1321321", id = "323232";
        
        new moreInfo(location, price, id, status, name,username, fname, lname, userId, userNum, userEmail, finalLogoIc);
            dispose();
        }
    }

    
}
