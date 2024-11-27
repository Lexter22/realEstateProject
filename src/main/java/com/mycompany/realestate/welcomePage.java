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
    public welcomePage() {
        setTitle("Homepage");
        setSize(400,600);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblWelcome = new JLabel("WELCOME");
        lblWelcome.setBounds(0,50,400,50);
        lblWelcome.setHorizontalAlignment(JLabel.CENTER);
        lblWelcome.setFont(new Font("Arial", Font.PLAIN, 25));
        add(lblWelcome);
        
        lblRealEstate = new JLabel("Richfield Real Estate");
        lblRealEstate.setBounds(0,100,400,50);
        lblRealEstate.setHorizontalAlignment(JLabel.CENTER);
        lblRealEstate.setFont(new Font("Arial", Font.PLAIN, 25));
        add(lblRealEstate);
        
        logoIc = new ImageIcon("logoRealEstates.png");
        finalLogoIc = new ImageIcon(logoIc.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));

        lblLogo = new JLabel(finalLogoIc);
        lblLogo.setBounds(95, 160, 200, 200);
        add(lblLogo);
        
        jpLogo = new JPanel();
        jpLogo.setBounds(95,160,200,200);
        jpLogo.setBackground(Color.red);
        add(jpLogo);
        
        lblTagLine1 = new JLabel("Greener as ever, Trees everywhere");
        lblTagLine1.setBounds(0,380,400,20);
        lblTagLine1.setHorizontalAlignment(JLabel.CENTER);
        lblTagLine1.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblTagLine1);
        
        lblTagLine2 = new JLabel("Make Your Move with Us!");
        lblTagLine2.setBounds(0,410,400,15);
        lblTagLine2.setHorizontalAlignment(JLabel.CENTER);
        lblTagLine2.setFont(new Font("Arial", Font.PLAIN, 15));
        add(lblTagLine2);
        
        btnLogin = new JButton("Log In");
        btnLogin.setBounds(150,450, 100,35);
        btnLogin.setHorizontalAlignment(JLabel.CENTER);
        btnLogin.setFont(new Font("Arial", Font.PLAIN, 15));
        add(btnLogin);
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(150,490, 100,35);
        btnSignUp.setHorizontalAlignment(JLabel.CENTER);
        btnSignUp.setFont(new Font("Arial", Font.PLAIN, 15));
        add(btnSignUp);
        
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
