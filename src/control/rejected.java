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
		j2=new JLabel("退货数量：");	
		jt1=new JTextField();
		jt2=new JTextField();
		//jt.addActionListener(linstener);
		bt=new Button("    点击即确认可以进行二次销售，并入库！       ");
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
			JOptionPane.showMessageDialog(this, "请输入退货入库的记录对应的number的值！！！");
			this.dispose();
		}
		if(jt2.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "请输入您要入库的数量！！！");
			this.dispose();
		}
		else {
			JOptionPane.showMessageDialog(this, "确定要入库吗？");
			ds.add("number",jt1.getText(),jt2.getText());
			win.dispose();
			new repaint();
		}
	}
}