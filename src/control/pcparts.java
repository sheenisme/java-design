package control;
import mysql.*;

import javax.swing.JFrame;

import UI.*;

@SuppressWarnings("serial")
public class pcparts extends JFrame{
	JFrame win=new JFrame();
	Win_table wt;//创建生成表格组件的类
	Data_sql ds;//创建配件的数据库类
	public pcparts() {
		this.setTitle("显示配件信息");
		ds=new Data_sql();
		ds.initsql();
		
		ds.setsuppliers();
		wt=new Win_table(ds.getpartsrecord(),ds.getpartsname(),this);
		this.setLocation(480,200);
		this.setSize(670,455);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}