/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.view;

import garage.model.Part;
import garage.model.Service;
import garage.model.User;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


import garage.DAO.PartStatDAO;
import garage.DAO.ServiceStatDAO;
import garage.model.PartStat;
import garage.model.ServiceStat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ruy_pa_
 */
public class StatisticFrm extends JFrame implements ActionListener{
    
    private JTextField txtTimeStart;
    private JTextField txtEndTime;
    private JButton btnStatistic;
    private String typeofStatistic;
    private ArrayList<ServiceStat> listServiceStat;
    private ArrayList<PartStat> listPartStat;
    private JTable tblResult;
    private JButton btnOK;
    private User user;
    private StatisticFrm mainFrm;
    
    public StatisticFrm(String typeofStatistic, User user)
    {
        super(typeofStatistic + "Statistic");
        this.typeofStatistic= typeofStatistic;
        this.user= user;
        mainFrm= this;
        
        txtTimeStart= new JTextField(15);
        txtEndTime= new JTextField(15);
        
        
        
        
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
	pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
        JLabel lbStatistic= new JLabel(this.typeofStatistic+ "Statistic");
        pnMain.add(lbStatistic);
        
        JPanel pnStartTime= new JPanel();
        pnStartTime.add(new JLabel("TimeStart"));
        pnStartTime.add(txtTimeStart);
        pnMain.add(pnStartTime);
        
        JPanel pnEndTime= new JPanel();
        pnEndTime.add(new JLabel("EndTime"));
        pnEndTime.add(txtEndTime);
        pnMain.add(pnEndTime);
        
        
        btnStatistic= new JButton("Statistic");
        btnStatistic.setAlignmentX(CENTER_ALIGNMENT);
        btnStatistic.addActionListener(this);
        pnMain.add(btnStatistic);
        
        
        
        JPanel pntbl= new JPanel();
        pntbl.setLayout(new BoxLayout(pntbl, BoxLayout.Y_AXIS));
        tblResult= new JTable();
        JScrollPane sp= new JScrollPane(tblResult);
        
        btnOK= new JButton("OK");
        btnOK.addActionListener(this);
        btnOK.setAlignmentX(CENTER_ALIGNMENT);
        pnMain.add(btnOK);
        
        
        tblResult.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int column= tblResult.getColumnModel().getColumnIndexAtX(e.getX());
                int row= e.getY()/ tblResult.getRowHeight();
                
                if(row< tblResult.getRowCount()&& row>= 0 && column< tblResult.getColumnCount()&& column>=0)
                {
                    try {
                        //                    System.out.println(".mouseclicked()");
                        
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date startin = dateFormat.parse(txtTimeStart.getText().trim());
                        SimpleDateFormat dateFormatt = new SimpleDateFormat("yyyy-MM-dd");
                        Date endin= dateFormatt.parse(txtEndTime.getText().trim());
                        
                        if(typeofStatistic.equals("Part"))
                        {
                            UsingFrm a= new UsingFrm(typeofStatistic, listPartStat.get(row), startin, endin);
                            a.setVisible(true);
                        }
                        else
                        {
//                            System.out.println(listPartStat.get(row).getId());
                            UsingFrm a= new UsingFrm(typeofStatistic, listServiceStat.get(row), startin, endin);
                            a.setVisible(true);
                        }

//                        mainFrm.dispose();
                    } catch (ParseException ex) {
                        Logger.getLogger(StatisticFrm.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        
        
        
        pntbl.add(sp);
        pnMain.add(pntbl);
        this.add(pnMain);
        this.setSize(450,300);
        this.setLocation(600,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnStatistic)))
        {
            if(txtEndTime.getText()== null|| txtEndTime.getText().length()== 0 || txtTimeStart.getText()== null|| txtTimeStart.getText().length()== 0)
            {
                return;
            }
            
            if(this.typeofStatistic.equals("Part"))
            {
                
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date startin = dateFormat.parse(txtTimeStart.getText().trim());
                    SimpleDateFormat dateFormatt = new SimpleDateFormat("yyyy-MM-dd");
                    Date endin= dateFormatt.parse(txtEndTime.getText().trim());
                    
                    PartStatDAO partdao= new PartStatDAO();
                    listPartStat= partdao.searchPart(startin, endin);
                    
                    
                    
//                    Collections.sort(listPartStat, new Comparator<PartStat>()
//                    {
//                        @Override
//                        public int compare(PartStat truoc, PartStat sau)
//                        {
//                            return sau.getRevenue()-truoc.getRevenue();
//                        }
//                    }
//                    );
                    
                    
                    
                    String[] columns= {"STT", "ID", typeofStatistic+ "name", "Quantity", "Revenue"};
                    String[][] value= new String[listPartStat.size()][5];
                    
                    for(int i= 0; i< listPartStat.size(); i++ )
                    {
                        value[i][0]= String.valueOf(i+ 1);
                        value[i][1]= String.valueOf(listPartStat.get(i).getId());
                        value[i][2]= listPartStat.get(i).getName();
                        value[i][3]= String.valueOf(listPartStat.get(i).getQuantity());
                        value[i][4]= String.valueOf(listPartStat.get(i).getRevenue());
                    }
                    
                    DefaultTableModel tableModel= new DefaultTableModel(value, columns)
                    {
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;
                        }
                    };
                    
                    tblResult.setModel(tableModel);
                    
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger("please fill date in the blank with format 'YYYY-MM-DD'");
                }
                
//                        System.out.println("garage.view.StatisticFrm.actionPerformed()");
                
            }
            else
            {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date startin = dateFormat.parse(txtTimeStart.getText().trim());
                    SimpleDateFormat dateFormatt = new SimpleDateFormat("yyyy-MM-dd");
                    Date endin= dateFormatt.parse(txtEndTime.getText().trim());
                    
                    ServiceStatDAO servicestatdao= new ServiceStatDAO();
                    listServiceStat= servicestatdao.searchServiceStat(startin, endin);
//                       System.out.println(listServiceStat.size());
//                    Collections.sort(listServiceStat, new Comparator<ServiceStat>()
//                    {
//                        @Override
//                        public int compare(ServiceStat truoc, ServiceStat sau)
//                        {
//                            return sau.getRevenue()-truoc.getRevenue();
//                        }
//                    }
//                    );
                    
                    
                    
                    String[] columns= {"STT", "ID", typeofStatistic+ "name", "Quantity", "Revenue"};
                    String[][] value= new String[listServiceStat.size()][5];
                    
                    
                    
                    for(int i= 0; i< listServiceStat.size(); i++ )
                    {
                        value[i][0]= String.valueOf(i+ 1);
                        value[i][1]= String.valueOf(listServiceStat.get(i).getId());
                        value[i][2]= listServiceStat.get(i).getName();
                        value[i][3]= String.valueOf(listServiceStat.get(i).getQuantity());
                        value[i][4]= String.valueOf(listServiceStat.get(i).getRevenue());
                    }
                    
                    DefaultTableModel tableModel= new DefaultTableModel(value, columns)
                    {
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;
                        }
                    };
                    
                    tblResult.setModel(tableModel);
                    
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger(StatisticFrm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnOK)))
        {
            MenuFrm a= new MenuFrm(user);
            a.setVisible(true);
            mainFrm.dispose();
        }
    }
    
    
}
