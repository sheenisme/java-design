package control;
import mysql.*;
import UI.Mutual_ui;
import UI.Win_table;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({ "serial", "unused" })
public class in extends JFrame implements ActionListener{
	JFrame jframe;
	ActionListener listener;
	Data_sql ds=new Data_sql();
	Mutual_ui mu=new Mutual_ui();
	JTable tin1,tin2;
	Container con;
	String name[]= ds.getcolumname();
	String [][] data=new String[1][8];
	public in() {
		jframe=new JFrame();
		this.setLayout(new GridLayout(3,1));//ʹ�����񲼾�
		init();

		ds=new Data_sql();
		tin2=new JTable(ds.getrecord(),ds.getcolumname());
		tin2.setCellSelectionEnabled(true); 
		this.add(tin2);
		add(new JScrollPane(tin2),BorderLayout.CENTER);

		
		JScrollPane js=new JScrollPane(tin1);
		js.setLocation(0,0);
		js.setSize(670,150);
		add(js,BorderLayout.NORTH);
		
		con =getContentPane();
		JButton bt=new JButton("ȷ����񣨳�Others�⣩����Ϊ��ȷ����ʱ�ٵ������⡯�����ɳɹ���ӣ�");
		bt.addActionListener(this);
		bt.setSize(670,50);
		setLocation(0,400);
		con.add(bt,BorderLayout.SOUTH);
				
		setTitle("������");
		setLocation(480,200);
		setSize(670,455);
		setVisible(true);
		validate();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	private void init() {
		int value=0;
		for(int i=0;i<data.length;i++){
		   for (int j=0;j<data.length;j++){
		      data[i][j]=String.valueOf(value++);
		    }
		  }
		tin1=new JTable(data,name);
		tin1.setCellSelectionEnabled(true); 
		this.add(tin1);
	}
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "�Ƿ�ȷ������������");
		this.dispose();
		
		int i=0;
    	for(;i<7;i++) {
    		if(data[0][i]==null)
    		{
    			JOptionPane.showMessageDialog(this, "���벻�Ϸ���");
    			//this.dispose();
    			i=10;
    			break;
    		}
    	}
    	if(i==10) {
    	      try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
    	}
    	if(data[0][7]==null)
    		data[0][7]=" ";
		ds.in(name, data[0]);
		this.dispose();
		new repaint();
	}
}