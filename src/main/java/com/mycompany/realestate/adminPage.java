package com.mycompany.realestate;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.ArrayList;
public class adminPage extends JFrame implements ActionListener, MouseListener{

    private JPanel bargraphPanel, barGraphPanel, panelUpdateLayout, panelHeader, panelUsers, panelADD, panelDelete, panelProfile, transactJPanel, homeJPanel,panelAddLayout,panelHome,panelTransaction,panelUsersPanel; 
    private JLabel lblUpdate, lblImageUpdate, lblRichField, lblRealEstates,lblPropertyName,lblLocation,lblPrice,lblDescription,lblImage,lblAdminDetails,lblUsers, previewImg, lblLogo,lblTotalSalesContents,lblPropertiesSoldContents,lblDailySalesContents;
    private JButton btnUpdateData,btnImageUpdate, btnHome, btnAdd, btnDel, btnTransact, btnUsers,btnDetails, btnProfile,btnImage,btnAddImage,btnChangePassword,btnSignOut,btnUserSearch,btnUpdate,btnClearUserSearch,btnOverall,btnBinan,btnSantaRosa,btnSanPedro;
    private JTabbedPane jtab;
    private JTable tableMarket, tableEstate, tableUser,tableTransactions;
    private JScrollPane estates;
    private JTextField txtPropertyName,txtLocation,txtPrice,txtUpdatePropertyName, txtUpdateLocation, txtUpdatePrice,txtClientSearch;
    private JTextArea txaDescription, txaUpdateDescription;
    private ImageIcon accountIc, homeIc, finalAccountIc, finalHomeIc, clientIc, finalClientIc, transIc, finalTransIc, previewImage, finalPreviewImage;
    private DefaultTableModel tableModelMarket, tableEstateModel, tableUserModel, tableTransactionModel,tbModel,searchedClient;
    private JFileChooser jfcImage = new JFileChooser();
    private Color cGreen = (Color.decode("#28A745"));
    private Color cBlue = (Color.decode("#004A8C")); 
    private ImageIcon logoIc, finalLogoIc, finalHousePicture;
    private Connection con;
    private Statement st;
    private PreparedStatement pst;
    private ResultSet rs;
    private String[] marketRows;
    private String clientId, houseUpdateId, houseLocation, houseName, houseDescription, houseDetailsDescription , houseStatus, houseId;
    private int housePrice;
    private String updateImagePath, imagePath;
    private int selectedrows = -1;
    private String userID,firstName,lastName,username,contactNum,email,password;
    private JButton btnClientDetails;
    private Map<String,String[]> clientsMap = new HashMap(); // hashmap
                       // since naka array yung mga clientsData kaya naka arra yan

    public adminPage() {
        Connect();
  
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        clientsMap = new HashMap<>();
        searchedClient = new DefaultTableModel();
        
        logoIc = new ImageIcon("logoRealEstates.png");
        finalLogoIc = new ImageIcon(logoIc.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(finalLogoIc);
        lblLogo.setBounds(10, 10, 80, 80);
        add(lblLogo);
        
        
        lblRichField=new JLabel("RICHFIELD");
        lblRichField.setBounds(120,10,350,50);
        lblRichField.setForeground(Color.WHITE);
        lblRichField.setFont(new Font("Arial", Font.BOLD, 25));
        add(lblRichField);
        
        lblRealEstates=new JLabel("REAL ESTATES");
        lblRealEstates.setBounds(120,40,300,50);
        lblRealEstates.setForeground(Color.WHITE);
        lblRealEstates.setFont(new Font("Arial", Font.BOLD, 15));
        add(lblRealEstates);
        
        accountIc = new ImageIcon("infoIcon.png");
        finalAccountIc = new ImageIcon(accountIc.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));

        homeIc = new ImageIcon("homeIcon.png");
        finalHomeIc = new ImageIcon(homeIc.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        
        btnHome=new JButton();
        btnHome.setBounds(1150,60,30,30);
        btnHome.setBorder(null);
        btnHome.setBackground(cBlue);
        btnHome.setIcon(finalAccountIc);
        btnHome.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnHome);
        
        panelAddLayout = new JPanel();
        panelAddLayout.setLayout(null);
        panelAddLayout.setBounds(0, 0, 1200, 560);
        add(panelAddLayout);

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
        
        clientIc = new ImageIcon("accountIcon.png");
        finalClientIc = new ImageIcon(clientIc.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        
        btnUsers=new JButton();
        btnUsers.setBounds(1100, 60, 30, 30);
        btnUsers.setBorder(null);
        btnUsers.setFocusable(false);
        btnUsers.setBackground(cBlue);
        btnUsers.setIcon(finalClientIc);
        btnUsers.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnUsers);
        
        transIc = new ImageIcon("transIcon.png");
        finalTransIc = new ImageIcon(transIc.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH));
        
