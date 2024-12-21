package com.mycompany.realestate;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;



        
public class moreInfo extends JFrame implements ActionListener{

    private JLabel lblNameId, lblID, lblPrice, lblLocation,lblStatus, lblRichField, lblRealEstates, lblLogo,lblInfo,pnPic;
    private JTextArea txaInfo;
    private JButton btnBack, btnBuy;
    private ImageIcon logoIc, finalLogoIc, picture, finalPicture;
    private JPanel  panelAddLayout, panelHeader;
    private String inheretBack, location, status, name, id, price, locationBack, priceBack, idBack, statusBack, nameBack, fname, lname, userNum, userEmail, admin;
    private int userId;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cBlue = (Color.decode("#004A8C")); 
    
   public moreInfo(String id, String name, String location, String price, String status, String inheret, String fname, String lname, int userId, String userNum, String userEmail, ImageIcon picture){
  
        setSize(1200, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        admin = inheret;
        
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
        

        panelAddLayout = new JPanel();
        panelAddLayout.setLayout(null);
        panelAddLayout.setBounds(0, 95, 1200, 560);
        add(panelAddLayout);

        lblNameId = new JLabel("Property Name : " + name);
        lblNameId.setBounds(50, 50, 500, 30);
        lblNameId.setHorizontalAlignment(SwingConstants.LEFT);
        lblNameId.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblNameId);

        lblID = new JLabel("Property ID       : " + id);
        lblID.setBounds(50, 80, 500, 30);
        lblID.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblID);
        
        lblID = new JLabel("Location            : " + location);
        lblID.setBounds(50, 110, 500, 30);
        lblID.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblID);
        
        lblPrice = new JLabel("Price                 : " + price);
        lblPrice.setBounds(50, 140, 500, 30);
        lblPrice.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblPrice);
    
        lblStatus = new JLabel("Status               : " + status);
        lblStatus.setBounds(50, 170, 500, 30);
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblStatus);

        lblInfo = new JLabel("DESCRIPTION :");
        lblInfo.setBounds(50, 200, 500, 30);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 14));
        panelAddLayout.add(lblInfo);

        txaInfo = new JTextArea();
        txaInfo.setEditable(false);
        txaInfo.setFocusable(false);
        txaInfo.setBounds(50, 240, 500, 300);
        panelAddLayout.add(txaInfo);
        
        finalPicture = new ImageIcon(picture.getImage().getScaledInstance(500,300, Image.SCALE_SMOOTH));
        
        pnPic = new JLabel();
        pnPic.setBounds(650, 100, 500, 300);
        pnPic.setBackground(Color.gray);
        pnPic.setIcon(finalPicture);
        pnPic.setOpaque(true);
        panelAddLayout.add(pnPic);

        btnBack = new JButton("Back");
        btnBack.setBounds(650, 450, 200, 50);
        btnBack.setBackground(cGreen);
        btnBack.setForeground(Color.white);
        panelAddLayout.add(btnBack);
        
        btnBuy = new JButton("Buy");
        btnBuy.setBounds(950, 450, 200, 50);
        btnBuy.setBackground(cGreen);
        btnBuy.setForeground(Color.white);
        panelAddLayout.add(btnBuy);
        
        panelHeader=new JPanel();
        panelHeader.setBounds(0,0,1200,100);
        panelHeader.setBackground(cBlue);
        add(panelHeader);
        
        locationBack = location;
        priceBack = price;
        idBack = id;
        statusBack = status;
        nameBack = name;
        finalPicture = picture;
        inheretBack = inheret;
        
        setVisible(true);
        
        btnBack.addActionListener(this);
        btnBuy.addActionListener(this);
    }
   
           @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnBuy){
            
            new purchasePage(locationBack, priceBack, idBack, statusBack, nameBack, inheretBack, fname, lname, userId, userNum, userEmail, finalPicture).setVisible(true);
            dispose();
        }else if(e.getSource()==btnBack){
            if(admin.equals("Admin")){
            new adminPage().setVisible(true);
            dispose();
            }else{
               new ClientInterface(inheretBack).setVisible(true);
               dispose(); 

            }
            
        }
    }
}