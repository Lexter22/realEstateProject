package com.mycompany.realestate;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JTextField;


public class loginPage extends JFrame implements ActionListener, MouseListener{
    private JLabel hdrLogin,lblUserName,lblPassword,lblProfile,lblsignup;
    private JPanel pnlLogin;
    private JTextField txtUsername;
    private JPasswordField pfPassword;
    private JButton btnLogin,btnBack;
    private ImageIcon finalAvatarIcon, finalMainBgIC;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C")); 
    private Connection con;
    public loginPage() {
        
        Connect();
        setSize(400, 600);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        ImageIcon mainBg = new ImageIcon("mainBg.png");
        finalMainBgIC = new ImageIcon(mainBg.getImage().getScaledInstance(400, 600, Image.SCALE_SMOOTH));
        
        hdrLogin = new JLabel("Login");
        hdrLogin.setBounds(0, 50, 400, 30);
        hdrLogin.setHorizontalAlignment(SwingConstants.CENTER);
        hdrLogin.setForeground(Color.white);
        hdrLogin.setFont(new Font("Arial",Font.BOLD,30));
        add(hdrLogin);
        
        ImageIcon avatarIcon = new ImageIcon("avatarIcon.png");
        finalAvatarIcon = new ImageIcon(avatarIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        
        lblProfile = new JLabel();
        lblProfile.setIcon(finalAvatarIcon);
        lblProfile.setBounds(150, 100, 100, 140);
        add(lblProfile);
        
        pnlLogin = new JPanel();
        pnlLogin.setBounds(70, 300, 250, 180);
        pnlLogin.setOpaque(true);
        pnlLogin.setBackground(new Color(80, 133,200,150));
        pnlLogin.setLayout(null);
        add(pnlLogin);
        
        lblUserName = new JLabel("Username:");
        lblUserName.setBounds(10, 30, 150, 30);
        lblUserName.setForeground(Color.white);
        lblUserName.setFont(new Font("Arial",Font.BOLD,15));
        pnlLogin.add(lblUserName);
        
        txtUsername = new JTextField();
        txtUsername.setForeground(Color.black);
        txtUsername.setBackground(cGray);
        txtUsername.setBounds(100, 30, 130, 30);
        pnlLogin.add(txtUsername);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 80, 150, 30);
        lblPassword.setForeground(Color.white);
        lblPassword.setFont(new Font("Arial",Font.BOLD,15));
        pnlLogin.add(lblPassword);
        
        pfPassword = new JPasswordField();
        pfPassword.setForeground(Color.black);
        pfPassword.setBackground(cGray);
        pfPassword.setBounds(100, 80, 130, 30);
        
        pnlLogin.add(pfPassword);
               
        btnLogin = new JButton("Login");
        btnLogin.setForeground(Color.white);
        btnLogin.setBackground(cGreen);
        btnLogin.setBounds(110, 120, 110, 30);
        pnlLogin.add(btnLogin);
        
        lblsignup = new JLabel("I don't have an account");
        lblsignup.setBounds(0,150,250,30);
        lblsignup.setForeground(Color.white);
        lblsignup.setHorizontalAlignment(SwingConstants.CENTER);
        lblsignup.setFont(new Font("Arial",Font.CENTER_BASELINE,12));
        pnlLogin.add(lblsignup);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(10, 10, 80, 30);
        add(btnBack);
        
        JPanel lblmainBg = new JPanel();
        lblmainBg.setBounds(0,0,400,600);
        lblmainBg.setLayout(null);
        add(lblmainBg);
        
        JLabel lblBg = new JLabel(finalMainBgIC);
        lblBg.setBounds(0,0,400,600);
        lblmainBg.add(lblBg);   
        
        btnBack.addActionListener(this);
        btnLogin.addActionListener(this);
        lblsignup.addMouseListener(this);
        
        
        setVisible(true);
        
    }
    
        @Override
    public void mouseClicked(MouseEvent e) {
     if(e.getSource()==lblsignup){
         new SignUp();
         dispose();
     }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource()==btnBack){
            
            new welcomePage().setVisible(true);
            dispose();
            
        }
        
        else if(e.getSource()==btnLogin){
            
            PreparedStatement pst;
            ResultSet rs;
            String username = txtUsername.getText();
            String userPassword = pfPassword.getText();
            
            String admin = "Select * from admindetails where username=? and password=? ";
            String clients = "Select * from clientsinfo where username=? and password=? ";
            
            
            try{
                if (username.isEmpty()|| userPassword.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Error");
                }    
                else if (username.contains("Admin")){
                    pst = con.prepareStatement(admin);
                    pst.setString(1, username);
                    pst.setString(2, userPassword);
                    rs = pst.executeQuery();
                    while(rs.next()){
                    
                     new adminPage().setVisible(true);
                    }
                }
                
                else {
                    pst = con.prepareStatement(clients);
                    pst.setString(1, username);
                    pst.setString(2, userPassword);
                    rs = pst.executeQuery();
                        while(rs.next()){
                    
                     new ClientInterface().setVisible(true);
                        }
                }
                    
                }
            catch (SQLException ex) {
                Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
            }     
            }
            
//            try {
//                if (pst = con.prepareStatement(clients))
//                {
//                    pst.setString(1, username);
//                pst.setString(2, userPassword);
//                rs = pst.executeQuery();
//                
//                while(rs.next()){
//                    
//                     new ClientInterface().setVisible(true);
//                    
//                }}
//                
//                else if (pst = con.prepareStatement(admin))
//                {
//                    pst.setString(1, username);
//                pst.setString(2, adminPassword);
//                rs = pst.executeQuery();
//                        }
//                while(rs.next()){
//                    
//                     new ClientInterface().setVisible(true);
//                    
//                }
//
//            } catch (SQLException ex) {
//                Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
//            }
                
 
}
    public void Connect(){
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        
        try {
          con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(loginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


     
}
      