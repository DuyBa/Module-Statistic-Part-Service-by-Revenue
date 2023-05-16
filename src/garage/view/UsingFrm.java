/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package garage.view;

import garage.DAO.BillDAO;
import garage.model.Bill;
import garage.model.Part;
import garage.model.PartStat;
import garage.model.Service;
import garage.model.ServiceStat;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ruy_pa_
 */
public class UsingFrm extends JFrame implements ActionListener{
    private JTable tblResult;
    private JButton btnOK;
    private Part part;
    private Service service;
    private UsingFrm mainFrm;
    private ArrayList<Bill> listBill;
    
//    public UsingFrm()
    public UsingFrm(String typeofStatistic, PartStat partstat, Date timeStart, Date endTime)
    {
        Part res= new Part();
        res.setId(partstat.getId());
        this.part= res;
        mainFrm= this;
        
        btnOK= new JButton("OK");
        
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
	pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
//        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);       
//        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
//        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
        btnOK.addActionListener(this);
        
        JPanel pntbl= new JPanel();
        pntbl.setLayout(new BoxLayout(pntbl, BoxLayout.LINE_AXIS));
        tblResult= new JTable();
        JScrollPane sp= new JScrollPane(tblResult);
        
        btnOK= new JButton("OK");
        btnOK.setAlignmentX(CENTER_ALIGNMENT);
        btnOK.addActionListener(this);
        pnMain.add(btnOK);
        
       
        pnMain.add(sp);
        pnMain.add(pntbl);
        
        pnMain.add(btnOK);
        

        
        
        BillDAO billdao= new BillDAO();
        listBill= billdao.searchBill(timeStart, endTime, part);

        String[] columns= {"STT", "Date", "Client name","Car name", typeofStatistic+ "name","Price", "Quantity", "Total cost"};
        String[][] value= new String[listBill.size()][8];
        for(int i= 0; i< listBill.size(); i++ )
        {
            value[i][0]= String.valueOf(i+ 1);
            value[i][1]= String.valueOf(listBill.get(i).getFixedCar().get(0).getPartUsing().get(0).getDate());
            value[i][2]= listBill.get(i).getFixedCar().get(0).getCar().getClient().getName();
            value[i][3]= listBill.get(i).getFixedCar().get(0).getCar().getName();
            value[i][4]= listBill.get(i).getFixedCar().get(0).getPartUsing().get(0).getPart().getName();
            value[i][5]= String.valueOf(listBill.get(i).getFixedCar().get(0).getPartUsing().get(0).getPrice());
            value[i][6]= String.valueOf(listBill.get(i).getFixedCar().get(0).getPartUsing().get(0).getQuantity());
            value[i][7]= String.valueOf(Integer.parseInt(value[i][5])* Integer.parseInt(value[i][6]));
        }
                            DefaultTableModel tableModel= new DefaultTableModel(value, columns)
                    {
                        @Override
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;
                        }
                    };
                    
                    tblResult.setModel(tableModel);
        
        
        this.add(pnMain);
        this.setSize(800,600);
        this.setLocation(500,150);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public UsingFrm(String typeofStatistic, ServiceStat partstat, Date timeStart, Date endTime)
    {
        Service res= new Service();
        res.setId(partstat.getId());
        this.service= res;
        mainFrm= this;
        
        btnOK= new JButton("OK");
        
        JPanel pnMain= new JPanel();
        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);		
	pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
//        pnMain.setSize(this.getSize().width-5, this.getSize().height-20);       
//        pnMain.setLayout(new BoxLayout(pnMain,BoxLayout.PAGE_AXIS));
//        pnMain.add(Box.createRigidArea(new Dimension(0,10)));
        
        btnOK.addActionListener(this);
        
        JPanel pntbl= new JPanel();
        pntbl.setLayout(new BoxLayout(pntbl, BoxLayout.LINE_AXIS));
        tblResult= new JTable();
        JScrollPane sp= new JScrollPane(tblResult);
        
        btnOK= new JButton("OK");
        btnOK.setAlignmentX(CENTER_ALIGNMENT);
        btnOK.addActionListener(this);
        pnMain.add(btnOK);
        
       
        pnMain.add(sp);
        pnMain.add(pntbl);
        
        pnMain.add(btnOK);
        

        
        
        BillDAO billdao= new BillDAO();
        listBill= billdao.searchBill(timeStart, endTime, service);
        Collections.sort(listBill, new Comparator<Bill>()
        {
            @Override
            public int compare(Bill truoc, Bill sau)
            {
                String ngaytruoc= String.valueOf(truoc.getFixedCar().get(0).getServiceUsing().get(0).getDate());
                String ngaysau= String.valueOf(sau.getFixedCar().get(0).getServiceUsing().get(0).getDate());
                return ngaysau.compareTo(ngaytruoc);
            }
        }
        );
        String[] columns= {"STT", "Date", "Client name","Car name", typeofStatistic+ "name","Price", "Quantity", "Total cost"};
        String[][] value= new String[listBill.size()][8];
        for(int i= 0; i< listBill.size(); i++ )
        {
            value[i][0]= String.valueOf(i+ 1);
            value[i][1]= String.valueOf(listBill.get(i).getFixedCar().get(0).getServiceUsing().get(0).getDate());
            value[i][2]= listBill.get(i).getFixedCar().get(0).getCar().getClient().getName();
            value[i][3]= listBill.get(i).getFixedCar().get(0).getCar().getName();
            value[i][4]= listBill.get(i).getFixedCar().get(0).getServiceUsing().get(0).getService().getName();
            value[i][5]= String.valueOf(listBill.get(i).getFixedCar().get(0).getServiceUsing().get(0).getPrice());
            value[i][6]= String.valueOf(listBill.get(i).getFixedCar().get(0).getServiceUsing().get(0).getQuantity());
            value[i][7]= String.valueOf(Integer.parseInt(value[i][5])* Integer.parseInt(value[i][6]));
        }
                            DefaultTableModel tableModel= new DefaultTableModel(value, columns)
                    {
                        @Override
                        public boolean isCellEditable(int row, int column)
                        {
                            return false;
                        }
                    };
                    
                    tblResult.setModel(tableModel);
        
        
        this.add(pnMain);
        this.setSize(800,200);
        this.setLocation(600,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((e.getSource() instanceof JButton) && (((JButton)e.getSource()).equals(btnOK)))
        {
            mainFrm.dispose();
        }
    }
    
    
}
