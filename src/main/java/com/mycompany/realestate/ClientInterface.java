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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

public class ClientInterface extends JFrame implements ActionListener, MouseListener {

  private JPanel  panelHeader, panelItems, panelItemsPanel, panelAccount, panelAccountPanel;
  private JLabel lblUserImage, logo, lblRichfields, lblRealEstates, lblUName, lblInputUName, lblCDetails , lblCID, lblInputCID, lblEmail, lblInputEmail, lblCNumber, lblInputCNumber, lblpreviewImg,imgPreviewImage;
  private JButton btnViewOwned, btnView,btnReset, btnAccHome, btnSearch, btnItems, btnLogout;
  private JComboBox jcbLocation, jcbPrice;
  private JTabbedPane jtab;
  private JTable itemTable, accTable;
  private Object[][] houses = {} , ownedHouses = {};
  private ImageIcon finalPreviewImageOwned, searchIc, resetIc, accountIc, homeIc, moreInfoIc, finalSearchIc, finalResetIc, finalAccountIc, finalHomeIc, finalMoreInfoIc, logoIC, finalLogoIC, previewImage, finalPreviewImage;
  private String[] columnNames = { "ID","Name","Location", "Price", "Status" };
  private String Location[] = {"Location", "San Pedro", "Santa Rosa", "Binan" };
  private String Price[] = { "Price Range", "₱100M - ₱200M", "₱201M - ₱400M","₱401M - ₱600M", "₱601M - ₱800M", "₱801M - ₱1B" };
  private DefaultTableModel itemTModel, accTModel;
  private JTable itemT;
  private Color cGreen = (Color.decode("#28A745"));
  private Color cBlue = (Color.decode("#004A8C")); 
  private Connection con;
  private Statement st;
  private PreparedStatement pst;
  private ResultSet rs;
  private String newDescription, houseId, housePrice, userId, inheret, username, fname, lname, userNum, userEmail, houseLocation, houseName, houseDescription, houseStatus, ownedLocation, ownedId, ownedPrice, ownedName;
  private ArrayList<Object[]> arrayList;
  
  public ClientInterface(String username) {
     
    Connect();
    
    arrayList = new ArrayList<>();
    
    setSize(1200, 700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    
    logoIC = new ImageIcon("logoRealEstates.png");
    finalLogoIC = new ImageIcon(logoIC.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

    logo = new JLabel(finalLogoIC);
    logo.setBounds(10, 10, 80, 80);
    add(logo);

    lblRichfields = new JLabel("RICHFIELD REAL ESTATES");
    lblRichfields.setBounds(120, 10, 350, 50);
    lblRichfields.setForeground(Color.white);
    lblRichfields.setFont(new Font("Arial", Font.BOLD, 25));
    add(lblRichfields);

    lblRealEstates = new JLabel("RESIDENTIALS");
    lblRealEstates.setBounds(320, 50, 350, 50);
    lblRealEstates.setHorizontalAlignment(SwingConstants.CENTER);
    lblRealEstates.setForeground(Color.white);
    lblRealEstates.setFont(new Font("Arial", Font.BOLD, 15));
    add(lblRealEstates);

    jcbLocation = new JComboBox(Location);
    jcbLocation.setBounds(700, 60, 150, 25);
    add(jcbLocation);

    jcbPrice = new JComboBox(Price);
    jcbPrice.setBounds(880, 60, 150, 25);
    add(jcbPrice);
   
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
    panelItemsPanel.setBounds(10, 10, 800, 530);
    panelItems.add(panelItemsPanel);

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
                 houseId = rsHouses.getString("id");
                 houseName = rsHouses.getString("name");
                 houseLocation = rsHouses.getString("location");
                 housePrice = rsHouses.getString("price");
                 houseDescription = rsHouses.getString("description");
                 houseStatus = rsHouses.getString("status");
                 
                 String[] dataSql={houseId, houseName, houseLocation, housePrice, houseStatus};
                 arrayList.add(dataSql);
                 itemTModel.addRow(dataSql);
                 
            }
            pst = con.prepareStatement(UsersInfo);
            pst.setString(1, username);
            rs = pst.executeQuery();
            while(rs.next()){
                 fname = rs.getString("firstname");
                 lname = rs.getString("lastname");
                 userId = rs.getString("id");
                 userNum = rs.getString("contactnum");
                 userEmail = rs.getString("email");
            }
      } catch (SQLException ex) {
          Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        JScrollPane scrollPaneEstate = new JScrollPane(itemT);
        scrollPaneEstate.setPreferredSize(new Dimension(800, 520));
        panelItemsPanel.add(scrollPaneEstate);
           
        lblpreviewImg = new JLabel("IMAGE PREVIEW");
        lblpreviewImg.setBounds(800,10,390,30);
        lblpreviewImg.setHorizontalAlignment(SwingConstants.CENTER);
        lblpreviewImg.setFont(new Font("Arial", Font.BOLD, 15));
        panelItems.add(lblpreviewImg);
        
        btnView = new JButton("View Details");
        btnView.setBounds(815, 430, 350, 35);
        btnView.setBackground(cGreen);
        btnView.setForeground(Color.white);
        panelItems.add(btnView);
        
        imgPreviewImage = new JLabel();
        imgPreviewImage.setBounds(820, 50, 350, 280);
        imgPreviewImage.setBorder(BorderFactory.createLineBorder(Color.black));
        panelItems.add(imgPreviewImage);
        
        panelAccount = new JPanel();
        panelAccount.setBounds(0, 0, 1200, 560);
        panelAccount.setLayout(null);
        jtab.add(panelAccount);
    
        panelAccountPanel = new JPanel();
        panelAccountPanel.setBounds(10, 10, 790, 530);
        panelAccount.add(panelAccountPanel);

        accTModel = new DefaultTableModel(ownedHouses, columnNames);
        accTable = new JTable(accTModel);
        accTable.setDefaultEditor(Object.class, null);
        accTable.setRowHeight(30);
        accTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        JScrollPane sp2 = new JScrollPane(accTable);
        sp2.setPreferredSize(new Dimension(780, 530));
        panelAccountPanel.add(sp2);
    
        propertiesOwned();
        
        lblCDetails = new JLabel("Your information");
        lblCDetails.setBounds(900, 20, 200, 30);
        lblCDetails.setFont(new Font("Arial", Font.BOLD, 25));
        panelAccount.add(lblCDetails);
        
        lblUName=new JLabel("Name : " + fname +" " + lname);
        lblUName.setBounds(810,50,300,50);
        lblUName.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblUName);

        lblCID=new JLabel("ID       : "+ userId);
        lblCID.setHorizontalAlignment(SwingConstants.LEFT);
        lblCID.setBounds(810,80,300,50);
        lblCID.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblCID);

