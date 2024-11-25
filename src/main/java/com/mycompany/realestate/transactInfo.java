package com.mycompany.realestate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author johnl
 */
public class transactInfo extends JFrame implements ActionListener {
    
private JLabel lblNameId, lblID, lblPrice, lblLocation;
private JTextArea txaInfo;
private JButton btnBack;
private JPanel pnPic;
    public transactInfo(){
        
        setTitle("Details");
        setSize(800,700);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblNameId = new JLabel("Name: ");
        lblNameId.setBounds(50, 50, 350, 50);
        lblNameId.setFont(new Font("Arial" ,Font.PLAIN, 17));
        add(lblNameId);
       
        
        lblID = new JLabel("Property ID: ");
        lblID.setBounds(50, 110, 350, 50);
        lblID.setFont(new Font("Arial" ,Font.PLAIN, 17));
        add(lblID);
        
        lblLocation = new JLabel("Location: " );
        lblLocation.setBounds(50, 170, 350, 50);
        lblLocation.setFont(new Font("Arial" ,Font.PLAIN, 17));
        add(lblLocation);
        
        lblPrice = new JLabel("Price: ");
        lblPrice.setBounds(50, 230, 350, 50);
        lblPrice.setFont(new Font("Arial" ,Font.PLAIN, 17));
        add(lblPrice);
        
        txaInfo = new JTextArea();
        txaInfo.setBounds(50, 290, 680, 290);
        txaInfo.setFont(new Font("Arial" ,Font.PLAIN, 17));
        txaInfo.setEditable(false);
        add(txaInfo);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(650, 610, 75, 30);
        add(btnBack);
        
        pnPic = new JPanel();
        pnPic.setBounds(400, 50, 330, 230);
        pnPic.setBackground(Color.red);
        add(pnPic);
               
        setVisible(true);
        btnBack.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBack){
            new ClientInterface();
            dispose();
        }
    }
    }

   
   

