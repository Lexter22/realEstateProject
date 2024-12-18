/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

/**
 *
 * @author Admin_2025
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ClientInterface extends JFrame implements ActionListener, MouseListener {

  private JPanel  panelHeader, panelItems, panelItemsPanel, panelAccount, panelAccountPanel;
  private JLabel logo, lblRichfields, lblRealEstates, lblUName, lblInputUName, lblCDetails , lblCID, lblInputCID, lblEmail, lblInputEmail, lblCNumber, lblInputCNumber, lblpreviewImg,imgPreviewImage;
  private JButton btnViewOwned, btnView,btnReset, btnAccHome, btnSearch, btnItems, btnLogout;
  private JComboBox jcbLocation, jcbPrice, jcbHtL;
  private JTabbedPane jtab;
  private JTable itemTable, accTable;
  private Object[][] houses = {} , ownedHouses = {};
  private ImageIcon searchIc, resetIc, accountIc, homeIc, moreInfoIc, finalSearchIc, finalResetIc, finalAccountIc, finalHomeIc, finalMoreInfoIc, logoIC, finalLogoIC;
  private String[] columnNames = { "Location","Price", "ID", "Status" };
  private String Location[] = {"Location", "San Pedro", "Santa Rosa", "Binan" };
  private String Price[] = { "Price Range", "$1", "$10,000,001 - $50,000,000", "$50,000,001 - $100,000,000" };
  private String HtL[] = {"Default","High - Low", "Low - High" };
  private DefaultTableModel itemTModel, accTModel;
  private JTable itemT;
  private Color cGreen = (Color.decode("#28A745"));
  private Color cBlue = (Color.decode("#004A8C")); 
  private Connection con;
  private Statement st;
  private PreparedStatement pst;
  private ResultSet rs;
  private String inheret, username, fname, lname, userNum, userEmail, houseLocation, houseName, houseDescription, houseStatus;
  private int userId, houseId, housePrice;

  public ClientInterface(String username) {
     
     Connect();

    setSize(1200, 700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    
    logoIC = new ImageIcon("logoRealEstates.png");
    finalLogoIC = new ImageIcon(logoIC.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    logo = new JLabel(finalLogoIC);
    logo.setBounds(10, 10, 80, 80);
    add(logo);

    lblRichfields = new JLabel("RICHFIELD");
    lblRichfields.setBounds(120, 10, 350, 50);
    lblRichfields.setForeground(Color.white);
    lblRichfields.setFont(new Font("Arial", Font.BOLD, 25));
    add(lblRichfields);

    lblRealEstates = new JLabel("REAL ESTATES");
    lblRealEstates.setBounds(120, 40, 300, 50);
    lblRealEstates.setForeground(Color.white);
    lblRealEstates.setFont(new Font("Arial", Font.BOLD, 15));
    add(lblRealEstates);

    jcbLocation = new JComboBox(Location);
    jcbLocation.setBounds(490, 60, 150, 25);
    add(jcbLocation);

    jcbPrice = new JComboBox(Price);
    jcbPrice.setBounds(660, 60, 150, 25);
    add(jcbPrice);

    jcbHtL = new JComboBox(HtL);
    jcbHtL.setBounds(830, 60, 150, 25);
    add(jcbHtL);

    searchIc = new ImageIcon("searchIcon.png");
    finalSearchIc = new ImageIcon(searchIc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    
    btnSearch = new JButton();
    btnSearch.setIcon(finalSearchIc);
    btnSearch.setBounds(1050, 60, 30, 30);
    btnSearch.setBorder(null);
    btnSearch.setBackground(cBlue);
    btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
    add(btnSearch);
    
    resetIc = new ImageIcon("resetIcon.png");
    finalResetIc = new ImageIcon(resetIc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

    btnReset = new JButton();
    btnReset.setIcon(finalResetIc);
    btnReset.setBorder(null);
    btnReset.setBackground(cBlue);
    btnReset.setBounds(1100, 60, 30, 30);
    add(btnReset);
    
    accountIc = new ImageIcon("accountIcon.png");
    finalAccountIc = new ImageIcon(accountIc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
    
    homeIc = new ImageIcon("homeIcon.png");
    finalHomeIc = new ImageIcon(homeIc.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));

    btnAccHome = new JButton();
    btnAccHome.setBorder(null);
    btnAccHome.setIcon(finalAccountIc);
    btnAccHome.setBackground(cBlue);
    btnAccHome.setBounds(1150, 60, 30, 30);
    add(btnAccHome);

    panelHeader = new JPanel();
    panelHeader.setBounds(0, 0, 1200, 100);
    panelHeader.setBackground(cBlue);
    add(panelHeader);

    jtab = new JTabbedPane();
    jtab.setBounds(0, 100, 1200, 560);
    jtab.setLayout(null);
    add(jtab);

    panelItems = new JPanel();
    panelItems.setBounds(0, 0, 1200, 560);
    panelItems.setLayout(null);
    jtab.add(panelItems);
    
    panelItemsPanel = new JPanel();
    panelItemsPanel.setBounds(0, 0, 800, 560);
    panelItems.add(panelItemsPanel);

    Object[][] houses = {};
    String[] tablecolumn = {"ID","Property Name", "Location", "Price", "Status"};
        
    itemTModel = new DefaultTableModel(houses, tablecolumn);
    itemT = new JTable(itemTModel);
    itemT.setDefaultEditor(Object.class, null);
    itemT.setRowHeight(30);
    itemT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    itemT.setBounds(0,0,800,560);
    
          String UsersInfo = "Select firstname, lastname, id, contactnum, email From clientsinfo where username=? ";
          String HousesData = "Select * from residentialrealestates";
      try {
          
          st = con.createStatement();
          ResultSet rsHouses = st.executeQuery(HousesData);
           
            while(rsHouses.next()){
                 houseId = rsHouses.getInt("id");
                 houseName = rsHouses.getString("name");
                 houseLocation = rsHouses.getString("location");
                 housePrice = rsHouses.getInt("price");
                 houseDescription = rsHouses.getString("description");
                 houseStatus = rsHouses.getString("status");
                 
                 Object [] dataSql={houseId, houseName, houseLocation, housePrice, houseStatus};
                 itemTModel.addRow(dataSql);
                 
            }
            pst = con.prepareStatement(UsersInfo);
            pst.setString(1, username);
            rs = pst.executeQuery();
            while(rs.next()){
                 fname = rs.getString("firstname");
                 lname = rs.getString("lastname");
                 userId = rs.getInt("id");
                 userNum = rs.getString("contactnum");
                 userEmail = rs.getString("email");
            }
      } catch (SQLException ex) {
          Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        JScrollPane scrollPaneEstate = new JScrollPane(itemT);
        scrollPaneEstate.setPreferredSize(new Dimension(800, 560));
        panelItemsPanel.add(scrollPaneEstate);
           
        lblpreviewImg = new JLabel("IMAGE PREVIEW");
        lblpreviewImg.setBounds(820, 20, 360, 30);
        lblpreviewImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblpreviewImg.setFont(new Font("Arial", Font.BOLD, 15));
        panelItems.add(lblpreviewImg);
        
        btnView = new JButton("View Details");
        btnView.setBounds(810, 470, 350, 35);
        btnView.setBackground(cGreen);
        btnView.setForeground(Color.white);
        panelItems.add(btnView);
        
        imgPreviewImage = new JLabel();
        imgPreviewImage.setBounds(810, 60, 350, 280);
        imgPreviewImage.setBorder(BorderFactory.createLineBorder(Color.black));
        panelItems.add(imgPreviewImage);
        
        panelAccount = new JPanel();
        panelAccount.setBounds(0, 0, 1200, 560);
        panelAccount.setLayout(null);
        jtab.add(panelAccount);
    
        panelAccountPanel = new JPanel();
        panelAccountPanel.setBounds(0, 0, 800, 560);
        panelAccount.add(panelAccountPanel);

        lblCDetails= new JLabel("Properties Owned");
        lblCDetails.setHorizontalAlignment(SwingConstants.CENTER);
        lblCDetails.setBounds(0,20,800,50);
        lblCDetails.setFont(new Font("Arial", Font.BOLD, 25));
        panelAccountPanel.add(lblCDetails);
        
        accTModel = new DefaultTableModel(ownedHouses, columnNames);
        accTable = new JTable(accTModel);
        accTable.setDefaultEditor(Object.class, null);
        accTable.setRowHeight(30);
        accTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        JScrollPane sp2 = new JScrollPane(accTable);
        sp2.setPreferredSize(new Dimension(800, 560));
        panelAccountPanel.add(sp2);
    
        lblCDetails = new JLabel("Your information");
        lblCDetails.setBounds(900, 20, 200, 30);
        lblCDetails.setFont(new Font("Arial", Font.BOLD, 25));
        panelAccount.add(lblCDetails);
        
        lblUName=new JLabel("Name : " + fname +" " + lname);
        lblUName.setBounds(810,50,300,50);
        lblUName.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblUName);

        lblCID=new JLabel("ID :       "+ userId);
        lblCID.setHorizontalAlignment(SwingConstants.LEFT);
        lblCID.setBounds(810,80,300,50);
        lblCID.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblCID);

        lblEmail=new JLabel("Email :  "+userEmail);
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setBounds(810,110,300,50);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblEmail);

        lblCNumber=new JLabel("No.     : "+userNum);
        lblCNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lblCNumber.setBounds(810,140,300,50);
        lblCNumber.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblCNumber);
        
        JLabel lblUserPreview =new JLabel("IMAGE PREVIEW");
        lblUserPreview.setBounds(810,160,390,50);
        lblUserPreview.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserPreview.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblUserPreview);

        JLabel lblUserImage = new JLabel();
        lblUserImage.setBounds(810, 200, 350, 250);
        lblUserImage.setBorder(BorderFactory.createLineBorder(Color.black));
        lblUserImage.setBackground(Color.red);
        panelAccount.add(lblUserImage);
        
        btnViewOwned = new JButton("View Details");
        btnViewOwned.setBounds(810, 470, 350, 35);
        btnViewOwned.setBackground(cGreen);
        btnViewOwned.setForeground(Color.white);
        panelAccount.add(btnViewOwned);
        
        btnLogout = new JButton("Log Out");
        btnLogout.setBounds(810, 510, 350, 35);
        btnLogout.setBackground(cGreen);
        btnLogout.setForeground(Color.white);
        panelAccount.add(btnLogout);
    
        btnReset.addActionListener(this);
        btnAccHome.addActionListener(this);
        btnSearch.addActionListener(this);
        btnView.addActionListener(this);
        btnViewOwned.addActionListener(this);
        btnLogout.addActionListener(this);
        jcbLocation.addActionListener(this);
        jcbPrice.addActionListener(this);
        jcbHtL.addActionListener(this);
        itemT.addMouseListener(this);
        accTable.addMouseListener(this);

        setVisible(true);
        
        inheret = username;
        System.out.println("ClientInterface " + inheret);
      }
  
     public void Connect(){
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
  
    @Override
      public void mouseClicked(MouseEvent e) {
      if(e.getSource()==itemT){
  
        }else if(e.getSource()==accTable){
    
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
       }

      @Override
      public void mouseReleased(MouseEvent e) {
       }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
       }
  
    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == btnAccHome) {
        int currentIndex = jtab.getSelectedIndex();
        if (currentIndex == 0) {
          jtab.setSelectedIndex(1);
          btnAccHome.setIcon(finalHomeIc);
        } else {
          btnAccHome.setIcon(finalAccountIc);
          jtab.setSelectedIndex(0);
        }
      }else if(e.getSource()== btnReset){
          jcbLocation.setSelectedIndex(0);
          jcbPrice.setSelectedIndex(0);
          jcbHtL.setSelectedIndex(0);
      }
      else if (e.getSource()== btnView) {
        int selectedRowItem = itemT.getSelectedRow();
          if (selectedRowItem != -1) {
              String id = String.valueOf(itemT.getValueAt(selectedRowItem, 0)); 
              String name =String.valueOf(itemT.getValueAt(selectedRowItem, 1)); 
              String location = String.valueOf(itemT.getValueAt(selectedRowItem, 2));
              String price =String.valueOf(itemT.getValueAt(selectedRowItem, 3)); 
              String status = String.valueOf(itemT.getValueAt(selectedRowItem, 4)); 
              new moreInfo(id, name, location, price, status, inheret, fname, lname, userId, userNum, userEmail).setVisible(true);

              dispose();
        }else{
               JOptionPane.showMessageDialog(null, "Please Select a row");
           }
      }else if (e.getSource()== btnViewOwned) {
         int selectedRowAccItem = accTable.getSelectedRow();
           if(selectedRowAccItem != -1) {
              String location = (String) accTable.getValueAt(selectedRowAccItem, 0); 
               String id = (String) accTable.getValueAt(selectedRowAccItem, 1); 
              String price = (String) accTable.getValueAt(selectedRowAccItem, 2); 
              String status = (String) accTable.getValueAt(selectedRowAccItem, 3);

              new transactInfo().setVisible(true);
              dispose();
        }else{
               JOptionPane.showMessageDialog(null, "Please Select a row");
           }
      }

      else if(e.getSource()==btnSearch){       
            JOptionPane.showMessageDialog(null, "Binary Search");
      }else if(e.getSource()==btnLogout){
          
          int response = JOptionPane.showConfirmDialog(null, "You are signing out \nClick OK to proceed","Sign Out",JOptionPane.OK_CANCEL_OPTION);
          
             if(response==JOptionPane.OK_OPTION){
              JOptionPane.showMessageDialog(null, "Signed Out");
              dispose();
              new welcomePage().setVisible(true);
          }

      }

    }
}