        btnTransact=new JButton();
        btnTransact.setBounds(1050, 60, 30, 30);
        btnTransact.setBorder(null);
        btnTransact.setFocusable(false);
        btnTransact.setBackground(cBlue);
        btnTransact.setIcon(finalTransIc);
        btnTransact.setFont(new Font("Arial", Font.BOLD, 15));
        add(btnTransact);
        
        panelHeader=new JPanel();
        panelHeader.setBounds(0,0,1200,100);
        panelHeader.setBackground(cBlue);
        add(panelHeader);
        
        jtab = new JTabbedPane();
        jtab.setBounds(0,95,1200,560);
        jtab.setLayout(null);
        jtab.setBackground(Color.PINK);
        add(jtab);
        
        homeJPanel= new JPanel();
        homeJPanel.setBounds(0,0,1200,560);
        homeJPanel.setLayout(null);
        jtab.add(homeJPanel);
        
        panelHome = new JPanel();
        panelHome.setBounds(20, 20, 780, 530);
        panelHome.setLayout(null);
        homeJPanel.add(panelHome);
        
        Object[][] data = {};
        tbModel = new DefaultTableModel();
        String[] tablecolumn = {"ID","Property Name", "Location", "Price", "Status"};
        tableEstateModel = new DefaultTableModel(data, tablecolumn);
        tableEstate = new JTable(tableEstateModel);
        tableEstate.setDefaultEditor(Object.class, null);
        tableEstate.setRowHeight(30);
        tableEstate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPaneEstate = new JScrollPane(tableEstate);
        scrollPaneEstate.setBounds(0, 0, 780, 530);
        panelHome.add(scrollPaneEstate);
           
        JLabel lblpreviewImg = new JLabel("Preview Image");
        lblpreviewImg.setBounds(820, 20, 360, 30);
        lblpreviewImg.setHorizontalAlignment(SwingConstants.CENTER);
        homeJPanel.add(lblpreviewImg);
        
        previewImg = new JLabel();
        previewImg.setBounds(820, 60, 350, 280);
        previewImg.setBorder(BorderFactory.createLineBorder(Color.black));
        homeJPanel.add(previewImg);
        
        btnDetails=new JButton("DETAILS");
        btnDetails.setBounds(820,350,100,25);
        btnDetails.setForeground(Color.WHITE);
        btnDetails.setBorder(null);
        btnDetails.setBackground(cGreen);
        btnDetails.setFocusable(false);
        btnDetails.setFont(new Font("Arial", Font.BOLD, 15));
        homeJPanel.add(btnDetails);
        
        btnUpdate =new JButton("UPDATE");
        btnUpdate.setBounds(950,350,100,25);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setBorder(null);
        btnUpdate.setBackground(cGreen);
        btnUpdate.setFocusable(false);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        homeJPanel.add(btnUpdate);
        
        btnDel=new JButton("DELETE");
        btnDel.setBounds(1070,350,100,25);
        btnDel.setBorder(null);
        btnDel.setForeground(Color.white);
        btnDel.setBackground(cGreen);
        btnDel.setFocusable(false);
        btnDel.setFont(new Font("Arial", Font.BOLD, 15));
        homeJPanel.add(btnDel);
        
