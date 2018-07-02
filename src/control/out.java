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
	JTextField jt1,jt2;
	Button bt;
	public out() {
		win.setTitle("配件出库");
		init();
		
		win.setLocation(480,300);
		win.setSize(400,200);
		win.setVisible(true);
		win.validate();
		win.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void init() {
		JLabel j1,j2;
		j1=new JLabel("number:");
		j2=new JLabel("出库数量：");	
		jt1=new JTextField();
		jt2=new JTextField();
		//jt.addActionListener(linstener);
		bt=new Button("           点击及确认出库？             ");
		bt.addActionListener(this);
		
		
		Box b1,b2;
		b1=Box.createHorizontalBox();
		b2=Box.createVerticalBox();
		b1.add(j1);
		b1.add(jt1);
		b1.add(j2);
		b1.add(jt2);
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
		if(jt1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入您要出库的记录对应的number的值！！！");
			this.dispose();
		}
		if(jt2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入您要出库的数量！！！");
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "确定要出库吗？");

			ds.out("number",jt1.getText(),jt2.getText());
			win.dispose();
			mu=new Mutual_ui();
	        mu.manger_menu();
	        mu.center_table();
		}
	}
}