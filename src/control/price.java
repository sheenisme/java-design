package control;
import mysql.*;
import javax.swing.JFrame;
import UI.*;

@SuppressWarnings("serial")
public class price extends JFrame{
	JFrame win=new JFrame();
	Win_table wt;//�������ɱ���������
	Data_sql ds;//������������ݿ���
	public price() {
		this.setTitle("��ʾ����۸���Ϣ");
		ds=new Data_sql();
		ds.initsql();
		
		ds.setprice();
		wt=new Win_table(ds.getpricerecord(),ds.getpricename(),this);
		this.setLocation(480,200);
		this.setSize(670,455);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
}