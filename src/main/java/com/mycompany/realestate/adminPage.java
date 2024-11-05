package com.mycompany.realestate;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.util.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class adminPage extends JFrame implements ActionListener{

    
    private JPanel panelLogo, panelHeader, panelUsers, panelADD, panelDelete, panelProfile, transactJPanel, homeJPanel,panelAddLayout,panelTransaction,panelUsersPanel; 
    private JLabel lblHeader, lblRealEstates,lblPropertyName,lblLocation,lblPrice,lblDescription,lblImage,lblAdminDetails,lblUsers;
    private JButton btnHome, btnAdd, btnDel, btnTransact, btnUsers,  btnProfile,btnImage,btnAddImage,btnChangePassword,btnSignOut,btnUserSearch;
    private JTabbedPane jtab;
    private JTable tableEstate, tableUser,tableTransactions;
    private JScrollPane estates;
    private JTextField txtPropertyName,txtLocation,txtPrice;
    private JTextArea txaDescription;
  //  private JFileChooser jfcImage;
    private JFileChooser jfcImage = new JFileChooser();
    public adminPage() {
        
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        panelLogo=new JPanel();
        panelLogo.setBounds(10,10,80,80);
        panelLogo.setBackground(Color.green);
        add(panelLogo);
        
        
        
        lblHeader=new JLabel("QUAHOG SPRINGFIELDS");
        lblHeader.setBounds(120,10,300,50);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 25));
        add(lblHeader);
        
        lblRealEstates=new JLabel("REAL ESTATES");
        lblRealEstates.setBounds(120,40,300,50);
        lblRealEstates.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblRealEstates);
        
        
        
        btnHome=new JButton("HOME");
        btnHome.setBounds(400,60,100,25);
        btnHome.setBorder(null);
        btnHome.setBackground(Color.CYAN);
        btnHome.setFocusable(false);
        btnHome.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnHome);
        
        
        btnAdd=new JButton("ADD");
        btnAdd.setBounds(525,60,100,25);
        btnAdd.setBorder(null);
        btnAdd.setBackground(Color.CYAN);
        btnAdd.setFocusable(false);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnAdd);
        
        panelAddLayout = new JPanel();
        panelAddLayout.setLayout(null);
        panelAddLayout.setBounds(0, 0, 1200, 560);
        btnAdd.add(panelAddLayout);

        lblPropertyName = new JLabel("PROPERTY NAME : ");
        lblPropertyName.setBounds(50, 50, 250, 30);
        lblPropertyName.setHorizontalAlignment(SwingConstants.LEFT);
        lblPropertyName.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblPropertyName);

        txtPropertyName = new JTextField();
        txtPropertyName.setBounds(220, 50, 250, 30);
        panelAddLayout.add(txtPropertyName);

        lblLocation = new JLabel("LOCATION :");
        lblLocation.setBounds(50, 95, 250, 30);
        lblLocation.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblLocation);
    
        lblPrice = new JLabel("Price :");
        lblPrice.setBounds(50, 140, 250, 30);
        lblPrice.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblPrice);
    
        txtLocation = new JTextField();
        txtLocation.setBounds(220, 95, 250, 30);
        panelAddLayout.add(txtLocation);

        txtPrice = new JTextField();
        txtPrice.setBounds(220, 140, 250, 30);
        panelAddLayout.add(txtPrice);

        lblDescription = new JLabel("DESCRIPTION :");
        lblDescription.setBounds(50, 185, 250, 30);
        lblDescription.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblDescription);

        txaDescription = new JTextArea();
        txaDescription.setBounds(50, 215, 500, 300);
        panelAddLayout.add(txaDescription);

        lblImage = new JLabel();
        lblImage.setBounds(650, 100, 500, 300);
        lblImage.setBackground(Color.gray);
        lblImage.setOpaque(true);
        panelAddLayout.add(lblImage);

        btnImage = new JButton("Choose an Image");
        btnImage.setBounds(650, 450, 200, 50);
        panelAddLayout.add(btnImage);

        btnAddImage = new JButton("Add");
        btnAddImage.setBounds(950, 450, 200, 50);
        panelAddLayout.add(btnAddImage);

        btnDel=new JButton("DELETE");
        btnDel.setBounds(650,60,100,25);
        btnDel.setBorder(null);
        btnDel.setBackground(Color.CYAN);
        btnDel.setFocusable(false);
        btnDel.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnDel);
        
        btnUsers=new JButton("USERS");
        btnUsers.setBounds(775,60,100,25);
        btnUsers.setBorder(null);
        btnUsers.setFocusable(false);
        btnUsers.setBackground(Color.CYAN);
        btnUsers.setFocusable(false);
        btnUsers.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnUsers);
        
        btnTransact=new JButton("TRANSACTIONS");
        btnTransact.setBounds(900,60,130,25);
        btnTransact.setBorder(null);
        btnTransact.setFocusable(false);
        btnTransact.setBackground(Color.CYAN);
        btnTransact.setFocusable(false);
        btnTransact.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnTransact);
        
        btnProfile=new JButton("PROFILE");
        btnProfile.setBounds(1055,60,130,25);
        btnProfile.setBorder(null);
        btnProfile.setFocusable(false);
        btnProfile.setBackground(Color.CYAN);
        btnProfile.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnProfile);
        
        panelHeader=new JPanel();
        panelHeader.setBounds(0,0,1200,100);
        panelHeader.setBackground(Color.CYAN);
        add(panelHeader);
        
        jtab = new JTabbedPane();
        jtab.setBounds(0,95,1200,560);
        jtab.setLayout(null);
        jtab.setBackground(Color.PINK);
        add(jtab);
        
        homeJPanel= new JPanel();
        homeJPanel.setBounds(0,0,1200,560);
        jtab.add(homeJPanel);
        
        String[][] data = {{"Abdul", "hello", "blehhh", "poop"},{"hi", "hello", "blehhh", "poop"}};
        String[] tablecolumn = {"Name", "Location", "Price", "Status"};
        tableEstate = new JTable(data, tablecolumn);
        tableEstate.setDefaultEditor(Object.class,null);
        tableEstate.setBounds(0, 0,1200,560);
        tableEstate.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableEstate.getColumnModel().getColumn(0).setPreferredWidth(300);
        tableEstate.getColumnModel().getColumn(1).setPreferredWidth(300);
        tableEstate.getColumnModel().getColumn(2).setPreferredWidth(300);
        tableEstate.getColumnModel().getColumn(3).setPreferredWidth(300);
        tableEstate.setRowHeight(30);

        //homeJPanel.add(tableEstate);
        
        JScrollPane scrollPaneEstate = new JScrollPane(tableEstate);
        scrollPaneEstate.setPreferredSize(new Dimension(1200, 560));
        homeJPanel.add(scrollPaneEstate);
           
        
        panelADD= new JPanel();
        panelADD.setBounds(0,0,1200,560);
        panelADD.setBackground(Color.green);
        jtab.add(panelAddLayout);
        
        
        // user table
        panelUsers= new JPanel();
        panelUsers.setBounds(0,0,1200,560);
        panelUsers.setLayout(null);
        jtab.add(panelUsers);      
        
        panelUsersPanel = new JPanel();
        panelUsersPanel.setBounds(0, 0, 800, 560);
        panelUsers.add(panelUsersPanel);
        
        
        String[][] data2 = {{"Abdul", "hello", "blehhh", "poop"},{"hi", "hello", "blehhh", "poop"}};
        String[] tablecolumn2 = {"Name", "Location", "Price", "Status"};
        tableUser = new JTable(data2, tablecolumn2);
        tableUser.setDefaultEditor(Object.class,null);
        tableUser.setBounds(0, 0,800,560);
        tableUser.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableUser.getColumnModel().getColumn(0).setPreferredWidth(200);
        tableUser.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableUser.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableUser.getColumnModel().getColumn(3).setPreferredWidth(200);
        tableUser.setRowHeight(30);

        panelUsersPanel.add(tableUser);
        
        JScrollPane sp2 = new JScrollPane(tableUser);
        sp2.setPreferredSize(new Dimension(800, 560));
        panelUsersPanel.add(sp2);
        
        // search button to find users
       
        lblUsers = new JLabel("Users");
        lblUsers.setBounds(950, 40, 200, 30);
        lblUsers.setFont(new Font("Arial", Font.BOLD, 30));
        panelUsers.add(lblUsers);
        
        JTextField txtUserSearch = new JTextField();
        txtUserSearch.setBounds(890, 80, 200, 30);
        panelUsers.add(txtUserSearch);
        
        JButton btnUserSearch = new JButton("Search");
        btnUserSearch.setBounds(890, 120, 100, 30);
        panelUsers.add(btnUserSearch);
        
        JButton btnClearUserSearch = new JButton("Clear");
        btnClearUserSearch.setBounds(990, 120, 100, 30);
        panelUsers.add(btnClearUserSearch);
        
        
        // transaction page
        transactJPanel= new JPanel();
        transactJPanel.setBounds(0,0,1200,560);
        transactJPanel.setLayout(null);
      
        jtab.add(transactJPanel);
        
        panelTransaction = new JPanel();
        panelTransaction.setBounds(0, 0, 800, 560);
        transactJPanel.add(panelTransaction);
        
        String[][] transactions = {{"123", "property123", "ClientID", "10/28/2024"}};
        String[] transcationsColumns = {"Transaction ID", "Property ID", "Client ID", "Date"};
        tableTransactions = new JTable(transactions, transcationsColumns);
        tableTransactions.setDefaultEditor(Object.class, null);
        tableTransactions.setBounds(0, 0,800,560);
        tableTransactions.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableTransactions.getColumnModel().getColumn(0).setPreferredWidth(200);
        tableTransactions.getColumnModel().getColumn(1).setPreferredWidth(200);
        tableTransactions.getColumnModel().getColumn(2).setPreferredWidth(200);
        tableTransactions.getColumnModel().getColumn(3).setPreferredWidth(200);
        tableTransactions.setRowHeight(30);
        
        panelTransaction.add(tableTransactions);

        
        JScrollPane scrollPaneTransaction = new JScrollPane(tableTransactions);
        scrollPaneTransaction.setPreferredSize(new Dimension(800, 560));
        panelTransaction.add(scrollPaneTransaction);
        
        JButton btnMarketAnalysis = new JButton("Generate Market Analysis");
        btnMarketAnalysis.setBounds(900, 40, 200, 30);
        transactJPanel.add(btnMarketAnalysis);
        
        JButton btnSalesReport = new JButton("Sales Report");
        btnSalesReport.setBounds(900, 80, 200, 30);
        transactJPanel.add(btnSalesReport);
        
        
        panelProfile= new JPanel();
        panelProfile.setBounds(0,0,1200,560);
        panelProfile.setLayout(null);
        jtab.add(panelProfile);
        
        lblAdminDetails = new JLabel("Admin Profile");
        lblAdminDetails.setBounds(450,160, 500, 30);
        lblAdminDetails.setFont(new Font("Arial", Font.BOLD, 30));
        panelProfile.add(lblAdminDetails);
        
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(480, 200, 200, 30);
        btnChangePassword.setFont(new Font("Arial", Font.BOLD, 15));
        panelProfile.add(btnChangePassword);
        
        btnSignOut = new JButton("Sign Out");
         btnSignOut.setBounds(480, 240, 200, 30);
        btnSignOut.setFont(new Font("Arial", Font.BOLD, 15));
        panelProfile.add(btnSignOut);
        
        btnHome.addActionListener(this);
        btnAdd.addActionListener(this);
        btnUsers.addActionListener(this);
        btnTransact.addActionListener(this);
        btnProfile.addActionListener(this);
        btnImage.addActionListener(this);
        btnAddImage.addActionListener(this);
        btnSignOut.addActionListener(this);
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==btnHome){
            jtab.setSelectedIndex(0);
        }else if(e.getSource()==btnAdd){
            jtab.setSelectedIndex(1);
        }else if(e.getSource()==btnUsers){
            jtab.setSelectedIndex(2);
        }else if(e.getSource()==btnTransact){
            jtab.setSelectedIndex(3);
        }else if(e.getSource()==btnProfile){
            jtab.setSelectedIndex(4);
        }else if (e.getSource() == btnImage) {
                jfcImage.setCurrentDirectory(new File("user.dir"));
                FileNameExtensionFilter fneFilter = new FileNameExtensionFilter("Images", "jpg", "png");
                jfcImage.addChoosableFileFilter(fneFilter);
                int res = jfcImage.showOpenDialog(null);

              if (res == JFileChooser.APPROVE_OPTION) {
                    File fSelect = jfcImage.getSelectedFile();
                    String fDirectory = fSelect.getAbsolutePath();
                    ImageIcon path = new ImageIcon(fDirectory);
                    Image img = path.getImage();
                    Image newImg = img.getScaledInstance(500, 300, Image.SCALE_SMOOTH);
                    ImageIcon image = new ImageIcon(newImg);
                    lblImage.setIcon(image);
               }
        } else if (e.getSource() == btnAddImage) {

            lblImage.setIcon(null);

        } else if(e.getSource() == btnSignOut) {
            int response = JOptionPane.showConfirmDialog(this, "You are signing out\nClick ok to proceed","Sign out",JOptionPane.OK_CANCEL_OPTION);
            if(response == JOptionPane.OK_OPTION) {
                // pupunta sa home page
//                  dispose();
//                  welcomePage frame = new welcomePage();
//                  frame.setVisible(true);
            } 
        } else if(e.getSource() == btnChangePassword) {
            dispose();
//            changePassword frame = new changePassword();
//            frame.setVisible(true);
        }
       
    }
   
}