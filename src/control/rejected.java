package control;
import mysql.*;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class rejected extends JFrame implements ActionListener{
	JFrame win=new JFrame();
	ActionListener linstener;
	JTextField jt1,jt2;
	Button bt;
	public rejected() {
		win.setTitle("�������");
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
		j2=new JLabel("�˻�������");	
		jt1=new JTextField();
		jt2=new JTextField();
		//jt.addActionListener(linstener);
		bt=new Button("    �����ȷ�Ͽ��Խ��ж������ۣ�����⣡       ");
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

	public void actionPerformed(ActionEvent e) {
		Data_sql ds=new Data_sql();
		if(jt1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "�������˻����ļ�¼��Ӧ��number��ֵ������");
			this.dispose();
		}
		if(jt2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "��������Ҫ��������������");
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "ȷ��Ҫ�����");
			ds.add("number",jt1.getText(),jt2.getText());
			win.dispose();
			new repaint();
		}
	}
}