        btnAdd=new JButton("ADD A NEW ITEM");
        btnAdd.setBounds(820, 385, 350, 30);
        btnAdd.setBorder(null);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setBackground(cGreen);
        btnAdd.setFocusable(false);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 15));
        homeJPanel.add(btnAdd);

        panelADD= new JPanel();
        panelADD.setBounds(0,0,1200,560);
        panelADD.setBackground(Color.green);
        jtab.add(panelAddLayout);
        
        try {
          String HousesData = "Select * from residentialrealestates";
          
          st = con.createStatement();
          ResultSet rs = st.executeQuery(HousesData);
           
            while(rs.next()){
                 
                 houseId = rs.getString("id");
                 houseName = rs.getString("name");
                 houseLocation = rs.getString("location");
                 housePrice = rs.getInt("price");
                 houseStatus = rs.getString("status");
                 Object [] dataSql={houseId, houseName, houseLocation, housePrice, houseStatus};
                 tableEstateModel.addRow(dataSql);
            }
           } catch (SQLException ex) {
             Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
           }   
        
        panelUsers= new JPanel();
        panelUsers.setBounds(0,0,1200,560);
        panelUsers.setLayout(null);
        jtab.add(panelUsers);      
        
        panelUsersPanel = new JPanel();
        panelUsersPanel.setBounds(20, 20, 780, 530);
        panelUsersPanel.setLayout(null);
        panelUsers.add(panelUsersPanel);
        
        
        String[][] data2 = {};
        String[] tablecolumn2 = {"ID", "First Name", "Last Name", "Username"};
       
        tableUserModel = new DefaultTableModel(data2, tablecolumn2);
        showClients();
        tableUser = new JTable(tableUserModel);
        tableUser.setDefaultEditor(Object.class, null);
        tableUser.setRowHeight(30);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane sp2 = new JScrollPane(tableUser);
        sp2.setBounds(0,0,780,530);
        panelUsersPanel.add(sp2);

        lblUsers = new JLabel("Clients");
        lblUsers.setBounds(940, 40, 200, 30);
        lblUsers.setFont(new Font("Arial", Font.BOLD, 30));
        panelUsers.add(lblUsers);
        
        txtClientSearch = new JTextField(); // para sa clients
        txtClientSearch.setBounds(880, 80, 220, 30);
        panelUsers.add(txtClientSearch);
        
        btnUserSearch = new JButton("SEARCH");
        btnUserSearch.setBounds(880, 120, 100, 30);
        btnUserSearch.setBorder(null);
        btnUserSearch.setForeground(Color.white);
        btnUserSearch.setBackground(cGreen);
        btnUserSearch.setFocusable(false);
        btnUserSearch.setFont(new Font("Arial", Font.BOLD, 15));
        panelUsers.add(btnUserSearch);
        
        btnClearUserSearch = new JButton("CLEAR");
        btnClearUserSearch.setBounds(1000, 120, 100, 30);
        btnClearUserSearch.setBorder(null);
        btnClearUserSearch.setForeground(Color.white);
        btnClearUserSearch.setBackground(cGreen);
        btnClearUserSearch.setFocusable(false);
        btnClearUserSearch.setFont(new Font("Arial", Font.BOLD, 15));
        panelUsers.add(btnClearUserSearch);
        
        btnClientDetails = new JButton("VIEW DETAILS");
        btnClientDetails.setBounds(880,160,220,30);
        btnClientDetails.setBorder(null);
        btnClientDetails.setForeground(Color.white);
        btnClientDetails.setBackground(cGreen);
        btnClientDetails.setFocusable(false);
        btnClientDetails.setFont(new Font("Arial", Font.BOLD, 15));
        panelUsers.add(btnClientDetails);
        
        transactJPanel= new JPanel();
        transactJPanel.setBounds(0,0,1200,560);
        transactJPanel.setLayout(null);
      
        jtab.add(transactJPanel);
        
        panelTransaction = new JPanel();
        panelTransaction.setBounds(20, 20, 780, 530);
        panelTransaction.setLayout(null);
        transactJPanel.add(panelTransaction);
        
        String[][] transactions = {};
        String[] transactionsColumns = {"Transaction ID", "Property ID", "Client ID", "Date"};
        tableTransactionModel = new DefaultTableModel(transactions, transactionsColumns);
        showTransactions();
        tableTransactions = new JTable(tableTransactionModel);
        tableTransactions.setDefaultEditor(Object.class, null);
        tableTransactions.setRowHeight(30);
        tableTransactions.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableTransactions.setBounds(0,0,800,560);
        
        panelTransaction.add(tableTransactions);

        JScrollPane scrollPaneTransaction = new JScrollPane(tableTransactions);
        scrollPaneTransaction.setBounds(0,0,780,530);
        panelTransaction.add(scrollPaneTransaction);
        
