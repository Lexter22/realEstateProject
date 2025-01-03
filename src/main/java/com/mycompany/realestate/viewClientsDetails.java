/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
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
    public viewClientsDetails()  {
        setSize(800,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        setTitle("Client Details");
        setResizable(false);
        
        String ownedPropertiesColumn[]= {"House ID","Transaction ID","Location","Date of Purchase"};
        String[][] sampleRow = {
            {"1","abdul123","Canlalay","date"},
            {"2","abdul124","Canlalay","date"},     
        };
        
        ownedProperties = new DefaultTableModel(sampleRow,ownedPropertiesColumn);
      
        tableProperties = new JTable(ownedProperties);
        tableProperties.setRowHeight(30);      
                
        paneTable = new JScrollPane(tableProperties);
        paneTable.setBounds(20, 20, 500, 420);
        add(paneTable);
        
        lblName = new JLabel("Name: ");
        lblName.setBounds(570,120,80,30);
        lblName.setFont(new Font("Arial",Font.BOLD,15));
        add(lblName);
        
        // name from sql
        lblNameFromSQL = new JLabel("a");
        lblNameFromSQL.setBounds(660,120,80,30);
        lblNameFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblNameFromSQL);
        
        lblID = new JLabel("ID: ");
        lblID.setBounds(570,150,80,30);
        lblID.setFont(new Font("Arial",Font.BOLD,15));
        add(lblID);
        
        // id from sql
        lblIDfromSQL = new JLabel("a");
        lblIDfromSQL.setBounds(660,150,80,30);
        lblIDfromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblIDfromSQL);
        
        lblUsername = new JLabel("Username: ");
        lblUsername.setBounds(570,180,80,30);
        lblUsername.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUsername);
        
        // username from sql
        lblUsernameFromSQL = new JLabel("a");
        lblUsernameFromSQL.setBounds(660,180,80,30);
        lblUsernameFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblUsernameFromSQL);
        
        
        lblGmail = new JLabel("Gmail: ");
        lblGmail.setBounds(570,210,80,30);
        lblGmail.setFont(new Font("Arial",Font.BOLD,15));
        add(lblGmail);
        
        // gmail from sql
        lblGmailFromSQL = new JLabel("a");
        lblGmailFromSQL.setBounds(660,210,80,30);
        lblGmailFromSQL.setFont(new Font("Arial",Font.BOLD,15));
        add(lblGmailFromSQL);
        
        lblPhoneNumber = new JLabel("Number: ");
        lblPhoneNumber.setBounds(570,240,80,30);
        lblPhoneNumber.setFont(new Font("Arial",Font.BOLD,15));
        add(lblPhoneNumber);
        
        // number from sql
        lblPnFromSQL = new JLabel("a");
        lblPnFromSQL.setBounds(660,240,80,30);
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
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new viewClientsDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            new adminPage();
        }
    }
}
