/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.view;

import garage.DAO.UserDAO;
import garage.model.User;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author ruy_pa_
 */
public class LoginFrm extends JFrame implements ActionListener{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    
    public LoginFrm()
    {
        super("Login");
        txtUsername= new JTextField(15);
        txtPassword= new JPasswordField(15);
        txtPassword.setEchoChar('*');
        btnLogin= new JButton("Login");
        
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width- 5, this.getSize().height- 20);
        pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        
        JLabel lblHome= new JLabel("Login");
        lblHome.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblHome.setFont(lblHome.getFont().deriveFont(20.0f));
        pnMain.add(lblHome);
        pnMain.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JPanel pnUsername= new JPanel();
        pnUsername.setLayout(new FlowLayout());
        pnUsername.add(new JLabel("Username:"));
        pnUsername.add(txtUsername);
        pnMain.add(pnUsername);
        
        JPanel pnPassword= new JPanel();
        pnPassword.setLayout(new FlowLayout());
        pnPassword.add(new JLabel("Password:"));
        pnPassword.add(txtPassword);
        pnMain.add(pnPassword);
        
        pnMain.add(btnLogin);
        pnMain.add(Box.createRigidArea(new Dimension(0, 10)));
        btnLogin.addActionListener(this);
        
        this.setSize(400, 200);
        this.setLocation(600,300);
        this.setContentPane(pnMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        		
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnLogin)))
        {
//            System.out.println("garage.view.LoginFrm.actionPerformed()");
            User user= new User();
            user.setUsername(txtUsername.getText());
            user.setPassword(txtPassword.getText());
            
            UserDAO ud= new UserDAO();
            if(ud.checkLogin(user))
            {
                if(user.getRole().equalsIgnoreCase("manager"))
                {
                    (new ManagerHomeFrm(user)).setVisible(true);
                    this.dispose();
                }
                else
                {
                    JOptionPane.showConfirmDialog(this, "this function of the role "+ user.getRole()+ " is under contruction!");
                    
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "incorrect username and/or password!");
            }
        }
        
    }
    
    //    nokidding121002@gmail.com

}
