/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.realestate;

import java.awt.*;
import javax.swing.*;

public class SignUp extends JFrame {
    private JLabel hdrSignUp, lblFName,lblLName, lblUsername, lblContact, lblEmail, lblRetypePass, lblPassword;
    private JPanel pnlSignUp;
    private JButton btnBack;
    private JTextField txtName, txtUsername, txtContact, txtEmail;
    private JPasswordField jpfPassword, jpfRetypePass;
    private ImageIcon mainBg, finalMainBgIC;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C"));
    
    public SignUp() {
        
        setSize(400,600);
        setTitle("Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        ImageIcon mainBg = new ImageIcon("C:\\Users\\Lenovo Ideapad\\OneDrive\\Desktop\\mainBg.png");
        finalMainBgIC = new ImageIcon(mainBg.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));

        hdrSignUp = new JLabel("Sign Up");
        hdrSignUp.setBounds(140, 50, 150, 30);
        hdrSignUp.setForeground(Color.white);
        hdrSignUp.setFont(new Font("Arial",Font.PLAIN,30));
        add(hdrSignUp);
    
        pnlSignUp = new JPanel();
        pnlSignUp.setBounds(80, 100, 240, 430);
        pnlSignUp.setLayout(null);
        add(pnlSignUp);
        
        
        lblFName=new JLabel("FIRST");
        lblFName.setBounds(10,10,100,30);
        lblFName.setForeground(Color.white);
        lblFName.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblFName);
        
        txtName = new JTextField();
        txtName.setBackground(cGray);
        txtName.setForeground(Color.black);
        txtName.setBounds(10,40,100,30);
        pnlSignUp.add(txtName);
        
        lblLName=new JLabel("LAST");
        lblLName.setBounds(130,10,100,30);
        lblLName.setForeground(Color.white);
        lblLName.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblLName);
        
        txtName = new JTextField();
        txtName.setBackground(cGray);
        txtName.setForeground(Color.black);
        txtName.setBounds(130,40,100,30);
        pnlSignUp.add(txtName);
        
        lblUsername=new JLabel("USERNAME");
        lblUsername.setBounds(0,80,240,30);
        lblUsername.setForeground(Color.white);
        lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBackground(cGray);
        txtUsername.setForeground(Color.black);
        txtUsername.setBounds(10,110,220,30);
        pnlSignUp.add(txtUsername);
        
        lblContact=new JLabel("CONTACT NO.");
        lblContact.setBounds(0,150,240,30);
        lblContact.setForeground(Color.white);
        lblContact.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblContact);
        
        txtContact = new JTextField();
        txtContact.setBackground(cGray);
        txtContact.setForeground(Color.black);
        txtContact.setBounds(10,180,220,30);
        pnlSignUp.add(txtContact);
        
        lblEmail=new JLabel("EMAIL");
        lblEmail.setBounds(0,220,240,30);
        lblEmail.setForeground(Color.white);
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBackground(cGray);
        txtEmail.setForeground(Color.black);
        txtEmail.setBounds(10,250,220,30);
        pnlSignUp.add(txtEmail);
        
        lblPassword=new JLabel("PASSWORD");
        lblPassword.setBounds(0,290,240,30);
        lblPassword.setForeground(Color.white);
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        pnlSignUp.add(lblPassword);
        
        jpfPassword = new JPasswordField();
        jpfPassword.setBackground(cGray);
        jpfPassword.setForeground(Color.black);
        jpfPassword.setBounds(10,320,220,30);
        jpfPassword.setForeground(Color.BLACK);
        pnlSignUp.add(jpfPassword);
        
        JButton btnSignUp = new JButton("SignUp");
        btnSignUp.setBounds(10,370,220,30);
        btnSignUp.setForeground(Color.white);
        btnSignUp.setBackground(cGreen);
        pnlSignUp.add(btnSignUp);
        
        JLabel lbllogin = new JLabel("I have an account");
        lbllogin.setBounds(10,395,220,30);
        lbllogin.setForeground(Color.white);
        lbllogin.setHorizontalAlignment(SwingConstants.CENTER);
        lbllogin.setFont(new Font("Arial",Font.CENTER_BASELINE,12));
        pnlSignUp.add(lbllogin);

        JLabel bg = new JLabel();
        bg.setBounds(0,0,240,430);
        bg.setOpaque(true);
        bg.setBackground(new Color(80, 133,200,150));
        pnlSignUp.add(bg);
        
        JPanel lblmainBg = new JPanel();
        lblmainBg.setBounds(0,0,400,600);
        lblmainBg.setLayout(null);
        add(lblmainBg);
        
        JLabel lblBg = new JLabel(finalMainBgIC);
        lblBg.setBounds(0,0,400,600);
        lblmainBg.add(lblBg);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        add(btnBack);
        
        setVisible(true);
    }
    public static void main (String[] args){
        new SignUp();
    }
}
