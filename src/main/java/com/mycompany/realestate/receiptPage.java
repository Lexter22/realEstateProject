/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class receiptPage extends JFrame implements ActionListener{
    
    
    private JLabel lblRichfield, lblRichfield2, lblName, lblUserName, lblDate, lblLocation, lblProductName, lblProductID, lblPrice, lblTransactionID, lblPurchasedEstate, lblOfficial, lblThankYou, lblLogo;
    private JButton btnBackToHome;
    private ImageIcon icLogo, icFinalLogo;
    private String user;
    
    
    public receiptPage (String firstName, String surname, String userName, String propertyId, String propertyName, String propertyLocation, String datePurchased, String pricePaid, String transactionId) {
       
        
        setSize(400, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        lblRichfield = new JLabel("Richfield");
        lblRichfield.setBounds(20, 20, 360, 30);
        lblRichfield.setHorizontalAlignment(JLabel.CENTER);
        lblRichfield.setFont(new Font("Arial", Font.PLAIN, 25));
        add(lblRichfield);
        
        
        lblRichfield2 = new JLabel("Real Estates");
        lblRichfield2.setBounds(20, 55, 360, 20);
        lblRichfield2.setHorizontalAlignment(JLabel.CENTER);
        lblRichfield2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblRichfield2);
        
        
        icLogo = new ImageIcon("logoRealEstates.png");
        icFinalLogo = new ImageIcon(icLogo.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(icFinalLogo);
        lblLogo.setBounds(10, 10, 80, 80);
        add(lblLogo);
        
        
        
        lblName = new JLabel("Name : " + firstName + " " + surname);
        lblName.setBounds(20, 210, 360, 15);
        lblName.setHorizontalAlignment(JLabel.LEFT);
        lblName.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblName);
        
        
        lblUserName = new JLabel("Username : " + userName);
        lblUserName.setBounds(20, 240, 360, 15);
        lblUserName.setHorizontalAlignment(JLabel.LEFT);
        lblUserName.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblUserName);
        
        
        lblPurchasedEstate = new JLabel("- - - - - - - - - - - - - - - Purchased Estate - - - - - - - - - - - - - - -");
        lblPurchasedEstate.setBounds(20, 270, 360, 15);
        lblPurchasedEstate.setHorizontalAlignment(JLabel.CENTER);
        lblPurchasedEstate.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblPurchasedEstate);
        
        
        lblProductName = new JLabel("Estate Name : " + propertyName);
        lblProductName.setBounds(20, 300, 360, 15);
        lblProductName.setHorizontalAlignment(JLabel.LEFT);
        lblProductName.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblProductName);
        
        
        lblProductID = new JLabel("Estate ID : " + propertyId);
        lblProductID.setBounds(20, 330, 360, 15);
        lblProductID.setHorizontalAlignment(JLabel.LEFT);
        lblProductID.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblProductID);
        
        
        lblLocation = new JLabel("Estate Location : " + propertyLocation);
        lblLocation.setBounds(20, 360, 360, 15);
        lblLocation.setHorizontalAlignment(JLabel.LEFT);
        lblLocation.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblLocation);
        
        
        lblDate = new JLabel("Date Purchased : " + datePurchased);
        lblDate.setBounds(20, 390, 360, 15);
        lblDate.setHorizontalAlignment(JLabel.LEFT);
        lblDate.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblDate);
        
        
        lblPrice = new JLabel("Paid Amount : " + pricePaid);
        lblPrice.setBounds(20, 420, 360, 15);
        lblPrice.setHorizontalAlignment(JLabel.LEFT);
        lblPrice.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblPrice);
        
        
        lblTransactionID = new JLabel("Transaction ID : " + transactionId);
        lblTransactionID.setBounds(20, 450, 360, 15);
        lblTransactionID.setHorizontalAlignment(JLabel.LEFT);
        lblTransactionID.setFont(new Font("Arial", Font.PLAIN, 10));
        add(lblTransactionID);
        
        
        lblOfficial = new JLabel("THIS IS AN OFFICIAL RECEIPT");
        lblOfficial.setBounds(20, 480, 360, 20);
        lblOfficial.setHorizontalAlignment(JLabel.CENTER);
        lblOfficial.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblOfficial);
        
        
        lblThankYou = new JLabel("Thank you for purchase!");
        lblThankYou.setBounds(20, 500, 360, 20);
        lblThankYou.setHorizontalAlignment(JLabel.CENTER);
        lblThankYou.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblThankYou);
        
        
        btnBackToHome = new JButton("Back to Home");
        btnBackToHome.setBounds(245, 530, 130, 20);
        btnBackToHome.setFocusable(false);
        btnBackToHome.setHorizontalAlignment(JLabel.CENTER);
        btnBackToHome.setFont(new Font("Arial", Font.PLAIN, 15));
        add(btnBackToHome);
        
        
        btnBackToHome.addActionListener(this);
        
        
        setVisible(true);
        user = userName;
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource() == btnBackToHome) {
            
            
            new ClientInterface(user).setVisible(true);
            dispose();
            
        }
        
    }
    
}
