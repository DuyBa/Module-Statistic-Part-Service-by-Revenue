/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.view;

import garage.model.User;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ruy_pa_
 */
public class ManagerHomeFrm extends JFrame implements ActionListener{

    private JButton btnStatistic, btnCancle;
    private User user;
    
    
    public ManagerHomeFrm(User user)
    {
        super("Manage home");
        this.user= user;
                   
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
	pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
        JLabel aaa= new JLabel(user.getRole()+ "Home");
        aaa.setAlignmentX(CENTER_ALIGNMENT);
        pnMain.add(aaa);
        
        JLabel aaaa= new JLabel("name: "+ user.getName());
        aaaa.setAlignmentX(CENTER_ALIGNMENT);
        pnMain.add(aaaa);
        
        btnStatistic= new JButton("Statistic");
        btnStatistic.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStatistic.addActionListener(this);
        pnMain.add(btnStatistic);
        
        btnCancle= new JButton("Cancle");
        btnCancle.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCancle.addActionListener(this);
        pnMain.add(btnCancle);
        
        this.setSize(300,300);
        this.setLocation(600, 300);
        this.setContentPane(pnMain);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() instanceof JButton)&&(((JButton)e.getSource()).equals(btnStatistic)))
        {
            MenuFrm a= new MenuFrm(user);
            a.setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "this function is under construction");
        }
    }
    

    
}
