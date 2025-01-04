/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author johnl
 */
public class viewClientsDetails extends JFrame implements ActionListener{
    // para pinindot yung row cng client ay pupunta dito - Reyes
    private JLabel lblName,lblID,lblUsername,lblGmail,lblPhoneNumber,lblProfilePicture;
    private JLabel lblNameFromSQL,lblIDfromSQL,lblUsernameFromSQL,lblGmailFromSQL,lblPnFromSQL;
    private DefaultTableModel ownedProperties,rowsDetails;
    private JTable tableProperties;
    private JScrollPane paneTable;
    private ImageIcon accountAvatarIcon;
    private JButton btnBack;
    private Connection con;
    private PreparedStatement pst;
    private Statement st;
    private ResultSet rs;
    private String firstName, lastName, Username, clientsNumber, clientsEmail, propertyId, transactionId, transactionDate, propertyLocation;
    
    public viewClientsDetails(String clientsId)  {
        
        Connect();
        userData(clientsId);
        
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Client Details");
        setResizable(false);
        
        String ownedPropertiesColumn[]= {"House ID","Transaction ID","Location","Date of Purchase"};
        String[][] propertyRow = {};
        
        ownedProperties = new DefaultTableModel(propertyRow,ownedPropertiesColumn);
      
        tableProperties = new JTable(ownedProperties);
        tableProperties.setRowHeight(30);      
        tableProperties.setDefaultEditor(Object.class, null);
                
        paneTable = new JScrollPane(tableProperties);
        paneTable.setBounds(20, 20, 500, 420);
        add(paneTable);
        
        lblName = new JLabel("Name: ");
        lblName.setBounds(530,120,80,30);
        lblName.setFont(new Font("Arial",Font.BOLD,15));
        add(lblName);
        
        // name from sql
        lblNameFromSQL = new JLabel(firstName+" "+lastName);
        lblNameFromSQL.setBounds(610,120,150,30);
        lblNameFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblNameFromSQL);
        
        lblID = new JLabel("ID: ");
        lblID.setBounds(530,150,80,30);
        lblID.setFont(new Font("Arial",Font.BOLD,15));
        add(lblID);
        
        // id from sql
        lblIDfromSQL = new JLabel(clientsId);
        lblIDfromSQL.setBounds(610,150,150,30);
        lblIDfromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblIDfromSQL);
        
        lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(530,180,80,30);
        lblUsername.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUsername);
        
        // username from sql
        lblUsernameFromSQL = new JLabel(Username);
        lblUsernameFromSQL.setBounds(610,180,150,30);
        lblUsernameFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUsernameFromSQL);
        
        
        lblGmail = new JLabel("Gmail: ");
        lblGmail.setBounds(530,210,80,30);
        lblGmail.setFont(new Font("Arial",Font.BOLD,15));
        add(lblGmail);
        
        // gmail from sql
        lblGmailFromSQL = new JLabel(clientsEmail);
        lblGmailFromSQL.setBounds(610,210,150,30);
        lblGmailFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblGmailFromSQL);
        
        lblPhoneNumber = new JLabel("Number: ");
        lblPhoneNumber.setBounds(530,240,80,30);
        lblPhoneNumber.setFont(new Font("Arial",Font.BOLD,15));
        add(lblPhoneNumber);
        
        // number from sql
        lblPnFromSQL = new JLabel(clientsNumber);
        lblPnFromSQL.setBounds(610,240,150,30);
        lblPnFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblPnFromSQL);
        
        // para sa image
        accountAvatarIcon = new ImageIcon("accountAvatar.png");
        lblProfilePicture = new JLabel(accountAvatarIcon);
        lblProfilePicture.setBounds(580, 10, 120, 120);
        add(lblProfilePicture);
        
        // back button
        btnBack = new JButton("Back");
        btnBack.setBounds(600,400, 80, 30);
        add(btnBack);
        
        btnBack.addActionListener(this);
        
        
       
        propertyData(clientsId);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            dispose();
            new adminPage();
        }
    }
    
    public void Connect(){
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(viewClientsDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void userData(String clientsId){
        String getUserData = "Select * from clientsinfo where id=?";
        
        try{
        pst = con.prepareStatement(getUserData);
        pst.setString(1, clientsId);
        rs = pst.executeQuery();
        
            while(rs.next()){
            
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                Username = rs.getString("username");
                clientsNumber = rs.getString("contactnum");
                clientsEmail = rs.getString("email");

            }   
        }catch (SQLException ex) {
          Logger.getLogger(viewClientsDetails.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void propertyData(String clientsId){
        String getHouseId = "Select * from transactions where clientid=?";
        
        try{
        pst = con.prepareStatement(getHouseId);
        pst.setString(1, clientsId);
        rs = pst.executeQuery();
        
            while(rs.next()){

                propertyId = rs.getString("propertyId");
                transactionId = rs.getString("transactionId");
                transactionDate = rs.getString("date");

            }
            location(clientsId, propertyId, transactionId, transactionDate);
        }catch (SQLException ex) {
          Logger.getLogger(viewClientsDetails.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public void location(String clientsId, String propertyIds, String transactionIds, String transactionDates){
        String getLocation = "Select * from propertiesowned where usersId=?";
        try{
            pst = con.prepareStatement(getLocation);
            pst.setString(1, clientsId);
            rs = pst.executeQuery();
            
            while(rs.next()){
                propertyLocation = rs.getString("propertyLocation");
                
                Object [] dataSql={propertyIds, transactionIds, propertyLocation, transactionDates};
                
                ownedProperties.addRow(dataSql);
            }
            
            
        }catch (SQLException ex) {
          Logger.getLogger(viewClientsDetails.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
}
