package com.mycompany.realestate;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener, MouseListener{
    private JLabel hdrSignUp, lblFName,lblLName, lblUsername, lblContact, lblEmail, lblRetypePass, lblPassword, lbllogin;
    private JPanel pnlSignUp;
    private JButton btnBack, btnSignUp;
    private JTextField txtName,txtLName, txtUsername, txtContact, txtEmail;
    private JPasswordField jpfPassword, jpfRetypePass;
    private ImageIcon mainBg, finalMainBgIC;
    private Color cGreen = (Color.decode("#28A745"));
    private Color cGray = (Color.decode("#E0E0E0"));
    private Color cBlue = (Color.decode("#004A8C"));
    private Connection con;                                            // this is the User Registration
    private Statement st;
    
    public SignUp() {
        Connect();  // sql
        
        setSize(400,600);
        setTitle("Sign up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        
        ImageIcon mainBg = new ImageIcon("mainBg.png");
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
        
        txtLName = new JTextField();
        txtLName.setBackground(cGray);
        txtLName.setForeground(Color.black);
        txtLName.setBounds(130,40,100,30);
        pnlSignUp.add(txtLName);
        
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
        
        btnSignUp = new JButton("SignUp");
        btnSignUp.setBounds(10,370,220,30);
        btnSignUp.setForeground(Color.white);
        btnSignUp.setBackground(cGreen);
        pnlSignUp.add(btnSignUp);
        
        lbllogin = new JLabel("I have an account");
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
        btnBack.setBounds(10, 10, 80, 25);
        btnBack.setBackground(cGreen);
        btnBack.setBorder(null);
        btnBack.setForeground(Color.white);
        btnBack.setFont(new Font("Arial",Font.CENTER_BASELINE,14));
        add(btnBack);
        
        lbllogin.addMouseListener(this);
        lbllogin.setCursor(new Cursor(HAND_CURSOR));
        btnSignUp.addActionListener(this);
        btnBack.addActionListener(this);
        
        setVisible(true);
    }
   
    
        @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==lbllogin){
     
        new loginPage();
        dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnBack){
            new welcomePage().setVisible(true);
            dispose();
         }
        else if (e.getSource() == btnSignUp){
            String firstValue = txtName.getText();
            String lastValue = txtLName.getText();
            String userNameValue = txtUsername.getText();
            String contactNumValue = txtContact.getText();
            String emailValue = txtEmail.getText();
            String passwordValue = jpfPassword.getText();
            
            String values = "insert into clientsinfo (firstname, lastname, username, contactnum, email, password) "
                    + "values ('"+firstValue+"', '"+lastValue+"', '"+userNameValue+"', '"+contactNumValue+"', '"+emailValue+"', '"+passwordValue+"')";
           /*
              to summarize if hindi empty lahat ng textfields then gagana dapat yung code
              then if may kahit isang blank, error 
            */
            if (!firstValue.isEmpty() && !lastValue.isEmpty() && !userNameValue.isEmpty() && !contactNumValue.isEmpty() && !emailValue.isEmpty() && !passwordValue.isEmpty() && emailValue.contains("@gmail.com")){
                   
                    try {
                        st = con.createStatement();
                        st.executeUpdate(values);
                
                        txtName.setText("");
                        txtLName.setText("");
                        txtUsername.setText("");
                        txtContact.setText("");
                        txtEmail.setText("");
                        jpfPassword.setText("");
                        // here is nakapag create kana ng account
                        JOptionPane.showMessageDialog(null, "SignUp Successful", "Registration Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
            else {
                JOptionPane.showMessageDialog(null, "Please fill all the field");
            }
            
        }
    }
    public void Connect(){
        String url = "jdbc:mysql://localhost:3306/realestates";
        String username = "root";
        String password = "admin123";
        
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 public static void main (String[] args){
        new SignUp();
    }
}