        lblEmail=new JLabel("Email : "+userEmail);
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setBounds(810,110,350,50);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblEmail);

        lblCNumber=new JLabel("No.     : "+userNum);
        lblCNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lblCNumber.setBounds(810,140,300,50);
        lblCNumber.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblCNumber);
        
        JLabel lblUserPreview =new JLabel("IMAGE PREVIEW");
        lblUserPreview.setBounds(800,160,390,50);
        lblUserPreview.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserPreview.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblUserPreview);

        lblUserImage = new JLabel();
        lblUserImage.setBounds(815, 200, 350, 250);
        lblUserImage.setBorder(BorderFactory.createLineBorder(Color.black));
        lblUserImage.setBackground(Color.red);
        panelAccount.add(lblUserImage);
        
        btnViewOwned = new JButton("View Details");
        btnViewOwned.setBounds(815, 470, 350, 35);
        btnViewOwned.setBackground(cGreen);
        btnViewOwned.setForeground(Color.white);
        panelAccount.add(btnViewOwned);
        
        btnLogout = new JButton("Log Out");
        btnLogout.setBounds(815, 510, 350, 35);
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
        itemT.addMouseListener(this);
        accTable.addMouseListener(this);

        setVisible(true);
        inheret = username;
        
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
  
        int selectedrows = itemT.getSelectedRow();
        if(selectedrows != -1){
            String id = String.valueOf(itemTModel.getValueAt(selectedrows, 0));
            displayImage(id);
        }
      }else if(e.getSource()==accTable){
          int selectedrowss = accTable.getSelectedRow();
        if(selectedrowss != -1){
            String id = String.valueOf(accTModel.getValueAt(selectedrowss, 0));
            displayImageOwned(id);
        }
      }
      }

      @Override
      public void mousePressed(MouseEvent e) {}

      @Override
      public void mouseReleased(MouseEvent e) {}

      @Override
      public void mouseEntered(MouseEvent e) {}

      @Override
      public void mouseExited(MouseEvent e) {}
      
      public void displayImage(String id){
          
        try {
            String image = "select img from residentialrealestates where id = ?";
            
            pst = con.prepareStatement(image);
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                Blob images = rs.getBlob("img");
                InputStream isImage = images.getBinaryStream();
                Image ioImage = ImageIO.read(isImage);
                previewImage = new ImageIcon(ioImage);
                finalPreviewImage = new ImageIcon(previewImage.getImage().getScaledInstance(350,280, Image.SCALE_SMOOTH));
                imgPreviewImage.setIcon(finalPreviewImage);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Remove The Code Below this JOption Para di makita SQLEXCEPTION");
            JOptionPane.showMessageDialog(null, "DAPAT ITO LANG LALABAS HAHAHA");
            JOptionPane.showMessageDialog(null, "Please Wait for the Preview Image");
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Remove The Code Below this JOption Para di makita IOEXCEPTION");
            JOptionPane.showMessageDialog(null, "DAPAT ITO LANG LALABAS HAHAHA");
            JOptionPane.showMessageDialog(null, "Please Wait for the Preview Image");
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      public void displayImageOwned(String id){
          
        try {
            String image = "select img from propertiesowned where propertyID = ?";
            
            pst = con.prepareStatement(image);
            pst.setString(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                
                Blob images = rs.getBlob("img");
                InputStream isImage = images.getBinaryStream();
                Image ioImage = ImageIO.read(isImage);
                ImageIcon previewImageOwned = new ImageIcon(ioImage);
                finalPreviewImageOwned = new ImageIcon(previewImageOwned.getImage().getScaledInstance(350,280, Image.SCALE_SMOOTH));
                lblUserImage.setIcon(finalPreviewImageOwned);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Remove The Code Below this JOption Para di makita SQLEXCEPTION");
            JOptionPane.showMessageDialog(null, "DAPAT ITO LANG LALABAS HAHAHA");
            JOptionPane.showMessageDialog(null, "Please Wait for the Preview Image");
            Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Remove The Code Below this JOption Para di makita IOEXCEPTION");
            JOptionPane.showMessageDialog(null, "DAPAT ITO LANG LALABAS HAHAHA");
            JOptionPane.showMessageDialog(null, "Please Wait for the Preview Image");
            Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
//      public void newDescription
      
      public void propertiesOwned() {
          
          String owned = "SELECT * FROM propertiesowned WHERE usersId = ?";
      try {
          
          PreparedStatement ps = con.prepareStatement(owned);
          ps.setString(1, userId);
          rs = ps.executeQuery();
          while (rs.next()) {
              
              ownedId = rs.getString("propertyid");
              ownedName = rs.getString("propertyName");
              ownedLocation = rs.getString("propertyLocation");
              ownedPrice = rs .getString("propertyprice");
              
              String ownedStatus = "Owned";
              
              Object [] dataSql = {ownedId, ownedName, ownedLocation, ownedPrice, ownedStatus};
              
              accTModel.addRow(dataSql);
                 
          }
      } 
      
      catch (SQLException ex) {
          Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
      }
          
      }
  
    @Override
    public void actionPerformed(ActionEvent e) {

      if (e.getSource() == btnAccHome) {
        int currentIndex = jtab.getSelectedIndex();
        if (currentIndex == 0) {
          jtab.setSelectedIndex(1);
          lblRealEstates.setText("PROPERTIES OWNED");
          btnAccHome.setIcon(finalHomeIc);
        } else {
          btnAccHome.setIcon(finalAccountIc);
          jtab.setSelectedIndex(0);
          lblRealEstates.setText("RESIDENTIALS");
        }
      }else if(e.getSource()== btnReset){
          jcbLocation.setSelectedIndex(0);
          jcbPrice.setSelectedIndex(0);
          
            String jcbLocValue = jcbLocation.getSelectedItem().toString();
            Object jcbPriceValue = jcbPrice.getSelectedItem();
            
            //Reset Image Preview
    ImageIcon none = new ImageIcon("");
    imgPreviewImage.setIcon(none);
    
          String[] arrs = new String[arrayList.size()];
          itemTModel.setRowCount(0);
            for (int i = 0; i < arrayList.size(); i++) {
            arrs[i] = (String) arrayList.get(i)[2]; 
            }
            Arrays.sort(arrs);
            int bts = Arrays.binarySearch(arrs, jcbLocValue);
            if(jcbLocValue.equals("Location")){
                 for(int i=0; i<arrayList.size(); i++){
                     itemTModel.addRow(arrayList.get(i));
                 }
            }
      }
      else if (e.getSource()== btnView) {
        int selectedRowItem = itemT.getSelectedRow();
          if (selectedRowItem != -1) {
              String id = String.valueOf(itemT.getValueAt(selectedRowItem, 0)); 
              String name =String.valueOf(itemT.getValueAt(selectedRowItem, 1)); 
              String location = String.valueOf(itemT.getValueAt(selectedRowItem, 2));
              String price =String.valueOf(itemT.getValueAt(selectedRowItem, 3)); 
              String status = String.valueOf(itemT.getValueAt(selectedRowItem, 4)); 
              
              String descriptionSql = "Select description From residentialrealestates where id=? ";
              
             try {
                 pst= con.prepareStatement(descriptionSql);
                 pst.setString(1, id);
                 rs = pst.executeQuery();
                 while(rs.next()){
                     newDescription = rs.getString("description");
                 }
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
             }
              
              new moreInfo(id, name, location, price, status, newDescription, inheret, fname, lname, userId, userNum, userEmail, finalPreviewImage).setVisible(true);

              dispose();
        }else{
               JOptionPane.showMessageDialog(null, "Please Select a row");
           }
      }else if (e.getSource()== btnViewOwned) {
         int selectedRowAccItem = accTable.getSelectedRow();
           if(selectedRowAccItem != -1) {
              String id = String.valueOf(accTable.getValueAt(selectedRowAccItem, 0)); 
              String name =String.valueOf(accTable.getValueAt(selectedRowAccItem, 1)); 
              String location = String.valueOf(accTable.getValueAt(selectedRowAccItem, 2));
              String price =String.valueOf(accTable.getValueAt(selectedRowAccItem, 3)); 
              String status = String.valueOf(accTable.getValueAt(selectedRowAccItem, 4)); 
              
              String descriptionSql = "Select description From propertiesowned where id=? ";
              
             try {
                 pst= con.prepareStatement(descriptionSql);
                 pst.setString(1, id);
                 rs = pst.executeQuery();
                 while(rs.next()){
                     newDescription = rs.getString("description");
                 }
                 
             } catch (SQLException ex) {
                 Logger.getLogger(ClientInterface.class.getName()).log(Level.SEVERE, null, ex);
             }
              
              new transactInfo(id, name, location, price, status, newDescription, inheret, fname, lname, userId, userNum, userEmail, finalPreviewImageOwned).setVisible(true);
              dispose();
        }else{
               JOptionPane.showMessageDialog(null, "Please Select a row");
           }
      }
      //For Binary Search
 else if (e.getSource() == btnSearch) {
    
    String jcbLocValue = (String) jcbLocation.getSelectedItem();
    int jcbPriceValue = jcbPrice.getSelectedIndex();
    
    //Reset All Elements in the table
    itemTModel.setRowCount(0);
    
    //Reset Image Preview
    ImageIcon none = new ImageIcon("");
    imgPreviewImage.setIcon(none);
    
    int minPrice = 0;
    int maxPrice = Integer.MAX_VALUE;

    switch (jcbPriceValue) {
        case 1:
            minPrice = 100000000;
            maxPrice = 200000000;
            break;
        case 2:
            minPrice = 200000001;
            maxPrice = 400000000;
            break;
        case 3:
            minPrice = 400000001;
            maxPrice = 600000000;
            break;
        case 4:
            minPrice = 600000001;
            maxPrice = 800000000;
            break;
        case 5:
            minPrice = 800000001;
            maxPrice = Integer.MAX_VALUE;
            break;
        default:
            break; 
    }

    boolean resultsNotFound = true;

    ArrayList<Integer> prices = new ArrayList<>();
    
    for (Object[] house : arrayList) {
        int itemPrice = Integer.parseInt(((String) house[3]).replaceAll("[^0-9]", ""));
        prices.add(itemPrice);
    }
    
    Integer[] pricesArray = prices.toArray(new Integer[0]);
    Arrays.sort(pricesArray);

    for (Object[] house : arrayList) {
        int itemPrice = Integer.parseInt(((String) house[3]).replaceAll("[^0-9]", ""));
        String itemLocation = (String) house[2]; 
        
        boolean locationMatches = jcbLocValue.equals("Location") || itemLocation.equals(jcbLocValue);
        boolean priceMatches = (itemPrice >= minPrice && itemPrice <= maxPrice);
        
        if (locationMatches && priceMatches) {
            int index = Arrays.binarySearch(pricesArray, itemPrice);
            
            if (index >= 0) { 
                itemTModel.addRow(house);
                resultsNotFound = false; 
            }
        }
    }
    if (resultsNotFound) {
        JOptionPane.showMessageDialog(null, "No residential available");
    }
}
      else if(e.getSource()==btnLogout){
          
          int response = JOptionPane.showConfirmDialog(null, "You are signing out \nClick OK to proceed","Sign Out",JOptionPane.OK_CANCEL_OPTION);
          
             if(response==JOptionPane.OK_OPTION){
              JOptionPane.showMessageDialog(null, "Signed Out");
              dispose();
              new welcomePage().setVisible(true);
          }
      }
    }
    public static void main(String[] args) {
        String username = "jhommm";
        new ClientInterface(username);
    }
}
