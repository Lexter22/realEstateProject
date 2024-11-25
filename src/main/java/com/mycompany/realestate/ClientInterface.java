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
import javax.swing.table.DefaultTableModel;

public class ClientInterface extends JFrame implements ActionListener, MouseListener {

  private JPanel logo, panelHeader, panelItems, panelItemsPanel, panelAccount, panelAccountPanel;
  private JLabel lblRichfields, lblRealEstates, lblUName, lblInputUName, lblCDetails , lblCID, lblInputCID, lblEmail, lblInputEmail, lblCNumber, lblInputCNumber, lblpreviewImg,imgPreviewImage;
  private JButton btnViewOwned, btnView,btnReset, btnAccHome, btnSearch, btnItems, btnLogout;
  private JComboBox jcbLocation, jcbPrice, jcbHtL;
  private JTabbedPane jtab;
  private JTable itemTable, accTable;
  private Object[][] data = {
        {"San Pedro","$1", "aasadaaa0", "Sold" },
        {"Santa Rosa","$50,321,4afdsa42", "aaaaa0", "Sold" },
        {"Binan","$1,000,012", "aaafdraa2", "Sold" },
        {"Santa Rosa","$2,331,523", "aaassaaa1", "Available" }
    };

    // Column Names
    private String[] columnNames = { "Location","Price", "ID", "Status" };
  private ImageIcon searchIc, resetIc, accountIc, homeIc, moreInfoIc, finalSearchIc, finalResetIc, finalAccountIc, finalHomeIc, finalMoreInfoIc;
  private Image searchImg, resetImg, accountImg, homeImg, moreInfoImg, adjustedSearchIc, adjustedResetIc, adjustedAccountIc, adjustedHomeIc, adjustedMoreInfoIc;
  private String Location[] = {"Location", "San Pedro", "Santa Rosa", "Binan" };
  private String Price[] = { "Price Range", "$1", "$10,000,001 - $50,000,000", "$50,000,001 - $100,000,000" };
  private String HtL[] = {"Default","High - Low", "Low - High" };
  private DefaultTableModel itemTModel, accTModel;
  private JTable itemT;
  private Color cGreen = (Color.decode("#28A745"));
  private Color cBlue = (Color.decode("#004A8C")); 

  public ClientInterface() {

    setSize(1200, 700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);

    logo = new JPanel();
    logo.setBounds(10, 10, 80, 80);
    logo.setBackground(Color.green);
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

 Object[][] data1 = {
        {"San Pedro","$100,210,000", "aasadaaa0", "Owned" },
        {"Santa Rosa","$50,321,4afdsa42", "aaaaa0", "Owned" },
        {"Binan","$1,000,012", "aaafdraa2", "Owned" },
        {"Santa Rosa","$2,331,523", "aaassaaa1", "Owned" }
    };

    String[] tablecolumn = {"Property Name", "Location", "Price", "Status"};
        
    itemTModel = new DefaultTableModel(data, tablecolumn);
    itemT = new JTable(itemTModel);
    itemT.setDefaultEditor(Object.class, null);
    itemT.setRowHeight(30);
    itemT.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    itemT.setBounds(0,0,800,560);
        
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
        
        accTModel = new DefaultTableModel(data1, columnNames);
        accTable = new JTable(accTModel);
        accTable.setDefaultEditor(Object.class, null);
        accTable.setRowHeight(30);
        accTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        JScrollPane sp2 = new JScrollPane(accTable);
        sp2.setPreferredSize(new Dimension(800, 560));
        panelAccountPanel.add(sp2);
    
        lblCDetails = new JLabel("About You");
        lblCDetails.setBounds(940, 20, 200, 30);
        lblCDetails.setFont(new Font("Arial", Font.BOLD, 25));
        panelAccount.add(lblCDetails);
    
        lblUName=new JLabel("Name : ");
        lblUName.setBounds(810,50,300,50);
        lblUName.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblUName);

        lblCID=new JLabel("ID : ");
        lblCID.setHorizontalAlignment(SwingConstants.LEFT);
        lblCID.setBounds(810,80,300,50);
        lblCID.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblCID);

        lblEmail=new JLabel("Email : ");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setBounds(810,110,300,50);
        lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
        panelAccount.add(lblEmail);

        lblCNumber=new JLabel("No. : ");
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
      }
  
    @Override
      public void mouseClicked(MouseEvent e) {
      if(e.getSource()==itemT){
          jtab.setSelectedIndex(1);
          panelItems.add(btnView);
          jtab.setSelectedIndex(0);
      }else if(e.getSource()==accTable){
          jtab.setSelectedIndex(0);
          panelAccount.add(btnViewOwned);
          jtab.setSelectedIndex(1);
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
              String location = (String) itemT.getValueAt(selectedRowItem, 0); 
              String price = (String) itemT.getValueAt(selectedRowItem, 1); 
              String id = (String) itemT.getValueAt(selectedRowItem, 2); 
              String status = (String) itemT.getValueAt(selectedRowItem, 3);
              new transactInfo();//id, location, price, status);
              dispose();
        }
      }else if (e.getSource()== btnViewOwned) {
         int selectedRowAccItem = accTable.getSelectedRow();
           if(selectedRowAccItem != -1) {
              String location = (String) accTable.getValueAt(selectedRowAccItem, 0); 
              String price = (String) accTable.getValueAt(selectedRowAccItem, 1); 
              String id = (String) accTable.getValueAt(selectedRowAccItem, 2); 
              String status = (String) accTable.getValueAt(selectedRowAccItem, 3);
//              new moreInfo(id, location, price, status);
              dispose();
        }
      }

      else if(e.getSource()==btnSearch){       
            JOptionPane.showMessageDialog(null, "Binary Search");
      }else if(e.getSource()==btnLogout){
          dispose();
  //        new welcomePage();
      }

    }
 
    
}