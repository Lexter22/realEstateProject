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
import java.io.InputStream;
import java.sql.Blob;
import javax.swing.BorderFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
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
    private String location, price, id, status, description, name, locationBack, priceBack, idBack, statusBack, descriptionBack, nameBack, username, fname, lname, userNum, userEmail, inheretBack;
    private String userId;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C"));
    private Connection con;
    private LocalDate date = LocalDate.now();
    private Set<String> uniqueID = new HashSet<>();
    private Set<String> str = uniqueID;
    private String firstName, lastName, userPassword, userid, dateString, idFortransaction;
        
    purchasePage(String id, String name, String location, String price, String status, String description, String inheret, String fname, String lname, int userId, String userNum, String userEmail, ImageIcon picture){
        
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

        lblId = new JLabel("ID : " + id);
        lblId.setBounds(30, 180, 335, 30);
        lblId.setForeground(Color.white);
        purchasePagePanel.add(lblId);
     
        
        lblLocation = new JLabel("Location : " + location);
        lblLocation.setBounds(30, 220, 335, 30);
        lblLocation.setForeground(Color.white);
        purchasePagePanel.add(lblLocation);
   
        
        
        
        
        
        lblDate = new JLabel("Date: " + date);
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
        descriptionBack = description;
        nameBack = name;
        finalPicture = picture;
        inheretBack = inheret;
        userData(inheret);
        
        
    }
    public void storeDate(){
          String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        String charactersForID = "ABCDEFGHIJ0123456789";
        idFortransaction = transactId(charactersForID);
        String store = "Insert INTO transaction (transactionId, clientId, propertyId, date) VALUES (?,?,?,?)";
        
        dateString = date.toString();
        try {
             con = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = con.prepareStatement(store);
             ps.setString(1, idFortransaction);
             ps.setString(2, userid);
             ps.setString(3, idBack);
             ps.setString(4, dateString);
             ps.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(purchasePage.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
        
    }
    
    public String transactId(String randomTransactId){

        Random randomizer = new Random();

        String randomString = "";

        for(int i=0; i<10; i++){
            randomString += randomTransactId.charAt(randomizer.nextInt(randomTransactId.length()));
        }
        
        return randomString;
    }
    
    public void userData(String userName){
        
        
        String dataOfUser = "Select firstname, lastname, password, id FROM clientsinfo WHERE username = ?";
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        try {
            con = DriverManager.getConnection(url, username, password);
            PreparedStatement ps = con.prepareStatement(dataOfUser);
            ps.setString(1, userName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                userPassword = rs.getString("password");
                userid = rs.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(purchasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
             
        
       
        
        
        
    }
    
    public void updateStatus(String propertyId){
        
        try {
            
            String Idproperty = "UPDATE residentialrealestates SET status = 'Sold' WHERE id = ?";
            String url = "jdbc:mysql://localhost:3306/realestates";
            String username = "root";
            String password = "admin123";
            
            PreparedStatement ps = con.prepareStatement(Idproperty);
            ps.setString(1, propertyId);
            ps.executeUpdate();
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(purchasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void propertiesOwned(String ID) {
        
        String img = "SELECT img from residentialrealestates WHERE id = ?";
        String inputimg = "INSERT into propertiesowned (userId, propertyId, propertyName, propertyLocation, propertyPrice, img) values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(img);
            PreparedStatement sp = con.prepareStatement(inputimg);
            ps.setString(1, ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blob image = rs.getBlob("img");
                InputStream Image = image.getBinaryStream();
                
                sp.setString(1, userid);
                sp.setString(2, ID);
                sp.setString(3, nameBack);
                sp.setString(4, locationBack);
                sp.setString(5, priceBack);
                sp.setBlob(6, Image);
                
                sp.executeUpdate();
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(purchasePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnContinue){
            String passWord = txtpass.getText();
            String retypePassword = txtrepass.getText();
            
            
            if (passWord.isEmpty() || retypePassword.isEmpty()) {
            
                JOptionPane.showMessageDialog(null, "Field is empty");
            }
            else if (passWord.equals(userPassword) && retypePassword.equals(userPassword)){
                
                
                storeDate();
                updateStatus(idBack);
                propertiesOwned(idBack);
                new receiptPage(firstName, lastName, inheretBack, idBack, nameBack, locationBack, dateString, priceBack, idFortransaction).setVisible(true);
                dispose();
                
            }
            
            else if (!passWord.equals(retypePassword)) {
                
                JOptionPane.showMessageDialog(null, "Password does not match");
                
            }
            
            else if (!passWord.equals(userPassword)){
                
                JOptionPane.showMessageDialog(null, "Password is incorrect");
                
            }
            
            
        } else if(e.getSource()==btnBack){
                new moreInfo(idBack, nameBack, locationBack, priceBack, statusBack, descriptionBack, inheretBack, fname, lname, userId, userNum, userEmail, finalPicture);
            dispose();
        }
        
    }

    
}
