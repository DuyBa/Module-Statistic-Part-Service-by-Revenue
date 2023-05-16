/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.view;

import garage.model.User;
import java.awt.BorderLayout;
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
public class MenuFrm extends JFrame implements ActionListener{
    
    
    private JButton btnServiceStatistic, btnPartStatistic;
    private User user;
    
    public MenuFrm(User user)
    {
        super("Statistic Menu");
        
        this.user= user;
        
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
	pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
        JLabel lbHome= new JLabel(user.getRole()+ " Menu");
        lbHome.setAlignmentX(CENTER_ALIGNMENT);
        JLabel lbName= new JLabel("name: "+ user.getName());
        lbName.setAlignmentX(CENTER_ALIGNMENT);
        pnMain.add(lbHome);
        pnMain.add(lbName);
        
        btnPartStatistic= new JButton("Part Statistic");
        btnPartStatistic.setAlignmentX(CENTER_ALIGNMENT);
        btnPartStatistic.addActionListener(this);
        pnMain.add(btnPartStatistic);
        
        btnServiceStatistic= new JButton("Service Statistic");
        btnServiceStatistic.setAlignmentX(CENTER_ALIGNMENT);
        btnServiceStatistic.addActionListener(this);
        pnMain.add(btnServiceStatistic);
        
        this.setSize(300,300);
        this.setLocation(600,300);
        this.add(pnMain, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( (e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnPartStatistic) ) )
        {
            StatisticFrm a= new StatisticFrm("Part", user);
            a.setVisible(true);
            this.dispose();
        }
        else if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnServiceStatistic) ))
        {
            StatisticFrm a= new StatisticFrm("Service", user);
            a.setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "this function is under construction");
        }
                
        
    }
    
//    public static void main(String[] args) {
//        MenuFrm a= new MenuFrm();
//        a.setVisible(true);
//    }
    
}
