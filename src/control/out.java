package control;
import mysql.*;
import UI.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


@SuppressWarnings("serial")
public class out extends JFrame implements ActionListener{
	JFrame win=new JFrame();
	ActionListener linstener;
	JTextField jt=new JTextField();
	Button bt;
	public out() {
		win.setTitle("�������");
		init();
		
		win.setLocation(480,300);
		win.setSize(400,200);
		win.setVisible(true);
		win.validate();
		win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void init() {
		JLabel jl=new JLabel("number:");		
		//jt.addActionListener(linstener);
		bt=new Button("ɾ��number��Ӧ�����м�¼��");
		bt.addActionListener(this);
		
		
		Box b1,b2;
		b1=Box.createHorizontalBox();
		b2=Box.createVerticalBox();
		b1.add(jl);
		b1.add(jt);
		b2.add(b1);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(bt);
		//b2.setLayout(new FlowLayout());
		win.setLayout(new FlowLayout());
		win.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Data_sql ds=new Data_sql();
		Mutual_ui mu=new Mutual_ui();
		if(jt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "��������Ҫɾ���ļ�¼��Ӧ��number��ֵ������");
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "ȷ��Ҫɾ���ü�¼��");

			ds.out("number",jt.getText());
			win.dispose();
			mu=new Mutual_ui();
	        mu.manger_menu();
	        mu.center_table();
		}
	}
}