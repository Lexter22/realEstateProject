/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author jcasu
 */
public class purchasePage extends JFrame implements ActionListener{
    private JLabel lblRichField, lbPurchaseForm, lblId, lblLocation, lblDate, lblLogo, lblPrice,lblpass,lblrepass;
    private JPasswordField txtpass, txtrepass;
    private JButton btnBack, btnContinue;
    private JPanel  logoPanel;
    private ImageIcon logoIc, finalLogoIc, picture, finalPicture;
    private String location, price, id, status, name, locationBack, priceBack, idBack, statusBack, nameBack, username, fname, lname, userNum, userEmail, inheretBack;
    private int userId;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C"));
    private Connection con;
        
    purchasePage(String id, String name, String location, String price, String status, String inheret, String fname, String lname, int userId, String userNum, String userEmail, ImageIcon picture){
        
        setTitle("Purchase Form");
        setSize(400, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel purchasePagePanel = new JPanel();
        purchasePagePanel.setBackground(cGreen);
        purchasePagePanel.setLayout(null);
        purchasePagePanel.setBounds(0,0,400,600);
        add(purchasePagePanel);
 
        logoIc = new ImageIcon("logoRealEstates.png");
        finalLogoIc = new ImageIcon(logoIc.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(finalLogoIc);
        lblLogo.setBounds(145, 10, 110, 110);
        purchasePagePanel.add(lblLogo);
        
        
        lbPurchaseForm = new JLabel("PURCHASE FORM");
        lbPurchaseForm.setHorizontalAlignment(SwingConstants.CENTER);
        lbPurchaseForm.setBounds(120, 140, 150, 30);
        lbPurchaseForm.setForeground(Color.white);
        lbPurchaseForm.setFont(new Font("Arial", Font.BOLD, 15));
        purchasePagePanel.add(lbPurchaseForm);

        lblId = new JLabel("ID:");
        lblId.setBounds(30, 180, 335, 30);
        lblId.setForeground(Color.white);
        purchasePagePanel.add(lblId);
     
        
        lblLocation = new JLabel("Location:");
        lblLocation.setBounds(30, 220, 335, 30);
        lblLocation.setForeground(Color.white);
        purchasePagePanel.add(lblLocation);
   
        lblDate = new JLabel("Date:");
        lblDate.setBounds(30, 260, 335, 30);
        lblDate.setForeground(Color.white);
        purchasePagePanel.add(lblDate);
       
        txtpass = new JPasswordField();
        txtpass.setBounds(125,340,150,30);
        txtpass.setBackground(cGreen);
        txtpass.setForeground(Color.white);
        txtpass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        txtpass.setCaretColor(Color.white);
        txtpass.setCursor(new Cursor(HAND_CURSOR));
        txtpass.setHorizontalAlignment(SwingConstants.CENTER);
        purchasePagePanel.add(txtpass);
        
        lblpass = new JLabel("Enter your password");
        lblpass.setBounds(0,370,395,30);
        lblpass.setHorizontalAlignment(SwingConstants.CENTER);
        lblpass.setFont(new Font("Arial", Font.BOLD, 15));
        lblpass.setForeground(Color.white);
        purchasePagePanel.add(lblpass);
        
        txtrepass = new JPasswordField();
        txtrepass.setBounds(125,410,150,30);
        txtrepass.setBackground(cGreen);
        txtrepass.setForeground(Color.white);
        txtrepass.setCaretColor(Color.white);
        txtrepass.setCursor(new Cursor(HAND_CURSOR));
        txtrepass.setHorizontalAlignment(SwingConstants.CENTER);
        txtrepass.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        purchasePagePanel.add(txtrepass);
        
        lblrepass = new JLabel("Re-enter your password");
        lblrepass.setBounds(0,440,395,30);
        lblrepass.setHorizontalAlignment(SwingConstants.CENTER);
        lblrepass.setFont(new Font("Arial", Font.BOLD, 15));
        lblrepass.setForeground(Color.white);
        purchasePagePanel.add(lblrepass);
        
      
        btnBack = new JButton("Back");
        btnBack.setBounds(95, 500, 90, 35);
        btnBack.setHorizontalAlignment(JLabel.CENTER);
        btnBack.setBackground(cGray);
        btnBack.setForeground(Color.BLACK);
        btnBack.setFont(new Font("Arial", Font.BOLD, 12));
        purchasePagePanel.add(btnBack);
        
        btnContinue = new JButton("Continue");
        btnContinue.setBounds(200,500, 90,35);
        btnContinue.setHorizontalAlignment(JLabel.CENTER);
        btnContinue.setBackground(cGray);
        btnContinue.setForeground(Color.BLACK);
        btnContinue.setFont(new Font("Arial", Font.BOLD, 12));
        purchasePagePanel.add(btnContinue);
        
        btnBack.addActionListener(this);
        btnContinue.addActionListener(this);
        locationBack = location;
        priceBack = price;
        idBack = id;
        statusBack = status;
        nameBack = name;
        finalPicture = picture;
        inheretBack = inheret;
        databaseGetInfo();
        getStoredDate();
        getDate();

        
    }

    private void databaseGetInfo() {
        
        
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        
        
         String getInfoForConfirm = "SELECT id, location FROM residentialrealestates";

         
        try (Connection connection = DriverManager.getConnection(url, username, password); 
                PreparedStatement ps = connection.prepareStatement(getInfoForConfirm))
        {
        
            try (ResultSet rs = ps.executeQuery()) {

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
    
    
    private void getDate() {
    
        String url = "jdbc:mysql://localhost:3306/realestates"; 
        String username = "root";
        String password = "admin123";

        try (Connection con = DriverManager.getConnection(url, username, password)) {
            String storeDate = "INSERT INTO date (date) VALUES (?)";

            

            try (PreparedStatement ps = con.prepareStatement(storeDate)) {
                

                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                

                ps.setDate(1, sqlDate); 
                

                ps.executeUpdate();
                
            }
            
        } 
        
        catch (SQLException e) {
            
            e.printStackTrace();
            
        }
        
    }
    
    
private void getStoredDate() {
    
    
        String url = "jdbc:mysql://localhost:3306/realestates"; 
        String username = "root";
        String password = "admin123";

        
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            
            
        String gettingStoredDate = "SELECT date FROM date ORDER BY date DESC LIMIT 1"; 
        
        
            try (PreparedStatement ps = con.prepareStatement(gettingStoredDate)) {


                try (ResultSet rs = ps.executeQuery()) {
                    
                    if (rs.next()) {

                        java.sql.Date dateStored = rs.getDate("date"); 
                        lblDate.setText("Date: " + dateStored.toString()); 
                        
                        
                    } 
                    
                    else {
                        
                        lblDate.setText("Date: Not Found");
                        
                    }
                    
                }
                
            }
            
        } 
        
        
        catch (SQLException e) {
            e.printStackTrace();
            
        }
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnContinue){
            String passWord = txtpass.getText();
            String retypePassword = txtrepass.getText();
            
            
            if (passWord.isEmpty() || retypePassword.isEmpty()){
                JOptionPane.showMessageDialog(this, "Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);               
            } else if (!passWord.equals(retypePassword)){
                JOptionPane.showMessageDialog(this, "Password does not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Puchase Successful!\nClick OK to continue.", "Congratulations", JOptionPane.INFORMATION_MESSAGE);
                
                new receiptPage().setVisible(true);
                dispose();
            } 
            
        } else if(e.getSource()==btnBack){
                new moreInfo(locationBack, priceBack, idBack, statusBack, nameBack, inheretBack, fname, lname, userId, userNum, userEmail, finalPicture);
            dispose();
        }
    }

    
}