//        JButton btnMarketAnalysis = new JButton("Generate Market Analysis");
//        btnMarketAnalysis.setBounds(900, 40, 200, 30);
//        transactJPanel.add(btnMarketAnalysis);
//        
//        JButton btnSalesReport = new JButton("Sales Report");
//        btnSalesReport.setBounds(900, 80, 200, 30);
//        transactJPanel.add(btnSalesReport);
//        
        panelProfile= new JPanel();
        panelProfile.setBounds(0,0,1200,560);
        panelProfile.setLayout(null);
        jtab.add(panelProfile);
        
        JLabel lblDashboard = new JLabel("Market Analysis");
        lblDashboard.setBounds(60, 20, 500, 30);
        lblDashboard.setFont(new Font("Arial", Font.BOLD,25));
        panelProfile.add(lblDashboard);
        
        bargraphPanel = new JPanel();
        bargraphPanel.setBackground(Color.gray);
        bargraphPanel.setBounds(60,60, 450, 350);
        bargraphPanel.setLayout(null);
        panelProfile.add(bargraphPanel);
        
        int[] values = {70,50,220};
        
        barGraphPanel = new JPanel();
        barGraphPanel.setLayout(new GridLayout(1, values.length, 1, 1));
        barGraphPanel.setBounds(0,0, 450, 350);
        barGraph(values);
        
        JLabel lblTotalSales = new JLabel("Total Sales: ");
        lblTotalSales.setBounds(60, 430, 100, 30);
        panelProfile.add(lblTotalSales);
        
        lblTotalSalesContents = new JLabel("a");
        lblTotalSalesContents.setBounds(200, 430, 200, 30);
        panelProfile.add(lblTotalSalesContents);
        
        JLabel lblPropertiesSold = new JLabel("Properties Sold");
        lblPropertiesSold.setBounds(60, 460, 100, 30);
        panelProfile.add(lblPropertiesSold);
        
        lblPropertiesSoldContents = new JLabel("a");
        lblPropertiesSoldContents.setBounds(200, 460, 100, 30);
        panelProfile.add(lblPropertiesSoldContents);
        
        JLabel lblDailySales = new JLabel("Daily Sales");
        lblDailySales.setBounds(60, 490, 100, 30);
        panelProfile.add(lblDailySales);
        
        lblDailySalesContents = new JLabel("a");
        lblDailySalesContents.setBounds(200, 490, 100, 30);
        panelProfile.add(lblDailySalesContents);
        
        // market analysis 
        String [] marketColumns = {"Client ID","Property ID","Price"};
        String [][] marketRows = {};
        tableModelMarket = new DefaultTableModel(marketRows,marketColumns);
        tableMarket = new JTable(tableModelMarket);
        
        tableData();
        
        JScrollPane scrollPaneMarket = new JScrollPane(tableMarket);
        scrollPaneMarket.setBounds(600,60,450,350);
        panelProfile.add(scrollPaneMarket);
        
        btnOverall = new JButton("Overall");
        btnOverall.setBounds(600,450,100,30);
        panelProfile.add(btnOverall);
        
        btnBinan = new JButton("Binan");
        btnBinan.setBounds(715,450,100,30);
        panelProfile.add(btnBinan);
        
        btnSantaRosa = new JButton("Santa Rosa");
        btnSantaRosa.setBounds(835,450,100,30);
        panelProfile.add(btnSantaRosa);
        
        btnSanPedro = new JButton("San Pedro");
        btnSanPedro.setBounds(950,450,100,30);
        panelProfile.add(btnSanPedro);
        
        
        lblAdminDetails = new JLabel("Admin");
        lblAdminDetails.setBounds(530,20000, 500, 30);
        lblAdminDetails.setFont(new Font("Arial", Font.BOLD, 30));
        panelProfile.add(lblAdminDetails);
        
        btnChangePassword = new JButton("Change Password");
        btnChangePassword.setBounds(480, 20000, 200, 30);
        btnChangePassword.setFont(new Font("Arial", Font.BOLD, 15));
        panelProfile.add(btnChangePassword);
        
        btnSignOut = new JButton("Sign Out");
        btnSignOut.setBounds(480, 2000, 200, 30);
        btnSignOut.setFont(new Font("Arial", Font.BOLD, 15));
        panelProfile.add(btnSignOut);
        
        panelUpdateLayout = new JPanel();
        panelUpdateLayout.setLayout(null);
        panelUpdateLayout.setBounds(0, 0, 1200, 560);
        jtab.add(panelUpdateLayout);
        
        lblUpdate = new JLabel("You are Updating : ");
        lblUpdate.setBounds(0, 0, 1195, 25);
        lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
        lblUpdate.setFont(new Font("Arial", Font.BOLD, 15));
        panelUpdateLayout.add(lblUpdate);

        lblPropertyName = new JLabel("PROPERTY NAME : ");
        lblPropertyName.setBounds(50, 50, 250, 30);
        lblPropertyName.setHorizontalAlignment(SwingConstants.LEFT);
        lblPropertyName.setFont(new Font("Arial", Font.BOLD, 14));
        panelUpdateLayout.add(lblPropertyName);

        txtUpdatePropertyName = new JTextField();
        txtUpdatePropertyName.setBounds(220, 50, 250, 30);
        panelUpdateLayout.add(txtUpdatePropertyName);

        lblLocation = new JLabel("LOCATION :");
        lblLocation.setBounds(50, 95, 250, 30);
        lblLocation.setFont(new Font("Arial", Font.BOLD, 14));
        panelUpdateLayout.add(lblLocation);
        
        txtUpdateLocation = new JTextField();
        txtUpdateLocation.setBounds(220, 95, 250, 30);
        panelUpdateLayout.add(txtUpdateLocation);
        
        lblPrice = new JLabel("Price :");
        lblPrice.setBounds(50, 140, 250, 30);
        lblPrice.setFont(new Font("Arial", Font.BOLD, 14));
        panelUpdateLayout.add(lblPrice);

        txtUpdatePrice = new JTextField();
        txtUpdatePrice.setBounds(220, 140, 250, 30);
        panelUpdateLayout.add(txtUpdatePrice);

        lblDescription = new JLabel("DESCRIPTION :");
        lblDescription.setBounds(50, 185, 250, 30);
        lblDescription.setFont(new Font("Arial", Font.BOLD, 14));
        panelUpdateLayout.add(lblDescription);

        txaUpdateDescription = new JTextArea();
        txaUpdateDescription.setBounds(50, 215, 500, 300);
        panelUpdateLayout.add(txaUpdateDescription);
        
        lblImageUpdate = new JLabel();
        lblImageUpdate.setBounds(650, 100, 500, 300);
        lblImageUpdate.setBackground(Color.gray);
        lblImageUpdate.setOpaque(true);
        panelUpdateLayout.add(lblImageUpdate);

        btnImageUpdate = new JButton("Change Image");
        btnImageUpdate.setBounds(650, 450, 200, 50);
        panelUpdateLayout.add(btnImageUpdate);
        
        btnUpdateData = new JButton("Update");
        btnUpdateData.setBounds(950, 450, 200, 50);
        panelUpdateLayout.add(btnUpdateData);
        
        btnUpdateData.addActionListener(this); 
        btnHome.addActionListener(this);
        btnAdd.addActionListener(this);
        btnUsers.addActionListener(this);
        btnTransact.addActionListener(this);
        btnImage.addActionListener(this);
        btnAddImage.addActionListener(this);
        btnSignOut.addActionListener(this);
        btnChangePassword.addActionListener(this);
        tableEstate.addMouseListener(this);
        btnUpdate.addActionListener(this);
        btnDetails.addActionListener(this);
        btnDel.addActionListener(this);
        btnImageUpdate.addActionListener(this);
        btnClientDetails.addActionListener(this);
        btnUserSearch.addActionListener(this); // para sa search clients
        btnClearUserSearch.addActionListener(this); // para sa lear and bumalik yung table
        btnOverall.addActionListener(this);// sa market analysis
        btnSantaRosa.addActionListener(this); // sta rosa
        btnBinan.addActionListener(this); // binan
        btnSanPedro.addActionListener(this);// san pedro
        setVisible(true);
    } 
    
    private void barGraph(int[] values) {
        
        for (int i = 0; i < values.length; i++) {
            JPanel barPanel = new JPanel();
            barPanel.setLayout(new BorderLayout());

            JPanel bar = new JPanel();
            bar.setBackground(Color.RED);
            int barHeight = ((int) values[i] * 2); 
            bar.setPreferredSize(new Dimension(50, barHeight));
            barPanel.add(bar, BorderLayout.SOUTH);
            
            JPanel spacer = new JPanel();
            int spacerHeight = 10 - barHeight - 20;
            spacer.setPreferredSize(new Dimension(50, spacerHeight)); 
            barPanel.add(spacer, BorderLayout.CENTER); 

            barGraphPanel.add(barPanel);
        }
        
        bargraphPanel.add(barGraphPanel);
        bargraphPanel.revalidate();
        bargraphPanel.repaint();

    }
    
    public void tableData(){
        
        tableModelMarket.setRowCount(0);
        String martketTable = "Select usersID, propertyId, propertyPrice From propertiesowned";
        
        try {
            pst = con.prepareStatement(martketTable);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                String usersID = rs.getString("usersID");
                String propertyId = rs.getString("propertyId");
                String propertyPrice = rs.getString("propertyPrice");
                
                String[] arr = {usersID,propertyId,propertyPrice};
                tableModelMarket.addRow(arr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   @Override
public void mouseClicked(MouseEvent e) {
    if (e.getSource() == tableEstate) {
        selectedrows = tableEstate.getSelectedRow();
        if (selectedrows != -1) {
            houseId = String.valueOf(tableEstateModel.getValueAt(selectedrows, 0));
            houseUpdateId = houseId; 
            lblUpdate.setText("You are Updating Residential ID : "+houseUpdateId);
            displayImage(houseId);
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
                InputStream imagefinalpt2 = images.getBinaryStream();
                Image imagefinalpt3 = ImageIO.read(imagefinalpt2);
                ImageIcon imagefinalpt4 = new ImageIcon(imagefinalpt3);
                finalPreviewImage = new ImageIcon(imagefinalpt4.getImage().getScaledInstance(350,280, Image.SCALE_SMOOTH));
                previewImg.setIcon(finalPreviewImage);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnHome){
            int currentIndex = jtab.getSelectedIndex();
            if (currentIndex == 0) {
              jtab.setSelectedIndex(4);
              btnHome.setIcon(finalHomeIc);
            }else  {
              btnHome.setIcon(finalAccountIc);
                jtab.setSelectedIndex(0);
                ImageIcon none = new ImageIcon();
                lblImageUpdate.setIcon(none);
            }
        }else if(e.getSource()==btnAdd){
            btnHome.setIcon(finalHomeIc);
            jtab.setSelectedIndex(1);
        }else if(e.getSource()==btnUsers){
            btnHome.setIcon(finalHomeIc);
            jtab.setSelectedIndex(2);
        }else if(e.getSource()==btnTransact){
            btnHome.setIcon(finalHomeIc);
            jtab.setSelectedIndex(3);
        }
        
        else if (e.getSource() == btnUpdate) {
            int currentIndex = jtab.getSelectedIndex();
            int selectedRowItem = tableEstate.getSelectedRow();
            if (selectedRowItem != -1 && currentIndex == 0) {
        
        btnHome.setIcon(finalHomeIc);
        jtab.setSelectedIndex(5);
    } else {
        JOptionPane.showMessageDialog(null, "Select a row from the table", "Error", JOptionPane.WARNING_MESSAGE);
        btnHome.setIcon(finalAccountIc);
        jtab.setSelectedIndex(0);
    }
}else if (e.getSource() == btnImage || e.getSource() == btnImageUpdate) {
            
            jfcImage.setCurrentDirectory(new File("user.dir"));
            
            FileNameExtensionFilter fneFilter = new FileNameExtensionFilter("*.images", "jpg", "png");
            jfcImage.addChoosableFileFilter(fneFilter);
            
            int res = jfcImage.showOpenDialog(null);
                
                if (res == JFileChooser.APPROVE_OPTION) {
                    File fSelect = jfcImage.getSelectedFile();
                    imagePath = fSelect.getAbsolutePath();
                    ImageIcon path = new ImageIcon(imagePath);
                    ImageIcon imageIcon = new ImageIcon(path.getImage().getScaledInstance(500, 300, Image.SCALE_SMOOTH));
                    lblImage.setIcon(imageIcon);
                    lblImageUpdate.setIcon(imageIcon);
                }
        }else if (e.getSource() == btnAddImage) {
            String values = "insert into residentialrealestates (name,location,price,description,status,img) values (?,?,?,?,?,?)";
            String name = txtPropertyName.getText();
            String location = txtLocation.getText();
            String price = txtPrice.getText();
            String description = txaDescription.getText();
            if (!name.isEmpty() && !location.isEmpty() && !price.isEmpty() && !description.isEmpty()){
              
                try {
                    pst = con.prepareStatement(values);

                    String status = "Available";

                    pst.setString(1,txtPropertyName.getText());
                    pst.setString(2,txtLocation.getText());
                    pst.setString(3,txtPrice.getText());
                    pst.setString(4,txaDescription.getText());
                    pst.setString(5,status);
                if(imagePath!=null){
                    InputStream imagefinalpt5 = new FileInputStream(new File(imagePath));
                    pst.setBlob(6,imagefinalpt5);
                }else{
                    JOptionPane.showMessageDialog(null, "Please insert an Image","ERROR", JOptionPane.ERROR_MESSAGE);
                }
                    
                    pst.executeUpdate();
                    lblImage.setIcon(null);
                    txtPropertyName.setText("");
                    txtLocation.setText("");
                    txtPrice.setText("");
                    txaDescription.setText("");
                    
                    dispose();
                    JOptionPane.showMessageDialog(null, "House Added", "ADD SUCCESS", JOptionPane.INFORMATION_MESSAGE);
                    new adminPage();
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
              
            } catch (FileNotFoundException ex) {
                Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all the field","ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
        }else if(e.getSource() == btnSignOut) {
            int response = JOptionPane.showConfirmDialog(this, "You are signing out\nClick ok to proceed","Sign out",JOptionPane.OK_CANCEL_OPTION);
            if(response == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(null, "Signed Out");
                dispose();
                new welcomePage().setVisible(true);
            } 
        }else if(e.getSource() == btnChangePassword) {
                dispose();
                new changePassword().setVisible(true);
        }else if(e.getSource()==btnDetails){
            
          int selectedRowItem = tableEstate.getSelectedRow();
          
          if (selectedRowItem != -1) {
              
              String houseId = String.valueOf(tableEstate.getValueAt(selectedRowItem, 0)); 
              String houseName =String.valueOf(tableEstate.getValueAt(selectedRowItem, 1)); 
              String houseLocation = String.valueOf(tableEstate.getValueAt(selectedRowItem, 2));
              String housePrice =String.valueOf(tableEstate.getValueAt(selectedRowItem, 3)); 
              String houseStatus = String.valueOf(tableEstate.getValueAt(selectedRowItem, 4)); 
              String a = "Admin";
              String b = null;
              String c = null;
              String d = null;
              String ee = null;
              String f = null;
              
             
        try {
            String descriptionSql = "select description from residentialrealestates where id = ?";
            
            pst = con.prepareStatement(descriptionSql);
            pst.setString(1, houseId);
            rs = pst.executeQuery();
            
            while(rs.next()){
               houseDetailsDescription = rs.getString("description");
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
              
              dispose();
              new transactInfo(houseId, houseName, houseLocation, housePrice, houseStatus, houseDetailsDescription, a, b, c, d, ee, f, finalPreviewImage).setVisible(true);
        }else{
               JOptionPane.showMessageDialog(null, "Select a row from the table","Error",JOptionPane.WARNING_MESSAGE);
           }
            
        }else if(e.getSource()==btnDel) { 
            int index = tableEstate.getSelectedRow();
            if(index != -1){
                try {
                 String id = tableEstateModel.getValueAt(index, 0).toString();
                 String query = "delete from residentialrealestates where id = ?";
                 PreparedStatement pst = con.prepareStatement(query);
                 pst.setString(1, id); 
                 pst.executeUpdate();
                 tableEstateModel.removeRow(index); 
                 JOptionPane.showMessageDialog(null, "Resident Deleted","Delete Success",JOptionPane.OK_OPTION);
                 ImageIcon none = new ImageIcon();
                 previewImg.setIcon(none);
                } catch (Exception ex) {
                  Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } else{
                JOptionPane.showMessageDialog(null, "Select a row from the table","Error",JOptionPane.WARNING_MESSAGE);
            }
       }else if(e.getSource()==btnUpdateData){ 
           int index = Integer.parseInt(houseId);
            if(index != -1){
                try {
                 String query = "UPDATE residentialrealestates SET name=?, location=?, price=?, description=?, img=? where id = ?";
                 PreparedStatement pst = con.prepareStatement(query);
                 pst.setString(1, txtUpdatePropertyName.getText());
                 pst.setString(2, txtUpdateLocation.getText());
                 pst.setString(3, txtUpdatePrice.getText());
                 pst.setString(4, txaUpdateDescription.getText());
                 pst.setInt(6, index);
                 if(imagePath!=null){
                     InputStream imagefinalpt5 = new FileInputStream(new File(imagePath));
                     pst.setBlob(5,imagefinalpt5);
                 }else{
                     JOptionPane.showMessageDialog(null, "Please insert an Image","ERROR", JOptionPane.ERROR_MESSAGE);
                 }
                 
                 pst.executeUpdate();
                 
                 dispose();
                 JOptionPane.showMessageDialog(null, "Resident Updated");
                 new adminPage();
                } catch (Exception ex) {
                  Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                }            
                
            } else{
                JOptionPane.showMessageDialog(null, "Select a row from the table","Error",JOptionPane.WARNING_MESSAGE);
            }
       } else if(e.getSource()==btnClientDetails){ // pupunta sa viewClientDetails class
           int index = tableUser.getSelectedRow();
           if(index != -1) {
               clientId = String.valueOf(tableUserModel.getValueAt(index, 0));
               new viewClientsDetails(clientId).setVisible(true);
               dispose();
           } else {
               JOptionPane.showMessageDialog(null, "Pick a user","Error",JOptionPane.ERROR_MESSAGE);
           }
           
       } else if(e.getSource()== btnUserSearch){ // para sa search clients hashmap
           searchClients();
       } else if(e.getSource()==btnClearUserSearch) { // para bumalik yung dating table and mag clear txtfield
           String clientSearch = txtClientSearch.getText();
           //if(clientSearch.isEmpty()) {
               txtClientSearch.setText("");
               searchedClient = (DefaultTableModel) tableUserModel;
               searchedClient.setRowCount(0);
                for(Map.Entry<String,String[]> entry :clientsMap.entrySet()) {
                    String[] clientData = entry.getValue();
                    searchedClient.addRow(clientData);
                }
     //      }
       } else if(e.getSource()== btnOverall){ // ito yung mga locations and then dito ko ginamit yung mergeSort, nasa method sa baba
          marketOverallProcess();
         //  tableData();
       } else if(e.getSource()==btnSantaRosa){
           santaRosaMarketProcess();
       } else if(e.getSource()==btnBinan){
           binanMarketProcess();
       } else if(e.getSource()==btnSanPedro){
           sanPedroMarketProcess();
       }
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
    public void showClients(){        
        // dito ko ipapasok hashmap - reyes
       
            String sql = "Select * from clientsinfo";
            PreparedStatement pst;
            clientsMap.clear(); // Ito yung hasmap tinawag ko dito para laging mag reset
         
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            
            tableUserModel.setRowCount(0);
            while(rs.next()) {
                userID = rs.getString("id");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                username = rs.getString("username");
           
                String clientsData[] = {userID,firstName,lastName,username}; 
                // yung mga data ay need natin mastore sa hashmap
                clientsMap.put(userID, clientsData);
                
                // store sa table
                tableUserModel.addRow(clientsData);        
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void searchClients(){
        String clientSearch = txtClientSearch.getText().trim();
        if(!clientSearch.isEmpty()){
     
                boolean nahanapSiClient = false;
                 searchedClient = (DefaultTableModel) tableUserModel;    
                 searchedClient.setRowCount(0);
               // ang process nito ang mag loop until mahanap clientID or clientValue
               
               for(Map.Entry<String,String[]> entry : clientsMap.entrySet()) {
                   String clientID = entry.getKey();
                   String[] clientData = entry.getValue();
                   
                       if( clientID.contains(clientSearch)){
                           searchedClient.addRow(clientData);
                           nahanapSiClient = true;
                           break;
                       }
                       for(String clientValue: clientData){ // loop incase yung isearch ay first name
                           if(clientValue.contains(clientSearch.toLowerCase())) {
                               searchedClient.addRow(clientData);
                               nahanapSiClient = true;
                               break;
                           }
                       }
                   if(nahanapSiClient){
                        // since true na yung nahanap na si client, kailangan na natin ito itigil
                         break;
                   }    
               }
                  if(!nahanapSiClient){ // if hindi nahanap
                        JOptionPane.showMessageDialog(null, "Client not found","Not found",JOptionPane.ERROR_MESSAGE);
                   } 
        } else {
              JOptionPane.showMessageDialog(null, "Enter something to search","Error",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public void showTransactions(){        
            String sql = "Select * from transactions";
        try {
            PreparedStatement pstTransact = con.prepareStatement(sql);
            ResultSet rsTransact = pstTransact.executeQuery(sql);
            
            while(rsTransact.next()) {
                String transactionId = rsTransact.getString("transactionId");
                String clientId = rsTransact.getString("clientId");
                String propertyId = rsTransact.getString("propertyId");
                String date = rsTransact.getString("date");
                
                String transactData[] = {transactionId, propertyId, clientId, date}; 
                tableTransactionModel.addRow(transactData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void marketOverallProcess(){
       String query = "Select usersID, propertyId, propertyPrice From propertiesowned";     
       marketMethod(query);
    }
    public void santaRosaMarketProcess(){ // santa rosa btn
       String query = "Select usersID, propertyId, propertyPrice From propertiesowned where propertyLocation = 'Santa Rosa'";
       marketMethod(query);
    }
    public void binanMarketProcess(){ // Binan btn
       String query = "Select usersID, propertyId, propertyPrice From propertiesowned where propertyLocation = 'Binan'";
       marketMethod(query);
    }
    public void sanPedroMarketProcess(){ // san pedro btn
       String query = "Select usersID, propertyId, propertyPrice From propertiesowned where propertyLocation = 'San Pedro'";
       marketMethod(query);
    }
     public void marketMethod(String query){
         tableModelMarket.setRowCount(0);
          List<Object[]> dataList = new ArrayList<>();
          
        try {
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
         
            while(rs.next()){
                String usersID = rs.getString("usersID");
                String propertyId = rs.getString("propertyId");
                String propertyPrice = rs.getString("propertyPrice");
                            
                tableModelMarket.addRow(new Object[]{usersID,propertyId,propertyPrice});
                dataList.add(new Object[]{usersID,propertyId,propertyPrice});    
            }
              dataList = mergeSort(dataList);
              int propertieSold = tableModelMarket.getRowCount();
              lblPropertiesSoldContents.setText(String.valueOf(propertieSold));
             
              JOptionPane.showMessageDialog(null, "This is Overall");
        } catch (SQLException ex) {
            Logger.getLogger(adminPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    private List<Object[]> mergeSort(List<Object[]> dataList) {
        
        if(dataList.size()<= 1){
            return dataList;
        }
        int mid =  dataList.size() / 2;
        List<Object[]> left = new ArrayList<>(dataList.subList(0, mid));
        List<Object[]> right = new ArrayList<>(dataList.subList(mid, dataList.size()));

        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left,right);
    }
    private List<Object[]> merge(List<Object[]> left, List<Object[]> right){
        List<Object[]> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        
        while(leftIndex < left.size()&&rightIndex < right.size()){
            String leftPrice = (String) left.get(leftIndex)[2];
            String rightPrice = (String) right.get(rightIndex)[2];
            if(leftPrice.compareTo(rightPrice) <= 0){
                mergedList.add(left.get(leftIndex));
                leftIndex++;
            } else {
                mergedList.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        while(leftIndex < left.size()){
            mergedList.add(left.get(leftIndex));
            leftIndex++;
        }
         while(rightIndex < right.size()){
            mergedList.add(right.get(rightIndex));
            rightIndex++;
        }
            return mergedList;
        }
    public static void main(String[] args) {
        new adminPage().setVisible(true);
    }

}