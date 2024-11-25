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
import java.util.Arrays;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientInterface extends JFrame implements ActionListener {

  private JPanel logo, panelHeader, panelItems, panelAccount;
  private JLabel lQs, lRe;
  private JButton btnReset, btnAccHome, btnSearch, btnItems;
  private JComboBox jcbLocation, jcbPrice, jcbHtL;
  private JTabbedPane jtab;
  private JTable estateTable, userTable;
  private ImageIcon searchIc, resetIc, accountIc, homeIc, finalSearchIc, finalResetIc, finalAccountIc, finalHomeIc;
  private Image searchImg, resetImg, accountImg, homeImg, adjustedSearchIc, adjustedResetIc, adjustedAccountIc, adjustedHomeIc;
  private String Location[] = {"Location", "San Pedro", "Santa Rosa", "Binan" };
  private String Price[] = { "Price Range", "$0 - $10,000,000", "S10,000,001 - $50,000,000", "S50,000,001 - $100,000,000" };
  private String HtL[] = {"Default","High - Low", "Low - High" };

  public ClientInterface() {

    setSize(1200, 700);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);

    logo = new JPanel();
    logo.setBounds(10, 10, 80, 80);
    logo.setBackground(Color.green);
    add(logo);

    lQs = new JLabel("image");
    lQs.setBounds(120, 10, 300, 50);
    lQs.setFont(new Font("Arial", Font.BOLD, 25));
    add(lQs);

    lRe = new JLabel("REAL ESTATES");
    lRe.setBounds(120, 40, 300, 50);
    lRe.setFont(new Font("Arial", Font.BOLD, 15));
    add(lRe);

    jcbLocation = new JComboBox(Location);
    jcbLocation.setBounds(540, 60, 150, 25);
    add(jcbLocation);

    jcbPrice = new JComboBox(Price);
    jcbPrice.setBounds(710, 60, 150, 25);
    add(jcbPrice);

    jcbHtL = new JComboBox(HtL);
    jcbHtL.setBounds(880, 60, 150, 25);
    add(jcbHtL);

    searchIc = new ImageIcon("C:\\Users\\AACI Admin\\Pictures\\ClientUI\\searchIcon.png");
    searchImg = searchIc.getImage();
    adjustedSearchIc = searchImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    finalSearchIc = new ImageIcon(adjustedSearchIc);
    
    btnSearch = new JButton();
    btnSearch.setIcon(finalSearchIc);
    btnSearch.setBounds(1050, 60, 30, 30);
    btnSearch.setBorder(null);
    btnSearch.setBackground(Color.CYAN);
    btnSearch.setFont(new Font("Arial", Font.BOLD, 15));
    add(btnSearch);

    resetIc = new ImageIcon("C:\\Users\\AACI Admin\\Pictures\\ClientUI\\resetIcon.png");
    resetImg = resetIc.getImage();
    adjustedResetIc = resetImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    finalResetIc = new ImageIcon(adjustedResetIc);

    btnReset = new JButton();
    btnReset.setIcon(finalResetIc);
    btnReset.setBorder(null);
    btnReset.setBackground(Color.cyan);
    btnReset.setBounds(1100, 60, 30, 30);
    add(btnReset);

    accountIc = new ImageIcon("C:\\Users\\AACI Admin\\Pictures\\ClientUI\\accountIcon.png");
    accountImg = accountIc.getImage();
    adjustedAccountIc = accountImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    finalAccountIc = new ImageIcon(adjustedAccountIc);
    
    homeIc = new ImageIcon("C:\\Users\\AACI Admin\\Pictures\\ClientUI\\homeIcon.png");
    homeImg = homeIc.getImage();
    adjustedHomeIc = homeImg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    finalHomeIc = new ImageIcon(adjustedHomeIc);

    btnAccHome = new JButton();
    btnAccHome.setBorder(null);
    btnAccHome.setIcon(finalAccountIc);
    btnAccHome.setBackground(Color.cyan);
    btnAccHome.setBounds(1150, 60, 30, 30);
    add(btnAccHome);

    panelHeader = new JPanel();
    panelHeader.setBounds(0, 0, 1200, 100);
    panelHeader.setBackground(Color.CYAN);
    add(panelHeader);

    jtab = new JTabbedPane();
    jtab.setBounds(0, 100, 1200, 560);
    jtab.setLayout(null);
    add(jtab);

    panelItems = new JPanel();
    panelItems.setBounds(0, 0, 1200, 560);
    panelItems.setBackground(Color.green);
    jtab.add(panelItems);

    

    panelAccount = new JPanel();
    panelAccount.setBounds(0, 0, 1200, 560);
    panelAccount.setLayout(null);
    panelAccount.setBackground(Color.blue);
    jtab.add(panelAccount);

    btnReset.addActionListener(this);
    btnAccHome.addActionListener(this);

    setVisible(true);
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
  }
}

