/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.realestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author johnl
 */
public class welcomePage extends JFrame implements  ActionListener{
    private JLabel lblWelcome,lblRealEstate, lblTagLine1,lblTagLine2, lblLogo;
    private JButton btnLogin,btnSignUp;
    private JPanel jpLogo;
    private ImageIcon logoIc, finalLogoIc;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C"));
    
    public welcomePage() {
        setTitle("Homepage");
        setSize(400,600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel welcomeBg = new JPanel();
        welcomeBg.setBackground(cGreen);
        welcomeBg.setLayout(null);
        welcomeBg.setBounds(0,0,400,600);
        add(welcomeBg);
        
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setBounds(0,40,400,50);
        lblWelcome.setHorizontalAlignment(JLabel.CENTER);
        lblWelcome.setForeground(Color.white);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 30));
        welcomeBg.add(lblWelcome);
        
        lblRealEstate = new JLabel("Richfield Real Estate");
        lblRealEstate.setBounds(0,90,400,50);
        lblRealEstate.setHorizontalAlignment(JLabel.CENTER);
        lblRealEstate.setForeground(Color.white);
        lblRealEstate.setFont(new Font("Arial", Font.PLAIN, 20));
        welcomeBg.add(lblRealEstate);
        
        logoIc = new ImageIcon("logoRealEstates.png");
        finalLogoIc = new ImageIcon(logoIc.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(finalLogoIc);
        lblLogo.setBounds(95, 160, 200, 200);
        welcomeBg.add(lblLogo);
        
        jpLogo = new JPanel();
        jpLogo.setBounds(95,160,200,200);
        jpLogo.setBackground(Color.red);
        welcomeBg.add(jpLogo);
        
        lblTagLine1 = new JLabel("Greener as ever, Trees everywhere");
        lblTagLine1.setBounds(0,380,400,20);
        lblTagLine1.setHorizontalAlignment(JLabel.CENTER);
        lblTagLine1.setForeground(Color.white);
        lblTagLine1.setFont(new Font("Arial", Font.PLAIN, 15));
        welcomeBg.add(lblTagLine1);
        
        lblTagLine2 = new JLabel("Make Your Move with Us!");
        lblTagLine2.setBounds(0,410,400,15);
        lblTagLine2.setHorizontalAlignment(JLabel.CENTER);
        lblTagLine2.setForeground(Color.white);
        lblTagLine2.setFont(new Font("Arial", Font.PLAIN, 15));
        welcomeBg.add(lblTagLine2);
        
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(95, 470, 90, 35);
        btnLogin.setHorizontalAlignment(JLabel.CENTER);
        btnLogin.setBackground(cGray);
        btnLogin.setForeground(Color.BLACK);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
        welcomeBg.add(btnLogin);
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(200,470, 90,35);
        btnSignUp.setHorizontalAlignment(JLabel.CENTER);
        btnSignUp.setBackground(cGray);
        btnSignUp.setForeground(Color.BLACK);
        btnSignUp.setFont(new Font("Arial", Font.BOLD, 15));
        welcomeBg.add(btnSignUp);
        
        
        
        btnLogin.addActionListener(this);
        btnSignUp.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnLogin){
            new loginPage();
            dispose();
           
            
        } else if(e.getSource() == btnSignUp) {
            new SignUp();
            dispose();
        }
    }
 
}
