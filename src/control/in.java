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
	Win_table wt;
	JTable tin;
	Container con;
	String name[]= ds.getcolumname();
	String [][] data=new String[1][8];
	public in() {
		jframe=new JFrame();
		this.setLayout(new GridLayout(3,1));//使用网格布局
		init();

		ds=new Data_sql();
		wt=new Win_table(ds.getrecord(),ds.getcolumname(),this);
		wt.table.setLocation(0,150);
		wt.table.setSize(670,250);
		add(wt.table,BorderLayout.CENTER);
		add(new JScrollPane(wt.table),BorderLayout.CENTER);
		
		JScrollPane js=new JScrollPane(tin);
		js.setLocation(0,0);
		js.setSize(670,150);
		add(js,BorderLayout.NORTH);
		
		con =getContentPane();
		JButton bt=new JButton("确保表格（除Others外），均为正确数据时再点击‘入库’，即可成功添加！");
		bt.addActionListener(this);
		bt.setSize(670,50);
		setLocation(0,400);
		con.add(bt,BorderLayout.SOUTH);
				
		setTitle("配件入库");
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
		tin=new JTable(data,name);
		tin.setCellSelectionEnabled(true); 
		this.add(tin);
	}
	
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "是否确认添加新配件？");
		this.dispose();
		
		int i=0;
    	for(;i<7;i++) {
    		if(data[0][i]==null)
    		{
    			JOptionPane.showMessageDialog(this, "输入不合法！");
    			//this.dispose();
    			i=10;
    			break;
    		}
    	}
    	if(i==10) {
    	      try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
    	}
    	if(data[0][7]==null)
    		data[0][7]=" ";
		ds.in(name, data[0]);
		this.dispose();
		mu=new Mutual_ui();
        mu.manger_menu();
        mu.center_table();
	}
}